package model;
// 

public class Submarino implements Objeto {
	public MatrizJogo matrizJogo=MatrizJogo.getInstance();
	
		// Se tiver submarino coloca o valor 2 na matriz
	public void alterar(int linha, int coluna){
		
		matrizJogo.setMatriz(linha, coluna, 2);
	}
	
	public boolean consultar(int linha, int coluna){
		
		if (matrizJogo.getMatrizJogo(linha,coluna) == 2){
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
		

//}
	
	
	// fazer 3 matrizes, se clicou, navio e submarino

