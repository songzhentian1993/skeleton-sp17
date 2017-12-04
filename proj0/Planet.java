public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double r;
		double dx;
		double dy;
		dx = p.xxPos - xxPos;
		dy = p.yyPos - yyPos;
		r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}
	
	public double calcForceExertedBy(Planet p) {
		double F;
		double m1 = mass;
		double m2 = p.mass;
		double G = 6.67 * Math.pow(10, -11);
		double r = calcDistance(p);
		F = G * m1 * m2 / (r * r);
		return F;
	}
	
	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - xxPos;
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double Fx;
		Fx = F * dx / r;
		return Fx;
	}
	
	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double Fy;
		Fy = F * dy / r;
		return Fy;
	}
}