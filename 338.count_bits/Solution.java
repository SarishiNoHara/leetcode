import java.util.ArrayList;
import java.util.List;

public class Solution {
	private int[] countBits(int num) {

		List<Integer> bits = new ArrayList<>();

		int[] array = new int[num + 1];

		int currentBit, eachNumber, currentNum;

		int count = 0, w = 0;

		for(eachNumber = 0; eachNumber <= num; eachNumber++) {

			currentNum = eachNumber;

			//add 1, 0 to each number's list
			for (int i = 0; i <= bits.size(); i++) {

				currentBit = currentNum % 2;

				currentNum = (currentNum >> 1);

				bits.add(currentBit);

				if (currentNum < 1)

					break;
			}

			//count 1 in each number list
			for (Integer j : bits) {

				if (j == 1)

					count++;

			}

			//add count to array
			array[w] = count;

			w ++;

			//initialize bits list and count
			bits.clear();

			count =0;

		}

		return array;

	}

	public static void main(String[] args) {

		Solution a = new Solution();

		int[] b = a.countBits(10);

		for(int num: b){

			System.out.println(num);
		}

	}
}
