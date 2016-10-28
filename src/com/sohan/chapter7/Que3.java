package com.sohan.chapter7;

/**
 * Given the two lines in a Cartesian plane, determine whether the two lines
 * would intersect.
 */
public class Que3 {
	public static void main(String[] args) {
		Line line1 = new Line(Math.tan(35), 3.0);
		Line line2 = new Line(Math.tan(34.9999999), 2.999999);
		Line line3 = new Line(Math.tan(35), 2);
		System.out.println(line1.intersect1(line2));
		System.out.println(line1.intersect2(line2));
		System.out.println(line1.intersect1(line3));
		System.out.println(line1.intersect2(line3));
	}
}
