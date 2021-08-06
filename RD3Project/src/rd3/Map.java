package rd3;

public class Map {

	private int tick;
	private int carColumn;
	private int numRows;
	private int[][] map;
	private int[] obstacles, arr;
	private final int EMPTY = 0, OIL = 1, POTHOLE = 2, CONE = 3;

	public Map(int rows) {
		tick = 0;
		carColumn = 1;
		numRows = rows;
		map = new int[3][numRows];
		obstacles = new int[3];
	}

	public void step() {
		// shift everything down
		for(int i = numRows - 2; i >= 0; --i) {
			map[0][i+1] = map[0][i];
			map[1][i+1] = map[1][i];
			map[2][i+1] = map[2][i];
		}
		//add new layer
		if(tick%2 == 0) {
			map[0][0] = 0;
			map[1][0] = 0;
			map[2][0] = 0;
		}
		else {
			int[] newRow = addRandomObstacles();
			map[0][0] = newRow[0];
			map[1][0] = newRow[1];
			map[2][0] = newRow[2];
		}
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
		return map[carColumn][numRows-1] != 0;
	}

	public void setCarColumn(int col) {
		carColumn = col;
	}

	void prettyPrint() {
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < 3; col++)
			{
				if(row == numRows - 1 && col == carColumn) {
					System.out.print("$");
				}
				else {
					System.out.print(map[col][row]);
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}
	
	void rightTurn() {
		//move one lane to the right if possible
		if(carColumn != 2) {
			++carColumn;
		}
	}
	
	void leftTurn() {
		//move one lane to the left if possible
		if(carColumn != 0) {
			--carColumn;
		}
	}
}
