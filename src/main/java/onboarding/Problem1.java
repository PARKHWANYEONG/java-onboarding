package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!isValidPage(pobi) || !isValidPage(crong)) return -1;

        return 0;
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