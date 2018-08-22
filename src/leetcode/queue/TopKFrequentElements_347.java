package leetcode.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cdx0312
 * 2018/4/8
 */
public class TopKFrequentElements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        //统计数组中的元素出现的频率，key-num, value-次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        //扫描map，维护当前频率最高的k个元素,
        PriorityQueue<Pair> queue = new PriorityQueue<>(k);
        for (Integer i : map.keySet()) {
            if (queue.size() == k) {
                if (map.get(i) > queue.peek().freq){
                    queue.poll();
                    queue.add(new Pair(map.get(i),i));
                }
            } else {
                queue.add(new Pair(map.get(i), i));
            }
        }
        //遍历优先队列，将num加入到结果集中
        for (Pair pair : queue) {
            res.add(0, pair.num);
        }
        return res;
    }

    class Pair implements Comparable<Pair>{
        int freq;
        int num;
        public Pair(int freq, int num) {
            this.freq = freq;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }
    }
}
