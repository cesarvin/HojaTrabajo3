package ht3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import javax.swing.JOptionPane;

public class Archivo {
	
	public static String Ruta() {
		return System.getProperty("user.dir") + "\\NumerosRandom.txt";
	}
	
	public static void GenerarArchivoRandom() {
		try {
			
			File archivo = new File(Ruta());
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
            
            dialogButton = JOptionPane.OK_OPTION;
			dialogResult = JOptionPane.showConfirmDialog (null, "Archivo creado con 3000 numeros aleatorios", null, dialogButton);
            
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public static RandomList[] leer(int n) {
		RandomList r[] =  new RandomList[n];
		
		try {
			File archivo = new File(Ruta());
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
	
	public static void ExecuteSelectionShort() {
		
		RandomList numeros[] = null;
		
		numeros = new RandomList[100];
		
		numeros = leer(100);
		
		Sorting.selectionSort(numeros);
		
		for (RandomList rl : numeros)
	         System.out.println (rl.getNumero());
	}
	
	
	public static void ExecuteInsertionSort() {
		
		RandomList numeros[] = null;
		
		numeros = new RandomList[100];
		
		numeros = leer(100);
		
		Sorting.insertionSort(numeros);
		
		for (RandomList rl : numeros)
	         System.out.println (rl.getNumero());
	}
}
