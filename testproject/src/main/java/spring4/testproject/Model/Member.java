package spring4.testproject.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "userId")
    private String userId;
    @Column(name = "userPwd")
    private String userPwd;
}
