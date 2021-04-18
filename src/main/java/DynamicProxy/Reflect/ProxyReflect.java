package DynamicProxy.Reflect;

import Common.BusinessModel;
import Common.IBusiness;
import Common.ICalculation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyReflect {
    public static void main(String[] args)
    {
        BusinessModel model = new BusinessModel();
        BusinessInvocationHandler businessInvocationHandler = new BusinessInvocationHandler(model);
        ICalculation proxiedCalcationModel = (ICalculation)
            Proxy.newProxyInstance(
                    BusinessModel.class.getClassLoader(),
                    //传入需要被代理的方法(接口的方式)
                    model.getClass().getInterfaces(),
                    businessInvocationHandler
            );
        //实现了ICalculation
        System.out.println(proxiedCalcationModel instanceof ICalculation);
        proxiedCalcationModel.Calculate();
        //实现了IBusiness
        System.out.println(proxiedCalcationModel instanceof IBusiness);
        ((IBusiness)proxiedCalcationModel).DoBusiness();
        //不可以强转成BusinessModel,尴尬
        System.out.println(proxiedCalcationModel instanceof BusinessModel);
        System.out.println(proxiedCalcationModel.getClass().getName());

    }
}
