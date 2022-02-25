package week7_package.study.classpath;

public class HelloWorld {

    public static void main(String[] args) {
        UtilClass utilClass = new UtilClass();
        SupportClass supportClass = new SupportClass();
        System.out.println("HelloWorld.main");
        String line = "hi";
        System.out.println("line = " + line);
    }
}
class SupportClass{}
class UtilClass{}
