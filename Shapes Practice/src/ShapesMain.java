import java.util.Random;
import java.util.Scanner;

public class ShapesMain {

	private static Shape[] shapes = new Shape[4];
	private static ShapeContainer shapeContainer;
	private static Random r = new Random();
	public static void main(String[] args) {
		
		shapes[0] = new Triangle(randomInt(),randomInt(),randomInt(),randomInt());
		shapes[1] = new Rectangle(randomInt(), randomInt());
		shapes[2] = new Square(randomInt());
		System.out.println("There are 3 new Shapes created!");
		System.out.println();
		
		for(Shape sh: shapes){
			if(sh != null){
				System.out.println(sh.toString());
				System.out.println("Its Perimeter is equal to: " +calcShapePerimeter(sh));
				System.out.println("Its Area is equal to: " +calcShapeArea(sh));
				int scale = randomInt();
				scaleShape(sh, scale);
				System.out.println("The new Rescaled  by "+scale+" is "+sh.toString());
				System.out.println("Its Perimeter is equal to: " +calcShapePerimeter(sh));
				System.out.println("Its Area is equal to: " +calcShapeArea(sh));
				System.out.println();
			}
		}
	}
	
	public static int randomInt(){
		int rand = 0;
		while(rand<2){
			rand = r.nextInt(10);
		}
		return rand;
	}
	
	public static <T extends Shape> Double calcShapePerimeter(T shape){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			return shapeContainer.calculatePerimeter();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static <T extends Shape> Double calcShapeArea(T shape){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			return shapeContainer.calculateArea();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static <T extends Shape> void scaleShape(T shape, double scale){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			shapeContainer.changeShapeScale(scale);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
