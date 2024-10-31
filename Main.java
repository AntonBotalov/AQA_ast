public class Main {
    public static void main(String[] args) {
        System.out.println("Task_1:");
        printThreeWords();
        System.out.println("Task_2:");
        checkSumSign();
        System.out.println("Task_3:");
        printColor();
        System.out.println("Task_4:");
        compareNumbers();
        System.out.println("Task_5:");
        System.out.println(task5(4, 17));
        System.out.println("Task_6:");
        task6(-3);
        System.out.println("Task_7:");
        System.out.println(task7(-1));
        System.out.println("Task_8:");
        task8("Привет", 3);
        System.out.println("Task_9:");
        System.out.println(task9(2024));
        System.out.println("Task_10:");
        task10();
        System.out.println("\nTask_11:");
        task11();
        System.out.println("\nTask_12:");
        task12();
        System.out.println("\nTask_13:");
        task13();
        System.out.println("Task_14:");
        task14(5, 5);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 2;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean task5(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void task6(int a) {
        System.out.println(a >= 0 ? "Позитивное" : "Негативное");
    }

    public static boolean task7(int a) {
        return a < 0;
    }

    public static void task8(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static boolean task9(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    public static void task10() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void task11() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    public static void task12() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void task13() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                if (j == i || arr[1].length-j-1 == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void task14(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
    }
}
