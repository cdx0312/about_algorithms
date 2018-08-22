import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/13
 */
public class TwoStackImpQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public Integer pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            try {
                throw new Exception("queue is empty");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return stack2.pop();
    }
}
