package DynamicProxy.Reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BusinessInvocationHandler implements InvocationHandler {
    private Object target;

    public BusinessInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println(method.getName()+"开启,记录日志");
        Object result = method.invoke(target, args);
        System.out.println(method.getName()+"结束,记录日志");
        return result;
    }
}
