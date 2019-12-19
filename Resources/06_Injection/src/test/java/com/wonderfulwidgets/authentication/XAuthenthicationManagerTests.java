package com.wonderfulwidgets.authentication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XAuthenthicationManagerTests {

    private IAuthenticator authenticationManager;
    String username;
    String password;

    @BeforeEach
    public void setup() {

        authenticationManager = new XAuthenticationManager();
        username = "ghopper";
        password = "P@ssW0rd";
    }

    @Test
    public void validAuthenticationAccepted() {

        assertTrue(authenticationManager.authenticate(username, password.toCharArray()));
    }

    @Test
    public void invalidAuthenticationRejected() {

        password = "S0methingElse";

        assertFalse(authenticationManager.authenticate(username, password.toCharArray()));
    }

    @Test
    public void injectedValidAuthenticationAccepted() {

        // Without input validation this will present a false positive because because the injection hack worked.

        username = "ghopper' or '1'='1";
        assertTrue(authenticationManager.authenticate(username, password.toCharArray()));
    }

    @Test
    public void injectedInvalidAuthenticationRejected() {

        // Without input validation this test will fail because the injection hack worked.

        username = "ghopper' or '1'='1";
        password = "Go@headBreak1t";
        assertFalse(authenticationManager.authenticate(username, password.toCharArray()));
    }
}
