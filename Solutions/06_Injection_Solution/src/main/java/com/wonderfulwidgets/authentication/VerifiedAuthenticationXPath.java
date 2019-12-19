package com.wonderfulwidgets.authentication;

public class VerifiedAuthenticationXPath {

    public String buildSearchExpression(String username, String hashedPassword) {

        return "/identities/identity[name/text()='" +
                stripValue(username) + "' and password/text()='" + stripValue(hashedPassword) + "']";
    }

    private String stripValue(String value) {

        // Option 1: Easy XPath fix: strip anything from an ' onwards to get the raw base data.
        //
        // return value.replace("'.*$", "");

        // Option 2: If a hack is detected, refuse to authenticate anything by returning an empty string.

        String result = value.replaceFirst(".*\\'.*", "");

        return result;
    }
}
