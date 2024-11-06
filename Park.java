public class Park {
    public class Attraction {
        private String name;
        private String workingHours;
        private int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    " Название = '" + name + '\'' +
                    ", Часы работы = '" + workingHours + '\'' +
                    ", Стоимость =" + price +
                    '}';
        }
    }
}
