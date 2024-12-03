package nov30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("dishes are: " + createDishes());

        createDishes().stream().filter((d)->(d.getPrice()<5)).map((d)->d.getName()).collect(Collectors.toList());

        createDishes().stream().filter((d)->(d.getPrice()<5)).map(Dish::getName).collect(Collectors.toList());
        System.out.println(createDishes().stream().map(Dish::getPrice).mapToDouble(Double::valueOf).sum());
    }

    public static List<Dish> createDishes() {
        List<Dish> dish = new ArrayList<Dish>();

        dish.add(new Dish("samosa",24,2.5,Arrays.asList("potato","peas"),DishType.VEG));
        dish.add(new Dish("butter chicken",30,5,Arrays.asList("butter","chicken"),DishType.NON_VEG));

        return dish;

    }
}
