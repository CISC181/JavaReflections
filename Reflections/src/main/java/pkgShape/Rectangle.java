package pkgShape;

public class Rectangle {

	private int iWidth;
	private int iHeight;
	private static int iNbrOfRecs = 0;
	
	public Rectangle(int iWidth, int iHeight) {
		super();
		this.iWidth = iWidth;
		this.iHeight = iHeight;
		iNbrOfRecs++;
	}
	public int getiWidth() {
		return iWidth;
	}
	public void setiWidth(int iWidth) {
		this.iWidth = iWidth;
	}
	public int getiHeight() {
		return iHeight;
	}
	public void setiHeight(int iHeight) {
		this.iHeight = iHeight;
	}
	
	public static int getINbrOfRecs()
	{
		return iNbrOfRecs;
	}
	public double area()
	{
		return iHeight * iWidth;
	}
	
	public double permeiter()
	{
		return (2 * iHeight) + (2 * iWidth);
	}
}
