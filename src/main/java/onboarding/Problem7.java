package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = findFriends(user,friends);
        Map<String, Integer> score = togetherFriends(user,userFriends,friends);
        visitScorePlus(score,visitors,userFriends);
        List<String> result = sortLimit5(score);

        return result;
    }
    private static List<String> sortLimit5(Map<String, Integer> score) {
        List<String> result = score.entrySet().stream()
                .sorted(scoreCompare()).map(entry -> entry.getKey()).limit(5).collect(Collectors.toList());
        return result;
    }
    private static Comparator<Map.Entry<String, Integer>> scoreCompare() {
        return new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int result = o2.getValue().compareTo(o1.getValue());
                if (result == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return result;
            }
        };
    }

    private static void visitScorePlus(Map<String, Integer> score, List<String> visitors, List<String> userFriends) {
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
    }


    private static Map<String, Integer> togetherFriends(String user, List<String> userFriends, List<List<String>> friends) {
        Map<String,Integer> score = new HashMap<>();
        for (List<String> relation : friends) {
            if (!relation.contains(user)) {
                relation.forEach(f->{
                    if (!userFriends.contains(f)) {
                        score.put(f, score.getOrDefault(f, 0)+10);}});
            }
        }
        return score;
    }

    private static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                addFriendsList(user, userFriends, relation);
            }
        }
        return userFriends;
    }
    private static void addFriendsList(String user, List<String> userFriends, List<String> relation) {
        relation.forEach(v-> {if (!v.equals(user)) {
            userFriends.add(v);}});
    }
}
