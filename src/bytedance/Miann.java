package bytedance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IVehical {

    void run();

}

//concrete implementation
class Car implements IVehical{

    public void run() {
        System.out.println("Car is running");
    }

}

//proxy class
class VehicalProxy {

    private IVehical vehical;

    public VehicalProxy(IVehical vehical) {
        this.vehical = vehical;
    }

    public IVehical create(){
        final Class<?>[] interfaces = new Class[]{IVehical.class};
        final VehicalInvacationHandler handler = new VehicalInvacationHandler(vehical);

        return (IVehical) Proxy.newProxyInstance(IVehical.class.getClassLoader(), interfaces, handler);
    }

    public class VehicalInvacationHandler implements InvocationHandler {

        private final IVehical vehical;

        public VehicalInvacationHandler(IVehical vehical) {
            this.vehical = vehical;
        }

        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            System.out.println("--before running...");
            Object ret = method.invoke(vehical, args);
            System.out.println("--after running...");

            return ret;
        }

    }
}

public class Miann {
    public static void main(String[] args) {

        IVehical car = new Car();
        VehicalProxy proxy = new VehicalProxy(car);

        IVehical proxyObj = proxy.create();
        proxyObj.run();
    }
}