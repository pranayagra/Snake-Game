import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class Snake implements KeyListener{
	public static final int UP=0, RIGHT=1, DOWN=2, LEFT=3;
	private BodySegment first;
	private BodySegment last;
	private int dir, size ;
	private boolean hasMoved=false;
	
	public Snake(){
		first = new BodySegment(200,200);
		last = first;
		dir = 1;
		size = 1;
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(){
		int yPos = first.getyPos();
		int xPos = first.getxPos();
		
		if(dir == 0) { //we want to go up..
			yPos-=15; //100
		}
		if(dir == 1) { //wanna go right
			xPos+=15; //100
		}
		if(dir == 2) { //wanna go down
			yPos+=15; //100
		}
		if(dir == 3) { //wanna go left
			xPos-=15; //100
		}
		BodySegment temp = new BodySegment(xPos, yPos); //add a new bodypart to the relative location of where we are
		temp.setNext(first); //change next
		first.setPrev(temp); //change the prev
		first = temp;  //first is new
		size++; //increase size
		hasMoved = true;
		
		first.setHue(Color.GREEN);
		last.setHue(Color.RED);

	}
	
	public void removeLast(){
		BodySegment almostLast = last.getPrev();
		almostLast.setNext(null);
		last.setPrev(null);
		last = almostLast;
		size--;
	}
	
	public BodySegment getFirst() {
		return first;
	}

	public void setFirst(BodySegment first) {
		this.first = first;
	}

	public BodySegment getLast() {
		return last;
	}

	public void setLast(BodySegment last) {
		this.last = last;
	}

	public void draw(Graphics g){
		BodySegment curr = first;
		while(curr!=null) {
			curr.draw(g);
			curr = curr.getNext();
		}
	}

	public boolean isTouchingSelf() {
		BodySegment curr = first.getNext();
		while(curr != null) {
			if(first.getxPos() == curr.getxPos() && first.getyPos() == curr.getyPos() && size >= 3) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(!hasMoved)
			return;
		if(e.getKeyCode() == KeyEvent.VK_UP && dir != 2){
			dir = 0;
			hasMoved = false;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN && dir != 0) {
			dir = 2;
			hasMoved = false;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT && dir != 1) {
			dir = 3;
			hasMoved = false;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT && dir != 3) {
			dir = 1;
			hasMoved = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}
