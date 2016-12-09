package batnav.controler;

import java.util.Random;


import model.Jajogou;
import model.Matriz;
import model.MatrizJogo;
import model.Navio;
import model.Navio1;
import model.Submarino;

public class ControladorBatNav {
    public int a=14;
  
    public Jajogou jajogou;
    public Submarino submarino ; 
    public Navio navio;
    public Navio1 navio1;
    public Matriz matriz;
    private Random radom;
    public MatrizJogo matrizJogo;
    
    
      public ControladorBatNav(){
    	  
    	  matriz=Matriz.getInstance();
    	  matrizJogo = MatrizJogo.getInstance();
    	  
    	  jajogou = new Jajogou();
    	  submarino = new Submarino();
    	  navio= new Navio();
    	  
    	  Inicializa();
      }
      
    public void Inicializa(){
    	
    	navio.alterar(1, 1);
    	navio.alterar(10, 5);
    	navio.alterar(6, 7);
    	navio.alterar(2, 4);
    	navio.alterar(9, 3);
    	navio.alterar(5, 6);
    	
    	submarino.alterar(1, 6);
    	submarino.alterar(3, 7);
    	submarino.alterar(5, 11);
    	submarino.alterar(6, 14);
    	submarino.alterar(8, 9);
    	submarino.alterar(13, 4);
    	
    }
      
    
	public void usuarioClicou(int indexLinha, int indexColuna) {
		
		if (jajogou.consultar(indexLinha, indexColuna)){
			
		}else {
			jajogou.alterar(indexLinha, indexColuna);
			
			
		}

	}
	

	public void restart() {
		batalha();
		// TODO Auto-generated method stub
	}

	public int getTamanhoJogo() {
		// declarar um atributo nessa classe com o tamanho e aqui retorno o atributo, criar um metado para fazer uma ligação com o 
		// modelo esse metado vai mandar para o objeto que vai ser estanciado no modelo para fazer com com atributo do tamanho 
		return a;
		
	}

	public boolean temSubmarino(int linha, int coluna) {
		
		//Consulta a linha e coluna onde o jogador clicou, se tiver navio/submarino, ele mostra a imagem
		
		//jajogou.consultar(linha, coluna);
		
		return (jajogou.consultar(linha,coluna))&&(submarino.consultar(linha,coluna));
		
	}
	
	public boolean temNavio1( int linha, int coluna){
		return (jajogou.consultar(linha, coluna))&&(navio1.consultar(linha,coluna));
	}
	
	public boolean temNavio(int linha, int coluna) {
		
		return (jajogou.consultar(linha,coluna))&&(navio.consultar(linha,coluna));
		
	}

	public boolean jaJogou(int linha, int coluna) {
		
		return jajogou.consultar(linha,coluna);
		
	}
	public void batalha(){
//		int t;
//		t=(int)(a*a)/5;
		
//		for(int i=0;i<t;i++){
//			int x,y;
//			x=radom.nextInt(a);
//			y=radom.nextInt(a);
//			
//			if(submarino.consultar(x,y)==false){
//				navio.alterar(x,y);
//			}
//			
//			x=radom.nextInt(a);
//			y=radom.nextInt(a);
//			
//			if(navio.consultar(x,y)==false){
//				submarino.alterar(x,y);
//			}
//		
//		}
		
		
		
		jajogou.reiniciar();
		navio.reiniciar();
		submarino.reiniciar();
		
		Inicializa();
	
	}
}
