package org.example.concept;

public class SelectionSort {
    public static void main(String[] args) {
        boolean change = false;
        int[] a = {42, 32, 24, 60, 15};
        int size = a.length;
        for(int i = 0; i < size - 1; i++) {
            int min_index = i;
            for(int j = i + 1; j < size; j++) {
                if(a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            swap(a, min_index, i);
        }
        for(int num:a){
            System.out.print(num+" ");
        }
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
