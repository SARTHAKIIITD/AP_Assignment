import java.util.Scanner;

public class Customer extends Main {
    public String user;
    static Scanner intinp = new Scanner(System.in);
    static Scanner strinp = new Scanner(System.in);
    
    public Customer(String user){
        this.user = user;
        menu();
    } public Customer(){
    }

    public void menu(){
        System.out.println("\n1.Browse Menu");
        System.out.println("2.Cart Operations");
        System.out.println("3.Order Tracking");
        System.out.println("4.Reviews");
        System.out.println("5.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
            dismenu();
            break;
            
            case 2:
            cartop();
            break;

            case 3:
            ordtrack();
            break;

            case 4:
            vrev();
            menu();
            break;

            case 5:
            home1();
            break;
        
            default:
            System.out.println("Something went wrong :/ \n");
            menu();
            break;
        }
    }

    public void vrev(){
        System.out.println("1.Write a review");
        System.out.println("2.See a review");
        System.out.println("3.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
                gfeed();
                vrev();
                break;
            case 2:
                sfeed();
                vrev();
                break;
            case 3:
                menu();
                break;
        
            default:
            System.out.println("Something went wrong :/ \n");
            vrev();
                break;
        }
    }

    static void gfeed(){
        Food food = new Food();
        
        System.out.print("\nwhich item review you want to give: ");
        String item = strinp.nextLine();
        System.out.print("Write review: ");
        String rev = strinp.nextLine();
        food.wreview(item, rev);

    }

    static void sfeed(){
        System.out.print("Which item review you want to see: ");
        String item = strinp.nextLine();
        Food food = new Food();
        food.sreview(item);
    }

    public void dismenu(){
        System.out.println("\nMenu options");
        System.out.println("1.View all items");
        System.out.println("2.Search functionality");
        System.out.println("3.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();

        switch (a) {
            case 1:
                viewitems();
                // dismenu();
                break;
            
            case 2:
            srchfunc();
            break;
            case 3:
            menu();
            break;

            default:
            System.out.println("Something went wrong :/ ");
            dismenu();
                break;
        }
    }

    public void viewitems(){
        Food food = new Food();
        food.prtallitems(user);
    }

    public void srchfunc(){
        System.out.println("\nSearch functionality");
        System.out.println("1.Filter by category");
        System.out.println("2.Sort by price");
        System.out.println("3.Back");
        System.out.print("Enter your choice:");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
            fltcar();
            // srchfunc();
                break;
            case 2:
                srtpr();
                // srchfunc();
                break;
            case 3:
                dismenu();
                break;
        
            default:
            System.out.println("Something went wrong :/ ");
            srchfunc();
                break;
        }
    }

    public void fltcar(){
        Food food = new Food();
        food.catsort(user);
        
    }
    public void srtpr(){
        Food food = new Food();
        food.pricesort(user);
    }


    public void cartop(){
        System.out.println("\n1.Add items");
        System.out.println("2.Modify quantities");
        System.out.println("3.Remove items");
        System.out.println("4.View total");
        System.out.println("5.Checkout process");
        System.out.println("6.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
            additem();
            cartop();
             break;

            case 2: 
            modq();
            cartop();
            break;

            case 3:
            remvitem();
            cartop();
            break;

            case 4:
            viewtot();
            cartop();

            case 5:
            checkout();
            cartop();

            case 6:
            menu();
            break;

            default:
            System.out.println("Something went wrong :/ ");
            cartop();
                break;
        }

    }

    public void additem(){
        // Food food = new Food();
        // food.prtallitems();
        System.out.print("Enter item name: ");
        String item = strinp.nextLine();
        System.out.print("Enter quatity: ");
        int q = intinp.nextInt();
        System.out.print("Special Request: ");
        String req = strinp.nextLine();

        Food order = new Food();
        order.getorder(item, q, req,0,user);
//        System.out.println(order.getorder(item, q, req,0,user));



    }

    public void modq(){
        System.out.print("Which item quatity you want to change: ");
        String item = strinp.nextLine();
        System.out.print("Enter new Quatity: ");
        int q = intinp.nextInt();
        Food food = new Food();
        food.modifyquant(item, q,0,user);
        System.out.println("quatity changed successfully!");
    
    }

    public void remvitem(){
        System.out.print("Enter item name you want to remove: ");
        String item = strinp.nextLine();
        Food food = new Food();
        food.remord(item,0,user);
        System.out.println("Item removed succssfully!");
    }

    static void viewtot(){
        Food food= new Food();
        food.seeprice(0);
    }

    static void checkout(){
        Food food = new Food();
        food.mvout(0);
    }




    
    public void ordtrack(){
        System.out.println("\n1.View order status");
        System.out.println("2.Cancel order");
        System.out.println("3.Order history");
        System.out.println("4.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
                vordstat();
                ordtrack();
                break;
            case 2:
                canord();
                ordtrack();
                break;
            case 3:
                ordhis();
                ordtrack();
                break;
        
            case 4:
            menu();
            break;

            default:
            System.out.println("Something went wrong :/ ");
            ordtrack();
                break;
        }

    }

    static void vordstat(){
        Food food = new Food();
        food.ordstatus(0);

    }

    public void canord(){
        Food food = new Food();
        System.out.print("Enter item name you want to cancel: ");
        String item = strinp.nextLine();
        food.remord(item,0,user);
        System.out.println("item has been cancelled.");
        
    }

    public void ordhis(){
        Food food = new Food();
        food.seehis(0,user);
    }
   
}
