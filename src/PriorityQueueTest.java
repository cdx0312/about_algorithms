import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int tmp = random.nextInt(100);
            queue.add(tmp);
        }
        System.out.println(queue.toString());
    }
}
