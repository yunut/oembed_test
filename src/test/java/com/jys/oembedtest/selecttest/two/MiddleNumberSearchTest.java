package com.jys.oembedtest.selecttest.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MiddleNumberSearchTest {

    /**
     * 3개의 숫자 중에 2번째 크기의 숫자 위치를 찾는 함수를 작성해주세요.
     * - ex) [0,1,2] ⇒ 1
     * - ex) [5,1,2] ⇒ 2
     */
    @Test
    void 중간_숫자_찾기() {
        // given
        int[] arr = {5, 1, 2};

        // when
        int answer = middleNumberSearch(arr);

        // then
        Assertions.assertTrue(answer == 2);
    }

    private int middleNumberSearch(int[] arr) {
        Arrays.sort(arr);
        return arr[1];
    }
}
