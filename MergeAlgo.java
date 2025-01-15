
/*
 * Detyra:
 * 4.Given a list of integers, sort these integers using the "merge sort".
 * 
 * Ekzekutimi:
 * Ndahet vargu ne nenvargje me te vogla ne menyre rekursive derisa qdo nenvarg te kete vetem nje element
 * Bashkohen nenvargjet ne rend te radhitur
 * Vazhdohet bashkimi derisa i gjithe vargu te jete i radhitur
 */

public class MergeAlgo {

    private static void mergeSort(int[] arr, int l, int r) {
        //Divide the array into two parts if it contains more than one element
        if (l < r) {
            int mid = (l + r) / 2; //calculating the middle index
            mergeSort(arr, l, mid); //recursive call to sort the first half
            mergeSort(arr, mid + 1, r);// recursive call to sort the second half
            merge(arr, l, mid, r); // combine the two sroted parts
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        //Calculate the sizes of Temporary Arrays
        int n1 = mid - l + 1;
        int n2 = r - mid;

        //Create temporary arrays to hold the left and right subarrays
        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        //Copy Elements from original array into lArr and rArr
        for (int x = 0; x < n1; x++) {
            lArr[x] = arr[l + x];
        }
        for (int x = 0; x < n2; x++) {
            rArr[x] = arr[mid + 1 + x];
        }

        //Merge the two temporary arrays back into the original array
        int i = 0; // first array will be counted by i
        int j = 0; // second array will be counted by j
        int k = l; // represents the main array

        while (i < n1 && j < n2) {
            //Compare elements and insert the smaller element into the original array
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        //if there are lefover elements on lArr||rArr copy them into the original array arr
        while (i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 9, 3, 2, 5, 7, 1, 47, 32, 10, 13, 4, 12 };//initializing the array
        
        System.out.println("Before Sorting");//Print array before sorting
        
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        mergeSort(arr, 0, arr.length - 1); //Sort The Array

        System.out.println("After Sorting");//Print array after sorting
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}