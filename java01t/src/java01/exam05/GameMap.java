package java01.exam05;

public class GameMap {
	public static final int DEFAULT_X_SIZE = 7;
	public static final int DEFAULT_Y_SIZE = 7;
	
	char[][] map;
	Item[] items;
	int itemSize;
	int maxX;
	int maxY;
	
	public GameMap() {
		this(DEFAULT_X_SIZE, DEFAULT_Y_SIZE);
	}
	
	public GameMap(int maxValue) {
		this(maxValue, maxValue);
	}
	
	public GameMap(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		map = new char[maxY][maxX];
		items = new Item[10];
		itemSize = 0;
	}
	
	private void initMap() {
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				map[y][x] = '.';
			}
		}
	}
	
	private void locateItems() {
		for (int i = 0; i < itemSize; i++) {
			map[items[i].getY()][items[i].getX()] = 
					items[i].getFlag();
		}
	}
	
	public void print() {
		initMap();
		locateItems();
		
		printBoundary();
		
	  for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
					System.out.print(map[y][x]);
			}
			System.out.println();
		}
	  
	  printBoundary();
  }

	private void printBoundary() {
	  for (int i = 0 ;i < maxX; i++) {
			System.out.print("-");
		}
		System.out.println();
  }

	public void addItem(Item item) {
		if (itemSize < items.length) {
			items[itemSize] = item;
			itemSize++;
		}
	}
	
}









