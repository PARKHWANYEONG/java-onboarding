package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {


        List<String> userFriends = findFriends(user,friends);
        Map<String, Integer> score = togetherFriends(user,userFriends,friends);

        return userFriends;
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
