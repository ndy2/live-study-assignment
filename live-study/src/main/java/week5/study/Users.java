package week5.study;

public class Users {

    private String username;
    private int age;

    public boolean hasLastname(String lastname){
        return username.startsWith(lastname);
    }

    public boolean isTeenage(){
        return age>=10&&age<20;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

