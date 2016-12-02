package model;
// 

public class Submarino {
	static int submarino[][];
	static int t;
	static int i;
	static int j;
	public Submarino(int t){
		submarino = new int[t][t];	
	}
	public void alterar(int linha, int coluna){
		
	   submarino[linha][coluna]=1; 
		
		
	}
	public  boolean consultar(int linha, int coluna){
		
		if (submarino[linha][coluna]==1){
			return true;
			
			
		}
		else {
			
			
		return false;	
			
		}
	}
		public void reiniciar(){
			for(i=0; i<t;i++){
				
				for(j=0; j<t;j++){
					submarino[i][j]=0;
					
				}
				
			}
			
		}
			
	}	
		

//}
	
	
	// fazer 3 matrizes, se clicou, navio e submarino

