//2022e065
//Question04

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Example Array
        int[] Eg_array = {12, 11, 13, 5, 6};

        System.out.println("Unsorted Array:");
        for (int num : Eg_array) {
            System.out.print(num + " ");
        }

        insertionSort(Eg_array);

        System.out.println("\nSorted Array in Ascending Order:");
        for (int num : Eg_array) {
            System.out.print(num + " ");
        }
    }
}