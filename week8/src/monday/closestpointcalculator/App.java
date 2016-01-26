package monday.closestpointcalculator;

import java.util.List;

public class App {
	// brutforce need 2 minutes for 100_000 Points
	// 2 threads ==> 1.34minutes
	// 3 threads ==> 1.14min
	// 4 threads ==> 1.28min
	public static void main(String[] args) {
		final List<Point> generatedPoints = PointsGenerator.pointsGenerator();
		long start = System.currentTimeMillis();

		NearestPointFinderThread t1 = new NearestPointFinderThread(generatedPoints, 0, 35_000);

		NearestPointFinderThread t2 = new NearestPointFinderThread(generatedPoints, 35_000, 65_000);

		NearestPointFinderThread t3 = new NearestPointFinderThread(generatedPoints, 65_000, 100_000);
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
