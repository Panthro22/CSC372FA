package CTA4;

public class ShapeArray {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2.0, 3.0, 4.0);
        Circle circle = new Circle(3.5);
        Rectangle square = new Rectangle(6.0, 6.0);
        
        Shape[] shapeArray = {triangle, circle, square};
        
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}
