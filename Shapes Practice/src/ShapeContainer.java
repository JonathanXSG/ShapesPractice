
public class ShapeContainer<T extends Shape> {

	private T shape;
	private String type;
	
	public ShapeContainer(T t){
		this.shape =t;
		this.type = t.shapeType();
	}
	
	public Double calculateArea() throws Exception{
		Double[] sides = shape.shapeMeasurments();
		
		if(type.equals("Square")){
			return Math.pow(sides[0], 2.0);
		}
		else if(type.equals("Rectangle")){
			return sides[0]*sides[1];
		}
		else if(type.equals("Triangle")){
			return (sides[0]*sides[3]) /2.0;
		}
		else{
			throw new Exception("Unknown shape type provided.");
		}
	}

	public Double calculatePerimeter() throws Exception{
		Double[] sides = shape.shapeMeasurments();
		
		if(type.equals("Square")){
			return sides[0]*4.0;
		}
		else if(type.equals("Rectangle")){
			return (sides[0] + sides[1]) *2.0;
		}
		else if(type.equals("Triangle")){
			return sides[0] + sides[1] + sides[2];
		}
		else{
			throw new Exception("Unknown shape type provided.");
		}
	}

	public void changeShapeScale(double scale){
		Double[] sides = shape.shapeMeasurments();

		for (int i = 0; i < sides.length; i++) {
			sides[i] *= scale;
		}
		this.shape.setSides(sides);
	}
}
