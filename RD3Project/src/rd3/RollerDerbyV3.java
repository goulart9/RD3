package rd3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;
import javax.swing.JFrame;

public class RollerDerbyV3 implements KeyListener{
	JFrame frame;
	Map gameMap = new Map(8);
	RollerDerbyV3() {
		frame = new JFrame("Roller Derby V3");
		frame.addKeyListener(this);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		RollerDerbyV3 rd3 = new RollerDerbyV3();
		int lastSecond = LocalTime.now().getSecond();
		int currentSecond = 0;

		while(!rd3.gameMap.gameOver()) {
			//check if its time to step the map
			currentSecond = LocalTime.now().getSecond();
			if(lastSecond != currentSecond) {
				System.out.println(LocalTime.now().getSecond());
				rd3.gameMap.step();
				rd3.gameMap.prettyPrint();
				lastSecond = currentSecond;
			}
			
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_RIGHT) {
			gameMap.rightTurn();
		}
		if(code == KeyEvent.VK_LEFT) {
			gameMap.leftTurn();
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}

