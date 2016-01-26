package monday.closestpointcalculator;

import java.util.List;
import java.util.Map;

public class PointsDistanceCalculator {

	public static void doCalculations(List<Point> generatedPoints, int indexFrom, int indexTo,
			Map<Point, Point> outMap) {
		Point closest = null;
		for (int i = indexFrom; i < indexTo; i++) {
			Point currentPoint = generatedPoints.get(i);
			double distance = Double.MAX_VALUE;
			for (Point point : generatedPoints) {
				if (point.equals(currentPoint)) {
					continue;
				}
				double dist = MathUtils.calculateDistance(currentPoint, point);
				if (dist < distance) {
					distance = dist;
					closest = point;
				}
			}
			outMap.put(currentPoint, closest);
			System.out.println(currentPoint + " closest: " + closest);
		}
	}
}
