package task2;

public interface Shape {
    String getFillColor();

    String getBorderColor();

    double getArea();

    double getPerimeter();

    default void getCharacteristics(){
        System.out.println("Цвет фона " + getFillColor());
        System.out.println("Цвет границ " + getBorderColor());
        System.out.println("Площадь " + getArea());
        System.out.println("Периметр " + getPerimeter());
    }
}
