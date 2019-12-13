package com.random.generate_random.util;

/**
 * 生成随机码
 *
 * @author QZJ
 */
public class RandomCreateCode {
    public static final String NUMBER = "0123456789";
    public static final String CHARACTER = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final String NUMAND_BIG_CHAR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 数字模式
     */
    public static final int MODE_NUMBER = 1;
    /**
     * 数字+字母模式
     */
    public static final int MODE_CHARACTER = 2;
    /**
     * 数字+大写字母模式
     */
    public static final int MODE_NUM_BIG_CHAR = 3;

    public static final String randomNumber(int length, int mode) {
        char[] numbersAndLetters = null;
        java.util.Random randGen = null;
        if (length < 1) {
            return null;
        }
        int size = 0;
        String content = "";
        switch (mode) {
            case MODE_NUMBER:
                content = NUMBER;
                break;
            case MODE_CHARACTER:
                content = CHARACTER;
                break;
            case MODE_NUM_BIG_CHAR:
                content = NUMAND_BIG_CHAR;
            default:
                break;
        }
        size = content.length();
        if (randGen == null) {
            randGen = new java.util.Random();
            numbersAndLetters = content.toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(size)];
        }
        return new String(randBuffer);
    }
}
