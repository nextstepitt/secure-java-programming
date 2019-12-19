package com.wonderfulwidgets.authentication;

public interface IAuthenticator {

    boolean authenticate(String username, char[] password);
}
