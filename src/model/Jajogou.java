package model;

public class Jajogou {
	public static int jogou[][];
	static int t;// tamanho
	static int i;
	static int j;
	
	
	
	
	public Jajogou(int t){
		jogou = new int[t][t];
		
		
		
		
	}
	public void alterar(int linha, int coluna){
		
	   jogou[linha][coluna]=1; 
		
		
	}
	public boolean consultar(int linha, int coluna){
		
		if (jogou[linha][coluna]==1){
			return true;
			
			
		}
		else {
			
			
		return false;	
			
		}
	}
		public void reiniciar(){
			for(i=0; i<t;i++){
				
				for(j=0; j<t;j++){
					jogou[i][j]=0;
					
				}
				
			}
			
		}
		
		
	
		
		
		
		
		
		
	}	
		

//}
