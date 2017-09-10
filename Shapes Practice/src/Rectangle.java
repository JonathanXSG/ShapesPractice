
public class Rectangle implements Shape {
	
	private double height, width;
	
	
	public Rectangle(double h, double w){
		this.height = h;
		this.width = w;
	}

	@Override
	public Double[] shapeMeasurments() {
		Double[] measurments = new Double[2];
		measurments[0] = this.height;
		measurments[1] = this.width;
		return measurments;
	}

	@Override
	public String shapeType() {
		return "Rectangle";
	}

	@Override
	public void setSides(Double[] S) {
		this.height = S[0];
		this.width = S[1];		
	}
	
	@Override
	public String toString(){
		return "Rectangle with width: "+this.width+", height: " +this.height;
	}

	
	

	

}
