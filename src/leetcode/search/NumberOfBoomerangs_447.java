package leetcode.search;

import java.util.HashMap;

/**
 * Created by cdx0312
 * 2018/4/5
 */
public class NumberOfBoomerangs_447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            //和i点的距离，距离出现的频率
            HashMap<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis)){
                        record.put(dis, record.get(dis)+1);
                    } else {
                        record.put(dis, 1);
                    }
                }
            }
            for (Integer integer : record.keySet()) {
                if (record.get(integer) >= 2) {
                    res += record.get(integer) * (record.get(integer)-1);
                }
            }
        }
        return res;
    }

    private int dis(int[] point, int[] point1) {
        return (point[0] - point1[0]) * (point[0] - point1[0])
                + (point[1] - point1[1]) * (point[1] - point1[1]);
    }
}
