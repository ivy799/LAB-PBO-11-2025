package Praktikum_4.TP_1_H071241090.utils;

public class StringUtils {
    public static String getNickName(String fullName) {

        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) {
            return parts[0];
        } else {
            return parts[1];
        }
    }
}