public class Solution {

    private static void topKFrequent(int[] nums, int k) {

        int flag;
        int index = 0;
        int[] b = new int[nums.length];
        int[] c = new int[nums.length];

        for (int num : nums) {
            flag = 0;
            for (int j = 0; j < index; j++) {
                if (num == b[j]) {
                    flag = 1;
                    c[j]++;
                }
            }
            if (flag == 0) {
                b[index] = num;
                index++;
            }
        }

        int[] newB = deleteZero(b);
        int[] newC= new int[newB.length];

        for (int i = 0; i < newB.length; i++) {
            newC[i] = c[i];
            newC[i] ++;
        }

        int max = findMax(nums);

        int[] sorted = bucket_sort(newC, b, max);

        reverseTopK(sorted, k);

    }

    private static int[] reverseTopK(int[] array, int k) {

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        int[] newArray = deleteZero(array);

        for (int i = 0; i < k; i++) {
            System.out.println("result:" + newArray[i]);
        }

        return newArray;
    }

    private static int[] deleteZero(int[] array) {

        int count = 0;
        int j = 0;

        for (int anArray : array) {
            if (anArray == 0) {
                count++;
            }
        }

        int[] newArray = new int[array.length - count];

        for (int anArray : array) {

            if (anArray != 0) {
                newArray[j++] = anArray;
            }
        }

        return newArray;
    }

    private static int findMax(int[] array) {

        int max = array[0];

        for (int anArray : array) {
            if (anArray > max) {
                max = anArray;
            }
        }

        return max;
    }

    private static int[] bucket_sort(int[] bucket, int[] goBucket, int maxNumInBucket) {

        int[] sortedBucket = new int[maxNumInBucket + 1];

        for (int i = 0; i < bucket.length; i++) {
            sortedBucket[bucket[i]] = goBucket[i];
        }

        return sortedBucket;
    }

    public static void main(String[] args) {

        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 6, 6, 6, 6, 6, 6, 8, 8, 9, 9, 10};

        topKFrequent(a, 3);

    }
}
