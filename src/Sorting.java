import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
       int beginIndex = 0;
       int currIndex = 0;
       int endIndex = arr.length-1;
        T temp;
       // Helper Vars
        int numComps = 0;
        int numSwaps = 0;
        int lastSwap;

        // Return empty array
        if (arr.length == 0)
            return;

        while (endIndex != 0){
            // Reset the lastSwap value to the default of the endIndex
            // Reset currIndex pointer
            lastSwap = 0;
            currIndex = 0;

            // Debug Printing
            System.out.println("Loop " + (arr.length-endIndex));
            //

            // Inner Loop
            while (currIndex < endIndex){
                // Increment comp counter
                numComps++;
                // Evaluate for swap
                if (comparator.compare(arr[currIndex],arr[currIndex+1]) > 0){
                    // Perform Swap
                    temp = arr[currIndex+1];
                    arr[currIndex+1] = arr[currIndex];
                    arr[currIndex] = temp;
                    numSwaps++;
                    // Save index of last swap
                    lastSwap = currIndex;
                }
                // Debug Print - Print after each swap
                printArr(arr);
                //

                // Increment index
                currIndex++;
            } // End Inner Loop

            // Last Swapped Optimization
            if (lastSwap != endIndex){
                endIndex = lastSwap;
            }
            else {
                endIndex--;
            }
        }
        //System.out.println("Total comparisons: " + numComps);
        //System.out.println("Total swaps: " + numSwaps);
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Initialize Local Vars
        int maxVal;
        int stopIndex = arr.length-1;
        T temp;
        // Helper Vars
        int numComps=0;
        int numSwaps=0;

        // Return empty array
        if (arr.length == 0)
            return;

        System.out.println("Initial Array");
        printArr(arr);
        while (stopIndex != 0){
            // Debug print
            System.out.println("Loop " + (arr.length-stopIndex));
            //

            // Reset maxVal
            maxVal = 0;
            // Inner Loop
            for (int i = 1; i <= stopIndex;i++){
                numComps++;
                if (comparator.compare(arr[i],arr[maxVal]) > 0){
                    maxVal = i;
                }
            }
            // Swap max val w/ end index
            System.out.println(maxVal);
            temp = arr[stopIndex];
            arr[stopIndex] = arr[maxVal];
            arr[maxVal] = temp;
            numSwaps++;
            //
            printArr(arr);
            stopIndex--;
        }
        // Print swaps/comps
        System.out.println("Comparisons: " + numComps);
        System.out.println("Swaps      : " + numSwaps);
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Local Vars
        T temp;

        // Helper Vars
        int numComps=0;
        int numSwaps=0;

        // Print initial Arr
        printArr(arr);

        // Outer Loop
        for (int i = 1; i < arr.length;i++){
            int currIndex = i;
            // While current index is less than previous, swap
            System.out.println("Loop " + i);
            while (currIndex > 0){
                    if (comparator.compare(arr[currIndex],arr[currIndex-1]) < 0){
                        // Swap values as necessary
                        temp = arr[currIndex];
                        arr[currIndex] = arr[currIndex-1];
                        arr[currIndex-1] = temp;
                        numSwaps++;
                        printArr(arr);
                        currIndex--;
                    }
                    else{
                        currIndex=-1;
                    }
                numComps++;
                }
            // Add back at least one comp per outer loop run
            System.out.println("Comparisons " + numComps);
            System.out.println("Swaps " + numSwaps);
            }
        }

    public static <T> void printArr(T[] arr){
        String myString = "[";
            for (int i = 0; i < arr.length;i++){
                if (i != arr.length && i != 0)
                    myString += ", ";
                myString += arr[i];
            }
        myString+="]";
        System.out.println(myString);
    }

    public static void main(String[] args) {
        Integer[] myArr = {5,4,3,2,1};
        String[] myStr = { "mouse","dog","cat"};
        Comparator<Integer> myComp = new Comparator<Integer>() {
            int numComps;
            int numSwaps;
            @Override
            public int compare(Integer o1, Integer o2) {
                numComps++;
                if (o1 -o2 > 0)
                    numSwaps++;
                System.out.println("Num Comps : " + numComps);
                System.out.println("Num Swaps : " + numSwaps);
                return o1 - o2;
            }
            public int getComps(){
                return numComps;
            }
        };
        Comparator<String> myCompStr = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int l1 = str1.length();
                int l2 = str2.length();
                int lmin = Math.min(l1, l2);

                for (int i = 0; i < lmin; i++) {
                    int str1_ch = (int) str1.charAt(i);
                    int str2_ch = (int) str2.charAt(i);

                    if (str1_ch != str2_ch) {
                        return str1_ch - str2_ch;
                    }
                }
                // Edge case for strings like
                // String 1="Geeks" and String 2="Geeksforgeeks"
                if (l1 != l2) {
                    return l1 - l2;
                }

                // If none of the above conditions is true,
                // it implies both the strings are equal
                else {
                    return 0;
                }
            }
        };

        bubbleSort(myArr,myComp);
        //bubbleSort(myStr,myCompStr);
        //selectionSort(myArr,myComp);
        //insertionSort(myArr,myComp);
    }

}