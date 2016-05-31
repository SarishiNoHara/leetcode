import java.util.*;

public class Solution {

	public List<String> findItinerary(String[][] tickets) {

		//Add tickets to hashmap
		Map<String, ArrayList<String>> hash = new HashMap<>();

		List<String> result = new ArrayList<>();

		if (tickets == null && tickets.length == 0) {

			return result;

		}

		//replace duplicated keys by second arraylist (JFK -> SFO to JFK -> SFO && ATL)
		for (int i = 0; i < tickets.length; i++) {

			if (!hash.containsKey(tickets[i][0])) {

				ArrayList<String> a = new ArrayList<>();

				a.add(tickets[i][1]);

				hash.put(tickets[i][0], a);

			} else {

				ArrayList<String> b = hash.get(tickets[i][0]);

				b.add(tickets[i][1]);

				hash.put(tickets[i][0], b);

			}

		}

		for (ArrayList<String> a : hash.values()) {

			Collections.sort(a);

		}

		//Create a stack
		ArrayDeque<String> deque = new ArrayDeque<>();

		deque.push("JFK");

		//find value according to key and push the removed (first) value of arraylist to stack
		while (!deque.isEmpty()) {

			while (hash.containsKey(deque.peek()) && !hash.get(deque.peek()).isEmpty()) {

				deque.push(hash.get(deque.peek()).remove(0));

			}

			result.add(0, deque.pop());

		}

		return result;

	}


	public static void main(String[] args) {

		String[][] tickets = new String[3][2];

		tickets[0][0] = "JFK";
		tickets[0][1] = "KUL";

		tickets[1][0] = "JFK";
		tickets[1][1] = "NRT";

		tickets[2][0] = "NRT";
		tickets[2][1] = "JFK";

		Solution a = new Solution();

		System.out.println(a.findItinerary(tickets));

	}

}
