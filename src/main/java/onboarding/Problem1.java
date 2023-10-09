package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!isValidPage(pobi) || !isValidPage(crong)) return -1;

        int pobiScore = getMaxNumber(pobi);
        int crongScore = getMaxNumber(crong);

        if(pobiScore > crongScore) return 1;
        if(pobiScore < crongScore) return 2;
        return 0;
    }

    private static int getMaxNumber(List<Integer> pages) {
        int max = Integer.MIN_VALUE;
        for (int page : pages) {
            int result = digitNumAddOrMultiCalculator(digitSplit(page));
            if (max < result) {
                max = result;
            }
        }
        return max;
    }

    private static int digitNumAddOrMultiCalculator(String[] strings) {
        int add = 0;
        int multi = 1;
        for (String digit : strings) {
            int digitNum = Integer.parseInt(digit);
            add += digitNum;
            multi *= digitNum;
        }
        return Math.max(add, multi);
    }


    private static String[] digitSplit(int page) {
       return String.valueOf(page).split("");
    }

    private static boolean isValidPage(List<Integer> pages) {
        if(!isContinueos(pages)){
            return false;
        }
        if (!isOddPage(pages.get(0))) {
            return false;
        }
        if (!isValidRange(pages)) {
            return false;
        }
        return true;
    }

    private static boolean isValidRange(List<Integer> pages) {
        for (int page : pages) {
            if (!(1 <= page && page <= 400)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOddPage(Integer integer) {
        return integer % 2 == 1;
    }

    private static boolean isContinueos(List<Integer> pages) {
        return (pages.get(1) - pages.get(0)) == 1;
    }

}