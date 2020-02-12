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
}
