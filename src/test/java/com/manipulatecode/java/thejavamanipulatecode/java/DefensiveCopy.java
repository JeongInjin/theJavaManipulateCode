package com.manipulatecode.java.thejavamanipulatecode.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DefensiveCopy {

    @Test
    @DisplayName("방어적 복사 사용, Names class 참고")
    void defensiveCopyTest() {
        List<Name> originalNames = new ArrayList<>();
        originalNames.add(new Name("Fafi"));
        originalNames.add(new Name("Kevin"));

        Names crewNames = new Names(originalNames); // crewNames의 names: Fafi, Kevin
        originalNames.add(new Name("Sally")); // crewNames의 names: Fafi, Kevin, Sally\
    }
}


class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Names {
    private final List<Name> names;

//    public Names(List<Name> names) {
//        this.names = names;
//    }

    public Names(List<Name> names) {
        this.names = new ArrayList<>(names);
    }

}