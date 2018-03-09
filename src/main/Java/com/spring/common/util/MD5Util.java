package com.spring.common.util;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class MD5Util {
    public String md5(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // a b c d e f 也可以改成大写的 A B C D E F
        char[] feedArray = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest msgDigest = MessageDigest.getInstance("MD5");
        msgDigest.update(plainText.getBytes("UTF-8"));
        byte[] bytes = msgDigest.digest();
        char[] out = new char[16 * 2];
        for (int i = 0, j = 0; i < 16; i++) {
            out[j++] = feedArray[bytes[i] >>> 4 & 0xf];
            out[j++] = feedArray[bytes[i] & 0xf];
        }
        return new String(out);
    }
}
