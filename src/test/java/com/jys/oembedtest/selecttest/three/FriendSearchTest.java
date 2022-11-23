package com.jys.oembedtest.selecttest.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FriendSearchTest {

    private final int FRIEND_LENGTH = 4;

    /**
     * 이름이 4글자면 친구입니다. 친구를 찾는 함수를 작성해주세요.
     * ex) ["Ryan", "Kieran", "Mark"] => ["Ryan", "Mark"]
     */
    @Test
    void 친구_찾기() {
        // given
        String[] arr = {"Ryan", "Kieran", "Mark"};

        // when
        ArrayList<String> answer = friendSearch(arr);

        // then
        Assertions.assertTrue(answer.get(0) == "Ryan");
        Assertions.assertTrue(answer.get(1) == "Mark");
    }

    private ArrayList<String> friendSearch(String[] arr) {
        ArrayList<String> answers = new ArrayList<>();
        for(String name : arr) {
            if(name.length() == FRIEND_LENGTH) answers.add(name);
        }
        return answers;
    }
}
