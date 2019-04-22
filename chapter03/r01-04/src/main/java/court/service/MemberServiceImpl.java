package main.java.court.service;

import main.java.court.domain.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class MemberServiceImpl implements MemberService {

    private Map<String, Member> members = new TreeMap<>();

    public void add(Member member) {
        members.put(member.getName(), member);
    }

    public void remove(String memberName) {
        members.remove(memberName);
    }

    public List<Member> list() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Optional<Member> find(String memberName) {
        return Optional.ofNullable(members.get(memberName));
    }
}
