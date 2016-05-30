import java.util.*;

public class snake {
	private ArrayList<coordinate> list;
	private int length;
	
	public snake() {
		list = new ArrayList<coordinate>();
		length = 10;
		for (int i = 0; i < length; i++) {
			list.add(new coordinate(25, length - 1 - i));
		}		
	}
	
	public ArrayList<coordinate> getlist() {
		return list;
	}
	
	public int size() {
		return this.length;
	}
	
	public void changeL() {
		this.length++;
	}
	
	public void rightMove() {
		list.remove(list.size() - 1);
		coordinate temp = list.get(0);
		int x = temp.getX();
		int y = temp.getY();
		coordinate newhead = new coordinate(x, y + 1);
		list.add(0, newhead);
	}
	
	public void upMove() {
		list.remove(list.size() - 1);
		coordinate temp = list.get(0);
		int x = temp.getX();
		int y = temp.getY();
		coordinate newhead = new coordinate(x - 1, y);
		list.add(0, newhead);
	}
	
	public void leftMove() {
		list.remove(list.size() - 1);
		coordinate temp = list.get(0);
		int x = temp.getX();
		int y = temp.getY();
		coordinate newhead = new coordinate(x, y - 1);
		list.add(0, newhead);
	}
	
	public void downMove() {
		list.remove(list.size() - 1);
		coordinate temp = list.get(0);
		int x = temp.getX();
		int y = temp.getY();
		coordinate newhead = new coordinate(x + 1, y);
		list.add(0, newhead);
	}

}
