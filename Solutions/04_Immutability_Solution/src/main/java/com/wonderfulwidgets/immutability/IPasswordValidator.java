// IPasswordChecker.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import java.io.InputStream;

public interface IPasswordValidator {

	boolean validate(InputStream in, byte[] target);
}
