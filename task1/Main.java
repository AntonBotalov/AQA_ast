package task1;

public class Main {
    public static void main(String[] args) {

        // создаем собак и котов и отправляет их на пробежку и на плаванье
        Dog dog1 = new Dog("Рекс");
        Dog dog2 = new Dog("Боб");
        Dog dog3 = new Dog("Собак");
        Cat cat1 = new Cat("Хлеб");
        Cat cat2 = new Cat("Барсик");

        dog2.run(100);
        dog3.run(501);
        dog1.swim(5);
        dog2.swim(11);

        cat1.run(150);
        cat2.swim(2);

        System.out.println("\nВсего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего кошек: " + Cat.getCatCount());

        // Создаем миску с едой и кормим котов
        Bowl bowl = new Bowl(20);
        Cat[] cats = {cat1, cat2};
        System.out.println("\n" + bowl);

        for (Cat cat : cats){
            cat.eat(bowl);
        }
        System.out.println("\n" + bowl);

        // проверка сытости
        for (Cat cat : cats){
            System.out.println(cat.name + cat.getIsFull());
        }

        // добавили еды в миску
        bowl.addFood(20);
        System.out.println("\n" + bowl);

    }
}
