package happystrings;

import java.util.List;

public class NumberOfHappyStringsSolution {

    public static void main(String[] args) {
        var solution = new NumberOfHappyStringsSolution();
        System.out.println(solution.numberOfHappyStrings(List.of("abbcc", "abc", "abcabc", "cabcbb")) == 2);
        System.out.println(solution.numberOfHappyStrings(List.of("abcbcbcbc", "abcaa")) == 1);
        System.out.println(solution.numberOfHappyStrings(List.of("aa", "ababcc", "abcabccba", "bcabba")) == 0);
    }

    private int numberOfHappyStrings(List<String> strings) {
        int result = 0;

        for (String s : strings) {
            if (isHappy(s)) {
                result++;
            }
        }

        return result;
    }

    private boolean isHappy(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }

}
