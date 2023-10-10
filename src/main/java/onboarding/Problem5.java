package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static final int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();

        for (int unit : moneyUnit) {
            exchange(money,unit,result);
            money = money % unit;
        }
        return result;
    }
    private static void exchange(int money, int unit, List<Integer> result) {
        result.add(money / unit);
    }


}
