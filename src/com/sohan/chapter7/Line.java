package com.sohan.chapter7;

public class Line {
	private double epsilon = 0.000001;
	private boolean infiniteSlope = false;
	private double slope;
	private double yIntercept;
	private Point p1;
	private Point p2;

	Line(double s, double y) {
		this.slope = s;
		this.yIntercept = y;
	}

	Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		if (Double.compare(p1.x, p2.x) == 0.0) {
			this.infiniteSlope = true;
			this.yIntercept = p1.x;
		} else {
			this.slope = (p1.y - p2.y) / (p1.x - p2.x);
			this.yIntercept = p1.y + this.slope * (0 - p1.x);
		}
	}

	public boolean intersect1(Line line) {
		return Math.abs(this.slope - line.slope) > epsilon || Math.abs(this.yIntercept - line.yIntercept) < epsilon;
	}

	public boolean intersect2(Line line) {
		return Double.compare(this.slope, line.slope) != 0 || Double.compare(this.yIntercept, line.yIntercept) == 0;
	}

	public boolean isInfiniteSlope() {
		return infiniteSlope;
	}

	public double getSlope() {
		return slope;
	}

	public double getyIntercept() {
		return yIntercept;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (infiniteSlope ? 1231 : 1237);
		long temp = Double.doubleToLongBits(slope);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yIntercept);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (infiniteSlope != other.infiniteSlope)
			return false;
		if (Double.doubleToLongBits(slope) != Double.doubleToLongBits(other.slope))
			return false;
		if (Double.doubleToLongBits(yIntercept) != Double.doubleToLongBits(other.yIntercept))
			return false;
		return true;
	}

}