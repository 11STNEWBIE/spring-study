/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.service;

import com.springrecipes.ch03.ch031.court.domain.Member;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class MemberServiceImpl implements MemberService {

    private Map<String, Member> members = new TreeMap<>();

    @Override
    public void add(Member member) {
        members.put(member.getName(), member);
    }

    public void remove(String memberName) {
        members.remove(memberName);
    }

    public List<Member> list() {
        return new ArrayList<>(members.values());
    }

    public Optional<Member> find(String memberName) {
        return Optional.ofNullable(members.get(memberName));
    }
}
