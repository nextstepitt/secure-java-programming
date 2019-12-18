// IPasswordValidator.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.authentication;

public interface IPasswordValidator {

	boolean validate(byte[] target);
}
