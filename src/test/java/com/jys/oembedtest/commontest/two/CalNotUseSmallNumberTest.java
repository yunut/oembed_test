package com.jys.oembedtest.commontest.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class CalNotUseSmallNumberTest {

    /**
     * 0부터 시작하는 양수(+)인 ID가 있습니다. 여러 ID를 보고 사용하지 않는 가장 작은 숫자를 찾는 함수를 작성해주세요.
     * ex) [0,1,2,4] ⇒ 3
     * ex) [0,1,2,3,4,5,6] ⇒ 7
     */
    @Test
    void 사용하지_않는_가장_작은_숫자_찾기() {
        // given
        int[] arr = {0, 1, 1, 2, 6, 3, 5,};

        // when
        int answer = calNotUseSmallNumber(arr);

        // then
        Assertions.assertTrue(answer == 4);
    }

    private int calNotUseSmallNumber(int[] arr) {
        int answer = 0;
        Set<Integer> checkSet = new HashSet<>();

        for(int i : arr) {
            checkSet.add(i);
        }
        while(checkSet.contains(answer)) answer ++;

        return answer;
    }
}
