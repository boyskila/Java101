package monday.vector;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class SubList<T> extends AbstractList<T> {
	private final List<T> original;
	private final int from;
	private final int to;
	private int size;

	@SuppressWarnings("unchecked")
	public SubList(Object[] original, int from, int to) {
		List<T> l = (List<T>) Arrays.asList(original);
		this.original = l;
		this.from = from;
		this.to = to;
		size = to - from;
	}

	public T get(int i) {
		if (i < 0 || i > to - from) {
			throw new IllegalArgumentException();
		}

		return original.get(from + i);
	}

	public SubList<T> subList() {
		return this;
	}

	@Override
	public int size() {
		return size;
	}
}
