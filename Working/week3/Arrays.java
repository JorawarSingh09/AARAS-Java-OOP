import java.util.ArrayList;

public class Arrays {
    public static void main(String[] args) {
        /*
         * Index Value
         * 0 Banana
         * 1 Pineapple
         * 2 Apple
         * 3 Potato
         */

        // DECLARE VARIABLE[] NAME
        String[] food = { "banana", "pineapple", "apple", "potato" };

        // System.out.println(food);
        // [Ljava.lang.String;@372f7a8d << JVM

        System.out.println(food[0]);
        System.out.println(food[1]);
        System.out.println(food[2]);
        System.out.println(food[3]);

        System.out.println(food.length);

        ArrayList<String> ShoppingList = new ArrayList<String>();
        ShoppingList.add("Milk");
        ShoppingList.add(food[1]);

        System.out.println(ShoppingList);

    }
}
