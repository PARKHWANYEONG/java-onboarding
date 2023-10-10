package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        return word.chars()
                .mapToObj(ch -> String.valueOf((char) charMapping(ch)))
                .collect(Collectors.joining());
    }

    private static int charMapping(int ch) {
        final int lowerCase = 'a'+'z';
        final int upperCase = 'A'+'Z';

        if (isLowerCase(ch)) {
            return lowerCase - ch;
        }
        if (isUpperCase(ch)) {
            return upperCase - ch;
        }
        return ch;
    }

    private static boolean isUpperCase(int ch) {
        return ('A' <= ch && ch <= 'Z');
    }

    private static boolean isLowerCase(int ch) {
        return ('a' <= ch && ch <= 'z');
    }
}
