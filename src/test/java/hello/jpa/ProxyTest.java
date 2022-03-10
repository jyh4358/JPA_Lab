package hello.jpa;

import hello.jpa.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class ProxyTest {

    @Autowired
    EntityManager em;


    @Test
    @Transactional
    @Rollback(false)
    void 프록시() {

        MemberTest member1 = new MemberTest();
        member1.setName("hello1");

        MemberTest member2 = new MemberTest();
        member2.setName("hello2");
        em.persist(member1);
        em.persist(member2);
        em.flush();
        em.clear();

        MemberTest findMember1 = em.find(MemberTest.class, member1.getId());
        System.out.println(findMember1.getClass());
        MemberTest findMember2 = em.getReference(MemberTest.class, member2.getId());
        System.out.println(findMember2.getClass());

        System.out.println(findMember1.getClass() == findMember2.getClass());

    }
}