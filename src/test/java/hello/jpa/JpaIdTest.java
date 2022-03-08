package hello.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class JpaIdTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    void sequenceStrategy() {

        MemberTest member = new MemberTest();
        member.setName("테스트");

        System.out.println("================");
        em.persist(member);
        System.out.println(member.getId());
        System.out.println("================");

    }

    @Test
    @Transactional
    @Rollback(false)
    void identityStrategy() {

        MemberTest member = new MemberTest();
        member.setName("테스트");

        System.out.println("================");
        em.persist(member);
        System.out.println(member.getId());
        System.out.println("================");

    }

    @Test
    @Transactional
    @Rollback(false)
    void sequenceStrategy2() {

        MemberTest member1 = new MemberTest();
        member1.setName("테스트1");
        MemberTest member2 = new MemberTest();
        member2.setName("테스트2");
        MemberTest member3 = new MemberTest();
        member3.setName("테스트3");

        System.out.println("================");
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        System.out.println("member1 = " + member1.getId());
        System.out.println("member2 = " + member2.getId());
        System.out.println("member3 = " + member3.getId());
        System.out.println("================");

    }
}
