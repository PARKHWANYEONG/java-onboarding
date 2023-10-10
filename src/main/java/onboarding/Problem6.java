package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> map = nicknameMap(forms);
        Set<String> emailSet = setEmails(map.values());

    }

    private static Set<String> setEmails(Collection<List<String>> values) {
        Set<String> emailSet = new HashSet<>();
        values.forEach(v->{
            if (v.size() != 1) v.forEach(e-> emailSet.add(e));
        });
        return emailSet;
    }


    private static Map<String, List<String>> nicknameMap(List<List<String>> forms) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> form : forms) {
            subStrNickname(map,form);
        }
        return map;
    }

    private static void subStrNickname(Map<String, List<String>> map, List<String> form) {
        String nickname = form.get(1);
        String email = form.get(0);
        for (int i = 0; i < nickname.length()-1; i++) {
            String substring = nickname.substring(i, i + 2);
            if (!map.containsKey(substring)) {
                List<String> emailList = new ArrayList<>();
                emailList.add(email);
                map.put(substring, emailList);
            } else {
                map.get(substring).add(email);
            }
        }
    }
}
