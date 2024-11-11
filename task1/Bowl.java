package task1;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        if (food > 0) {
            this.food += food;
            System.out.println("В миску добавлено " + food + " ед. еды.");
        }
    }

    public void decreaseFood(int eatenFood) {
        if (food >= eatenFood) {
            food -= eatenFood;
        }
    }

    @Override
    public String toString() {
        return "В миске " + food + " ед. еды";
    }

}
