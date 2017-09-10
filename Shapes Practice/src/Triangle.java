
public class Triangle implements Shape {
	
	private double base, side1, side2;
	private double height;
	
	public Triangle(double base, double s1, double s2, double height){
		this.base = base;
		this.side1 = s1;
		this.side2 = s2;
		this.height = height;
	}

	@Override
	public Double[] shapeMeasurments() {
		Double[] measurments = new Double[4];
		measurments[0] = this.base;
		measurments[1] = this.side1;
		measurments[2] = this.side2;
		measurments[3] = this.height;
		return measurments;
	}

	@Override
	public String shapeType() {
		return "Triangle";
	}

	@Override
	public void setSides(Double[] S) {
		this.base = S[0];
		this.side1 = S[1];
		this.side2 = S[2];
		this.height = S[3];
	}


}
