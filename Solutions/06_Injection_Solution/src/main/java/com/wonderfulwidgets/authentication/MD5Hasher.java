package com.wonderfulwidgets.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hasher implements IHash {

    private HexCodec hexCodec;

    public MD5Hasher() {

        hexCodec = new HexCodec();
    }

    public String hash(String value) {

        return hash(value.toCharArray());
    }

    public String hash(char[] value) {

        String result = null;
        byte[] bytePassword = null;

        try {

            bytePassword = hexCodec.toBytes(value);
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(bytePassword);
            result = hexCodec.encode(md.digest());
        }

        catch (NoSuchAlgorithmException e) {
        }

        finally {

            hexCodec.clearObject(bytePassword);
        }

        return result;
    }
}
