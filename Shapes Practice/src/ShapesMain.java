
public class ShapesMain {

	private Shape[] shapes;
	private ShapeContainer shapeContainer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public <T extends Shape> Double calcShapePerimeter(T shape){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			return shapeContainer.calculatePerimeter();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public <T extends Shape> Double calcShapeArea(T shape){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			return shapeContainer.calculateArea();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public <T extends Shape> void scaleShape(T shape, double scale){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			shapeContainer.changeShapeScale(scale);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
