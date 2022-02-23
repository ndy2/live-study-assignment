package week6_inheritance.study;

public class FinalStudy {

}

class Member {
    static final String classID = "Member-Class";
    final String username;

    Member(String username) {
        super();
        this.username = username;
    }
}

class PasswordMember extends Member{
    String password;

    PasswordMember(String username) {
        super(username);
    }
}



