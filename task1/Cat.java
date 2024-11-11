package task1;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;
    private int eatFood = 15;


    public Cat(String name) {
        super(name, 0, 200);
        catCount++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
        ;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFood() >= eatFood) {
            bowl.decreaseFood(eatFood);
            isFull = true;
            System.out.println(name + " поел и теперь сыт");
        } else {
            System.out.println(name + " не поел, недостаточно еды");
        }
    }

    public String getIsFull() {
        return isFull ? " сытый" : " голодный";
    }

    public static int getCatCount() {
        return catCount;
    }
}
