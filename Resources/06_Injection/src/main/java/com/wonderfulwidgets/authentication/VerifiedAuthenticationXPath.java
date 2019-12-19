package com.wonderfulwidgets.authentication;

public class VerifiedAuthenticationXPath {

    String buildSearchExpression(String username, String hashedPassword) {

        return "/identities/identity[username/text()='" +
                stripValue(username) + "' and password/text()='" + stripValue(hashedPassword) + "']";
    }

    private String stripValue(String value) {

        // Easy XPath fix: strip anything from an ' onwards to get the raw base data.

        return value.replace("'.*$", "");
    }
}
