package ru.aglophotis.data;

import java.io.File;
import java.nio.charset.Charset;

public class XorCryptImpl implements XorCrypt {
    @Override
    public StringBuilder strCrypt(StringBuilder value, StringBuilder key) throws Exception {
        int numOfTHread = value.length()/key.length() > 4 ? 4 : value.length()/key.length();
        Thread[] threadArr = new Thread[numOfTHread];
        Worker[] workers = new Worker[numOfTHread];
        for (int i = 0; i < numOfTHread; i++){
            threadArr[i] = new Thread((workers[i])(value));
        }
    }

    @Override
    public StringBuilder strCrypt(StringBuilder value, StringBuilder key, Charset chs) throws Exception {
        if (value.equals("") || value == null)
            throw new Exception("Incorrect encrypted data");
        if (key.equals("") || key == null)
            throw new Exception("Incorrect key");
        if (chs == null)
            throw new Exception("Incorrect charset");
        try {
            byte[] vByte = value.toString().getBytes(chs);
            byte[] kByte = key.toString().getBytes(chs);
            byte[] res = new byte[value.length()];
            for (int i = 0; i < value.length(); i++) {
                res[i] = (byte) ((vByte[i]) ^ (kByte[i % key.length()]));
            }
            return new StringBuilder(new String(res, chs));
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public File fileCrypt(File value, StringBuilder key) {
        return null;
    }

    private class Worker implements Runnable{
        StringBuilder value, key, resStr;
        boolean isThreadActive = true;

        Worker(StringBuilder value, StringBuilder key){
            this.value = value;
            this.key = key;
        }

        @Override
        public void run() {
            if (value.equals("") || value == null)
                try {
                    throw new Exception("Incorrect encrypted data");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (key.equals("") || key == null)
                try {
                    throw new Exception("Incorrect key");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            try {
                byte[] vByte = value.toString().getBytes(Charset.defaultCharset());
                byte[] kByte = key.toString().getBytes(Charset.defaultCharset());
                byte[] res = new byte[value.length()];
                for (int i = 0; i < value.length(); i++) {
                    res[i] = (byte) ((vByte[i]) ^ (kByte[i % key.length()]));
                }
                resStr = new StringBuilder(new String(res));
                while (isThreadActive)
                    Thread.sleep(50);
            }
            catch (Exception e){
                try {
                    throw e;
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

        public StringBuilder getResult(){
            while (resStr == null);
            isThreadActive = false;
            return resStr;
        }
    }
}
