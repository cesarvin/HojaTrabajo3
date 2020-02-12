package ht3;

public class RandomList implements Comparable<RandomList> {
	
	private int numero; 
	
	public RandomList(int n) {
		numero = n;
	}

	
	@Override
	public int compareTo(RandomList o) {
		RandomList rl = (RandomList)o;
		
		return this.numero - rl.numero; //si es negativo el siguiente es mayor, sino es menor, 0 son iguales
		
	}
	
	public int getNumero() {
		return this.numero;
	}

	
}
