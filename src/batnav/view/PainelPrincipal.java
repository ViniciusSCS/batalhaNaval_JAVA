package batnav.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import batnav.controler.ControladorBatNav;

public class PainelPrincipal extends JPanel {

	private ControladorBatNav controlador;
	
	private static final Color GRADE = Color.decode("#000000");
	private static final Color AGUA = Color.decode("#17cfc5");
	
	private static BufferedImage IMG_SUB;
	private static BufferedImage IMG_NAV_PT1;
	private static BufferedImage IMG_NAV_PT2;
	private static BufferedImage IMG_NAV1_PT1;
	private static BufferedImage IMG_NAV1_PT2;
	private static BufferedImage IMG_NAV1_PT3;
	private static BufferedImage BOMB;
	
	static {
		try {
			IMG_SUB = ImageIO.read(new File("resources/sub.png"));
			IMG_NAV_PT1 = ImageIO.read(new File("resources/nav-pt1.png"));
			IMG_NAV_PT2 = ImageIO.read(new File("resources/nav-pt2.png"));
			IMG_NAV1_PT1 = ImageIO.read(new File("resources/nav1-pt1.png"));
			IMG_NAV1_PT2 = ImageIO.read(new File("resources/nav1-pt2.png"));
			IMG_NAV1_PT3 = ImageIO.read(new File("resources/nav1-pt3.png"));
			BOMB = ImageIO.read(new File("resources/bomb.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PainelPrincipal(JLabel score) {
		controlador = new ControladorBatNav();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				String ponto;
				
				int indexCol = x / calculaMenorDimensao();
				int indexLin = y / calculaMenorDimensao();
				
				controlador.usuarioClicou(indexLin, indexCol);
				
				ponto = String.valueOf(controlador.getScore());
				
				
				score.setText(ponto);
				
				//System.out.println(controlador.getScore());
				
				repaint();
				//Verifica onde o Usuário clicou e altera a cor do quadrado clicado (menor dimensao)
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		int size = calculaMenorDimensao();
		
		// desenha tabuleiro		
		for(int i = 0; i < controlador.getTamanhoJogo(); i++) {
			for(int j = 0; j < controlador.getTamanhoJogo(); j++) {
				g2.setColor(AGUA);
				g2.fillRect(j * size, i * size, size, size);

				g2.setColor(GRADE);
				g2.drawRect(j * size, i * size, size, size);
			}
		}
		
		for(int i = 0; i < controlador.getTamanhoJogo(); i++) {
			for(int j = 0; j < controlador.getTamanhoJogo(); j++) {
				if(controlador.temSubmarino(i, j)) {
					g.drawImage(IMG_SUB, j * size, i * size, size, size, null);
				}
			
			// Navio de 2 blocos
				if(controlador.temNavioPt1(i, j)){
					g.drawImage(IMG_NAV_PT1, j * size, i * size, size * 1, size, null);
				}
				
				if(controlador.temNavioPt2(i, j)){
					g.drawImage(IMG_NAV_PT2, j * size, i * size, size * 1, size, null);
				}
				
			// Navio de 3 blocos
				if(controlador.temNavio1PT1(i, j)){
					g.drawImage(IMG_NAV1_PT1, j * size, i * size, size * 1, size, null);
				}
				if(controlador.temNavio1PT2(i, j)){
					g.drawImage(IMG_NAV1_PT2, j * size, i * size, size * 1, size, null);
				}
				if(controlador.temNavio1PT3(i, j)){
					g.drawImage(IMG_NAV1_PT3, j * size, i * size, size * 1, size, null);
				}
				if(controlador.temBomba(i, j)){
					g.drawImage(BOMB, j * size, i * size, size*1, size, null);
				}
			}
		}
		
		for(int i = 0; i < controlador.getTamanhoJogo(); i++) {
			for(int j = 0; j < controlador.getTamanhoJogo(); j++) {
				if(controlador.jaJogou(i, j)) {
					
					//g.drawImage(BOMB, j * size, i * size, size, size, null);
					g2.setColor(Color.black);
					g2.setComposite(AlphaComposite.SrcOver.derive(0.3f));
					g2.fillRect(j * size, i * size, size, size);
					g2.setComposite(AlphaComposite.SrcOver);
					
				}
			}
		}
		
		
	}
	
	
	private int calculaMenorDimensao() {
		int dimensao = getSize().height;
		
		if(dimensao > getSize().width)
			dimensao = getSize().width;
		
		return dimensao/controlador.getTamanhoJogo();
	}

	public void restart() {
		controlador.restart();
		repaint();
	}

}
