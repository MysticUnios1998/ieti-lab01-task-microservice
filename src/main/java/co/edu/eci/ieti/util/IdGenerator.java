package co.edu.eci.ieti.util;

import org.apache.commons.lang3.RandomStringUtils;

public class IdGenerator {

    public static String generateId(int length, boolean useLetters, boolean useNumbers) {
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

}
