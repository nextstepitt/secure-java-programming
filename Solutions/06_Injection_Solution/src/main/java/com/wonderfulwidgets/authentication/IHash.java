package com.wonderfulwidgets.authentication;

public interface IHash {

    String hash(String value);
    String hash(char[] value);
}
