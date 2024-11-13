public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "3", "а"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        try {
            try {
                int result = method(arr);
                System.out.println("Сумма всех ячеек: " + result);
            } catch (MyArraySizeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public static int method(String[][] arr)
            throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива превышен!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива превышен!");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке: " + (i + 1) + "x" + (j + 1));
                }
            }
        }
        return count;
    }

}

