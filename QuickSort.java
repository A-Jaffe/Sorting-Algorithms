public class QuickSort {

    //Main method to create and populate number array
    public static void main(String[] args) {
        // Create and fill number array
        int[] numbers = {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

        // Set first and last index positions
        int first = 0;
        int last = numbers.length - 1;

        // Display array before sorting
        System.out.println("Before:");
        printNumbers(numbers);

        // Call quicksort method on number array
        quicksort(numbers, first, last);

        // Display array after sorting
        System.out.println("\nAfter:");
        printNumbers(numbers);
    }

    // Create quicksort method to recursively sort through number array
    public static void quicksort(int[] numbers, int first, int last) {
        if (first >= last) {
            return;
        }

        // Call getMedian method to determine median of numbers array
        int pivot = getMedian(numbers, first, last);

        // Set leftPointer by calling partition method on the array
        int leftPointer = partition(numbers, first, last, pivot);

        // Recursively call quicksort method on new partitions of array
        quicksort(numbers, first, leftPointer - 1);
        quicksort(numbers, leftPointer + 1, last);

    }

    // Create partition method to divide and iterate through sub arrays
    public static int partition(int[] numbers, int first, int last, int pivot) {
        int leftPointer = first;
        int rightPointer = last - 1;

        while (leftPointer < rightPointer) {

            // Move left until number is greater than the pivot or equals right pointer.
            while (numbers[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Move right until number is greater than the pivot or equals right pointer.
            while (numbers[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // Call swap method on pointers while left is less than right
            swap(numbers, leftPointer, rightPointer);
        }

        if(numbers[leftPointer] > numbers[last]) {
            // Call swap method on pointers while left is greater than right
            swap(numbers, leftPointer, last);
        }

        else {
            leftPointer = last;
        }
        return leftPointer;
    }

    // Create getMedian method to determine median of array and sort numbers accordingly
    public static int getMedian(int[] numbers, int first, int last) {

        // Calculate median position of the array
        int center = (first + last)/2;

        // Compare elements in array and swap accordingly
        if(numbers[first] > numbers[center]) {
            swap(numbers, first, center);
        }

        else if(numbers[first] > numbers[last]) {
            swap(numbers, first, last);
        }

        else if(numbers[center] > numbers[last]) {
            swap(numbers, center, last);
        }

        swap(numbers, center, last);
        return numbers[last];
    }

    // Create swap method to swap numbers during sorting
    public static void swap(int[] numbers, int first, int last) {
        // Set temp to first, first to last and then last to temp
        int temp = numbers[first];
        numbers[first] = numbers[last];
        numbers[last] = temp;
    }

    // Create printNumbers method to display array of numbers
    public static void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}