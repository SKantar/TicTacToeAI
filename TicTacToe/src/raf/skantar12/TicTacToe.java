package raf.skantar12;

public class TicTacToe {
	private int matrix[][] = new int[9][9];
	private int best_i, best_j;
	
	
	public TicTacToe() {
		for(int i = 0 ; i < 3 ; i ++)
			for(int j = 0; j < 3; j ++)
					matrix[i][j] = 0;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	int isEnd(){
		for(int i = 0 ; i < 3 ; i ++)
			for(int j = 0; j < 3; j ++)
					if(matrix[i][j] == 0) return winner();
		return -2;
	}
	
	int winner(){
		for (int i = 0; i < 3; i++) {
			if (matrix[i][0] != 0 && matrix[i][1] == matrix[i][0] && matrix[i][2] == matrix[i][0])
				return matrix[i][0];
			if (matrix[0][i] != 0 && matrix[1][i] == matrix[0][i] && matrix[2][i] == matrix[0][i])
				return matrix[0][i];
		}
		if (matrix[1][1]==0) return 0;
	 
		if (matrix[1][1] == matrix[0][0] && matrix[2][2] == matrix[0][0]) return matrix[0][0];
		if (matrix[1][1] == matrix[2][0] && matrix[0][2] == matrix[1][1]) return matrix[1][1];
	 
		return 0;
	}
	
	public void printMatrix(){
		for(int i = 0 ; i < 3; i ++){
			for(int j = 0; j < 3; j ++)
					System.out.print(matrix[i][j] + " ");
			System.out.println(" ");
		}
		System.out.println(" \n");
	}
	
	int test_move(int player, int depthOfRecursion){
		int score;
		int best = -1;
		int changed = 0;
		
		score = winner();
		if (score > 0) return (score == player) ? 1 : -1;
	 
		for (int i = 0; i < 3; i++) 
			for (int j = 0; j < 3; j++) {
				
				if (matrix[i][j]!=0) continue;
	 
				changed = matrix[i][j] = player;
				score = -test_move(-player, depthOfRecursion + 1);
				matrix[i][j] = 0;
	 
				if (score <= best) continue;
				//kada dodje do pcoetne odmotavanje samo tad cuvamo max :D
				// one unutrasnje nam nisu bitne
				if (depthOfRecursion == 0) {
					best_i = i;
					best_j = j;
				}
				best = score;
			}
	 
		return changed != 0 ? best : 0;
	}
	
	public int getBest_i() {
		return best_i;
	}
	
	public int getBest_j() {
		return best_j;
	}

}
