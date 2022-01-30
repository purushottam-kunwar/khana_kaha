package utils

/**
 * This class is for generating various types of random numbers.
 */

public class RandGeneratorUtils {

    public static String getRanCode(int length) {

        String myString = "bcdfghjklmnpqrstvwxyz";
        String[] array = myString.split("");
        String restr = "";
        for (int i = 0; i < length; i++) {
            int nm = (int) (Math.random() * myString.length());
            restr += array[nm];
        }

        return restr;

    }

    public static long getLongTypeRandomCode(int length) {
        String myString = "123456789";
        String[] array = myString.split("");
        String restr = "";
        for (int i = 0; i < length; i++) {
            int nm = (int) (Math.random() * myString.length());
            restr += array[nm];
        }
        long returnValue = Long.parseLong(restr);
        return returnValue;
    }

    public static String getRanAlphaNum(int length) {

        String myString = "bcdfghjklmnpqrstvwxyz1234567890";
        String[] array = myString.split("");
        String restr = "";
        for (int i = 0; i < length; i++) {
            int nm = (int) (Math.random() * myString.length());
            restr += array[nm];
        }

        return restr;

    }


    public static String getPassGenerator(int length) {

        String myString = "bcdfghjklmnpqrstvwxyz1234567890";
        String[] array = myString.split("");
        String restr = "";
        for (int i = 0; i < length; i++) {
            int nm = (int) (Math.random() * myString.length());
            restr += array[nm];
        }

        return restr;

    }

    /**
     * This is static method which will generate string of random numbers
     * based upon the length of integer provided. The random number includes integer numbers only.
     *
     * @param length
     * @return String of random number
     */
    public static String getRanGeneratorNum(int length) {
        String myString = "1234567890"
        String[] array = myString.split("")
        String restr = ""
        for (int i = 0; i < length; i++) {
            int nm = (int) (Math.random() * myString.length())
            restr += array[nm]
        }

        return restr
    }

}
