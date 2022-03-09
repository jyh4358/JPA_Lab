package hello.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Locker {

    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;
    private String name;

    // 양방향 연관관계 매핑 시
    @OneToOne(mappedBy = "locker")
    private Member member;
}
