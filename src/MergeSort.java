import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 4, 2, 1, -7, 0, 5};
        System.out.println(Arrays.toString(mergeSort(array)));
        System.out.println("Steps taken: " + steps);
    }

    static int steps = 0;

    public static int[] mergeSort(int [] array) {
        // if array has less than 2 elements, return as is
        if (array.length < 2) {
            return array;
        }

        // split array into two halves
        int n = array.length;
        int[] leftHalf = new int[n / 2];
        int[] rightHalf = new int[n - leftHalf.length];
        int nLeft = leftHalf.length;
        int nRight = rightHalf.length;

        System.arraycopy(array, 0, leftHalf, 0, nLeft);
        System.arraycopy(array, nLeft, rightHalf, 0, nRight);

        // sort, merge, and return arrays
        int[] sortedArray = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n) {
            if (j == nLeft) {
                sortedArray[i] = mergeSort(rightHalf)[k];
                k++;
                i++;
                continue;
            } else if (k == nRight) {
                sortedArray[i] = mergeSort(leftHalf)[j];
                j++;
                i++;
                continue;
            } else {
                int nextElementLeft = mergeSort(leftHalf)[j];
                int nextElementRight = mergeSort(rightHalf)[k];

                if (nextElementLeft <= nextElementRight) {
                    sortedArray[i] = nextElementLeft;
                    j++;
                } else {
                    sortedArray[i] = nextElementRight;
                    k++;
                }
                i++;
            }
            steps++;
        }
        System.out.println(Arrays.toString(sortedArray));
        return sortedArray;
    }
}