import java.awt.Color;
import java.awt.Graphics;

public class BodySegment {
	public static final int SIZE=15;
	public Color hue = Color.ORANGE;
	public static int nextID = 0;
	public int myID;
	private int xPos, yPos;
	private BodySegment next; //in order to move forward
	private BodySegment prev; //in order to move backwards
	
	public BodySegment(int x, int y){
		xPos = x;
		yPos = y;
		myID = nextID++;
	}

	public void setHue(Color c) {
		hue = c;
	}
	public Color getHue() {
		return hue;
	}
	
	public boolean isTouching(BodySegment sp){
		if( Math.sqrt( Math.pow(xPos-sp.getxPos(), 2) + Math.pow(yPos-sp.getyPos(), 2) ) <= 15) { //if the distance between 2 pieces is <= 15
			return true;		
		}
		return false;
	}
	
	public BodySegment getNext() {
		return next;
	}

	public void setNext(BodySegment next) {
		this.next = next;
	}

	public BodySegment getPrev() {
		return prev;
	}

	public void setPrev(BodySegment prev) {
		this.prev = prev;
	}
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void draw(Graphics g){
		g.setColor(hue);
		g.fillOval(xPos, yPos, SIZE, SIZE);
		g.setColor(Color.BLACK);
	}
}
