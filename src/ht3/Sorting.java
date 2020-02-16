package ht3;

public class Sorting {
	
	//********************************************************************
	//  Sorting.java       Author: Lewis/Loftus
	//
	//  Demonstrates the selection sort and insertion sort algorithms.
	//********************************************************************
	//-----------------------------------------------------------------
	//  Sorts the specified array of objects using the selection
	//  sort algorithm.
	//-----------------------------------------------------------------
    public static void selectionSort (Comparable[] list)
    {
       int min;
       Comparable temp;
             
       for (int index = 0; index < list.length-1; index++)
       {
    	    min = index;
            for (int scan = index+1; scan < list.length; scan++)
            	if (list[scan].compareTo(list[min]) < 0)
            		min = scan;

            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] =  temp;
       }
  
    }

	//********************************************************************
	//  Sorting.java       Author: Lewis/Loftus
	//
	//  Demonstrates the selection sort and insertion sort algorithms.
	//********************************************************************
	//-----------------------------------------------------------------
    // Sorts the specified array of objects using the insertion
    //  sort algorithm.
    //-----------------------------------------------------------------
    public static void insertionSort (Comparable[] list)
    {
    	for (int index = 1; index < list.length; index++)
    	{
    		Comparable key = list[index];
    		int position = index;

    		//  Shift larger values to the right
    		while (position > 0 && key.compareTo(list[position-1]) < 0)
    		{
    			list[position] = list[position-1];
    			position--;
    		}
            
    		list[position] = key;
      }
    }
    
    /*
     * mergeSort
     * basado en Merge Sort Java Example
     * del sitio: https://howtodoinjava.com/algorithm/merge-sort-java-example/
     * */
    public static void mergeSort(Comparable[] list) 
    {
        //If list is empty; no need to do anything
        if (list.length <= 1) {
            return;
        }
         
        //Split the array in half in two parts
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        
        System.arraycopy(list, 0, first, 0, first.length);
        
        System.arraycopy(list, first.length, second, 0, second.length);
         
        //Sort each half recursively
        mergeSort(first);
        mergeSort(second);
         
        //Merge both halves together, overwriting to original array
        merge(first, second, list);
        
    }
    
    /*
     * merge
     * basado en Merge Sort Java Example
     * del sitio: https://howtodoinjava.com/algorithm/merge-sort-java-example/
     * */
    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) 
    {
        //Index Position in first array - starting with first element
        int iFirst = 0;
         
        //Index Position in second array - starting with first element
        int iSecond = 0;
         
        //Index Position in merged array - starting with first position
        int iMerged = 0;
         
        //Compare elements at iFirst and iSecond, 
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) 
        {
            if (first[iFirst].compareTo(second[iSecond]) < 0) 
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            } 
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
    
    /*
     * quickSort
     * basado en Quick Sort Java Example
     * del sitio: https://howtodoinjava.com/algorithm/quicksort-java-example/
     * */
    public static void quickSort(Comparable[] list, int l, int h) 
    {
    	//check for empty or null array
        if (list == null || list.length == 0){
            return;
        }
         
        if (l >= h){
            return;
        }
 
        //Get the pivot element from the middle of the list
        int m = l + (h - l) / 2;
        int pivot = ((Number)list[m]).getNumero();
 
        // make left < pivot and right > pivot
        int i = l, j = h;
        
        while (i <= j) 
        {
            //Check until all values on left side array are lower than pivot
            while (((Number)list[i]).getNumero() < pivot) 
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (((Number)list[j]).getNumero() > pivot) 
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping 
            //After swapping move the iterator on both lists
            if (i <= j) 
            {
                swap (list, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (l < j){
            quickSort(list, l, j);
        }
        if (h > i){
            quickSort(list, i, h);
        }
    }
     
    public static void swap (Comparable array[], int x, int y)
    {
    	Comparable temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    
    /*
     * bubbleSort
     * basado en Bubble Sort Java Example
     * del sitio: https://howtodoinjava.com/algorithm/bubble-sort-java-example/
     * */
    public static void bubbleSort(Comparable[] list) 
    {
    	Comparable d;
        int fromIndex=0, toIndex = list.length;
        
        for (int i = toIndex - 1; i > fromIndex; i--) 
        {
            boolean isSorted = true;
            for (int j = fromIndex; j < i; j++) 
            {
                //If elements in wrong order then swap them
                //if (((RandomList) list[j]).compareTo(list[j + 1]) > 0)
                if (((Number)list[j]).compareTo(list[j + 1]) > 0)
                {
                    isSorted = false;
                    d = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = d;
                }
            }
            //If no swapping then array is already sorted
            if (isSorted)
                break;
        }
    }

}
