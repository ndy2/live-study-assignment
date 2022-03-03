package week9_exception.study;

public class Ex {
    public static void main(String[] args) {
        try {
            System.out.println("hello world");
            System.out.println("args[0] = " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e){
            logError(e);
        }
        finally {
            System.out.println("hello me");
        }

        Hello hello = new Hello();
//        hello.runtimeEx(); //-> 컴파일러가 알려주지 않음
        try{
            hello.runtimeEx();
        }catch (CustomRunTimeException e) {
            logError(e);
        }

//        hello.ex(); // -> 컴파일러가 알려줌
        try {
            hello.ex();
        } catch (CustomException e) {
            logError(e);
        }
    }

    private static void logError(Exception e) {
        System.out.println("[Exception] " + e.getClass().getSimpleName() + "message : " + e.getMessage());
    }

    static class CustomRunTimeException extends RuntimeException{
        public CustomRunTimeException(String message) {
            super(message);
        }
    }

    static class CustomException extends Exception{
        public CustomException(String message) {
            super(message);
        }
    }

    static class Hello{
        public void runtimeEx(){
            System.out.println("hello");
            throw new CustomRunTimeException("runtime(unchecked) exception");
        }

        public void ex() throws CustomException {
            System.out.println("hello");
            throw new CustomException("(checked) exception");
        }
    }
}
