package tmp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cdx0312
 * 2018/3/30
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> random = new ArrayList<>();
        InvocationHandler h = new TimeHandler(random);
        ArrayList<Integer> o = (ArrayList<Integer>) Proxy.newProxyInstance(random.getClass().getClassLoader(), random.getClass().getInterfaces(),h);
        o.add(12);
    }
}
