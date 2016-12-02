package batnav.controler;
import java.util.Random;

import model.Jajogou;
import model.Navio;
import model.Submarino;

public class ControladorBatNav {
    public int a=15;
  
    public Jajogou jajogou;
    public Submarino submarino ; 
    public Navio navio;
    private Random radom;
      
      
      public ControladorBatNav(){
    	  
    	  radom = new Random();
    	  submarino = new Submarino(a);
    	  jajogou = new Jajogou(a);
    	  navio= new Navio(a);
    	  batalha();
    	  
    	  
      }
	public void usuarioClicou(int indexLinha, int indexColuna) {
		jajogou.alterar(indexLinha, indexColuna);
		
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
		
		return (jajogou.consultar(linha,coluna))&&(submarino.consultar(linha,coluna));
	}

	public boolean temNavio(int linha, int coluna) {
		
		//fazer a matriz ;
		
		return (jajogou.consultar(linha,coluna))&&(navio.consultar(linha,coluna));
	}

	public boolean jaJogou(int linha, int coluna) {
		// 
		return jajogou.consultar(linha,coluna);
	}
	public void batalha(){
		int t;
		t=(int)(a*a)/5;
		for(int i=0;i<t;i++){
			int x,y;
			x=radom.nextInt(a);
			y=radom.nextInt(a);
			if(submarino.consultar(x,y)==false){
				navio.alterar(x,y);
				
			}
			x=radom.nextInt(a);
			y=radom.nextInt(a);
			if(navio.consultar(x,y)==false){
				submarino.alterar(x,y);
				
			}
		
		}
		jajogou.reiniciar();
		navio.reiniciar();
		submarino.reiniciar();
		
		
	
	}

}
