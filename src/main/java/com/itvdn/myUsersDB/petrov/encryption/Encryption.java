package com.itvdn.myUsersDB.petrov.encryption;

import org.jasypt.util.text.BasicTextEncryptor;

public class Encryption {
    private static final String KEY_WORD = "cd372e68-c127-4e46-bb22-cd4a2d2e7182";
    private static BasicTextEncryptor textEncryptor;

    private static BasicTextEncryptor getTextEncryptor() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(KEY_WORD.toCharArray());
        return textEncryptor;
    }

    public static String encrypt(String value) {
        return getTextEncryptor().encrypt(value);
    }

    public static String decrypt(String value) {
        return getTextEncryptor().decrypt(value);
    }
}
