package Mylist;

public interface IMyList<E> {
    /**
     * size
     */
    int size();

    /**
     * isEmpty
     */
    boolean isEmpty();

    /**
     * add to tail
     */
    void add(E ele);

    /**
     * add anywhere
     */
    void add(int index, E element);

    /**
     * find
     */
    boolean contains(E ele);

    /**
     * set
     */
    void set(int idx, E ele);

    /**
     * get
     */
    E get(int index);

    /**
     * delete
     */
    E remove(int index);

    boolean remove(E element);

    /**
     * print
     */
    void print();

}
