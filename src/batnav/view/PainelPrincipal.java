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
import javax.swing.JPanel;

import batnav.controler.ControladorBatNav;

public class PainelPrincipal extends JPanel {

	private ControladorBatNav controlador;
	
	private static final Color GRADE = Color.decode("#000000");
	private static final Color AGUA = Color.decode("#17cfc5");
	
	private static BufferedImage IMG_SUB;
	private static BufferedImage IMG_NAV;
	private static BufferedImage IMG_NAV1;
	
	static {
		try {
			IMG_SUB = ImageIO.read(new File("resources/sub.png"));
			IMG_NAV = ImageIO.read(new File("resources/nav.png"));
			IMG_NAV1 = ImageIO.read(new File("resources/nav1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PainelPrincipal() {
		controlador = new ControladorBatNav();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				int indexCol = x / calculaMenorDimensao();
				int indexLin = y / calculaMenorDimensao();
				
				controlador.usuarioClicou(indexLin, indexCol);
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
				
				if(controlador.temNavio(i, j)){
					g.drawImage(IMG_NAV, j * size, i * size, size * 2, size, null);
				}
				
				if(controlador.temNavio1(i, j)){
					g.drawImage(IMG_NAV1, j * size, i * size, size * 3, size, null);
				}
			}
		}
		
		for(int i = 0; i < controlador.getTamanhoJogo(); i++) {
			for(int j = 0; j < controlador.getTamanhoJogo(); j++) {
				if(controlador.jaJogou(i, j)) {
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
