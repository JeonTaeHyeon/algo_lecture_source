package org.example.concept;

public class MergeSort {
    private static int[] sorted;

    public static void main(String[] args) {
        int[] a = {42, 32, 24, 60, 15};
        sorted = new int[a.length];
        MergeSort(a, 0, a.length - 1);
        sorted = null;
        for(int res:a){
            System.out.print(res+" ");
        }
    }
    private static void MergeSort(int[] a, int left, int right) {
        if(left == right) return;

        int mid = (left + right) / 2;
        MergeSort(a, left, mid);
        MergeSort(a, mid + 1, right);
        merge(a, left, mid, right);

    }
    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while(l <= mid && r <= right) {
            if(a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        if(l > mid) {
            while(r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        else {
            while(l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }
        for(int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}
