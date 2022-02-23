package week6_inheritance.study;

public class MainOverride {

    public static void main(String[] args) {

    }
}

class Parent{
    Parent myMethod(){
        return this;
    }
}

class Child extends Parent{
    @Override
    Child myMethod() {
        return this;
    }   //Covariant return type!
}