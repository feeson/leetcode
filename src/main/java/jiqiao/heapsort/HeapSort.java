package jiqiao.heapsort;

import java.util.Scanner;

public class HeapSort {
    void sort(int[] arr){
        sort(arr, arr.length);
    }
    void sort(int[] arr, int length){
        if (arr == null || length < 0)
            return;
        buildMaxHeap(arr, length);
        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }
    void swap(int[] arr, int i, int j){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    void buildMaxHeap(int[] arr, int length){
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, length);
        }
    }
    void maxHeapify(int[] arr, int index, int length){
        int child = (index << 1) + 1;
        int val = arr[index];
        int x = index;
        for (;child < length;x=child, child = (child << 1) + 1){
            if (child + 1 < length && arr[child] < arr[child + 1]){
                child = child + 1;
            }
            if (arr[child] < arr[index]){
                break;
            }
            arr[x] = arr[child];
        }
        arr[x] = val;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        sort.sort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
