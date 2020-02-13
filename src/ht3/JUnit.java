package ht3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit {

	@Test
	public void ExecuteSelectionSort() {
		
		RandomList n[] =  {new RandomList (19),new RandomList (18),new RandomList (27),new RandomList (3), new RandomList (7)};
		
		Sorting.selectionSort(n);
		Archivo.GenerarArchivoOrdenado(n,"TESTSelectionSort");
		
	}
	
	@Test
	public void ExecuteInsertionSort() {
		
		RandomList n[] =  {new RandomList (19),new RandomList (18),new RandomList (27),new RandomList (3), new RandomList (7)};
		Sorting.insertionSort(n);
		Archivo.GenerarArchivoOrdenado(n, "TESTInsertionSort");
	}
	
	@Test
	public void ExecuteMergeSort() {
		
		RandomList n[] =  {new RandomList (19),new RandomList (18),new RandomList (27),new RandomList (3), new RandomList (7)};
		Sorting.mergeSort(n);
		Archivo.GenerarArchivoOrdenado(n, "TESTMergeSort");
		
	}
	
	@Test
	public void ExecuteQuickSort() {
		
		RandomList n[] =  {new RandomList (19),new RandomList (18),new RandomList (27),new RandomList (3), new RandomList (7)};
		Sorting.quickSort(n, 0, n.length - 1);
		Archivo.GenerarArchivoOrdenado(n, "TESTQuickSort");
		
	}

	@Test
	public static void ExecuteBubbleSort() {
		
		RandomList n[] =  {new RandomList (19),new RandomList (18),new RandomList (27),new RandomList (3), new RandomList (7)};
		Sorting.bubbleSort(n);
		Archivo.GenerarArchivoOrdenado(n, "TESTBubbleSort");
		
	}

}
