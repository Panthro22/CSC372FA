package CTA4;

public class ShapeArray {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        Circle circle = new Circle(5.0);
        Rectangle square = new Rectangle(6.0, 6.0);
        
        Shape[] shapeArray = {triangle, circle, square};
        
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}
