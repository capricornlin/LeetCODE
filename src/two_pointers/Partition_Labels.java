package two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partition_Labels {

        public List<Integer> partitionLabels(String S) {
            List<Integer> res = new ArrayList<>();
            Map<Character,Integer> hashmap = new HashMap<>();
            int rightmost=Integer.MIN_VALUE;
            int start_point = 0;
            for(int i = 0; i< S.length();i++){
                hashmap.put(S.charAt(i),i);
            }
            for(int i = 0; i < S.length();i++){
                char ch = S.charAt(i);
                rightmost = Math.max(rightmost,hashmap.get(ch));
                if(i == rightmost){
                    res.add(rightmost-start_point+1);
                    start_point = rightmost+1;
                }

            }
            return res;
        }

        public static void main(String[] args){
            String s ="ababcbacadefegdehijhklij";
            Partition_Labels p = new Partition_Labels();
            p.partitionLabels(s);
        }

    }


/**

 S = "ababcbaca defegde hijhklij"
 The partition is "ababcbaca", "defegde", "hijhklij".
 9 15
 1.hashmap紀錄<char,Integer> 每一個char right most的值
 2.time complexity: O(N)



 */



