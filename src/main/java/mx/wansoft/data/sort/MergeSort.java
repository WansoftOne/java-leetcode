package mx.wansoft.data.sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int middle = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(array, middle, array.length));

        return merge(left, right);
    }

    // both arrays should be sorted
    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int c = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[c] = array1[i];
                i++;
            } else {
                combined[c] = array2[j];
                j++;
            }
            c++;
        }

        while(i < array1.length) {
            combined[c] = array1[i];
            c++;
            i++;
        }

        while(j < array2.length) {
            combined[c] = array2[j];
            c++;
            j++;
        }

        return combined;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {1,5,2,3,6,7,0,10};
        int[] sortedArray = mergeSort(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}
