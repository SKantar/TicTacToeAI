package raf.skantar12;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{

	private Image image = null;
	private Image imageX = null;
	private Image imageO = null;
	
	
	
	
	public Panel() {
		setLayout(new GridLayout(3,3));
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("board.jpg"));
		image = icon.getImage();
		
		ImageIcon iconX = new ImageIcon(this.getClass().getResource("X.png"));
		imageX = iconX.getImage();
		ImageIcon iconO = new ImageIcon(this.getClass().getResource("O.png"));
		imageO = iconO.getImage();
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				boolean maked = false;
				if(AppCore.getInstance().getGame().getMatrix()[e.getY()/104][e.getX()/100] == 0){
					AppCore.getInstance().getGame().getMatrix()[e.getY()/104][e.getX()/100] = AppCore.getPLAYER();
					maked = true;
				}
				if(maked){
					if(AppCore.getInstance().getGame().winner() == 0){
						System.out.println(AppCore.getInstance().getGame().test_move(AppCore.getCOMPUTER(),0));
						//System.out.println(be"");
						AppCore.getInstance().getGame().getMatrix()[AppCore.getInstance().getGame().getBest_i()][AppCore.getInstance().getGame().getBest_j()] = AppCore.getCOMPUTER();
					}
				}
				AppCore.getInstance().getGame().printMatrix();
				repaint();
				if(AppCore.getInstance().getGame().isEnd() != 0){
					if(AppCore.getInstance().getGame().isEnd() == 1) JOptionPane.showMessageDialog(AppCore.getInstance(), "He is an idiot, tralalala");
					if(AppCore.getInstance().getGame().isEnd() == -1) JOptionPane.showMessageDialog(AppCore.getInstance(), "You are an idiot, tralalala");
					if(AppCore.getInstance().getGame().isEnd() == -2) JOptionPane.showMessageDialog(AppCore.getInstance(), "Draw!");
				}
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null)
	        g.drawImage(image, 0, 0,300,300, null);
		
		for(int i = 0 ; i < 3; i++)
			for(int j = 0 ; j < 3; j++){
				if(AppCore.getInstance().getGame().getMatrix()[i][j] == 1)
					//System.out.println("bulja");
					g.drawImage(imageX, j*100, i*100,100,100, null);
				if(AppCore.getInstance().getGame().getMatrix()[i][j] == -1)
			//System.out.println("bulja");
					g.drawImage(imageO, j*100, i*100,100,100, null);
			}
	}

	
}
