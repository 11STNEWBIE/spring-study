/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.service;

import com.springrecipes.ch03.ch031.court.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void add(Member member);

    void remove(String memberName);

    List<Member> list();

    Optional<Member> find(String memberName);
}
