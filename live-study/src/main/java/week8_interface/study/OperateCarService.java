package week8_interface.study;

public class OperateCarService {

    public static void main(String[] args) {
//        OperateCar operateCar = new OperateCar();
        OperateBMW760i operateBMW760i = new OperateBMW760i();
        OperateCar polymorphism = new OperateBMW760i();
    }
}
