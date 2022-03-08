package hello.jpa;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class JpaMainTest {

    @Autowired EntityManager em;


    @Test
    @Transactional
    @Rollback(false)
    void 동일성(){

        MemberTest member = new MemberTest();
        member.setId(1L);
        member.setName("member1");

        System.out.println("==== persist before ====");
        em.persist(member);
        System.out.println("==== persist after ====");

        MemberTest findMember1 = em.find(MemberTest.class,1L);
        MemberTest findMember2 = em.find(MemberTest.class, 1L);

        Assertions.assertThat(findMember1).isEqualTo(findMember2);
    }

    @Test
    @Transactional
    @Rollback(false)
    void 쓰기지연(){

        MemberTest member1 = new MemberTest();
        member1.setId(1L);
        member1.setName("member1");
        MemberTest member2 = new MemberTest();
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

        MemberTest member = new MemberTest();
        member.setId(1L);
        member.setName("member1");

        System.out.println("==== persist before ====");
        em.persist(member);
        System.out.println("==== persist after ====");

        member.setName("changeName");
        member.setName("changeName2");

        Assertions.assertThat(em.find(MemberTest.class, 1L).getName())
                .isEqualTo(member.getName());
    }

    @Test
    @Transactional
    @Rollback(false)
    void 플러시(){

        MemberTest member = new MemberTest();
        member.setId(1L);
        member.setName("member1");


        em.persist(member);
        System.out.println("==== flush before ====");
        em.flush();
        System.out.println("==== flush after ====");
        Assertions.assertThat(em.find(MemberTest.class, 1L))
                .isEqualTo(member);

    }

    @Test
    @Transactional
    @Rollback(false)
    void 준영속(){

        MemberTest member = new MemberTest();
        member.setId(1L);
        member.setName("member1");

        em.persist(member);
        // 준영속 상태로 전환
        em.detach(member);

        Assertions.assertThat(em.find(MemberTest.class, 1L))
                .isNotEqualTo(member);
    }
}
