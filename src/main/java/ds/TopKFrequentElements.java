package ds;

import java.util.*;

public class TopKFrequentElements {

    /*Input: nums = [1,1,1,2,2,3],
      k = 2 Output: [1,2]*/

    public static void main(String[] args) {
        int[] num ={1,1,1,2,2,3,3,2,1,3,2,4,5,1,4,4,2,2,3};
        int k =4;
        for(int i: frequentNum(num,k)){
            System.out.println(i);
        }
    }
     static List<Integer> frequentNum(int[] num,int k){

        //Put values in map with frequency
        Map<Integer,Integer> freq =new HashMap<>();
        for(int i:num)
        {
            //System.out.println(i);
            freq.put(i,freq.getOrDefault(i,0)+1);
            System.out.println( i+ ":" + freq.getOrDefault(i,0) +": " +freq.entrySet() );
        }

        //Define priority queue Sort by Frequency
        PriorityQueue<Map.Entry<Integer,Integer>> maxHip = new PriorityQueue<>((a,b) ->b.getValue()-a.getValue());
        maxHip.addAll(freq.entrySet());

         PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry<Integer,Integer>::getValue).reversed());
         pq.addAll(freq.entrySet());
         //System.out.println(pq.);

        //extract top k elements from the heap
         List<Integer> result = new ArrayList<>();
         for(int i=0;i<k;i++){
             result.add(pq.poll().getKey());
         }

        return result;
     }

}
