package com.godofwarportfolio.godofwarportfolio.domain.member;

import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id) {return store.get(id);}

    public Optional<Member> findByLoginId(String loginId){
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    private List<Member> findAll() { return new ArrayList<>(store.values());}

    public void clearStore() {store.clear();}
}
