package raf.skantar12;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AppCore extends JFrame{
	private static AppCore instance = null;
	private Panel panel;
	private TicTacToe game;
	private static int PLAYER = 1;
	private static int COMPUTER = -1;
	
	public AppCore() {
		
		panel = new Panel();
		game = new TicTacToe();
		
		setSize(300, 320);
		setTitle("skantar12");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(panel);
	}
	
	
	public static AppCore getInstance() {
		if(instance == null)
			instance = new AppCore();
		return instance;
	}
	
	public static void main(String[] args) {
		AppCore appCore = AppCore.getInstance();
		appCore.setVisible(true);
	}
	
	
	public TicTacToe getGame() {
		return game;
	}
	
	public static int getPLAYER() {
		return PLAYER;
	}
	
	public static int getCOMPUTER() {
		return COMPUTER;
	}

}
