package ht3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit {

	@Test
	public void ExecuteSelectionSort() {
		
		Number n[] =  {new Number (19),new Number (18),new Number (27),new Number (3), new Number (7)};
		
		Sorting.selectionSort(n);
		NumberList.CreateOrderedFile(n,"TEST_selectionSort");
		
	}
	
	@Test
	public void ExecuteInsertionSort() {
		
		Number n[] =  {new Number (19),new Number (18),new Number (27),new Number (3), new Number (7)};
		Sorting.insertionSort(n);
		NumberList.CreateOrderedFile(n,"TEST_InsertionSort");
	}
	
	@Test
	public void ExecuteMergeSort() {
		
		Number n[] =  {new Number (19),new Number (18),new Number (27),new Number (3), new Number (7)};
		Sorting.mergeSort(n);
		NumberList.CreateOrderedFile(n,"TEST_MergeSort");
		
	}
	
	@Test
	public void ExecuteQuickSort() {
		
		Number n[] =  {new Number (19),new Number (18),new Number (27),new Number (3), new Number (7)};
		Sorting.quickSort(n, 0, n.length - 1);
		NumberList.CreateOrderedFile(n,"TEST_QuickSort");
		
	}

	@Test
	public static void ExecuteBubbleSort() {
		
		Number n[] =  {new Number (19),new Number (18),new Number (27),new Number (3), new Number (7)};
		Sorting.bubbleSort(n);
		NumberList.CreateOrderedFile(n,"TEST_BubbleSort");
		
	}

}
