package ht3;

public class Sorting {
	
	//-----------------------------------------------------------------
    //  Sorts the specified array of objects using the selection
    //  sort algorithm.
    //-----------------------------------------------------------------
    public static void selectionSort (RandomList[] list)
    {
       int min;
       RandomList temp;
      
       /*for (int i=0; i < list.length - 1; i++) {
	 		System.out.println(list[i].getNumero());
       }*/

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
  
       /*System.out.println("ordenado:");
       for (int i=0; i < list.length - 1; i++) {
			System.out.println(list[i].getNumero());
       }*/
    }

    //-----------------------------------------------------------------
    //  Sorts the specified array of objects using the insertion
    //  sort algorithm.
    //-----------------------------------------------------------------
    public static void insertionSort (RandomList[] list)
    {
    	for (int index = 1; index < list.length; index++)
    	{
    		RandomList key = list[index];
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
     * mergeShort
     * basado en Merge Sort Java Example
     * del sitio: https://howtodoinjava.com/algorithm/merge-sort-java-example/
     * */
    public static void mergeSort(RandomList[] list) 
    {
        //If list is empty; no need to do anything
        if (list.length <= 1) {
            return;
        }
         
        //Split the array in half in two parts
        RandomList[] first = new RandomList[list.length / 2];
        RandomList[] second = new RandomList[list.length - first.length];
        
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
    private static void merge(RandomList[] first, RandomList[] second, RandomList[] result) 
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
}
