package fr.imie.support;

public enum BrowserSize {

	PC(1440, 900), TABLETTE(1280, 800), SMARTPHONE(960, 640);
	
	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	private BrowserSize(int width, int height){
		this.width = width;
		this.height = height;
	}
}
