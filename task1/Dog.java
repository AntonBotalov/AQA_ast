package task1;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 10, 500);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
