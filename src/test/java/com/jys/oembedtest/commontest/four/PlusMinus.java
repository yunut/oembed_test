package com.jys.oembedtest.commontest.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PlusMinus {

    static Map<Integer, String> fruitMap = new HashMap<>();
    static String[] samples = {"apple", "banana", "cherry", "orange", "grape"};

    @BeforeAll
    static void init() {
        for(int i=1;i<=100;i++) {
            fruitMap.put(i, samples[(int) (Math.random() * 4)]);
        }
    }

    /**
     * 각 자리의 숫자를 더한값을 원래 숫자에서 빼고 결과가 하단에 나열한 과일코드가 나올때까지 계산하는 코드를 작성해주세요.
     *      - ex) 10 => 10 - (1+0) = 9 ⇒ apple
     *      - ex) 325 =>
     *      - 325 - (3+2+5) = 315
     *      - 315 - (3+1+5) = 306
     *      - 306 - (3+0+6) = 297
     *      - ...
     */
    @Test
    void 더하고빼기() {
        // given
        int num = 10;

        // when
        String answer = plusMinus(num);

        // then
        Assertions.assertTrue(answer == fruitMap.get(9));
    }

    private String plusMinus(int num) {
        int answer = num;
        do {
            String numToString = Integer.toString(answer);
            int numTemp = 0;
            for(int i=0;i<numToString.length();i++) {
                numTemp += Integer.parseInt(numToString.substring(i, i+1));
            }
            answer -= numTemp;
        } while(!fruitMap.containsKey(answer));

        return fruitMap.get(answer);
    }
}
