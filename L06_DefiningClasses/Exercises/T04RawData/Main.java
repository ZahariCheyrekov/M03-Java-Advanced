package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T04RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int num = Integer.parseInt(bf.readLine());
        while (num-- > 0) {
            String[] inline = bf.readLine().split("\\s+");
            String model = inline[0];
            int engineSpeed = Integer.parseInt(inline[1]);
            int hp = Integer.parseInt(inline[2]);
            int cargoW = Integer.parseInt(inline[3]);
            String cargoType = inline[4];

            ArrayList<Tyre> tyres = new ArrayList<>();
            Tyre tyre = new Tyre(Double.parseDouble(inline[5]), Integer.parseInt(inline[6]),
                    Double.parseDouble(inline[7]), Integer.parseInt(inline[8]),
                    Double.parseDouble(inline[9]), Integer.parseInt(inline[10]),
                    Double.parseDouble(inline[11]), Integer.parseInt(inline[12]));
            tyres.add(tyre);


            Car car = new Car(model, engineSpeed, hp, cargoW, cargoType, tyres);
            cars.add(car);
        }

        String type = bf.readLine();
        if (type.equals("fragile")) {
            List<String> model = new ArrayList<>();
            for (Car car : cars) {

                if (car.getTyres().get(0).getPressure1() < 1 || car.getTyres().get(0).getPressure2() < 1
                        || car.getTyres().get(0).getPressure3() < 1 || car.getTyres().get(0).getPressure4() < 1) {
                    model.add(car.getModel());
                }

            }
            model.forEach(System.out::println);
        } else {
            cars.forEach(e -> {
                if (e.getHp() >= 250) {
                    System.out.printf("%s%n", e.getModel());
                }
            });
        }
    }
}