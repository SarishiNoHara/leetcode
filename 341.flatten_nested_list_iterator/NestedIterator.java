/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

	ArrayDeque<Iterator<NestedInteger>> deque = new ArrayDeque();

	Integer current = null;

	public NestedIterator(List<NestedInteger> nestedList) {


		deque.push(nestedList.iterator());

	}

	@Override
		public Integer next() {

			Integer next = current;

			return next;

		}

	@Override
		public boolean hasNext() {

			while(!deque.isEmpty()){

				Iterator<NestedInteger> node = deque.peek(); //?

				if(!node.hasNext()){

					deque.pop();

					continue;

				}

				NestedInteger next = node.next();

				if(next.isInteger()){

					current = next.getInteger();

					return true;

				}else{

					deque.push(next.getList().iterator());

				}

			}

			return false;

		}

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
