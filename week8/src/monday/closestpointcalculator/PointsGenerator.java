package monday.closestpointcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsGenerator {
	public static final int POINTS_COUNT = 100_000;
	public static final int BOUND = 10_000;

	public static List<Point> pointsGenerator() {
		List<Point> points = new ArrayList<Point>(POINTS_COUNT);
		Random rand = new Random();
		for (int i = 0; i < POINTS_COUNT; i++) {
			points.add(new Point(rand.nextInt(BOUND), rand.nextInt(BOUND)));
		}
		return points;
	}
}
