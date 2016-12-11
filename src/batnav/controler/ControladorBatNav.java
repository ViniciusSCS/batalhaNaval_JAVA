package batnav.controler;

import java.util.Random;


import model.Jajogou;
import model.Matriz;
import model.MatrizJogo;
import model.Navio;
import model.Navio1;
import model.Score;
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
    public Score score;
    
      public ControladorBatNav(){
    	  
    	  matriz=Matriz.getInstance();
    	  matrizJogo = MatrizJogo.getInstance();
    	  
    	  jajogou = new Jajogou();
    	  submarino = new Submarino();
    	  navio= new Navio();
    	  navio1 = new Navio1();
    	  score = new Score();
    	  
    	  Inicializa();
      }
      
    public void Inicializa(){
    	
    	navio.alterar(1, 4);
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
    	
    	navio1.alterar(2, 0);
    	navio1.alterar(4, 8);
    	navio1.alterar(7, 6);
    	navio1.alterar(14, 3);
    	navio1.alterar(9, 8);
    	navio1.alterar(7, 7);
    	
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
		
		boolean res;
		res = (jajogou.consultar(linha,coluna))&&(submarino.consultar(linha,coluna));
		
		if (res=false){
			score.setPontos(35);
		}else score.setPontos(-10);
		
		
		return (jajogou.consultar(linha,coluna))&&(submarino.consultar(linha,coluna));
		
	}
	
	public boolean temNavio1( int linha, int coluna){
		
		return (jajogou.consultar(linha, coluna))&&(navio1.consultar(linha,coluna));
	}
	
	
	public boolean temNavioPt1(int linha, int coluna) {
		
		boolean res;
		res = (jajogou.consultar(linha,coluna))&&(navio.consultar(linha,coluna));
		
		if (res=false){
			score.setPontos(-10);
		}else score.setPontos(25);
		
		
		return (jajogou.consultar(linha,coluna))&&(navio.consultar(linha,coluna));
		
	}
	
	public boolean temNavioPt2(int linha, int coluna) {
		
		boolean res;
		res = (jajogou.consultar(linha,coluna))&&(navio.consultarPt2(linha,coluna));
		
		if (res=false){
			score.setPontos(25);
		}else score.setPontos(-10);
		
		
		return (jajogou.consultar(linha,coluna))&&(navio.consultarPt2(linha,coluna));
		
	}

	public boolean jaJogou(int linha, int coluna) {
		
		return jajogou.consultar(linha,coluna);
		
	}
	
	public boolean temBomba(int linha, int coluna) {
		
		return jajogou.consultarBomba(linha, coluna);
		
	}
	
	
	public float getScore(){
		
		return (score.getPontos());
	}
	
	public void batalha(){
		
		
		jajogou.reiniciar();
		navio.reiniciar();
		submarino.reiniciar();
		
		Inicializa();
	
	}
}
