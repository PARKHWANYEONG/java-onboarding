package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!isValidPage(pobi) || !isValidPage(crong)) return -1;

        return 0;
    }

    private static boolean isValidPage(List<Integer> pages) {
        if(isContinueos(pages)){
            return false;
        }
        
    }
    private static boolean isContinueos(List<Integer> pages) {
        return (pages.get(1) - pages.get(0)) != 1;
    }

}