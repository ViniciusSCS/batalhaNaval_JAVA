package batnav.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import batnav.controler.ControladorBatNav;
import model.Score;

public class PainelDoJogo extends JPanel {

    private PainelPrincipal painelPrincipal;


    public PainelDoJogo() {
        setLayout(new BorderLayout());
        
        JLabel score = new JLabel("Score: " + 0);
      
        painelPrincipal = new PainelPrincipal(score);
        add(painelPrincipal, BorderLayout.CENTER);
        
//        Score ponto = new Score();
        ControladorBatNav Controlador = new ControladorBatNav();
        
        
        JButton restart = new JButton("Restart");
        restart.addActionListener(e -> painelPrincipal.restart());
       
        
        //System.out.println(Controlador.getScore());
               
        JPanel painelBotao = new JPanel();
        painelBotao.add(restart);
        add(painelBotao, BorderLayout.SOUTH);
        
        JPanel painelScore = new JPanel();
        painelScore.add(score);
        add(painelScore, BorderLayout.NORTH);

 
    }
}
