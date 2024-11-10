import java.util.ArrayList;
import java.util.List;

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
            return " Attraction{" +
                    " Название = '" + name + '\'' +
                    ", Часы работы = '" + workingHours + '\'' +
                    ", Стоимость = " + price +
                    '}';
        }
    }

    private List<Attraction> attractions;

    public Park() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workingHours, int price) {
        Attraction attraction = new Attraction(name, workingHours, price);
        attractions.add(attraction);
    }

    public void showAttractions() {
        for (Attraction attraction : attractions) {
            System.out.println(attraction);
        }
    }

}


