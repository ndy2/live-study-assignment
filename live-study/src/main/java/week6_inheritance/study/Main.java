package week6_inheritance.study;

public class Main {

    public static void main(String[] args) {
        A a = new C();
        a.hello();

        B b = new C();
        b.hello();
    }
}

interface A{
    void hello();
}

interface B{
    void hello();
}

class C implements A, B{
    @Override
    public void hello() {
        System.out.println("hello");
    }
}
