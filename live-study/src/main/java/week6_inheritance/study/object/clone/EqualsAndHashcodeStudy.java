package week6_inheritance.study.object.clone;

import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class EqualsAndHashcodeStudy {

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(username, user.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username);
        }

        @Override
        public void finalize() throws Throwable {
            super.finalize();
        }
    }

    public static void main(String[] args) throws Throwable {
        User userOrig = new User("haha");
        userOrig.finalize();
        User userClone = userOrig.clone();
        System.out.println("userClone = " + userClone);
        System.out.println(userOrig==userClone);
    }
}
