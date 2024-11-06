public class Main {

    public static void main(String[] args) {
        Person person = new Person("Ivanov Ivan", "Engineer", "asfhasf@mail.ru", "8931231233", 60000, 24);
        System.out.println(person.toString());

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Manager", "petrov@mailbox.com", "893212312", 40000, 35);
        persArray[2] = new Person("Sidorov Egor", "Developer", "sidorov@mailbox.com", "894312312", 50000, 28);
        persArray[3] = new Person("Alexeev Alex", "Designer", "alexeev@mailbox.com", "895312312", 35000, 32);
        persArray[4] = new Person("Nikolaev Nikolai", "Analyst", "nikolaev@mailbox.com", "896312312", 45000, 29);

        System.out.println("Вывод массива:");
        for (int i = 0; i < persArray.length; i++) {
            System.out.println(persArray[i].toString());
        }

        Park.Attraction hauntedHouse = new Park().new Attraction("Haunted House", "12:00 - 22:00", 1000);
        System.out.println(hauntedHouse.toString());
    }
}
