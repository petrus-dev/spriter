package com.brashmonkey.spriter;


public class Rectangle {
	
	public float left, top, right, bottom;
	public final Dimension size;
	
	public Rectangle(float left, float top, float right, float bottom){
		this.set(left, top, right, bottom);
		this.size = new Dimension(0, 0);
		this.calculateSize();
	}
	
	public Rectangle(Rectangle rect){
		this(rect.left, rect.top, rect.right, rect.bottom);
	}
	
	public boolean isInside(float x, float y){
		return x >= this.left && x <= this.right && y <= this.top && y >= this.bottom; 
	}
	
	public boolean isInside(Point point){
		return isInside(point.x, point.y);
	}
	
	public void calculateSize(){
		this.size.set(right-left, top-bottom);
	}
	
	public void set(Rectangle rect){
		if(rect == null) return;
		this.bottom = rect.bottom;
		this.left = rect.left;
		this.right = rect.right;
		this.top = rect.top;
		this.calculateSize();
	}
	
	public void set(float left, float top, float right, float bottom){
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
	
	public static boolean areIntersecting(Rectangle rect1, Rectangle rect2){
		return rect1.isInside(rect2.left, rect2.top) || rect1.isInside(rect2.right, rect2.top)
				|| rect1.isInside(rect2.left, rect2.bottom) || rect1.isInside(rect2.right, rect2.bottom);
	}
	
	public static void setBiggerRectangle(Rectangle rect1, Rectangle rect2, Rectangle target){
		target.left = Math.min(rect1.left, rect2.left);
		target.bottom = Math.min(rect1.bottom, rect2.bottom);
		target.right = Math.max(rect1.right, rect2.right);
		target.top = Math.max(rect1.top, rect2.top);
	}

}
