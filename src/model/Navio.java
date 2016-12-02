package model;

public class Navio {

	static int navio[][];
	static int t;// tamanho
	static int i;
	static int j;
	
	
	
	
	public Navio(int t){
		navio = new int[t][t];
		
		
		
		
	}
	public void alterar(int linha, int coluna){
		
	   navio[linha][coluna]=1;
		
		
	}
	public boolean consultar(int linha, int coluna){
		
		if (navio[linha][coluna]==1){
			return true;
			
			
		}
		else {
			
			
		return false;	
			
		}
	}
		public void reiniciar(){
			for(i=0; i<t;i++){
				
				for(j=0; j<t;j++){
					navio[i][j]=0;
					
				}
				
			}
			
		}
		
		
	
		
		
		
		
		
		
	}	
		

//}
