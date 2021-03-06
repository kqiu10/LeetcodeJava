package separateChaining;
/**
 * Package Name : HashTable.separateChaining;
 * File name : HashNode;
 * Creator: Kane;
 * Date: 9/10/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class HashNode<K, V> {
    public K key;

    public V value;

    public HashNode next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
