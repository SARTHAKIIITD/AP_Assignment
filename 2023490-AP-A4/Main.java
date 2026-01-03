    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Scanner;

    public class Main {
        static Scanner intinp = new Scanner(System.in);
        static Scanner strinp = new Scanner(System.in);
        public static void main(String[] args) {
            Food food = new Food();
            food.addnewfood("maggi","snacks",1,50);
            food.Awreview("maggi", "spicy but good");

            food.addnewfood("paneer","main course",1,40);
            food.Awreview("paneer", "very tasty");

            food.addnewfood("tea", "beverage", 1, 20);
            food.Awreview("tea", "good in winters");

            food.addnewfood("pepsi", "beverage", 1, 30);
            food.Awreview("pepsi", "very good energy drink!");

            home1();
        }

        static void home1(){
            System.out.println("\nWelcome to BYTE ME!");
            System.out.println("You are:");
            System.out.println("1.Admin");
            System.out.println("2.Regular Customer");
            System.out.println("3.New Customer");
            System.out.println("4.exit");

            System.out.print("Enter your choice: ");
            int a = intinp.nextInt();

            switch (a) {
                case 1:
                abutton();
                    break;
                case 2:
                cbutton();
                break;

                case 3:
                Nbutton();
                break;

                case 4:
                System.out.println("See you soon!");;
                break;

                default:
                System.out.println("Something went wrong :/ ");
                home();
                    break;
            }
        }
        static void home(){
            System.out.println("\nWelcome to BYTE ME!");
            System.out.println("You are:");
            System.out.println("1.Admin");
            System.out.println("2.Regular Customer");
            System.out.print("Enter your choice: ");
            int a = intinp.nextInt();

            switch (a) {
                case 1:
                abutton();
                    break;
                case 2:
                cbutton();
                break;
                default:
                System.out.println("Something went wrong :/ ");
                home();
                break;
            }
        }


        static void abutton(){
            System.out.println("\nYou got some work to do!!");
             new Admin();
        }

        static void cbutton(){
            System.out.print("Enter your username:");
            String user =strinp.nextLine();
            boolean loginSuccessful = checkLogin(user,1);

            if (loginSuccessful){
    //            System.out.println("Login successful.");
                new Customer(user);
            } else{
    //            System.out.println("incorrect user name.");
                home1();
            }

        }
        public static boolean Nbutton() {
            System.out.print("Enter new user name: ");
            String newUsername  = strinp.nextLine();
            File file = new File("users.txt");

            try {
                if (!file.exists()) {
                    file.createNewFile();
                }

                if (checkLogin(newUsername,0)) {
                    System.out.println("Sign-in failed. Username already exists.\n");
                    home1();
                    return false;
                }

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                    bw.write(newUsername);
                    bw.newLine();
                }
                System.out.println("Sign-in successful.\n");

                File userFile = new File(newUsername + ".txt");
                if (!userFile.exists()) {
                    userFile.createNewFile();
                    // System.out.println("User file created: " + newUsername + ".txt");
                } else {
                    System.out.println("User file already exists: " + newUsername + ".txt");
                }

                home1();
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }


        public static boolean checkLogin(String username, int s) {
            File file = new File("users.txt");

            if (!file.exists()) {
                System.out.println("Error: users.txt file not found.");
                return false;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = br.readLine()) != null) {
                    if (line.trim().equals(username)) {
                        if(s == 1) {
                            System.out.println("Login successful.");
                        }
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(s == 1) {
                System.out.println("Login failed.");
            }
            return false;
        }



    }
