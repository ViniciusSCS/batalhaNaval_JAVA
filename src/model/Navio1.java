package model;

public class Navio1 implements Objeto {
		
	public Matriz matriz=Matriz.getInstance();
	public MatrizJogo matrizJogo = MatrizJogo.getInstance();
	
		// Se tiver Navio1 coloca o valor 5 na matriz
	public void alterar(int linha, int coluna){
		
		matrizJogo.setMatriz(linha, coluna, 5);
		matrizJogo.setMatriz(linha, coluna+1, 5);
	}
	
	public boolean consultar(int linha, int coluna){
		
		if (matrizJogo.getMatrizJogo(linha,coluna) == 5){
			  return true;
			 
		  } return false;
		  		  
	}
	
		public void reiniciar(){
						
			for(int i=0; i<matrizJogo.Lenght();i++){
				for(int j=0; j<matrizJogo.Lenght();j++){
					matrizJogo.setMatriz(i, j, 0);
				}	
			}
			
		}
	}
