package com.sohan.chapter7;

/**
 * Given two squares on a two-dimensional plane, find a line that would cut
 * these two squares in half. Assume that the top and the bottom sides of the
 * squares run parallel to the x-axis.
 */
public class Que5 {
	public static void main(String[] args) {
		Sqaure s1 = new Sqaure(new Point(1.5, 1.5), new Point(3, 3));
		Sqaure s2 = new Sqaure(new Point(1, 1), new Point(4, 4));
		Line line = s1.cut(s2);
		System.out.println(line.getP1() + " ... " + line.getP2());
	}
}

class Sqaure {
	private Point leftBottom;
	private Point rightTop;

	Sqaure(Point leftBottom, Point rightTop) {
		this.leftBottom = leftBottom;
		this.rightTop = rightTop;
	}

	public Point middle() {
		return new Point((leftBottom.x + rightTop.x) / 2, (leftBottom.y + rightTop.y) / 2);
	}

	public Line cut(Sqaure other) {
		Point thisMiddle = middle();
		Point otherMiddle = other.middle();
		Point p1;
		Point p2;
		if (thisMiddle.equals(otherMiddle)) {
			p1 = leftBottom;
			p2 = rightTop;
		} else {
			p1 = extend(thisMiddle, otherMiddle, this.rightTop.x - this.leftBottom.x);
			p2 = extend(otherMiddle, thisMiddle, other.rightTop.x - other.leftBottom.x);
		}
		return new Line(p1, p2);
	}

	public Point extend(Point mid1, Point mid2, double size) {
		int xDir = mid1.x < mid2.x ? -1 : 1;
		int yDir = mid1.y < mid2.y ? -1 : 1;

		if (Double.compare(mid1.x, mid2.x) == 0.0) {
			return new Point(mid1.x, mid1.y + yDir * size / 2.0);
		}

		double slope = (mid1.y - mid2.y) / (mid1.x - mid2.x);
		double x;
		double y;
		if (Math.abs(slope) == 1) {
			x = mid1.x + xDir * size / 2.0;
			y = mid1.y + yDir * size / 2.0;
		} else if (Math.abs(slope) < 1) {
			x = mid1.x + xDir * size / 2.0;
			y = mid1.y + slope * (x - mid1.y);
		} else {
			y = mid1.y + yDir * size / 2.0;
			x = mid1.x + (y - mid1.y) / slope;
		}
		return new Point(x, y);
	}
}
