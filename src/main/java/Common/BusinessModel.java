package Common;

public class BusinessModel implements IBusiness,ICalculation {
    @Override
    public void DoBusiness() {
        System.out.println("处理业务,此处略去一万行代码!");
    }

    @Override
    public void Calculate() {
        System.out.println("处理运算,此处略去一万行代码!");
    }
}
