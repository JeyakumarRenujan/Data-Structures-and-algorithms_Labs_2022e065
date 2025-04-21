//2022e065
//Question03

public class LinearSearch {
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        // Return -1 if the target is not found in the array
        return -1;
    }

    public static void main(String[] args) {
        // Example Array
        int[] Eg_array = {10, 24, 33, 47, 59, 16};
        int target = 47;

        int result = linearSearch(Eg_array, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found");
        }
    }
}