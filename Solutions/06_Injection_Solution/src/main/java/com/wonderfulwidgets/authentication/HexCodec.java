// HexCodec.java
// Copyright © 2019-2020 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.authentication;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public class HexCodec {

    private static final char[] HEXDIGITS = "0123456789abcdef".toCharArray();

    public String encode(byte[] value) {

        char[] result = new char[value.length * 2];

        for (int j = 0; j < value.length; j++) {

            int v = value[j] & 0xFF;                    // Makes it an unsigned byte first.
            result[j * 2] = HEXDIGITS[v >>> 4];
            result[j * 2 + 1] = HEXDIGITS[v & 0x0F];
        }

        return new String(result);
    }

    public byte[] toBytes(char[] chars) {

        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());

        return bytes;
    }

    public void clearObject(byte[] array) {

        if (array != null) {

            Arrays.fill(array, (byte)0);
        }
    }
}
