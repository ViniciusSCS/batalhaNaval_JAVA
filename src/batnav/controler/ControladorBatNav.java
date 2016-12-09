package batnav.controler;

import java.util.Random;

import batnav.model.Tabuleiro;
import batnav.model.Navio;
import batnav.model.Submarino;

public class ControladorBatNav {
    public int area = 15;

    public Tabuleiro tabuleiro;
    public Submarino submarino;
    public Navio navio;
    private Random random;


    public ControladorBatNav() {
        restart();
    }

    public void usuarioClicou(int indexLinha, int indexColuna) {
        tabuleiro.alterar(indexLinha, indexColuna);
    }

    public void restart() {
        random = new Random();
        submarino = new Submarino(area);
        tabuleiro = new Tabuleiro(area);
        navio = new Navio(area);
        batalha();
    }

    public int getTamanhoJogo() {
        // declarar um atributo nessa classe com o tamanho e aqui retorno o atributo, criar um metado para fazer uma ligação com o
        // modelo esse metado vai mandar para o objeto que vai ser estanciado no modelo para fazer com com atributo do tamanho
        return area;
    }

    public boolean temSubmarino(int linha, int coluna) {
        //Consulta a linha e coluna onde o jogador clicou, se tiver navio/submarino, ele mostra a imagem
        return (tabuleiro.consultar(linha, coluna)) && (submarino.consultar(linha, coluna));
    }

    public boolean temNavio(int linha, int coluna) {
        //fazer a matriz ;
        return (tabuleiro.consultar(linha, coluna)) && (navio.consultar(linha, coluna));
    }

    public boolean jaJogou(int linha, int coluna) {
        return tabuleiro.consultar(linha, coluna);
    }

    public void batalha() {
        int x, y, t = (area * area) / 5;

        for (int i = 0; i < t; i++) {
            x = random.nextInt(area);
            y = random.nextInt(area);

            if (!submarino.consultar(x, y)) {
                navio.alterar(x, y);
            }

            x = random.nextInt(area);
            y = random.nextInt(area);

            if (!navio.consultar(x, y)) {
                submarino.alterar(x, y);
            }
        }

        tabuleiro.reiniciar();
        navio.reiniciar();
        submarino.reiniciar();
    }
}
