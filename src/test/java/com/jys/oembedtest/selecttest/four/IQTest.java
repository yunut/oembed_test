package com.jys.oembedtest.selecttest.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class IQTest {

    /**
     * 홀수 또는 짝수중에 하나만 존재하는 값의 순번을 출력하는 함수를 작성해주세요.
     * - ex) "2 4 7 8 10" ⇒ 3 # 7만 홀수
     * - ex) "1 2 1 1" ⇒ 2 # 2만 짝수
     */
    @Test
    void 아이큐_테스트() {
        // given
        int[] arr = {2, 4, 7, 8, 10};

        // when
        int answer = iqTest(arr);

        // then
        Assertions.assertTrue(answer == 3);
    }

    private int iqTest(int[] arr) {
        int answer = 0;

        int even=0; int odd=0;
        for(int num : arr) {
            if(even == 2 || odd == 2) break;
            if(num % 2 == 0) even++;
            else odd++;
        }

        for(int i=0;i<arr.length;i++) {
            if(even == 2 && arr[i] % 2 == 1) {
                answer = i+1;
                break;
            } else if(odd == 2 && arr[i] % 2 == 0){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
