package ru.aglophotis.data;

import java.io.File;

public interface XorCrypt {
    StringBuilder strEncrypt(StringBuilder value, StringBuilder key);
    File fileEncrypt(File value, StringBuilder key);
    StringBuilder strDecrypt(StringBuilder value, StringBuilder key);
    File fileDecrypt(File value, StringBuilder key);
}
