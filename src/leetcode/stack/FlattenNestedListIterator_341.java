package leetcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class FlattenNestedListIterator_341 implements Iterator<Integer>{
    Stack<NestedInteger> stack = new Stack<>();
    Stack<Integer> integers = new Stack<>();
    public FlattenNestedListIterator_341(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            NestedInteger nestedInteger = stack.pop();
            if (nestedInteger.isInteger()) {
                integers.push(nestedInteger.getInteger());
            } else {
                for (NestedInteger j : nestedInteger.getList()){
                    stack.push(j);
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !integers.isEmpty();
    }

    @Override
    public Integer next() {
        return integers.pop();
    }
}
