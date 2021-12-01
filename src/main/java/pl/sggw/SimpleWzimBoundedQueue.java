import java.util.NoSuchElementException;

public class SimpleWzimBoundedQueue<E> implements WzimBoundedQueue<E> {

    private E[] elements;
    private int head = 0;
    private int tail = 0;

    public SimpleWzimBoundedQueue(final int maxCapacity) {
        elements = (E[]) new Object[maxCapacity];
    }


    @Override
    public boolean add(E e) {
        boolean result = false;
        if (e != null && tail < elements.length) {
            elements[tail++] = e;
            result = true;
        }
        else if (tail == elements.length)
            throw new IllegalStateException();
        else if (e == null)
            throw new NullPointerException();
        return result;
    }

    @Override
    public boolean offer(E e) {
        boolean result = false;
        if (e != null && tail < elements.length) {
            elements[tail++] = e;
            result = true;
        }
        else if (e == null)
            throw new NullPointerException();
        return result;
    }

    @Override
    public E remove() {
        if (head < 0 || head >= elements.length)
            throw new NoSuchElementException();
        E result = elements[head];
        if (result == null)
            return null;
        head++;
        return result;
    }

    @Override
    public E poll() {
        if (head < 0 || head >= elements.length)
            return null;
        E result = elements[head];
        if (result == null)
            return null;
        head++;
        return result;
    }

    @Override
    public E element() {
        if (head <= 0 && head == tail)
            throw new NoSuchElementException();
        return elements[head];
    }

    @Override
    public E peek() {
        if (head < 0)
            return null;
        return elements[head];
    }

    @Override
    public int size() {
        return tail;
    }

    @Override
    public int capacity() {
        return elements.length;
    }
}
