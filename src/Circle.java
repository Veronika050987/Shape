public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        super('C');
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
