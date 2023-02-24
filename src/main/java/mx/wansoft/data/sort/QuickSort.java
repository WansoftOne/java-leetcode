package mx.wansoft.data.sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int pivot(int[] array, int pivoteIndex, int endIndex) {
        int swapIndex = pivoteIndex;
        for (int i=pivoteIndex+1; i <= endIndex; i++) {
            if (array[i] < array[pivoteIndex]) {
               swapIndex++;
               swap(array, swapIndex, i); 
            }
        }
        swap(array, pivoteIndex, swapIndex);
        return swapIndex;
    }
    
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] myArray = {4,6,1,7,3,2,5};
        quickSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
