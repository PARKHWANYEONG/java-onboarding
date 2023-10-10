package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = findFriends(user,friends);


        return userFriends;
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
