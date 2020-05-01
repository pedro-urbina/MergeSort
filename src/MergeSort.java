import java.util.Arrays;

public class MergeSort {

    static int steps = 0;

    public static void main(String[] args) {
        int[] array = {9, 3, 4, 2, 1, -7, 0, 5};

        System.out.print("Input array: ");
        System.out.println(Arrays.toString(array));

        MergeSort input = new MergeSort();
        input.sort(array, 0, array.length - 1);

        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(array));

        System.out.println("While-loop iterations: " + steps);
    }

    void sort(int[] array, int startingIndex, int endingIndex) {
        if (startingIndex < endingIndex) { // only sort if there is more than one element
            int middleIndex = (startingIndex + endingIndex) / 2;

            sort(array, startingIndex, middleIndex); // sort left half
            sort(array, middleIndex + 1, endingIndex); // sort right half

            merge(array, startingIndex, middleIndex, endingIndex); // merge sorted halves
        }
    }

    void merge(int[] array, int startingIndex, int middleIndex, int endingIndex) {
        // find lengths of sub arrays
        int n1 = middleIndex - startingIndex + 1;
        int n2 = endingIndex - middleIndex;

        // create sub arrays and copy values from main array
        int[] leftHalf = new int[n1];
        int[] rightHalf = new int[n2];

        System.arraycopy(array, startingIndex, leftHalf, 0, n1);
        System.arraycopy(array, middleIndex + 1, rightHalf, 0, n2);

        // merge sub arrays back into main array in proper order
        int i = 0;
        int j = 0;
        int k = startingIndex;

        while (i < n1 && j < n2) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
            steps++;
        }

        while (i < n1) {
            array[k] = leftHalf[i];
            i++;
            k++;
            steps++;
        }

        while (j < n2) {
            array[k] = rightHalf[j];
            j++;
            k++;
            steps++;
        }
    }
}