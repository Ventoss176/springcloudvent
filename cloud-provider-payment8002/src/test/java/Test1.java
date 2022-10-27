import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/27
 * @description:
 */
public class Test1 {

    @Test
    public void testin(){
        AtomicInteger atomicInteger = new AtomicInteger(0);

        int i;
        int next;

            i = atomicInteger.get();

            next = i + 1;

            i = atomicInteger.get();

        System.out.println(next);
            next = i + 1;

        System.out.println(next);

        System.out.println(i);
    }
}
