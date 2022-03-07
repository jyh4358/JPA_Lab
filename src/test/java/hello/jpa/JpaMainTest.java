package hello.jpa;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class JpaMainTest {

    @Autowired EntityManager em;


    @Test
    @Transactional
    @Rollback(false)
    void 동일성(){

        Member member = new Member();
        member.setId(1L);
        member.setName("member1");

        System.out.println("==== persist before ====");
        em.persist(member);
        System.out.println("==== persist after ====");

        Member findMember1 = em.find(Member.class,1L);
        Member findMember2 = em.find(Member.class, 1L);

        Assertions.assertThat(findMember1).isEqualTo(findMember2);
    }

    @Test
    @Transactional
    @Rollback(false)
    void 쓰기지연(){

        Member member1 = new Member();
        member1.setId(1L);
        member1.setName("member1");
        Member member2 = new Member();
        member2.setId(2L);
        member2.setName("member2");

        System.out.println("==== persist before ====");
        em.persist(member1);
        em.persist(member2);
        System.out.println("==== persist after ====");

    }

    @Test
    @Transactional
    @Rollback(false)
    void 변경감지(){

        Member member = new Member();
        member.setId(1L);
        member.setName("member1");

        System.out.println("==== persist before ====");
        em.persist(member);
        System.out.println("==== persist after ====");

        member.setName("changeName");
        member.setName("changeName2");

    }

    @Test
    @Transactional
    @Rollback(false)
    void 플러시(){

        Member member = new Member();
        member.setId(1L);
        member.setName("member1");


        em.persist(member);
        System.out.println("==== flush before ====");
        em.flush();
        System.out.println("==== flush after ====");

    }

    @Test
    @Transactional
    @Rollback(false)
    void 준영속(){

        Member member = new Member();
        member.setId(1L);
        member.setName("member1");

        em.persist(member);

        // 준영속 상태로 전환
        em.detach(member);

    }
}
