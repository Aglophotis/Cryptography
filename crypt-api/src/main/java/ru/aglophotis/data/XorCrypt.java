package ru.aglophotis.data;

import java.io.File;
import java.nio.charset.Charset;

public interface XorCrypt {
    StringBuilder strCrypt(StringBuilder value, StringBuilder key) throws Exception;
    StringBuilder strCrypt(StringBuilder value, StringBuilder key, Charset chs) throws Exception;
    File fileCrypt(File value, StringBuilder key);
}
