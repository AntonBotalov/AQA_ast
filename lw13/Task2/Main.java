package Task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory pd = new PhoneDirectory();
        pd.add("Иванов","123456");
        pd.add("Иванов","234567");
        pd.add("Петров","345678");
        pd.add("Сидоров","456789");
        pd.add("Иванов","987654");

        System.out.println("Телефоны Иванова: "+pd.get("Иванов"));
        System.out.println("Телефоны Петрова: "+pd.get("Петров"));
        System.out.println("Телефоны Сидорова: "+pd.get("Сидоров"));
        System.out.println("Телефоны несуществующей фамилии: "+pd.get("Серый"));
    }
}

