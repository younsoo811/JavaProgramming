package 테스트;

import com.sun.jdi.IntegerValue;

import java.util.*;

public class ReservationSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> javaScore = new HashMap<String, Integer>();

        javaScore.put("김성동", 97);
        javaScore.put("황기태", 97);
        javaScore.put("김남윤", 97);
        javaScore.put("이재문", 97);
        javaScore.put("한원선", 97);

        System.out.println("HashMap의 요소 개수 :" + javaScore.size());

        Set<String> keys = javaScore.keySet();

        Iterator<String> it = keys.iterator();

        while(it.hasNext()) {
            String name = it.next();
            int score = javaScore.get(name);
            System.out.println(name + ":" + score);
        }
    }
}
