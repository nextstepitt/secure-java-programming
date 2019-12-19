// XAuthenticationManagerTets.java
// Copyright © 2019-2020 NextStep IT Training. All rights reserved.
//
// The rule is that if a hack is detected in the application is refuses to authenticate
// the user, even if the correct password is given.
//

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
    public void injectedValidAuthenticationRejected() {

        // Without input validation this will fail because the hack works and the authentication attempt should
        // be rejected when the hack is detected during input validation.

        username = "ghopper' or '1'='1";
        assertFalse(authenticationManager.authenticate(username, password.toCharArray()));
    }

    @Test
    public void injectedInvalidAuthenticationRejected() {

        // Without input validation this test will fail because the injection hack worked.

        username = "ghopper' or '1'='1";
        password = "Go@headBreak1t";
        assertFalse(authenticationManager.authenticate(username, password.toCharArray()));
    }
}
