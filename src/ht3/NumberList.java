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

public class NumberList {
	
	public static String FileName(String name) {
		return System.getProperty("user.dir") + "\\" + name + ".txt";
	}


	public static void CreateRandomFile() {
		try {
			
			File archivo = new File(FileName("NumerosOrdenados"));
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
	
	public static Number[] ReadNumberList(int n, String Name) {
		//NumberList r[] =  new NumberList[n];
		Number[] rl = new Number[n];
        
		try {
			File archivo = new File(FileName(Name));
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = "";
			int i= 0;
			
			
	        while((linea = br.readLine()) != null && (i < n) ) {
				rl[i] = new Number(Integer.parseInt(linea));
				i++;
			}
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha sucedido un error leyendo el archivo " + e);
		}
		
		return rl;
	}
	
	public static void CreateOrderedFile(Number[] list, String Name) {
		try {
			
			File file = new File(FileName(Name));
			
			if (file.exists()) {
				file.delete();
            }
			
			file.createNewFile();
			
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Number n:list) 
            	bw.write(Integer.toString(n.getNumero()) + "\n");
            
            bw.close();
            
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void OrderedEnd(String msj) {
		
		String[] options = {"OK"};
        JPanel panel = new JPanel();
		JLabel lbl = new JLabel(msj);
		panel.add(lbl);
		JOptionPane.showOptionDialog(null, panel, "Aceptar", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
		
	}
}
