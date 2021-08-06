package rd3;

public class Map {

	private int carColumn;
	private int numRows;
	private int[][] map;
	private int[] obstacles, arr;
	private final int EMPTY = 0, OIL = 1, POTHOLE = 2, CONE = 3;

	public Map(int rows) {
		carColumn = 1;
		numRows = rows;
		map = new int[3][numRows];
		obstacles = new int[3];
	}

	public void step() {
		// check gameOver()
		// shift everything down
	}

	private void populateArray() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < numRows; j++) {
				map[i][j] = 0;
			}
		}
	}
	
	private int[] addRandomObstacles() {
		for (int i = 0; i < 3; i++) {
			int rand = (int) (Math.random()*100);
			
			if (rand >= 0 && rand <= 70) {
				rand = 0;
			}
			
			else if (rand >= 71 && rand <= 80) {
				rand = 1;
			}
			
			else if (rand >= 81 && rand <= 90) {
				rand = 2;
			}
			
			else if (rand >= 91 && rand <= 100) {
				rand = 3;
			}
			
			obstacles[i] = rand;
		}
		
		if (!checkContainsEmpty(obstacles)) addRandomObstacles();
		return obstacles;
	}
	
	private boolean checkContainsEmpty(int[] arr) {
		for (int k : arr) {
			if (k == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkContainsObstacle(int[] arr) {
		for (int k : arr) {
			if (k == 1 || k == 2 || k == 3) {
				return true;
			}
		}
		
		return false;
	}

	public boolean gameOver() {
		return false;
	}

	public void setCarColumn(int col) {
		carColumn = col;
	}

	void prettyPrint() {

	}
}
