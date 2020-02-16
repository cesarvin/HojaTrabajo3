package ht3;

public class Number implements Comparable {

	private int numero;
	
	public Number (int n) {
		numero = n;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return numero -((Number)o).getNumero();
	}
	
	public int getNumero() {
		return this.numero;
	}

}
