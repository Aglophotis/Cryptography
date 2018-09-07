package ru.aglophotis.data;

import java.io.File;
import java.nio.charset.Charset;

public class XorCryptImpl implements XorCrypt {
    @Override
    public StringBuilder strCrypt(StringBuilder value, StringBuilder key) throws Exception {
        if (value.equals("") || value == null)
            throw new Exception("Incorrect encrypted data");
        if (key.equals("") || key == null)
            throw new Exception("Incorrect key");
        try {
            byte[] vByte = value.toString().getBytes(Charset.defaultCharset());
            byte[] kByte = key.toString().getBytes(Charset.defaultCharset());
            byte[] res = new byte[value.length()];
            for (int i = 0; i < value.length(); i++) {
                res[i] = (byte) ((vByte[i]) ^ (kByte[i % key.length()]));
            }
            return new StringBuilder(new String(res));
        }
        catch (Exception e){
            throw e;
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
}
