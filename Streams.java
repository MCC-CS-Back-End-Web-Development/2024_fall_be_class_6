import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        car1.setYear(2020);
        car1.setMake("Ford");
        car1.setModel("Focus");

        cars.add(car1);
        cars.add(new Car(1990, "Dodge", "Challenger"));
        cars.add(new Car(2019, "Dodge", "1500"));
        cars.add(new Car(2015, "Subaru", "Outback"));
        cars.add(new Car(1995, "Audi", "G150"));

        List<Car> newCarsList = cars.stream().filter(car -> car.make.equalsIgnoreCase("Dodge")).toList();
        newCarsList.forEach(System.out::println);

        List<String> stringCarMakeAndModel = cars.stream()
                .filter(car -> car.make.equalsIgnoreCase("Dodge"))
                .map(car -> car.getMake() + " " + car.getModel())
                .toList();
        stringCarMakeAndModel.forEach(System.out::println);

        List<MyCar> myCars = cars.stream()
                .map(car -> new MyCar(car.getYear().toString(), car.getMake()))
                .toList();
        myCars.forEach(System.out::println);
//        cars.stream().filter(car -> car.getYear() > 2019 || car.getYear() < 1994).toList().forEach(car -> System.out.println(car.getModel()));

//        cars.sort(Comparator.comparing(Car::getYear).reversed().thenComparing(Car::getMake));
//        cars.forEach(System.out::println);


//        List<String> names = new ArrayList<>(Arrays.asList("Evan", "Zach", "Frank", "Travis", "Kim", "Ev"));

//        names.forEach(name -> {
//            if(name.length() <=4){
//                System.out.println("You have a short name, " + name);
//            } else {
//                System.out.println("Hello " + name);
//            }
//        });
//
//        names.stream().filter(name -> name.startsWith("E") && name.length() > 2 || name.contains("a")).forEach(System.out::println);

    }

    private static class MyCar {
        public MyCar(String year, String model) {
            this.year = year;
            this.model = model;
        }

        @Override
        public String toString() {
            return "MyCar{" +
                    "year=" + year +
                    ", model='" + model + '\'' +
                    '}';
        }

        private String year;
        private String model;

        public String getYear() {
            return year;
        }

        public MyCar setYear(String year) {
            this.year = year;
            return this;
        }

        public String getModel() {
            return model;
        }

        public MyCar setModel(String model) {
            this.model = model;
            return this;
        }
    }

    private static class Car {
        public Car(Integer year, String make, String model) {
            this.year = year;
            this.make = make;
            this.model = model;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "year=" + year +
                    ", make='" + make + '\'' +
                    ", model='" + model + '\'' +
                    '}';
        }

        public Car(){}

        private Integer year;
        private String make;
        private String model;

        public Integer getYear() {
            return year;
        }

        public Car setYear(Integer year) {
            this.year = year;
            return this;
        }

        public String getMake() {
            return make;
        }

        public Car setMake(String make) {
            this.make = make;
            return this;
        }

        public String getModel() {
            return model;
        }

        public Car setModel(String model) {
            this.model = model;
            return this;
        }
    }
}
