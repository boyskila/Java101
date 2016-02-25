package monday.vector;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenericVector<T> extends AbstractList<T> implements List<T>,
		Iterable<T> {
	private Object[] data;
	private int elementCount;
	private static final int INITIAL_CAPACITY = 10;

	public GenericVector(int initialCapacity) {
		elementCount = 0;
		data = new Object[INITIAL_CAPACITY];
	}

	public GenericVector(Object[] arr) {
		elementCount = arr.length;
		data = new Object[elementCount];
		data = arr;
	}

	@Override
	public int size() {
		return elementCount;
	}

	@Override
	public boolean isEmpty() {
		return elementCount == 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < elementCount
						&& data[currentIndex] != null;
			}

			@SuppressWarnings("unchecked")
			@Override
			public T next() {
				return (T) data[currentIndex++];
			}
		};
	}

	@Override
	public synchronized Object[] toArray() {
		return Arrays.copyOf(data, elementCount);
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public synchronized <T> T[] toArray(T[] a) {
		if (a.length < elementCount) {
			return (T[]) Arrays.copyOf(data, elementCount, a.getClass());
		}
		System.arraycopy(data, 0, a, 0, elementCount);
		if (a.length > elementCount) {
			a[elementCount] = null;
		}
		return a;
	}

	private void resizeArray() {
		int newSize = data.length * 2;
		data = Arrays.copyOf(data, newSize);

	}

	@Override
	public synchronized boolean add(T e) {
		if (elementCount == data.length) {
			resizeArray();
		}
		data[elementCount++] = e;
		return true;
	}

	@Override
	public synchronized boolean remove(Object o) {
		int index = indexOf(o);
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= "
					+ elementCount);
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int j = elementCount - index - 1;
		if (j > 0) {
			System.arraycopy(data, index + 1, data, index, j);
		}
		elementCount--;
		data[elementCount] = null;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
//		int len = c.size();
		
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		c = null;
		return c == null;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		data = null;
		elementCount = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return (T) data[index];
	}

	@Override
	public synchronized T set(int index, T e) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		T oldValue = get(index);
		data[index] = e;
		return oldValue;
	}

	@Override
	public void add(int index, T element) {
		int length = data.length;
		Object[] destination = new Object[length + 1];
		System.arraycopy(data, 0, destination, 0, index);
		destination[index] = element;
		System.arraycopy(data, index, destination, index + 1, length - index);
		data = destination;
		elementCount++;
	}

	@Override
	public synchronized T remove(int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		T oldValue = get(index);

		int numMoved = elementCount - index - 1;
		if (numMoved > 0) {
			System.arraycopy(data, index + 1, data, index, numMoved);
		}
		return oldValue;
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < elementCount; i++) {
			if (o.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public synchronized int lastIndexOf(Object o) {
		int index = 0;
		boolean found = false;
		for (int i = elementCount; i > 0; i--) {
			if (o.equals(data[i])) {
				index = i;
				found = true;
			}
		}
		if (!found) {
			return -1;
		}
		return index;
	}

	@SuppressWarnings("hiding")
	private class ListIter<T> implements ListIterator<T> {
		int nextElement = 0;
		int prevElement = elementCount;
		int current = 0;

		@Override
		public boolean hasNext() {
			return nextElement != elementCount;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			current = nextElement;
			nextElement = nextElement + 1;
			return (T) data[current];
		}

		@Override
		public boolean hasPrevious() {
			return prevElement > 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T previous() {
			prevElement--;
			current = prevElement;
			return (T) GenericVector.this.get(current);
		}

		@Override
		public int nextIndex() {
			return nextElement;
		}

		@Override
		public int previousIndex() {
			return prevElement;
		}

		@Override
		public void remove() {
			GenericVector.this.remove(current);
			elementCount--;
			prevElement--;
			nextElement = 0;
		}

		@Override
		public void set(T e) {
			//this.set(e);
		}

		@Override
		public void add(T e) {

		}
	};

	@Override
	public ListIterator<T> listIterator(int index) {
		return new ListIter<>();
	}

	@Override
	public synchronized List<T> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0)
			throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
		if (toIndex > elementCount)
			throw new IndexOutOfBoundsException("toIndex = " + toIndex);
		if (fromIndex > toIndex)
			throw new IllegalArgumentException("fromIndex(" + fromIndex
					+ ") > toIndex(" + toIndex + ")");
		return new SubList<>(data, fromIndex, toIndex + 1);
	}

	@Override
	public String toString() {
		if (elementCount == 0) {
			return "[]";
		}
		String str = "[";
		for (int i = 0; i < elementCount - 1; i++) {

			str += data[i] + ", ";
		}
		str += data[elementCount - 1] + "]";
		return str;
	}
}