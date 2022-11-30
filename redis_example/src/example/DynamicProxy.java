package example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Stack;

public class DynamicProxy implements InvocationHandler {

    private Object targetObject;

    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("before invoke ");
            long begin = System.currentTimeMillis();
            proxy = method.invoke(targetObject, args);
            long end = System.currentTimeMillis();
            System.out.println("after invoke elpased " + (end - begin));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("invoke failed!");
            throw e;
        }
        return proxy;
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        Animals cat = (Animals) dynamicProxy.newProxyInstance(new Cat());
        cat.eat();
        Animals dog = (Animals) dynamicProxy.newProxyInstance(new Dog());
        dog.eat();
    }
}


