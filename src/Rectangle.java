class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super('R');
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
