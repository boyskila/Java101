package monday.closestpointcalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestPointFinderThread extends Thread {
	private int indexFrom;
	private int indexTo;
	private List<Point> points;
	private Map<Point, Point> outMap = new HashMap<>(PointsGenerator.POINTS_COUNT);

	public NearestPointFinderThread(List<Point> points, int indexFrom, int indexTo) {
		super();
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
		this.points = points;
	}

	@Override
	public void run() {
		PointsDistanceCalculator.doCalculations(points, indexFrom, indexTo, outMap);
	}
}
