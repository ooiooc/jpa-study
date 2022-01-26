package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "USERNAME") // db 테이블명 설정, not null
    private String username;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "TEAM_ID")
    public Team team;

/*    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodifiedDate;

    @Lob
    private String description;

    @Transient // DB와 상관없는 컬럼에 적용
    private int temp;*/

}
