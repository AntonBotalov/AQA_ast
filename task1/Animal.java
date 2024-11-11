package task1;

public class Animal {

    protected String name;
    private int swimmingDistance;
    private int runningDistance;
    private static int animalCount = 0;

    public Animal(String name, int swimmingDistance, int runningDistance) {
        this.name = name;
        this.swimmingDistance = swimmingDistance;
        this.runningDistance = runningDistance;
        animalCount++;
    }

    public void run(int distance){
        if(runningDistance >= distance){
            System.out.println(name + " пробежал " + distance + " м.");
        }
        else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    public void swim(int distance){
        if(swimmingDistance >= distance){
            System.out.println(name + " проплыл " + distance + " м.");
        }
        else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
