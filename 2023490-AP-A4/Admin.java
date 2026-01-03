import java.util.Scanner;

public class Admin extends Main {
    static Scanner intinp = new Scanner(System.in);
    static Scanner strinp = new Scanner(System.in);
    
    public Admin(){
        menu();
    }

    static void menu(){
        System.out.println("\n1.Menu Management");
        System.out.println("2.Order Management");
        System.out.println("3.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
            mmng();
            break;
                                   
            case 2:
            omng();
            break;

            case 3:
            home1();
            break;
        
            default:
            System.out.println("Something went wrong :/ \n");
            menu();
            break;
        }
    }

    static void mmng(){
        System.out.println("\nMenu management");
        System.out.println("1.Add new items");
        System.out.println("2.Update existing items");
        System.out.println("3.View report");
        System.out.println("4.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
            addnewitem();
            break;
            case 2:
                upexitem();
                break;

            case 3:
                vrepo();
                mmng();
                break;
            case 4:
                menu();
                break;
        
            default:
                System.out.println("Something went wrong :/");
                mmng();
                break;
        }

    }

    static void addnewitem(){
        System.out.print("Name: ");
        String item = strinp.nextLine();
        
        System.out.print("Category: ");
        String cat = strinp.nextLine();

        System.out.print("Availability(0/1): ");
        int avl = intinp.nextInt();

        System.out.print("Price: ");
        int amt = intinp.nextInt();

        Food food = new Food();
        food.addnewfood(item,cat,avl,amt);

        System.out.println("Item added succesfully.");
        mmng();

    }

    static void upexitem(){
        System.out.println("\n1.Remove item");
        System.out.println("2.Modify item");
        System.out.println("3.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
            remvitem();
            break;

            case 2:
            modifyitem();
            break;

            case 3:
            mmng();                
            break;
        
            default:
            System.out.println("Something went wrong :/");
                upexitem();
                break;
        }
        
    }

    static void remvitem(){
        Food food = new Food();
        // food.prtallitems();
        System.out.print("Which item you want to remove: ");
        String item = strinp.nextLine();
        food.delitem(item);
        System.out.println("Item deleted successful");
        upexitem();
    }

    static void modifyitem(){
        Food food = new Food();
        // food.prtallitems();
        System.out.print("Enter item which you want to update: ");
        String item = strinp.nextLine();

        System.out.print(" Update Availability(0/1): ");
        int avl = intinp.nextInt();

        System.out.print("Update Price: ");
        int amt = intinp.nextInt();

        food.chgstat(item,avl,amt);
        System.out.println("Upadates make successfully");
        upexitem();
    }




    static void omng(){
        System.out.println("\n1.View pending orders");
        System.out.println("2.Update order status");
        System.out.println("3.Process refunds");
        System.out.println("4.Back");
        System.out.print("Enter your choice: ");
        int a = intinp.nextInt();
        switch (a) {
            case 1:
            vpenord();
            // omng();
            break;

            case 2:
            upordstat();
            omng();
            break;
            case 3:
            prcrefund();
            omng();
                break;
            case 4:
               menu();
               break;
        
            default:
            System.out.println("Something went wrong :/");
            omng();
            break;
        }
    }

    static void vpenord(){
        Food food = new Food();
        food.seeorder();
    }
    static void upordstat(){
        System.out.print("Enter the new state: ");
        int s = intinp.nextInt();
        Food food = new Food();
        food.chgstate(s);
        
    }
    static void prcrefund(){
        System.out.println("Cancel orders are refunded!!");
    }
    

    static void vrepo(){
        Food food = new Food();
        food.total();
    }
}
