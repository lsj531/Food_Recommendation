import java.util.ArrayList;
import java.util.List;

public class Attribute {
	private double x0;
	private double x1;
	private double x2;
	private double x3;
	private double x4;
	private double x5;
	private double x6;
	private double x7;
	private double x8;
	
	private int num = 9;
	private double y;
	
	private List<Double> list;
	Attribute() {
		this.x0 = 1;
		this.x1 = 0;
		this.x2 = 0;
		this.x3 = 0;
		this.x4 = 0;
		this.x5 = 0;
		this.x6 = 0;
		this.x7 = 0;
		this.x8 = 0;
		this.y = 0;
		list = new ArrayList<Double>();
	}
	
	public List<Double> getAttribute() {
		list =null;
		list = new ArrayList<Double>();
		list.add(x0);
		list.add(x1);
		list.add(x2);
		list.add(x3);
		list.add(x4);
		list.add(x5);
		list.add(x6);
		list.add(x7);
		list.add(x8);
		return list;
	}
	public double getY() {
		return x1;
	}

	public Attribute setY(double y) {
		this.y = y;
		return this;
	}

	public double getX0() {
		return x0;
	}

	public Attribute setX0(double x0) {
		this.x0 = x0;
		return this;
	}
	public double getX1() {
		return x1;
	}

	public Attribute setX1(double x1) {
		this.x1 = x1;
		return this;
	}

	public double getX2() {
		return x2;
	}

	public Attribute setX2(double x2) {
		this.x2 = x2;
		return this;
	}

	public double getX3() {
		return x3;
	}

	public Attribute setX3(double x3) {
		this.x3 = x3;
		return this;
	}

	public double getX4() {
		return x4;
	}

	public Attribute setX4(double x4) {
		this.x4 = x4;
		return this;
	}

	public double getX5() {
		return x5;
	}

	public Attribute setX5(double x5) {
		this.x5 = x5;
		return this;
	}

	public double getX6() {
		return x6;
	}

	public Attribute setX6(double x6) {
		this.x6 = x6;
		return this;
	}

	public double getX7() {
		return x7;
	}

	public Attribute setX7(double x7) {
		this.x7 = x7;
		return this;
	}

	public double getX8() {
		return x8;
	}

	public Attribute setX8(double x8) {
		this.x8 = x8;
		return this;
	}
	
}