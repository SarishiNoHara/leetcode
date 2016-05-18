import java.util.*;


class EntryComparator implements Comparator<Map.Entry<Integer, Integer>> {

    public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {

        return arg0.getValue().compareTo(arg1.getValue());

    }
}


public class Solution {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hash = new HashMap<>();

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        List<Integer> newCopy = new ArrayList<>();

        int ownCounter = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            Integer count = hash.get(num);

            if (count != null) {
                
                hash.put(num, count + 1);
            
            } else {
            
                hash.put(num, 1);
            
            }

        }

        list.addAll(hash.entrySet());

        list.sort(new EntryComparator());

        Collections.reverse(list);

        for (Map.Entry<Integer, Integer> e : list) {

            if (ownCounter < k) {

                newCopy.add(e.getKey());

                System.out.println(e.getKey());

            }

            ownCounter++;

        }

        return newCopy;
    }

  
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        topKFrequent(nums, 4);

    }

}
