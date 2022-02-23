package week6_inheritance.study;

interface Animal {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}
interface EggLayer extends Animal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}
interface FireBreather extends Animal {
//    default public String identifyMyself() {
//        return "I am able to lay eggs.";
//    }
}


public class Dragon implements FireBreather, EggLayer{
    public static void main (String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}
