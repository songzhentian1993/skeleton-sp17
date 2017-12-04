public class NBody {
	
	public static double readRadius(String filename) {
		In in = new In(filename);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	
	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int num = in.readInt();
		double radius = in.readDouble();
		int count = 0;
		Planet[] planets = new Planet[num];
		while (count < num) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			planets[count] = p;
			count = count + 1;
		}
		return planets;
	}
}
