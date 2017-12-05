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
			String imgFileName = "./images/" + in.readString();
			Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			planets[count] = p;
			count = count + 1;
		}
		return planets;
	}

	public static void main(String[] args) {
		double time = 0;
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		//StdDraw.enableDoubleBuffering();
		while (time < T) {
			double[] arr_xForce = new double[planets.length];
			double[] arr_yForce = new double[planets.length];
			for (int i = 0; i < planets.length; i++) {
				double NFx = planets[i].calcNetForceExertedByX(planets);
				double NFy = planets[i].calcNetForceExertedByY(planets);
				arr_xForce[i] = NFx;
				arr_yForce[i] = NFy;
			}
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, arr_xForce[i], arr_yForce[i]);
			}
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for (Planet p: planets) {
				p.draw();
			}
			StdDraw.show(10);
			//StdDraw.pause(10);
			time = time + dt;
		}
	}
}
