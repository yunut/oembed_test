package com.jys.oembedtest.commontest.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalPointsTest {

    /**
     * 점수를 보고 이기면 3점, 비기면 1점, 지면 0점으로 계산하여 전체 승점을 구하는 함수를 작성해주세요.
     * ex) ["3:1", "2:2", "1:3"] ⇒ 4
     * ex) [0,1,2,3,4,5,6] ⇒ 7
     * 기준을 왼쪽 기준으로 수행
     */
    @Test
    void 승점구하기() {
        // given
        String[] scores = {"3:1", "2:2", "1:3"};

        // when
        int answer = calPoints(scores);

        // then
        Assertions.assertTrue(answer == 4);
    }

    private int calPoints(String[] scores) {
        int answer = 0;

        for(String score : scores) {
            String[] scoreSplit = score.split(":");
            int home = Integer.parseInt(scoreSplit[0]);
            int away = Integer.parseInt(scoreSplit[1]);

            if(home > away) answer += Point.WIN.getValue();
            else if(home == away) answer += Point.DRAW.getValue();
            else answer += Point.LOSS.getValue();
        }

        return answer;
    }
}