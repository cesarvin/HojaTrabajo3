package ht3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private int numeros = 1500, top = 0;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Generar Enteros");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberList.CreateRandomFile();
			}
		});
		btnNewButton.setBounds(29, 30, 142, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selection Sort");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				top = Integer.parseInt(textField.getText()) ;
				
				Number[] numbers = new Number[top];
		        numbers = NumberList.ReadNumberList(top, "NumerosOrdenados");
		        
		        Sorting.selectionSort(numbers);
		        
		        NumberList.CreateOrderedFile(numbers,"selectionSort");
		        
		        NumberList.OrderedEnd("Proceso selection sort completo");
			}
		});
		btnNewButton_1.setBounds(28, 92, 143, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Insertion Sort");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				top = Integer.parseInt(textField.getText()) ;
				
				Number[] numbers = new Number[top];
		        numbers = NumberList.ReadNumberList(top, "NumerosOrdenados");
		        
		        Sorting.insertionSort(numbers);
		        
		        NumberList.CreateOrderedFile(numbers,"insertionSort");
		        
		        NumberList.OrderedEnd("Proceso insertion sort completo");
			}
		});
		btnNewButton_2.setBounds(29, 126, 142, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Merge Sort");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				top = Integer.parseInt(textField.getText()) ;
				
				Number[] numbers = new Number[top];
		        numbers = NumberList.ReadNumberList(top, "NumerosOrdenados");
		        
		        Sorting.mergeSort(numbers);
		        
		        NumberList.CreateOrderedFile(numbers,"mergeSort");
		        
		        NumberList.OrderedEnd("Proceso merge sort completo");
			}
		});
		btnNewButton_3.setBounds(29, 160, 142, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Quick Sort");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				top = Integer.parseInt(textField.getText()) ;
				
				Number[] numbers = new Number[top];
		        numbers = NumberList.ReadNumberList(top, "NumerosOrdenados");
		        
		        Sorting.quickSort(numbers, 0, numbers.length-1);
		        
		        NumberList.CreateOrderedFile(numbers,"quickSort");
		        
		        NumberList.OrderedEnd("Proceso quick sort completo");
			}
		});
		btnNewButton_4.setBounds(29, 194, 142, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Operar");
		lblNewLabel.setBounds(29, 67, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(85, 64, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Bubble Sort");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				top = Integer.parseInt(textField.getText()) ;
				
				Number[] numbers = new Number[top];
		        numbers = NumberList.ReadNumberList(top, "NumerosOrdenados");
		        
		        Sorting.bubbleSort(numbers);
		        
		        NumberList.CreateOrderedFile(numbers,"bubbleSort");
		        
		        NumberList.OrderedEnd("Proceso bubble sort completo");
			}
		});
		btnNewButton_5.setBounds(29, 227, 142, 23);
		frame.getContentPane().add(btnNewButton_5);
	}
}
