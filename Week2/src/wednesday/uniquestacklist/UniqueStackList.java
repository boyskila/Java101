package wednesday.uniquestacklist;

import wednesday.doublylinkedlist.DoublyLinkedList;
import wednesday.stack.exceptions.DuplicateValueException;
import wednesday.stacklist.StackList;

public class UniqueStackList<T> {

	public static StackList<Integer> createStack() {
		return new StackList<Integer>() {
			DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();

			@Override
			public Integer push(Integer element) {
				if (ll.contains(element)) {
					throw new DuplicateValueException("UniqueStackList can contain only unique values");
				}
				ll.add(element);
				return element;
			}

			@Override
			public Integer peek() {
				return ll.getLast();
			}

			@Override
			public Integer pop() {
				return ll.removeLast();
			}

			@Override
			public int size() {
				return ll.size();
			}

			@Override
			public boolean isEmpty() {
				return ll.isEmpty();
			}
		};
	}
}
