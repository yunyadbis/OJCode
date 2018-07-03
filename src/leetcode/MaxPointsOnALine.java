package leetcode;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.*;
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        int len = points.length;
        if(len<3) return len;
        int max = 0;
        // <б�ʣ���б����ͬ�Ķ������>
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        double slope;
        for(int i=0; i<len; i++){
            map.clear();
            int same = 1; //���ڼ�¼����ǰ����ĺ������궼��ͬ�ĵ�
            for(int j=0; j<len; j++){
                if(j!=i){//ֻ����������
                    if( points[i].x==points[j].x && points[i].y==points[j].y ){//������ͬ
                        same ++;
                        continue;
                    }
                    else if( points[i].x==points[j].x )//������x������ͬ
                    {
                        slope = Integer.MAX_VALUE;
                    }
                    else{
                        slope = 1.0*(points[j].y - points[i].y) / (points[j].x - points[i].x);
                    }
                    map.put(slope, map.containsKey(slope)? (map.get(slope)+1) : 1);
                }
            }
            if(map.keySet().size()==0){
                max = same > max? same: max;
            }
            else{
                for(double key:map.keySet()){
                    max = same+map.get(key)>max? (same+map.get(key)): max;
                }
            }
        }
        return max;
            
    }
}
