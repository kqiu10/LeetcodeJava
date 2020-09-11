package heap.Impl;
import heap.IMaxHeap;
/**
 * Package Name : Impl;
 * File name : MaxHeapImpl;
 * Creator: Kane;
 * Date: 9/11/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class MaxHeapImpl<E extends Comparable<E>> implements IMaxHeap<E> {
    private int capacity;

    private int size;

    private E[] data;

    public MaxHeapImpl(E[] data) {
        this.data = data;
        this.size = 0;
        this.capacity = data.length;
    }

    public MaxHeapImpl() {
        this.capacity = 16;
        this.size = 0;
        this.data = (E[]) new Comparable[capacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean offer(E ele) {
        if (data.length == size) {
            expandCapacity();
        }
        data[size++] = ele;
        siftUp();
        return true;
    }

    private void expandCapacity() {
        E[] temp = (E[]) new Comparable[capacity * 2];
        for (int i = 0 ;i < capacity; i++) {
            temp[i] = data[i];
        }
        capacity *= 2;
        data = temp;
    }

    @Override
    public E poll() {
        if (size == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        E item = data[0];
        data[0] = data[size-1];
        data[size - 1] = null;
        size--;
        siftDown();
        return item;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data[0];
    }

    @Override
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i] + " ");
        }

    }

    @Override
    public void resize(int capacity) {

    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private E leftChild(int index) {
        return data[getLeftChildIndex(index)];
    }

    private E rightChild(int index) {
        return data[getRightChildIndex(index)];
    }

    private E parent(int index) {
        return data[getParentIndex(index)];
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void siftUp() {
        int index = size - 1;
        while (getParentIndex(index) >= 0 && parent(index).compareTo(data[index]) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void siftDown() {
        int index = 0;
        while (getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && rightChild(index).compareTo(leftChild(index)) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
                index = biggerChildIndex;
            }
        }
    }

}
