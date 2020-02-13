package ht3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Archivo {
	
	public static String Ruta(Boolean ordered) {
		if(!ordered)
			return System.getProperty("user.dir") + "\\NumerosRandom.txt";
		else 
			return System.getProperty("user.dir") + "\\NumerosOrdenados.txt";
	}
	
	public static void GenerarArchivoRandom() {
		try {
			
			File archivo = new File(Ruta(false));
			int dialogButton;
			int dialogResult;
            
			if (archivo.exists()) {
				dialogButton = JOptionPane.YES_NO_OPTION;
				dialogResult = JOptionPane.showConfirmDialog (null, "Ya existe un archivo ¿Desea generar otro?", null, dialogButton);
				
				if(dialogResult == JOptionPane.YES_OPTION){
					archivo.delete();
				} else {
					return;
				}
            }
			
			archivo.createNewFile();
			
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
                        
            Random r = new Random(System.currentTimeMillis());
            
            for (int i= 0; i< 3000 ; i ++) {
            	bw.write(Integer.toString(r.nextInt(5000))+ "\n");
            }
            
            bw.close();
            
            String[] options = {"OK"};
            JPanel panel = new JPanel();
    		JLabel lbl = new JLabel("Archivo generado!");
    		panel.add(lbl);
    		JOptionPane.showOptionDialog(null, panel, "Aceptar", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
    		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void GenerarArchivoOrdenado(RandomList list[]) {
		try {
			
			File archivo = new File(Ruta(true));
			
			if (archivo.exists()) {
				archivo.delete();
            }
			
			archivo.createNewFile();
			
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (RandomList rl : list)
            	bw.write(Integer.toString(rl.getNumero()) + "\n");
            
            bw.close();
            
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void GenerarArchivoOrdenado(RandomList list[], String Nombre) {
		try {
			
			File archivo = new File(System.getProperty("user.dir") + "\\" + Nombre + ".txt");
			
			if (archivo.exists()) {
				archivo.delete();
            }
			
			archivo.createNewFile();
			
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (RandomList rl : list)
            	bw.write(Integer.toString(rl.getNumero()) + "\n");
            
            bw.close();
            
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public static RandomList[] leer(int n, Boolean ordered) {
		RandomList r[] =  new RandomList[n];
		
		try {
			File archivo = new File(Ruta(ordered));
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			//ArrayList<String> lineas = new ArrayList<String>();
			String linea = "";
			int i= 0;
			
			while((linea = br.readLine()) != null && (i < n) ) {
				//lineas.add(linea);
				//System.out.println(linea);
				r[i] = new RandomList (Integer.parseInt(linea));
				i++;
				//if (i == n) break;
			}
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha sucedido un error leyendo el archivo " + e);
		}
		
		return r;
	} 	
	
	public static void ExecuteSelectionSort(int n) {
		
		RandomList numeros[] = null;
		RandomList numerosOrdenados[] = null;
		
		numeros = new RandomList[n];
		
		numeros = leer(n, false);
		
		Sorting.selectionSort(numeros);
		
		GenerarArchivoOrdenado(numeros);
		
		//numerosOrdenados = leer(n, true);
		
		//Sorting.selectionSort(numerosOrdenados);
		
		finaliza("Terminado Selection Sort");
	}
	
	
	public static void ExecuteInsertionSort(int n) {
		
		RandomList numeros[] = null;
		RandomList numerosOrdenados[] = null;
		
		numeros = new RandomList[n];
		
		numeros = leer(n, false);
		
		Sorting.insertionSort(numeros);
		
		GenerarArchivoOrdenado(numeros);
		
		//numerosOrdenados = leer(n, true);
		
		//Sorting.insertionSort(numerosOrdenados);
		
		finaliza("Terminado Insertion Sort");
	}
	
	public static void ExecuteMergeSort(int n) {
		
		RandomList numeros[] = null;
		RandomList numerosOrdenados[] = null;
		
		numeros = new RandomList[n];
		
		numeros = leer(n, false);
		
		Sorting.mergeSort(numeros);
		
		GenerarArchivoOrdenado(numeros);
		
		//numerosOrdenados = leer(n, true);
		
		//Sorting.mergeSort(numerosOrdenados);
		
		finaliza("Terminado Merge Sort");
		
	}
	
	public static void ExecuteQuickSort(int n) {
		
		RandomList numeros[] = null;
		RandomList numerosOrdenados[] = null;
		
		numeros = new RandomList[n];
		
		numeros = leer(n, false);;
		
		Sorting.quickSort(numeros, 0, numeros.length - 1);
		
		GenerarArchivoOrdenado(numeros);
		
		//numerosOrdenados = leer(n, true);
		
		//Sorting.quickSort(numerosOrdenados, 0, numeros.length - 1);
		
		finaliza("Terminado Quick Sort");
	}
	
	public static void ExecuteBubbleSort(int n) {
		
		RandomList numeros[] = null;
		RandomList numerosOrdenados[] = null;
		
		numeros = new RandomList[n];
		
		numeros = leer(n, false);
		
		Sorting.bubbleSort(numeros);
		
		GenerarArchivoOrdenado(numeros);
		
		numerosOrdenados = leer(n, true);
		
		Sorting.bubbleSort(numerosOrdenados);
		
		finaliza("Terminado Bubble Sort");
		
	}
	
	
	public static void finaliza(String msj) {
		
		String[] options = {"OK"};
        JPanel panel = new JPanel();
		JLabel lbl = new JLabel(msj);
		panel.add(lbl);
		JOptionPane.showOptionDialog(null, panel, "Aceptar", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
		
	}
	
}
