package ht3;

public class TestMain {

	public static void main(String[] args) {
		final String dir = System.getProperty("user.dir") + "\\";
        System.out.println("current dir = " + dir );
        ;
        
        Number[] numbers = new Number[100];
        
        NumberList.CreateRandomFile();
        
        numbers = NumberList.ReadNumberList(100, "NumerosOrdenados");
        
		//Sorting.selectionSort(numbers);
		//Sorting.insertionSort(numbers);
        //Sorting.mergeSort(numbers);
        //Sorting.quickSort(numbers, 0, numbers.length-1);
        Sorting.bubbleSort(numbers);
       
		//NumberList.CreateOrderedFile(numbers,"insertionSort");
        NumberList.CreateOrderedFile(numbers,"bubbleSort");
	    
		System.out.println("Listo" );
    
	}

}
