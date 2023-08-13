package CTA4;

public class Rectangle extends Shape {
    private double width;
    private double length;
    
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    
    @Override
    public double area() {
        return width * length;
    }
    
    @Override
    public double perimeter() {
        return 2 * (width + length);
    }
    
    @Override
    public String toString() {
        return "Rectangle - Area: " + area() + ", Perimeter: " + perimeter();
    }
    
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        System.out.println(rectangle.toString());
    }
}
