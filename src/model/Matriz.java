package model;

import java.security.GeneralSecurityException;

public class Matriz {
	private static Matriz MTR=null;
	
	private int matriz[][];
	
	public static Matriz getInstance(){
		if (MTR != null) return MTR; else {
			MTR = new Matriz();
			return MTR;
		}
	}
	
	public Matriz() {
		matriz = new int[15][15];
	}

	public int getMatriz(int linha, int coluna) {
		return this.matriz[linha][coluna];
	}

	public void setMatriz(int linha, int coluna, int value) {
		this.matriz[linha][coluna] = value;
		
	}
	
	public int Lenght(){
		return matriz.length;
	}

}
