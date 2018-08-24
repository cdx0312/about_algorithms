import leetcode.linkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 從數組中選取M個元素的組合
 */
public class Combinations {
    private static void combinations (List<Integer> data, int n, List<Integer> selected) {
        if (n == 0) {
            for (Integer integer : selected) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        if (data.isEmpty())
            return;

        selected.add(data.get(0));
        combinations(data.subList(1, data.size()), n-1, selected);

        selected.remove(selected.size() - 1);
        combinations(data.subList(1, data.size()), n, selected);
    }

    public static void main(String[] args) {
        combinations(Arrays.asList(1,2,3,4,5), 3, new ArrayList<>());
    }
}
