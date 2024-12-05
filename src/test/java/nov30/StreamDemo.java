package nov30;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("dishes are: " + createDishes());

        createDishes().stream().filter((d) -> (d.getPrice() < 5)).map((d) -> d.getName()).collect(Collectors.toList());

        createDishes().stream().filter((d) -> (d.getPrice() < 5)).map(Dish::getName).collect(Collectors.toList());

        List<String> reqDishes = createDishes().stream().filter(Dish::dishPrice).map(Dish::getName).collect(Collectors.toList());

        reqDishes.forEach(System.out::println);

        Optional<Double> totalPrice = createDishes().stream().map((d)->d.getPrice()).reduce((price1, price2) -> {
            return price1 + price2;});
        System.out.println("total price is: " + totalPrice.get());

        List<Dish> vegDishes = createDishes().stream().filter((g) -> g.getDishtype() == DishType.VEG).collect(Collectors.toList());

        vegDishes.forEach(d-> System.out.println(d.getName()));

        //System.out.println(createDishes().stream().map(Dish::getPrice).mapToDouble(Double::valueOf).sum());

        List<String> shoppingList = createDishes().stream().flatMap((d) -> d.getIngredients().stream()).distinct().collect(Collectors.toList());

        System.out.println(shoppingList);

        List<Dish> sortedCalories = createDishes().stream().sorted((d1,d2)-> d1.getCalories()- d2.getCalories()).collect(Collectors.toList());

        System.out.println(sortedCalories);

        Optional<Dish> anyDish = createDishes().stream().findAny();
        System.out.println("anyDish.get() = " + anyDish.get());

        Optional<String> anyDishName = createDishes().stream().filter((d) -> d.getDishtype() == DishType.VEG).map((d) -> d.getName()).findAny();

        System.out.println("anyDishName.get() = " + anyDishName.get());

        boolean matchFound = createDishes().stream().map(Dish::getName).anyMatch((d)->d.equals("Samosa"));
        System.out.println("matchFound = " + matchFound);

        Optional<Double> minPrice = createDishes().stream().map((d)->d.getPrice()).min((d1, d2) -> (int) (d1 - d2));

        System.out.println("minPrice.get() = " + minPrice.get());

        Optional<Dish> max = createDishes().stream().max((dish1, dish2) -> (int) (dish1.getPrice() - dish2.getPrice()));

        System.out.println("most expensive dish name is: " + max.get().getName() + "\n" + "price is: " + max.get().getPrice());

    }

    public static List<Dish> createDishes() {
        List<Dish> dish = new ArrayList<Dish>();

        dish.add(new Dish("samosa", 24, 2.5, Arrays.asList("potato", "peas"), DishType.VEG));
        dish.add(new Dish("butter chicken", 30, 5, Arrays.asList("butter", "chicken"), DishType.NON_VEG));
        dish.add(new Dish("sandwich", 50, 8, Arrays.asList("lettuce", "cheese", "bun", "tomato sauce"), DishType.VEG));
        dish.add(new Dish("sandwich", 50, 8, Arrays.asList("lettuce", "cheese", "bun", "tomato sauce"), DishType.VEG));
        return dish;

    }
}
