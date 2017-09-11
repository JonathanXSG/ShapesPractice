import java.util.Random;
import java.util.Scanner;

public class ShapesMain {

	private static Shape[] shapes = new Shape[4];
	private static ShapeContainer<Shape> shapeContainer;
	private static Random r = new Random();
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true){
			showMenu();
			menuSelector();
		}
	}
	
	private static int randomInt(){
		int rand = 0;
		while(rand<2){
			rand = r.nextInt(10);
		}
		return rand;
	}
	
	/**
	 * Method displays the various options to the user. 
	 */
	private static void showMenu(){
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("0) Show Shape information");
		System.out.println("1) Create Shape");
		System.out.println("2) Calculate perimeter");
		System.out.println("3) Calculate area");
		System.out.println("4) Scale shape");
	}
	
	/**
	 * Method handles the user's selection of the given options.
	 */
	private static void menuSelector(){
		int answer= getNumberAnswer();
		switch (answer) {
		case 0:
			showShapeInfo(shapes[0]);
			break;
		case 1:
			createShape();
			break;
		case 2:
			System.out.println("Its Perimeter is equal to: " +calcShapePerimeter(shapes[0]));
			break;
		case 3:
			System.out.println("Its Area is equal to: " +calcShapeArea(shapes[0]));
			break;
		case 4:
			System.out.println("Provide integer to use for scaling shape: ");
			scaleShape(shapes[0], getNumberAnswer());
			break;
		default:
			System.out.println("That's not actually an option.");
			break;
		}
	}
	
	/**
	 * Method is used to receive an integer answer from the user
	 * @return the answer from user
	 */
	private static int getNumberAnswer(){
		int answer=0;
		Boolean isNumber = false ;
		do {
			try{
				answer = Integer.parseInt(input.nextLine());
				isNumber =true;
			}
			catch(NumberFormatException e){
				System.out.println("Nope, that's not a number/integer.");
				System.out.println("Provide an integer answer.");
				System.out.println();
				isNumber = false;
			}
		} while (!isNumber);
		return answer;
	}
	
	/**
	 * Method is used to interact with user and create a new shape. 
	 * This method handles the necessary arguments required for each kind of shape.
	 */
	private static void createShape(){
		System.out.println();
		System.out.println("Choose shape to create:");
		System.out.println("1- Square");
		System.out.println("2- Rectangle");
		System.out.println("3- Triangle");
		System.out.println();
		int answer = getNumberAnswer();
		switch (answer) {
		case 1:
			System.out.println("Provide side measuremnt:");
			shapes[0] = new Square(getNumberAnswer());
			break;
		case 2:
			System.out.println("Provide height and width measuremnts separately:");
			shapes[0] = new Rectangle(getNumberAnswer(), getNumberAnswer());
			break;
		case 3:
			System.out.println("Provide base, side 1, side 2 and height measuremnts separately:");
			shapes[0] = new Triangle(getNumberAnswer(), getNumberAnswer(), getNumberAnswer(), getNumberAnswer());
			break;
		default:
			System.out.println("That's not actually an option.");
			break;
		}
	}
	
	/**
	 * Method displays the shape's measurements to the user.
	 * Also handles any exception it might cause.
	 * @param shape is any object that implements the Shape interface 
	 */
	private static <T extends Shape> void showShapeInfo(T shape){
		// Implement method and handle exception if there's not shape created
		if(shapes[0] != null){
			System.out.println();
			System.out.println(shapes[0].toString());
		}
		else{
			try {
				throw new IndexOutOfBoundsException("No shape has been created yet.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Method handles the calculation of the perimeter, along with any exceptions it might cause.
	 * @param shape is any object that implements the Shape interface
	 * @return The Perimeter of the provided shape
	 */
	private static <T extends Shape> Double calcShapePerimeter(T shape){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			return shapeContainer.calculatePerimeter();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Method handles the calculation of the area, along with any exceptions it might cause.
	 * @param shape is any object that implements the Shape interface
	 * @return The area of the provided shape
	 */
	private static <T extends Shape> Double calcShapeArea(T shape){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			return shapeContainer.calculateArea();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Method handles the scaling of the shape, along with any exceptions it might cause.
	 * @param shape is any object that implements the Shape interface
	 * @param scale is the number to be used for scaling the shape
	 */
	private static <T extends Shape> void scaleShape(T shape, double scale){
		shapeContainer = new ShapeContainer<Shape>(shape);
		try {
			shapeContainer.changeShapeScale(scale);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
