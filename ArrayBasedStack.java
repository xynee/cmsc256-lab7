package cmsc256;

import java.util.Arrays;

public class ArrayBasedStack <T> implements StackInterface <T>{
    private T[] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayBasedStack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Array initial size error.");
        }
        @SuppressWarnings("unchecked")
                T[] tempStack = (T[]) new Object[capacity];
                data = tempStack;
                topOfStack = -1;
    }

    public ArrayBasedStack(){
        data = (T[]) new Object[INITIAL_CAPACITY];
    }

    private void expandArray(){
        data = Arrays.copyOf(data, data.length*2);
    }

    private boolean isArrayFull(){
        return topOfStack >= data.length - 1;
    }

    @Override
    public void push(T newEntry) {
        if(isArrayFull()){
            expandArray();
        }
        topOfStack++;
        data[topOfStack] = newEntry;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T previous = data[topOfStack];
        data[topOfStack] = null;
        topOfStack--;
        return previous;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException("The stack is empty.");
        }
        return data[topOfStack];
    }

    @Override
    public boolean isEmpty() {
        return topOfStack <= 0;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
                T[] tempStack = (T[]) new Object[INITIAL_CAPACITY];
                data = tempStack;
                topOfStack = -1;
        }

    }

