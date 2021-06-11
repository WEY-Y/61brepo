
public class NBody{
	public static String imageToDraw = "images/starfield.jpg";

	public static void main(String[] args) {

		
		if (args.length == 0) {
			System.out.println("Please supply a country as a command line argument.");
			System.out.println("For countries with spaces, use an underscore, e.g. South_Korea");
			/* NOTE: Please don't use System.exit() in your code.
			   It will break the autograder. */
			System.exit(0);
		}	

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius (filename);
		Planet[] b = readPlanets (filename);
		//picture(double x, double y,   filename)；
		
		StdDraw.setScale(-100, 100);
		StdDraw.picture(0, 0, imageToDraw);

		

		for (Planet s : b) {//增强for循环
			s.draw();
		}	


		for (double time = 0 ; time < T; time = time + dt) {

			double[] xForces = new double[b.length];
			double[] yForces = new double[b.length];
//			for (int i=0;i<b.length;i++) {//for循环
//				xForces[i] = b[i].calcNetForceExertedByX (b);
//				yForces[i] = b[i].calcNetForceExertedByY (b);
//			}
			for (int i=0;i<b.length;i++) {//for循环
				xForces[i] = b[i].calcNetForceExertedByX (b);
				yForces[i] = b[i].calcNetForceExertedByY (b);
				b[i].update(time,xForces[i],yForces[i]);
				StdDraw.setScale(-100, 100);

				b[i].draw();
				StdDraw.show();
				StdDraw.pause(10);
		    }

	    }
}

	//读半径 eg:readRadius("./data/planets.txt")
	public static double readRadius (String a){
		In in = new In(a);
		double numOfPlanet = in.readDouble();
		double radius = in.readDouble();
		return radius;

	}
	// readPlanets("./data/planets.txt")
	public static Planet[] readPlanets (String a){
		In in = new In(a);
		//Body planet= new Planet[];
		Planet[] b = new Planet [5];//new一个里面是对象的数组
		
		double numOfPlanet = in.readInt();
		double radius = in.readDouble();
		for(int i=0;i<b.length;i++){
			

		    double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			b[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		 //    b[i].xxPos = in.readDouble();
			// b[i].yyPos = in.readDouble();
			// b[i].xxVel = in.readDouble();
			// b[i].yyVel = in.readDouble();
			// b[i].mass = in.readDouble();
			// b[i].imgFileName = in.readString();
			//不能直接赋值 因为我还没有创建对象 这个是reference type 只是给了空间 是null。
			//正常来讲 new了一个具体大小的数组 数组里是对象。 需要先给对象赋初值 类似初始化 构造器就是给对象初始化用的

		}
		return b;
		
	}


}