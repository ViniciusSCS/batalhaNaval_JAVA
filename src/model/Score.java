package model;

public class Score {

		float pontos;

		public float getPontos() {
			return pontos;
		}

		public void setPontos(float pontos) {
			this.pontos = (this.pontos + pontos);
		}
}
