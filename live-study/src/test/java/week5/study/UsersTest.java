package week5.study;

import org.junit.jupiter.api.Test;

class UsersTest {

    @Test
    void accessSpecifierTest(){
        Users users = new Users();
        users.username = "홍길동";
        String username = users.username;
    }

    @Test
    void getterSetterTest(){
        Users users = new Users();
        users.setUsername("홍길동");
        String username = users.getUsername();
    }
}