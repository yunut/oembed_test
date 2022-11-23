package com.jys.oembedtest.selecttest.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VowelsCountTest {

    /**
     * a, e, i, o, u가 몇개 들어 있는지 출력하는 함수를 작성해주세요.
     * ex) abracadabra ⇒ 5
     */
    @Test
    void 모음_찾기() {
        // given
        String str = "abracadabra";

        // when
        int answer = vowelsCount(str);

        // then
        Assertions.assertTrue(answer == 5);
    }

    private int vowelsCount(String str) {
        int answer = 0;
        for(int i=0;i<str.length();i++) {
            String s = str.substring(i, i+1);
            if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) answer++;
        }

        return answer;
    }
}
