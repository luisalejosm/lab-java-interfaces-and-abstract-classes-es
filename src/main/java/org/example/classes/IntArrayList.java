package org.example.classes;

import org.example.interfaces.IntList;

public class IntArrayList implements IntList {
    private int[] numbers;
    private int size;

    public IntArrayList(){
        this.numbers = new int[10];
        this.size = 0;
    }


    @Override
    public void add(int number) {
        if (size == numbers.length) {
            int newLength = numbers.length + numbers.length / 2;
            numbers = resizeArray(numbers, newLength);
        }
        numbers[size++] = number;
    }

    @Override
    public int get(int id) {
        if(id >= 0 && id <= size){
            return numbers[id];
        }else {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + id);
        }
    }

    private int[] resizeArray(int[] original, int newLength) {
        int[] newArray = new int[newLength];
        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }
}
