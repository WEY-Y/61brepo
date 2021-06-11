import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
public class Body{


	//属性：6个实例变量
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;


	//常量
	// public static double a = 10;
	// public static double b = -11;
	// public static final double G = 6.67 * Math.pow(a,b);
	public static final double G = 6.67e-11;
	//科学计数法


	
	

	public Body(double xP, double yP, double xV,double yV, double m, String img) {
	//构造器1:构造器的参数名最好和实例变量名不同 当然其实可以相同
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass =  m;
		imgFileName =  img;

	}

	public Body(Body b){
		//构造器2:用来copy一个 object
		

		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}


	//没有main方法 不需要直接执行 所以都是non-static
	//所有数字都是double
	//所有实例变量都用public

	public double calcDistance (Body c){
		double dx = c.xxPos - this.xxPos;
		double dy = c.yyPos - this.yyPos;
		double r0 = (dx * dx) + (dy * dy);
		double r = Math.sqrt(r0);
		return r;
	}

	// 输入rocinante 计算 samh和rocinante的距离 
	// samh.calcDistance(rocinante);
	// sqrt 调用math包

	public double calcForceExertedBy (Body d){	
		double f = (G * this.mass * d.mass)/Math.pow(calcDistance(d),2);
		return f;
	}
	// 计算 合力

	public double calcForceExertedByX (Body e){
		double fx = calcForceExertedBy(e) * (e.xxPos - this.xxPos)/calcDistance(e);
		return fx;

	}

	public double calcForceExertedByY (Body e){
		double fy = calcForceExertedBy(e) * (e.yyPos - this.yyPos)/calcDistance(e);
		return fy;

	}
	//计算 分力。想调用其他方法中的变量 比如直接用dx怎么用？ 在方法中定义的变量是局部变量 不可在其他方法中调用
	//解决方法1:变成类的变量 解决方法2：定义一个专门的方法计算 放到返回值里

	public double calcNetForceExertedByX (Body[] allBodys){

	   
	    double fxnet = 0 ;
		for (Body s : allBodys) {//增强for循环
			if (s.equals(this)){
				fxnet = fxnet + 0;
			} else{
				fxnet = fxnet + calcForceExertedByX(s);
			}
		}
		return fxnet;

	}

	public double calcNetForceExertedByY (Body[] allBodys){
	    double fynet = 0 ;
		for (Body s : allBodys) {//增强for循环 遍历数组中的元素
			if (s.equals(this)){//如果是自己就跳过 与== 不同。==是判断地址？ equals是判断内部的内容
				fynet = fynet + 0;
			} else{
				fynet = fynet + calcForceExertedByY(s);
			}
		}
		return fynet;

	}//计算多个物体一起的在y方向的合力

	public void update(double dt,double fX,double fY){
		double ax = fX/this.mass;
		double ay = fY/this.mass;
	    this.xxVel = this.xxVel + dt * ax ;
		this.yyVel = this.yyVel + dt * ay ;
		this.xxPos = this.xxPos + dt * xxVel ;
		this.yyPos = this.yyPos + dt * yyVel ;
		

	}//加速度 速度 位置更新    没有返回值 更新类的属性变量

	public void draw(){
		String pathimg = "images/" + imgFileName;
		System.out.println(pathimg);
		StdDraw.picture(xxPos, yyPos,pathimg );

	}


}