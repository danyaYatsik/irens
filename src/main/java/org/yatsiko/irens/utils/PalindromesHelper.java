package org.yatsiko.irens.utils;

import java.util.ArrayList;
import java.util.List;

public class PalindromesHelper {

    public static List<String> getPalindromes(String origin, int range) {
        List<String> palindromes = new ArrayList<>();
        while (0 < range) {
            List<String> candidates;
            if (origin.length() % 2 == 0) {
               candidates = getEvenLengthPlndrms(origin, range);
            } else {
                candidates = getOddLengthPlndrms(origin, range);
            }
            palindromes.addAll(candidates);
            range -= candidates.size();
            origin = incrementString(palindromes.get(palindromes.size() - 1), 0);
        }
        return palindromes;
    }

    private static List<String> getEvenLengthPlndrms(String origin, int range) {
        List<String> list = new ArrayList<>();
        StringComparator comp = new StringComparator();
        String half0 = origin.substring(0, origin.length() / 2);
        String half = origin.substring(0, origin.length() / 2);
        int counter = 0;
        while (half0.length() == half.length() && counter < range) {
            String palindrome = half + reverseString(half);
            if (comp.compare(palindrome, origin) >= 0) {
                list.add(half + reverseString(half));
                if (++counter >= range) {
                    break;
                }
            }
            half = incrementString(half, 0);
        }
        return list;
    }

    private static List<String> getOddLengthPlndrms(String origin, int range) {
        List<String> list = new ArrayList<>();
        StringComparator comp = new StringComparator();
        String half0 = origin.substring(0, origin.length() / 2);
        String half = origin.substring(0, origin.length() / 2);
        int counter = 0;
        while (half0.length() == half.length() && counter < range) {
            for (int i = 0; i < 10; i++) {
                String palindrome = half + i + reverseString(half);
                if (comp.compare(palindrome, origin) >= 0) {
                    list.add(palindrome);
                    if (++counter >= range) {
                        break;
                    }
                }
            }
            half = incrementString(half, 0);
        }
        return list;
    }

    public static String getPalindrome(String str) {
        String half = str.substring(0, str.length() / 2);
        if (str.length() % 2 == 0) {
            return half + new StringBuilder(half).reverse().toString();
        } else {
            String s = incrementString(str.substring(0, (str.length() / 2) + 1), 0);
            return half + s + new StringBuilder(half).reverse().toString();
        }
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String incrementString(String base, int level) {
        if (base.endsWith("9")) {
            return incrementString(base.substring(0, base.length() - 1), level + 1);
        }
        StringBuilder sb = new StringBuilder();
        if (base.length() == 0) {
            sb.append("1").append(base);
        } else {
            char lastNumber = base.charAt(base.length() - 1);
            sb.append(base, 0, base.length() - 1).append((char) (lastNumber + 1));
        }
        for (int i = 0; i < level; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static boolean isPalindrome(String str) {
        int middle = str.length() / 2;
        String a = "", b = "";
        if (str.length() % 2 == 0) {
            a = str.substring(0, middle);
            b = str.substring(middle);
        } else {
            a = str.substring(0, middle);
            b = str.substring(middle + 1);
        }
        return a.equals(b);
    }
}

