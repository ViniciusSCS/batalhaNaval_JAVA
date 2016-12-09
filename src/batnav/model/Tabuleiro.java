package batnav.model;

public class Tabuleiro {
    public static int bloco[][];
    static int t; // tamanho
    static int i;
    static int j;

    public Tabuleiro(int t) {
        bloco = new int[t][t];
    }

    public void alterar(int linha, int coluna) {
        bloco[linha][coluna] = 1;
    }

    public boolean consultar(int linha, int coluna) {
        return bloco[linha][coluna] == 1;
    }

    public void reiniciar() {
        for (i = 0; i < t; i++) {
            for (j = 0; j < t; j++) {
                bloco[i][j] = 0;
            }
        }
    }
}

