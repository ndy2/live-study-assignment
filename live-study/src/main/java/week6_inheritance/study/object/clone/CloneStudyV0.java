package week6_inheritance.study.object.clone;

public class CloneStudyV0 {

    static class User implements Cloneable{
        String username;

        public User(String username) {
            this.username = username;
        }

        @Override
        public User clone() throws CloneNotSupportedException {
            return (User)super.clone();
        }

        @Override
        public String toString() {
            return "User{username='" + username +'}';
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User userOrig = new User("haha");
        User userClone = userOrig.clone();
        System.out.println("userClone = " + userClone);
        System.out.println(userOrig==userClone);
    }
}
