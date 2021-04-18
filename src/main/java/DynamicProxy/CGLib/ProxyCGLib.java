package DynamicProxy.CGLib;

import Common.BusinessModel;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class ProxyCGLib {
    public static void main(String[] args)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BusinessModel.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                //obj 对应调用方法对应的this
                //method 对应调用方法对应的信息
                //args 对应方法对应的入参
                //proxy ?
                System.out.println(method.getName()+"开启,记录日志");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println(method.getName()+"结束,记录日志");
                return result;
            }
        });

        BusinessModel proxiedModel = (BusinessModel)enhancer.create();
        proxiedModel.DoBusiness();
        proxiedModel.Calculate();
    }
}
