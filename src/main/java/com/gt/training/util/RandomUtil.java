package com.gt.training.util;

import java.util.Random;

/**
 * RandomUtil
 *
 * @author Weihang
 * @date 9/4/20
 */
public class RandomUtil {

    public static String getRandomString(int length) {
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
