package week6_inheritance.study.object.clone;

import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * clone 기본 구현의 문제점 재현 시도
 * 잘 안됨
 */
public class CloneStudyV1 {

    static class UserSubclass extends User{
        public UserSubclass(String username, Password password) {
            super(username, password);
        }

        public void run() throws CloneNotSupportedException {
            User clone = (User) super.clone();
            super.setPassword(new Password("5678"));

            System.out.println(super.toString());
            System.out.println(clone);
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

    static class User implements Cloneable{
        String username;
        Password password;

        public User(String username, Password password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password=" + password.str +
                    '}';
        }

        public void setPassword(Password password) {
            this.password=password;
        }
    }

    static class Password{
        String str;
        public Password(String str) { this.str = str; }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new UserSubclass("haha", new Password("1234")).run();
    }


}
