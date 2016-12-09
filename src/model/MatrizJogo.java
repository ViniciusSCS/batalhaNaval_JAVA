package model;

public class MatrizJogo {
	
private static MatrizJogo MTR=null;
	
	private int matrizJogo[][];
	
	public static MatrizJogo getInstance(){
		if (MTR != null) return MTR; else {
			MTR = new MatrizJogo();
			return MTR;
		}
	}
	
	public MatrizJogo() {
		matrizJogo = new int[15][15];
	}

	public int getMatrizJogo(int linha, int coluna) {
		return this.matrizJogo[linha][coluna];
	}

	public void setMatriz(int linha, int coluna, int value) {
		this.matrizJogo[linha][coluna] = value;
		
	}
	
	public int Lenght(){
		return matrizJogo.length;
	}


}
