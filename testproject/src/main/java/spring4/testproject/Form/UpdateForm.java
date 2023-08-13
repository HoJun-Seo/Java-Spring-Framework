package spring4.testproject.Form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateForm {

    private String currentUserId; // hidden 으로 숨기기

    private String currentUserPwd;
    private String updateUserPwd;

}
