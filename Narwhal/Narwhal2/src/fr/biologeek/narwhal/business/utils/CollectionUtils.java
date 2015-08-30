package fr.biologeek.narwhal.business.utils;

import java.util.Map;
import java.util.Map.Entry;

public class CollectionUtils<T,E> {

	/**
	 * getKeyByValue allows to get a key knowing the value. The function returns
	 * the key for first matching value
	 * 
	 * @param map a Map Collection
	 * @param value the value to be found in the Map
	 * @return the corresponding key
	 */
	public static int getKeyByValue(Map<Integer, String> accountsMap,
			String selectedItem) {
		for (Entry<Integer, String> entry : accountsMap.entrySet()) {
			if (selectedItem.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return 0;
	}
}
