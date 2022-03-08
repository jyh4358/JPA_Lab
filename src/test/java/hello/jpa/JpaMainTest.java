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

        MemberTest memberTest = new MemberTest();
        memberTest.setName("member1");

        System.out.println("==== persist before ====");
        em.persist(memberTest);
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
        member1.setName("member2");
        MemberTest member2 = new MemberTest();
        member2.setName("member3");

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
        member.setName("member4");

        System.out.println("==== persist before ====");
        em.persist(member);
        Long id = member.getId();
        System.out.println("==== persist after ====");

        member.setName("changeName");
        member.setName("changeName2");

        Assertions.assertThat(em.find(MemberTest.class, id).getName())
                .isEqualTo(member.getName());
    }

    @Test
    @Transactional
    @Rollback(false)
    void 플러시(){

        MemberTest member = new MemberTest();
        member.setName("member5");


        em.persist(member);
        Long id = member.getId();
        System.out.println("==== flush before ====");
        em.flush();
        System.out.println("==== flush after ====");
        Assertions.assertThat(em.find(MemberTest.class, id))
                .isEqualTo(member);

    }

    @Test
    @Transactional
    @Rollback(false)
    void 준영속(){

        MemberTest member = new MemberTest();
        member.setName("member6");

        em.persist(member);
        Long id = member.getId();
        // 준영속 상태로 전환
        em.detach(member);

        Assertions.assertThat(em.find(MemberTest.class, id))
                .isNotEqualTo(member);
    }
}
