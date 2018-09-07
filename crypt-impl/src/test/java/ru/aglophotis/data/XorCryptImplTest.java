package ru.aglophotis.data;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class XorCryptImplTest {

    @Test
    public void strCryptTest1() throws Exception {
        XorCryptImpl xc = new XorCryptImpl();
        StringBuilder sb = new StringBuilder("Testing message");
        StringBuilder res = xc.strCrypt(sb, new StringBuilder("Random key"));
        assertEquals(xc.strCrypt(res, new StringBuilder("Random key")), sb);
    }

    @Test
    public void strCryptTest2() throws Exception {
        XorCryptImpl xc = new XorCryptImpl();
        for (int i = 0; i < 50; i++) {
            StringBuilder sb = generateString(100*i, 5*i);
            StringBuilder ps = generateString(1*i, 60);
            StringBuilder res = xc.strCrypt(sb, ps);
            assertEquals(xc.strCrypt(res, ps), sb);
        }
    }

    @Test
    public void fileDecrypt() {
    }

    private StringBuilder generateString(int size, int range){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++){
            str.append((char)ThreadLocalRandom.current().nextInt(0, range));
        }
        return str;
    }
}