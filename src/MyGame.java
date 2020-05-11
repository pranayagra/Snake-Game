import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyGame extends SnakeGame{
	public MyGame(){
		super();
		setBG(Color.DARK_GRAY);
		setGridColor(Color.ORANGE);
		playGame();
	}
	
	public void gameFrame(){
		player.addFirst();
		player.removeLast();

		//if the head is touching a piece of food...
		if(player.getFirst().isTouching(food)) {
			player.addFirst(); //add an extra piece
			placeFood(); //place another random food
		}

		int xPos = player.getFirst().getxPos();
		int yPos = player.getFirst().getyPos();

		long elapsedTime = (System.currentTimeMillis() - startTime); //milliseconds time
		long minutes = elapsedTime/(1000*60); //math to find minutes
		long seconds = (elapsedTime/1000)%60; //math to find seconds
		long miliseconds = elapsedTime%1000; //math to find milliseconds
		timer.setText("Time: " + minutes + ":" + seconds + ":" + miliseconds); //timer format
		timer.setBackground(Color.CYAN);
		timer.setForeground(Color.DARK_GRAY);
		timer.setFont(new Font("Times New Roman",Font.BOLD, 20));
		timer.setHorizontalAlignment(JTextField.CENTER);
		score.setText("Score:" + player.size()); //score format
		score.setBackground(Color.CYAN);
		score.setForeground(Color.DARK_GRAY);
		score.setFont(new Font("Times New Roman",Font.BOLD, 20));
		score.setHorizontalAlignment(JTextField.CENTER);

		drawGame();

		if(player.isTouchingSelf() || xPos <= 0 || xPos >= WIDTH-15 || yPos <= 0 || yPos >= HEIGHT-15) { //Out of bounds
			JOptionPane.showMessageDialog(null, "Game Over");
			System.exit(0);
		}
	}
	
	public static void main(String[] args){new MyGame();}	
}
