import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class AvlTest extends Food {
    Food food;

    // Create separate lists for testing to avoid modifying the ones in Food
    private static ArrayList<String> items = new ArrayList<>();
    private static ArrayList<Integer> available = new ArrayList<>();
     private static ArrayList<String> orders= new ArrayList<>();
      private static ArrayList<String> request= new ArrayList<>();
      private static ArrayList<Integer> quantity= new ArrayList<>();
      private static ArrayList<Integer> oby= new ArrayList<>();
      private static ArrayList<Integer> status= new ArrayList<>();
      private static ArrayList<String> Username= new ArrayList<>();
     private static  ArrayList<Integer> numoford= new ArrayList<>();
     private static  ArrayList<Integer> price= new ArrayList<>();
     private static  int ctotal;
     private static  int totalorders;


    @BeforeEach
    public void setup() {
        // Initialize the test-specific lists
        items.clear();       // Clear the lists before each test to avoid leftover data
        available.clear();   // Clear the lists before each test
        orders.clear();
        request.clear();
        quantity.clear();
        oby.clear();
        status.clear();
        Username.clear();
        numoford.clear();
        price.clear();

        // Populate the test lists with data
        items.add("apple");  // Add an item to test
        available.add(0);    // Set the item as unavailable (0 means unavailable)
        numoford.add(0);
        price.add(15);

        items.add("mango");
        available.add(1);
        numoford.add(0);
        price.add(12);

        // Optionally, you can also modify the static fields in Food, if needed
        Food.items = items;     // Point Food's static items to the test items
        Food.available = available; // Point Food's static available to the test available
        Food.orders = orders;
        Food.request = request;
        Food.quantity = quantity;
        Food.oby = oby;
        Food.status = status;
        Food.Username = Username;
        Food.numoford = numoford;
        Food.price = price;



        food = new Food();
    }

    @Test
    public void testItemNotAvailable() {
        int result = food.getorder("apple", 2, "request1", 0, "testUser");
        assertEquals(0, result);
    }
    @Test
    public void testItemNotPresent() {
        int result = food.getorder("Itemnotpresent", 2, "request1", 0, "testUser");
        assertEquals(-1, result);
    }
    @Test
    public void testItemAvailable(){
        int result = food.getorder("mango", 2, "request1", 0, "testUser");
        assertEquals(1, result);
    }
}



