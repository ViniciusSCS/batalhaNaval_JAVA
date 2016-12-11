package model;

public class Navio implements Objeto {

	public Matriz matriz = Matriz.getInstance();
	public MatrizJogo matrizJogo = MatrizJogo.getInstance();
	
	// Se tiver Navio coloca o valor 3 para parte 1 e 4 para parte 2 na matriz

	@Override
	public void alterar(int linha, int coluna) {
		// TODO Auto-generated method stub
		matrizJogo.setMatriz(linha, coluna, 3);
		matrizJogo.setMatriz(linha, coluna + 1, 4);
	}

	@Override
	public boolean consultar(int linha, int coluna) {
		// TODO Auto-generated method stub
		if (matrizJogo.getMatrizJogo(linha, coluna) == 3)  {
			return true;

		}
		return false;
	}
	
	public boolean consultarPt2(int linha, int coluna) {
		// TODO Auto-generated method stub
		if (matrizJogo.getMatrizJogo(linha, coluna) == 4)  {
			return true;

		}
		return false;
	}

	@Override
	public void reiniciar() {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrizJogo.Lenght(); i++) {
			for (int j = 0; j < matrizJogo.Lenght(); j++) {
				matrizJogo.setMatriz(i, j, 0);
			}
		}
	}

}
