package task2;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(6, "<Белый>", "Черный");
        Shape rectangle = new Rectangle(7, 2, "Красный", "Зеленый");
        Shape triangle = new Triangle(6, 8, 10, "Желтый", "Красный");

        System.out.println("Характеристики круга:");
        circle.getCharacteristics();

        System.out.println("\nХарактеристики прямоугольника:");
        rectangle.getCharacteristics();

        System.out.println("\nХарактеристики треугольника:");
        triangle.getCharacteristics();
    }
}
