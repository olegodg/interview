package ru.gb.homework2;

public class MyArrayList<T> {
    private T[] data;
    private int size;

    public MyArrayList() {
        data = (T[]) new Object[10];
        size = 0;
    }

    public MyArrayList(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
