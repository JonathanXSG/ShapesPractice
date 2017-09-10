
public class Square implements Shape {
	private double side;
	
	public Square(double s){
		this.side = s;
	}

	@Override
	public Double[] shapeMeasurments() {
		Double[] measurments = new Double[1];
		measurments[0] = this.side;
		return measurments;
	}

	@Override
	public String shapeType() {
		return "Square";
	}

	@Override
	public void setSides(Double[] S) {
		this.side = S[0];
	}

	
}
