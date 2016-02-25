package friday.hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V>, Iterable<K> {
	@SuppressWarnings("hiding")
	private class MapEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;

		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}

		@Override
		public String toString() {
			return "[key=" + key + ", value=" + value + "]";
		}
	}

	private static final float LOAD_FACTOR = 0.75f;
	private static final int INITIAL_CAPACITY = 16;
	private List<List<Entry<K, V>>> buckets;
	private int capacity;
	private int totalEntries;

	public MyHashMap() {
		this(INITIAL_CAPACITY);
	}

	public MyHashMap(int initialCapacity) {
		capacity = initialCapacity;
		buckets = new ArrayList<>(initialCapacity);
		totalEntries = 0;
		loadBuckets();
	}

	private void loadBuckets() {
		for (int i = 0; i < capacity; i++) {
			buckets.add(new LinkedList<Entry<K, V>>());
		}
	}

	static int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	static int indexFor(int h, int length) {
		return h & (length - 1);
	}

	@Override
	public int size() {
		return totalEntries;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		if (key == null) {
			return false;
		}
		int hash = hash(key.hashCode());
		int position = indexFor(hash, capacity);
		List<Entry<K, V>> entries = buckets.get(position);
		for (Entry<K, V> mapEntry : entries) {
			if (mapEntry.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		Iterator<List<Entry<K, V>>> it = buckets.iterator();
		while (it.hasNext()) {
			List<Entry<K, V>> list = (List<Entry<K, V>>) it.next();
			for (Entry<K, V> entry : list) {
				if (entry.getValue().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		int hash = hash(key.hashCode());
		int position = indexFor(hash, capacity);
		if (key == null || buckets.get(position) == null) {
			throw new NullPointerException();
		}
		List<Entry<K, V>> listEntry = buckets.get(position);
		for (Entry<K, V> mapEntry : listEntry) {
			if (mapEntry.getKey().equals(key)) {
				return mapEntry.getValue();
			}
		}
		return null;
	}

	private void resizeMap() {
		totalEntries++;
		capacity *= 2;
		List<List<Entry<K, V>>> tempBuckets = buckets;
		buckets = new ArrayList<>(capacity);
		loadBuckets();
		for (List<Entry<K, V>> list : tempBuckets) {
			for (Entry<K, V> el : list) {
				put(el.getKey(), el.getValue());
			}
		}
	}

	private boolean isReadyForResize() {
		return (LOAD_FACTOR * capacity) < totalEntries;
	}

	@Override
	public V put(K key, V value) {
		if (isReadyForResize()) {
			totalEntries = 0;
			resizeMap();
		}
		int hash = hash(key.hashCode());
		int position = indexFor(hash, capacity);
		if (key == null || buckets.get(position) == null) {
			throw new NullPointerException();
		}
		List<Entry<K, V>> listEntry = buckets.get(position);
		for (Entry<K, V> entry : listEntry) {
			if (entry.getKey().equals(key)) {
				remove(entry.getKey());
				break;
			}
		}
		listEntry.add(new MapEntry<>(key, value));
		totalEntries++;
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		int hash = hash(key.hashCode());
		int position = indexFor(hash, capacity);
		List<Entry<K, V>> mapEntry = buckets.get(position);
		Iterator<Entry<K, V>> it = mapEntry.iterator();
		while (it.hasNext()) {
			Entry<K, V> entry = it.next();
			if (entry.getKey().equals(key)) {
				it.remove();
			}
		}
		totalEntries--;
		return (V) key;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}

	}

	@Override
	public void clear() {
		buckets.clear();
		totalEntries = 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<>(totalEntries);
		Iterator<List<Entry<K, V>>> it = buckets.iterator();
		while (it.hasNext()) {
			List<Entry<K, V>> list = (List<Entry<K, V>>) it.next();
			for (Entry<K, V> entry : list) {
				keySet.add(entry.getKey());
			}
		}
		return keySet;
	}

	@Override
	public Collection<V> values() {
		Collection<V> coll = new ArrayList<>(totalEntries);
		Iterator<List<Entry<K, V>>> it = buckets.iterator();
		while (it.hasNext()) {
			List<Entry<K, V>> list = (List<Entry<K, V>>) it.next();
			for (Entry<K, V> entry : list) {
				coll.add(entry.getValue());
			}
		}
		return coll;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> entrySet = new HashSet<Map.Entry<K, V>>(totalEntries);
		Iterator<List<Entry<K, V>>> it = buckets.iterator();
		while (it.hasNext()) {
			List<Entry<K, V>> list = (List<Entry<K, V>>) it.next();
			for (Entry<K, V> entry : list) {
				entrySet.add(entry);
			}
		}
		return entrySet;
	}

	@Override
	public String toString() {
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < capacity; i++) {
			if (this.buckets.get(i) != null) {
				List<Entry<K, V>> entry = buckets.get(i);
				for (Entry<K, V> mapEntry : entry) {
					content.append("key: " + mapEntry.getKey() + " value: "
							+ mapEntry.getValue() + "\n");
				}
			}
		}
		return content.toString();
	}

	@Override
	public Iterator<K> iterator() {
		return this.iterator();
	}
}
