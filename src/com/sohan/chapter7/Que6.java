package com.sohan.chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a two-dimensional graph with points on it, find a line which passes the
 * most number of points.
 */
public class Que6 {

	public static void main(String[] args) {
		Point[] points = { new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(3, 1) };
		Line line = findBestLine(points);
		System.out.println(line.getSlope() + " ... " + line.getyIntercept());
	}

	public static Line findBestLine(Point[] points) {
		if (points == null || points.length < 2) {
			return null;
		}
		Line bestLine = null;
		Map<Line, Integer> lineCount = new HashMap<Line, Integer>();
		Line line;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; i < points.length; i++) {
				line = new Line(points[i], points[j]);
				if (!lineCount.containsKey(line)) {
					lineCount.put(line, 0);
				}
				lineCount.put(line, lineCount.get(line) + 1);
				if (bestLine == null || lineCount.get(line) > lineCount.get(bestLine)) {
					bestLine = line;
				}
			}

		}
		return bestLine;
	}

}
