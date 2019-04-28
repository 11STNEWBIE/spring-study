package court.service;

import court.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void add(Member member);

    void remove(String memberName);

    List<Member> list();

    Optional<Member> find(String memberName);
}
