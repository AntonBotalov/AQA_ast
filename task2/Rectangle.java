package task2;

public class Rectangle implements Shape {
    private double weight;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double weight, double height, String fillColor, String borderColor) {
        this.weight = weight;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double getArea() {
        return weight * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (weight + height);
    }
}
