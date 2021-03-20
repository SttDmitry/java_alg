package lesson3;

import java.util.NoSuchElementException;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;



    public MyDeque(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insertRight(T item) throws IllegalStateException {
        if (isFull()) {
            //реализовать расширение массива
            throw new IllegalStateException("Очередь заполнена");
        }
        if (end < begin) {
            for (int i = size; i > begin ; i--) {
                list[i] = list[i-1];
            }
            begin = nextIndex(begin);
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertLeft(T item) throws IllegalStateException {
        if (isFull()) {
            //реализовать расширение массива
            throw new IllegalStateException("Очередь заполнена");
        }
        if (end < begin) {
            for (int i = size; i > begin; i--) {
                list[i] = list[i-1];
            }
            list[begin] = item;
        } else if (begin < end) {
            for (int i = size; i > begin; i--) {
                list[i] = list[i-1];
            }
            list[begin] = item;
            end = nextIndex(end);
        } else {
            insertRight(item);
            size--;
        }        
        size++;
    }

    public T peekLeft() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peekRight() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (end == 0) {
            int tempEnd = prevIndex(end);
            return list[tempEnd];
        }
        return list[end-1];
    }

    public T removeLeft() {
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight() {
        T temp = peekRight();
        size--;
        if (end == 0) {
            end = prevIndex(end);
        }
        list[end-1] = null;
        end = prevIndex(end);
        return temp;
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        if (index == 0) {
            return (index - 1 + list.length) % list.length;
        }
        return index - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        int i = begin;
        while (i != end) {
            sb.append(list[i]).append(", ");
            i = nextIndex(i);
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
