package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;

        for (int i = 1; i <= number; i++) {
            clapCount += countClap(i);
        }
        return clapCount;
    }
    private static int countClap(int num) {
        int count = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
