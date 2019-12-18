package com.wonderfulwidgets.immutable_heap;

import java.io.InputStream;

public interface PasswordChecker {

	boolean check(InputStream in, byte[] target);
}
