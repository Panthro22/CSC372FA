package CTA4;

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return "Circle - Area: " + area() + ", Perimeter: " + perimeter();
    }
    
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println(circle.toString());
    }
}