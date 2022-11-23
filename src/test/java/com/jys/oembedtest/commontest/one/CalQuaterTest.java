package com.jys.oembedtest.commontest.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CalQuaterTest {

    static Map<Integer, Integer> checkMap = new HashMap<>();

    @BeforeAll
    static void init() {
        checkMap.put(1, 1);
        checkMap.put(2, 1);
        checkMap.put(3, 1);
        checkMap.put(4, 2);
        checkMap.put(5, 2);
        checkMap.put(6, 2);
        checkMap.put(7, 3);
        checkMap.put(8, 3);
        checkMap.put(9, 3);
        checkMap.put(10, 4);
        checkMap.put(11, 4);
        checkMap.put(12, 4);
    }

    /**
     * 1~12월중에 숫자를 입력받고 1분기, 2분기, 3분기, 4분기를 리턴하는 함수를 작성해주세요.
     * ex) 3 ⇒ 1
     * ex) 8 ⇒ 3
     * ex) 11 ⇒ 4
     */
    @Test
    void 분기_숫자_구하기() {
        // given
        int month = (int) (Math.random() * 13) + 1;

        // when
        int answer = calQueater(month);

        // then
        Assertions.assertTrue(answer == checkMap.get(month));
    }

    private int calQueater(int month) {
        return (int) Math.ceil((double) month / 3);
    }
}
