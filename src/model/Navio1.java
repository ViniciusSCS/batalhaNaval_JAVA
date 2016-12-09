package model;

public class Navio1 implements Objeto {
		
	public Matriz matriz=Matriz.getInstance();
		
		// Se tiver Navio1 coloca o valor 4 na matriz
	public void alterar(int linha, int coluna){
		
		matriz.setMatriz(linha, coluna, 4);
		matriz.setMatriz(linha, coluna+1, 4);
	}
	
	public boolean consultar(int linha, int coluna){
		
		if ((matriz.getMatriz(linha,coluna) == 0)&&(matriz.getMatriz(linha,coluna+1) == 0)){
			  return false;
			 
		  } return true;
		  		  
	}
	
		public void reiniciar(){
						
			for(int i=0; i<matriz.Lenght();i++){
				for(int j=0; j<matriz.Lenght();j++){
					matriz.setMatriz(i, j, 0);
				}	
			}
			
		}
	}
