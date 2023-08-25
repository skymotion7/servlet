package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
//    MemberRepository memberRepository = new MemberRepository();
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("jang", 37);
        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId());

        Assertions.assertThat(member).isEqualTo(findMember);

    }

    @Test
    void findAll() {
        Member member1 = new Member("jang", 37);
        Member member2 = new Member("lee", 24);
        Member saveMember1 = memberRepository.save(member1);
        Member saveMember2 = memberRepository.save(member2);

        List<Member> all = memberRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);
        Assertions.assertThat(all).contains(member1, saveMember2);
        Assertions.assertThat(saveMember1).isEqualTo(member1);
    }
}