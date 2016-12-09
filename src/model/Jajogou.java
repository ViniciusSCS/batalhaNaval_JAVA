package model;

public class Jajogou implements Objeto {
	public Matriz matriz = Matriz.getInstance();

	// Se for ja estiver jogado coloca o Valor 1 na matriz

	@Override
	public void alterar(int linha, int coluna) {
		// TODO Auto-generated method stub
		matriz.setMatriz(linha, coluna, 1);
	}

	@Override
	public boolean consultar(int linha, int coluna) {
		// TODO Auto-generated method stub
		if (matriz.getMatriz(linha, coluna) != 1)  {
			return false;

		}
		return true;
	}

	@Override
	public void reiniciar() {
		// TODO Auto-generated method stub

		for (int i = 0; i < matriz.Lenght(); i++) {
			for (int j = 0; j < matriz.Lenght(); j++) {
				matriz.setMatriz(i, j, 0);
			}
		}
	}

}

// teste do do hugo indiano
		
