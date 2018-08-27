package week09;

/**
 * Description: In this assignment you will be altering the MyHashMap implementation. 
 * The provided reference implementation is based on listing 27.2. This 
 * implementation uses chaining.  * You will create a new concrete class, MyHashMapLinear, 
 * that implements MyMap using open addressing with linear probing. 
 * 
 * For simplicity, use f(key) = key % size as the hash function, where size is the 
 * hash-table size.  Initialiy, the hash-table size is 4. The table size is doubled 
 * whenever the load factor exceeds the threshold (0.5)
 * 
 * @author eomed
 *
 */

import java.util.HashSet;
import java.util.Set;

public class MyHashMapLinear<K, V> implements MyMap<K, V>
{
	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MyHashMapLinear()
	 * @param override
	 *            None
	 * @param comment
	 *            Construct a map with the default capacity and load factor
	 * @param visiblity
	 *            public
	 */
	public MyHashMapLinear()
	{
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MyHashMapLinear(int initialCapacity)
	 * @param initialCapacity
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Construct a map with the specified initial capacity and
	 *            default load factor
	 * @param visiblity
	 *            public
	 */
	public MyHashMapLinear(int initialCapacity)
	{
		this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MyHashMapLinear(int initialCapacity, float
	 *            loadFactorThreshold)
	 * @param initialCapacity
	 *            Parameter
	 * @param loadFactorThreshold
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Construct a map with the specified initial capacity and load
	 *            factor
	 * @param visiblity
	 *            public
	 */

	public MyHashMapLinear(int initialCapacity, float loadFactorThreshold)
	{
		if(initialCapacity > MAXIMUM_CAPACITY)
		{
			capacity = MAXIMUM_CAPACITY;
		}
		else
		{
			capacity = trimToPowerOf2(initialCapacity);
		}

		this.loadFactorThreshold = loadFactorThreshold;
		table = new MyMap.Entry[capacity];
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            trimToPowerOf2(int initialCapacity)
	 * @param initialCapacity
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Helper method
	 * @param visiblity
	 *            private
	 * 
	 * @return the return type minus the qualified name
	 */
	private int trimToPowerOf2(int initialCapacity)
	{
		int capacity = 1;
		// h ^= (h >>> 20) ^ (h >>> 12);
		// return h ^ (h >>>7) ^ (h >>> 4);
		while(capacity < initialCapacity)
		{
			capacity <<= 1;
		}

		return capacity;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            clear()
	 * @param override
	 *            None
	 * @param comment
	 *            Remove all of the entries from this map
	 * @param visiblity
	 *            public
	 */
	public void clear()
	{
		size = 0;
		removeEntries();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            containsKey(K key)
	 * @param key
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Return true if the specified key is in the map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public boolean containsKey(K key)
	{
		if(get(key) != null)
			return true;
		else
			return false;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            containsValue(V value)
	 * @param value
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return true if this map contains the specified value
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public boolean containsValue(V value)
	{
		for(int i = 0; i < capacity; i++)
		{
			if(table[i] != null)
			{
				if(table[i].getValue().equals(value))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            entrySet()
	 * @param override
	 *            None
	 * @param comment
	 *            Return a set of entries in the map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public java.util.Set<MyMap.Entry<K, V>> entrySet()
	{
		Set<MyMap.Entry<K, V>> set = new HashSet<>();

		for(int i = 0; i < capacity; i++)
		{
			if(table[i] != null)
			{
				set.add(table[i]);
			}
		}
		return set;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            get(K key)
	 * @param key
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return the first value that matches the specified key
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public V get(K key)
	{
		int i = hash(key.hashCode());
		if(table[i] != null)
		{
			if(table[i].getKey().equals(key))
			{
				return table[i].getValue();
			}
		}
		return null;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getAll(K key)
	 * @param key
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Return all values for the specified key in this map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public java.util.Set<V> getAll(K key)
	{
		java.util.Set<V> set = new java.util.HashSet<V>();
		for(int i = 0; i < capacity; i++)
			if(table[i] != null && table[i].key.equals(key))
				set.add(table[i].value);

		return set;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            isEmpty()
	 * @param override
	 *            None
	 * @param comment
	 *            Return true if this map contains no entries
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            keySet()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return a set consisting of the keys in this map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public Set<K> keySet()
	{
		Set<K> set = new HashSet<K>();

		for(int i = 0; i < capacity; i++)
		{
			if(table[i] != null)
			{
				set.add(table[i].getKey());
			}
		}
		return set;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            put(K key, V value)
	 * @param key
	 *            Parameter
	 * @param value
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Add an entry (key, value) into the map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public V put(K key, V value)
	{
		if(size >= capacity * loadFactorThreshold)
		{
			if(capacity == MAXIMUM_CAPACITY)
			{
				throw new RuntimeException("Exceeding maximum capacity");
			}
			rehash();
		}

		int i = hash(key.hashCode());

		while(table[i] != null && table[i].key != null)
		{
			i = (i + 1) % table.length;
		}

		// // Add an entry (key, value) to the table
		table[i] = new MyMap.Entry<K, V>(key, value);

		size++; // Increase size

		return value;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            remove(K key)
	 * @param key
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Remove the element for the specified key
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public void remove(K key)
	{
		int i = hash(key.hashCode());

		while(table[i] != null
				&& (table[i].key == null || !table[i].key.equals(key)))
			i = (i + 1) % table.length;

		if(table[i] != null && table[i].key.equals(key))
		{
			// // A special marker Entry(null, null) is placed for the deleted
			// entry
			table[i] = new MyMap.Entry<K, V>(null, null);
			size--;
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            size()
	 * @param override
	 *            None
	 * @param comment
	 *            Return the number of mappings in this map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            values()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return a set consisting of the values in this map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public Set<V> values()
	{
		Set<V> set = new HashSet<>();

		for(int i = 0; i < capacity; i++)
		{
			if(table[i] != null)
			{
				set.add(table[i].getValue());
			}
		}

		return set;
	}

	/**
	 * * Parameterized constructor
	 * 
	 * @param name
	 *            hash(int hashCode)
	 * @param hashCode
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Hash function
	 * @param visiblity
	 *            private
	 * 
	 * @return the return type minus the qualified name
	 */
	private int hash(int hashCode)
	{
		// return hashCode % capacity;
		return supplementalHash(hashCode) & (capacity - 1);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            supplementalHash(int h)
	 * @param h
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Ensure the hashing is evenly distributed
	 * @param visiblity
	 *            private
	 * 
	 * @return the return type minus the qualified name
	 */
	private static int supplementalHash(int h)
	{
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            removeEntries()
	 * @param override
	 *            None
	 * @param comment
	 *            Remove all entries from each bucket
	 * @param visiblity
	 *            private
	 */
	private void removeEntries()
	{
		for(int i = 0; i < capacity; i++)
			table[i] = null;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            rehash()
	 * @param override
	 *            None
	 * @param comment
	 *            Rehash the map
	 * @param visiblity
	 *            private
	 */
	private void rehash()
	{
		Set<Entry<K, V>> set = entrySet();
		capacity <<= 1;
		table = new MyMap.Entry[capacity];
		size = 0;

		for(Entry<K, V> entry : set)
		{
			put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            toString()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return a string representation for this map
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder("[");

		for(int i = 0; i < capacity; i++)
		{
			if(table[i] != null)
			{
				builder.append(table[i]);
			}
		}

		builder.append("]");
		return builder.toString();
	}

	// Define the default hash table size.
	private static int DEFAULT_INITIAL_CAPACITY = 4;

	// Define the maximum hash table size. 1 << 30 is same as 2^30
	private static int MAXIMUM_CAPACITY = 1 << 30;

	// Current hash table capacity.
	private int capacity;

	// Define default load factor
	private static float DEFAULT_MAX_LOAD_FACTOR = 0.5f;

	// Specify a load factor used in the hash table
	private float loadFactorThreshold;

	// The number of entries in the map
	private int size = 0;

	// Hash table is an array with each cell that is a linked list
	MyMap.Entry<K, V>[] table;
}
