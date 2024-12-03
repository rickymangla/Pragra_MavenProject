package nov30;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class Dish {
    private final String name;
    private final int calories;
    private final double price;
    private final List<String> ingredients;
    private final DishType dishtype;


}
