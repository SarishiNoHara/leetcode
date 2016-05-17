public class Solution{

	public static int[] topKFrequent(int[] nums, int k){
		
		int index = 0;
		int flag;
		int[] b = new int[nums.length];
		int[] c = new int[nums.length];

		for(int i = 0; i < nums.length; i++){
			flag = 0;
			for(int j = 0; j < index; j++){
				if(nums[i] == b[j]){
					flag = 1;
					c[j] ++ ;
				}
			}
			if(flag == 0){
				b[index] = nums[i];
				index ++;
			}
		}
	
		int[] newB = deleteZero(b);	
		int[] d = new int[newB.length];
	
		for(int i = 0; i< newB.length; i++){
			d[i] = c[i];
			d[i]++;
		}
	
		int[] newC = d;
		
		int max = findMax(nums);	
		
		int [] sorted = bucket_sort(newC, b, max);
	
		int [] finalarr = showTopK(sorted, k);	
	
		return finalarr;	
	}

	public static int[] showTopK(int[] array, int k){
		
		for(int i = 0; i <array.length / 2; i++){
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
		
		int[] newArray = deleteZero(array);
	
		for(int i = 0; i<k ; i++){
			System.out.println("result:"+newArray[i]);
		}
	
		return newArray;
	}

	public static int[] deleteZero(int[] array){
		
		int count = 0;
		int j = 0;
		
		for(int i=0; i < array.length; i++){
			if(array[i] == 0){
				count ++;
			}
		}
	
		int[] newArray1 = new int[array.length - count];

		for(int i=0; i < array.length; i++){

			if(array[i] != 0){
				newArray1[j++] = array[i];
			}
		}
	
		return newArray1;
	}

	public static int findMax(int[] array){
	
		int max = array[0];
		
		for(int i = 0; i < array.length; i++){
			if(array[i]>max){
				max = array[i];
			}
		}
		
		return max;
	}

	public static int[] bucket_sort(int[] bucket, int[] goBucket, int maxNumInBucket){
		
		int[] sortedBucket = new int[maxNumInBucket+1];
	
		for(int i = 0; i < bucket.length; i++){
			sortedBucket[bucket[i]] = goBucket[i];
		}
	
		return sortedBucket;    
	}

	public static void main(String[] args){
		
		int[] a = {1,1,1,1,1,1,1,1,4,4,4,6,6,6,6,6,6,8,8,9,9,10};
		
		int[] meow = topKFrequent(a, 2);
		
	}  
}
