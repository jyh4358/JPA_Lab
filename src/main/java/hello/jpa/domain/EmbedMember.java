package hello.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class EmbedMember {

    @Id @GeneratedValue
    @Column(name = "EMBERDMEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",
                               column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street",
                               column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode",
                            column = @Column(name = "WORK_ZIPCODE"))
    })
    private Address sorkAddress;

//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
//
//    private String city;
//    private String street;
//    private String zipcode;
}
