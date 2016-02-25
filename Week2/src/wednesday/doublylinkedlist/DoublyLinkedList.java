package wednesday.doublylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements DoublyLinkeListInterface<T>, Iterable<T> {
	public class Node {
		private Node next;
		private Node prev;
		private T data;
		private int id;

		Node(Node prev, T data, Node next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}

	private Node tail;
	private Node head;
	private int size;

	public DoublyLinkedList() {
		size = 0;
	}

	@Override
	public T add(T element) {
		Node n = new Node(head, element, null);
		if (head != null) {
			n.id = head.id + 1;
			head.next = n;
		}
		head = n;
		if (tail == null) {
			n.id = 0;
			tail = n;
		}
		size++;
		return element;
	}

	@Override
	public void print() {
		System.out.print("[ ");
		if (!isEmpty()) {
			Node current = tail;
			while (current.next != null) {
				System.out.print(current.data + ", ");
				current = current.next;
			}
			System.out.print(current.data);
		}
		System.out.print(" ]");
	}

	@Override
	public void printInReverseOrder() {
		System.out.print("[ ");
		if (!isEmpty()) {
			Node current = head;
			while (current.prev != null) {
				System.out.print(current.data + ", ");
				current = current.prev;
			}
			System.out.print(current.data);
		}
		System.out.print(" ]");
	}

	@Override
	public boolean remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node current = tail;
		while (current != null) {
			current = current.next;
			if (current.id == index) {
				current.next = current.next.next;
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public T removeLast() {
		if (head != null) {
			T data = head.data;
			head = head.prev;
			return data;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node current = tail;
		while (current != null) {
			current = current.next;
			if (current.id == index) {
				return current.data;
			}
		}
		return null;
	}

	@Override
	public T getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	@Override
	public T getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	@Override
	public void clear() {
		tail = null;
	}

	@Override
	public boolean isEmpty() {
		return head == null;

	}

	@Override
	public boolean set(int index, T newData) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node current = tail;
		while (current != null) {
			current = current.next;
			if (current.id == index) {
				current.data = newData;
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			Node current = null;

			@Override
			public boolean hasNext() {
				return !isEmpty() && current != head;
			}

			@Override
			public T next() {
				if (current == null) {
					current = tail;
					return current.data;
				}
				if (current.next == null) {
					throw new NoSuchElementException();
				}
				current = current.next;
				return current.data;
			}
		};
	}

	public boolean contains(T element) {
		if (!isEmpty()) {
			Node current = head;
			while (current.prev != null) {
				current = current.prev;
				if (current.data == element) {
					return true;
				}
			}
		}

		return false;
	}
}
