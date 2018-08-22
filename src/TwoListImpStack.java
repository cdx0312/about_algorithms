import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cdx0312
 * 2018/4/13
 */
public class TwoListImpStack {
    private Queue<Integer> list1 = new LinkedList<>();
    private Queue<Integer> list2 = new LinkedList<>();

    public void push(int node) {
        if (list1.isEmpty() && list2.isEmpty()){
            list1.add(node);
        } else if (list1.isEmpty()) {
            list2.add(node);
        } else {
            list2.add(node);
        }
    }

    public Integer pop() {
        if (list1.isEmpty() && list2.isEmpty()){
            try {
                throw new Exception("stack is Empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (list1.isEmpty()) {
            while (list2.size() > 1) {
                list1.add(list2.poll());
            }
            return list2.poll();
        } else {
            while (list1.size() > 1) {
                list2.add(list1.poll());
            }
            return list1.poll();
        }
        return null;
    }


}
