package week8_interface.study;

public interface DoIt {
    void doSomething(int i, double x);
    int doSomethingElse(String s);
    boolean didItWork(int i, double x, String s);
}

class DoItImpl implements DoIt{
    @Override
    public void doSomething(int i, double x) {
    }

    @Override
    public int doSomethingElse(String s) {
        return 0;
    }

    @Override
    public boolean didItWork(int i, double x, String s) {
        return false;
    }
}
