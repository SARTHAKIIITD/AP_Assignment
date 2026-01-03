import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Food extends Main {
     static ArrayList<String> items = new ArrayList<String>();
    private static ArrayList<String> category = new ArrayList<String>();
     static ArrayList<Integer> available = new ArrayList<Integer>();
     static ArrayList<Integer> price = new ArrayList<Integer>();
    
     static ArrayList<Integer> numoford = new ArrayList<Integer>();
    
    private static  ArrayList<ArrayList<String>> reviews = new ArrayList<>();

     static ArrayList<String> orders = new ArrayList<String>();
     static ArrayList<Integer> quantity = new ArrayList<Integer>();
     static ArrayList<String> request = new ArrayList<String>();
     static ArrayList<Integer> oby = new ArrayList<Integer>();
     static ArrayList<Integer> status = new ArrayList<Integer>(); // 2->processing
     static ArrayList<String> Username = new ArrayList<String>();
    
    private static ArrayList<String> Corders = new ArrayList<String>();
    private static ArrayList<Integer> Cquantity = new ArrayList<Integer>();
    private static ArrayList<String> Crequest = new ArrayList<String>();
    private static ArrayList<Integer> Coby = new ArrayList<Integer>();
    private static ArrayList<Integer> Cstatus = new ArrayList<Integer>(); // 1-> completed
    private static ArrayList<String> CUsername = new ArrayList<String>(); 

    private static ArrayList<String> Dorders = new ArrayList<String>();
    private static ArrayList<Integer> Dquantity = new ArrayList<Integer>();
    private static ArrayList<String> Drequest = new ArrayList<String>();
    private static ArrayList<Integer> Doby = new ArrayList<Integer>();
    private static ArrayList<Integer> Dstatus = new ArrayList<Integer>(); // 0-> denied 
    private static ArrayList<String> DUsername = new ArrayList<String>(); 
    
    // private static ArrayList<String> Chistory = new ArrayList<String>();
    // private static ArrayList<String> hisUsername = new ArrayList<String>(); 
    private static ArrayList<String> Vhistory = new ArrayList<String>();

    private static int ctotal = 0;
    private static int vtotal = 0; 
    private static int totalorders = 0;

    // public String user; 

    public Food(){
    }

    // public Food(String user){
    //     this.user = user;
    // }
// ------------------------------------review------------------------------

public void wreview(String item, String rev){
    int idx = items.indexOf(item);
    ArrayList<String> arr = reviews.get(idx);
    arr.add(rev);
    reviews.set(idx, arr);
    System.out.println("Review added succesfully!");
}
public void Awreview(String item, String rev){
    int idx = items.indexOf(item);
    ArrayList<String> arr = reviews.get(idx);
    arr.add(rev);
    reviews.set(idx, arr);
    // System.out.println("Review added succesfully!");
}

public void sreview(String item){
    int idx = items.indexOf(item);
    ArrayList<String> arr = reviews.get(idx);
    System.out.println();
    for(String e : arr){
        System.out.println(e);
    }
}
// -------------------------------------menu---------------------------------------------------
    public void addnewfood(String food,String cat, int avl, int amt){
        items.add(food);
        category.add(cat);
        available.add(avl);
        price.add(amt);
        ArrayList<String> arr = new ArrayList<String>();
        reviews.add(arr);
        numoford.add(0);

    }

    public void prtallitems(String user){
        // for(int i = 0; i<items.size(); i++){
        //     System.out.println(i+1+"."+items.get(i));
        //     System.out.println("category: "+category.get(i));
        //     if(available.get(i) == 1){
        //         System.out.println("Availability: Yes");
        //     }
        //     else{
        //         System.out.println("Availability: No");
        //     }
        //     System.out.println("Price: $"+price.get(i)+"\n");

        // }
        String[] columnNames = { "Name", "category", "Availability", "Price"};
        Object[][] data = new Object[items.size()][4];

        for (int i = 0; i < items.size(); i++) {
            data[i][0] = items.get(i);      
            data[i][1] = category.get(i);    
            data[i][2] = available.get(i) == 1 ? "Yes" : "No";
            // data[i][2] = available.get(i);     
            data[i][3] = price.get(i);   
        }

         DefaultTableModel model = new DefaultTableModel(data, columnNames);
         JTable table = new JTable(model);
         JScrollPane scrollPane = new JScrollPane(table);

         JButton backButton = new JButton("Back");

         backButton.addActionListener(e -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
            currentFrame.dispose();
            new Customer(user);
            // home();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(500, 500);
        frame.add(scrollPane);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
    }

    public void delitem(String item){
        int idx = items.indexOf(item);
        items.remove(idx);
        category.remove(idx);
        available.remove(idx);
        price.remove(idx);
        numoford.remove(idx);
        reviews.remove(idx);

        if(status.size() > 0){
            for(int i = 0; i< status.size(); i++){
                String a = orders.get(i);
                int b =quantity.get(i);
                String req = request.get(i);
                int t = oby.get(i);

                if(a.equals(item)){
                Dorders.add(a);
                Dquantity.add(b);
                Drequest.add(req);
                Doby.add(t);
                Dstatus.add(0);
                
                orders.remove(i);
                quantity.remove(i);
                request.remove(i);
                oby.remove(i);
                }
            }
        }
    }

    public void chgstat(String item, int avl, int amt){
        int idx = items.indexOf(item);
        available.set(idx, avl);
        price.set(idx, amt);
    }

    public void pricesort(String user) {
        JButton backButton = new JButton("Back");


 backButton.addActionListener(e -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
            currentFrame.dispose();
            new Customer(user);
        });

 JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        JFrame frame = new JFrame("Sorted Items by Price");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);  
        JScrollPane scrollPane = new JScrollPane(textArea);  
        
frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < price.size(); i++) {
            arr.add(i);
        }

        arr.sort((a, b) -> Integer.compare(price.get(a), price.get(b)));
        Set<String> showitems = new HashSet<>();
        StringBuilder output = new StringBuilder("\nSorting by price:\n\n");

        for (int idx : arr) {
            String item = items.get(idx);
            if (!showitems.contains(item)) {
                showitems.add(item);
                int itemPrice = price.get(idx);
                output.append(item).append("\n");
                output.append("Price: ").append(itemPrice).append("\n");
                output.append("Category: ").append(category.get(idx)).append("\n");

                if (available.get(idx) == 1) {
                    output.append("Availability: Yes\n\n");
                } else {
                    output.append("Availability: No\n\n");
                }
            }
        }

        textArea.setText(output.toString());
        frame.setVisible(true);
    }

    // public void pricesort() {
    //     System.out.println("\nSorting by price:");
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     for (int i = 0; i < price.size(); i++) {
    //         arr.add(i);
    //     }
    //     arr.sort((a, b) -> Integer.compare(price.get(a), price.get(b)));
    //     Set<String> showitems = new HashSet<>();
    
    //     for (int idx : arr) {
    //         String item = items.get(idx);
    //         if (!showitems.contains(item)) {
    //             showitems.add(item);
    //             int itemPrice = price.get(idx);
    //             System.out.println(item);
    //             System.out.println("Price: " + itemPrice);
    //             System.out.println("Category: " + category.get(idx));
    //             if(available.get(idx) == 1){
    //                 System.out.println("Availability: Yes");
    //             }
    //             else{
    //                 System.out.println("Availability: No");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
    
    public void catsort(String user) {
        JButton backButton = new JButton("Back");

 backButton.addActionListener(e -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
            currentFrame.dispose();
            new Customer(user);
        });

 JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        JFrame frame = new JFrame("Sorted Items by Category");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);  

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);  
        JScrollPane scrollPane = new JScrollPane(textArea);  
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        ArrayList<String> arr = new ArrayList<String>();

        StringBuilder output = new StringBuilder("Sorting by category:\n");

        for (int i = 0; i < items.size(); i++) {
            String categoryName = category.get(i);
            if (arr.contains(categoryName)) {
                continue;  
            } else {
                output.append(categoryName).append(":\n");

                for (int j = 0; j < category.size(); j++) {
                    String cat = category.get(j);
                    if (categoryName.equals(cat)) {
                        output.append(items.get(j)).append("\n");
                        output.append("Price: ").append(price.get(j)).append("\n");

                        if (available.get(j) == 1) {
                            output.append("Availability: Yes\n\n");
                        } else {
                            output.append("Availability: No\n\n");
                        }
                    }
                }
                arr.add(categoryName);  
            }
        }

        textArea.setText(output.toString());

        frame.setVisible(true);
    }
    // public void catsort(){
    //     System.out.println("\nsorting by category:");
    //     ArrayList<String> arr = new ArrayList<String>();
    //     for(int i = 0; i< items.size();i++){
    //         String a = category.get(i);
    //         if (arr.contains(a)){
    //             continue;
    //         }
    //         else{
    //         System.out.println(a+":");
    //         for(int j = 0 ; j< category.size();j++){
    //             String cat = category.get(j);
    //             if(a.equals(cat)){
    //                 System.out.println(items.get(j));
    //                 System.out.println("Price: "+price.get(j));
    //                 if(available.get(j) == 1){
    //                     System.out.println("Availability: Yes\n");
    //                 }
    //                 else{
    //                     System.out.println("Availability: No\n");
    //                 }
    //             }
    //         }
    //         arr.add(a);
    //     }
    //         System.out.println();
    //     }



    // }


    // --------------------------------order handling-------------------------------------------

    public int getorder(String item, int q, String req,int t,String user){
//        System.out.println(items);
        if(items.contains(item)){
            int aa = items.indexOf(item);
            int bb = available.get(aa);
            if(bb == 0){
                System.out.println("Item not available!");
                return 0;
            }
            else if(t==0){
                orders.add(item);
                request.add(req);
                quantity.add(q);
                oby.add(t);
                status.add(2);
                Username.add(user);
                int idx = items.indexOf(item);

                int ordn = numoford.get(idx);
                ordn++;
                numoford.set(idx, ordn);
            
                int p = price.get(idx);
                ctotal += q*p;
                
                totalorders++;
                System.out.println("Item added successfully.");
                return 1;
            }
            else{
                if(orders.size() == 0){
                    orders.add(item);
                   request.add(req);
                   quantity.add(q);
                   oby.add(t);
                   status.add(2);

                   int idx = items.indexOf(item);

                   int ordn = numoford.get(idx);
                ordn++;
                numoford.set(idx, ordn);

                int p = price.get(idx);
                vtotal += q*p;
                
                totalorders++;
                return 1;
                }
                else{
                    orders.add(0, item);
                    request.add(0, req);
                    quantity.add(0, q);
                    oby.add(0, t);
                    status.add(0,2);

                int idx = items.indexOf(item);

                int ordn = numoford.get(idx);
                ordn++;
                numoford.set(idx, ordn);

                int p = price.get(idx);
                vtotal += q*p;
                
                totalorders++;
                    System.out.println("Item added successfully.");
                    return 1;
                }
            }

        }
        else{
            System.out.println("Item not found");
            return -1;
        }
    }

    public void seeorder(){    // for admin
        if(orders.size() == 0){
            System.out.println("WOW! There are no orders left.");
            home1();
        }
        // else{
        // for(int i = 0; i< orders.size();i++){

        //     System.out.println("\n"+orders.get(i));
        //     System.out.println("Quantity: "+quantity.get(i));
        //     System.out.println("Request: "+request.get(i));
        //     System.out.println("Status: processing");
            
        // }
        // }
        else{
        String[] columnNames = { "Name", "Quantity", "Request", "Status"};
        Object[][] data = new Object[items.size()][4];

        for (int i = 0; i < orders.size(); i++) {
            data[i][0] = orders.get(i);      
            data[i][1] = quantity.get(i);    
            data[i][2] = request.get(i) ;
            // data[i][2] = available.get(i);     
            data[i][3] = "Processing";   
        }

         DefaultTableModel model = new DefaultTableModel(data, columnNames);
         JTable table = new JTable(model);
         JScrollPane scrollPane = new JScrollPane(table);

         JButton backButton = new JButton("Back");

         backButton.addActionListener(e -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
            currentFrame.dispose();

            new Admin();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        JFrame frame = new JFrame("Pending orders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(500, 500);
        frame.add(scrollPane);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
    }
    }

public void modifyquant(String item , int q,int t,String user){
    for(int i = 0; i<orders.size(); i++){
        String a = orders.get(i);
        int b = oby.get(i);

        int idx = items.indexOf(item);
        int p = price.get(idx);

        if(a.equals(item) && b==t && user.equals(Username.get(i))){
            int pq = quantity.get(i);
            quantity.set(i, q);

            if(t == 0){
                ctotal = ctotal- pq*p;
                ctotal += q*p;
            }
            else{
                vtotal = vtotal-pq*p;
                vtotal += q*p;
            }
        }
    }
}
   
public void remord(String item,int t, String user){    // for customer
    for(int i = 0; i<orders.size();i++){
        String a = orders.get(i);
        int b = oby.get(i);

        int idx = items.indexOf(item);

        
        if(a.equals(item) && b==t && user.equals(Username.get(i))){
            int q = quantity.get(i);
            int p = price.get(idx);

            int ordn = numoford.get(idx);
            ordn--;
            numoford.set(idx, ordn);

            if(t ==0){
                ctotal = ctotal-p*q;

            }
            else{
                vtotal = vtotal-p*q;

            }

            orders.remove(i);
            quantity.remove(i);
            request.remove(i);
            oby.remove(i);
            Username.remove(i);
            
            totalorders--;

            
        }
        else{
            System.out.println("Item is completed or denied!");
        }
    }
}

public void seeprice(int t){
    if (t==0){
        System.out.println("Total: $"+ctotal);
    }
    else{
        System.out.println("Total: $"+vtotal);
    }
    
}

public void chgstate(int s){

    String a = orders.get(0);
    int b =quantity.get(0);
    String req = request.get(0);
    int t = oby.get(0);
    String user = Username.get(0);
    // System.out.println(user);

    if(s == 0){
        Dorders.add(a);
         Dquantity.add(b);  
        Drequest.add(req);
                Doby.add(t);
                Dstatus.add(0);
                DUsername.add(user);
    }
    else{
        Corders.add(a);
         Cquantity.add(b);
        Crequest.add(req);
        Coby.add(t);
        Cstatus.add(0);
        CUsername.add(user);
        if(t == 0 ){
            File userFile = new File(user + ".txt");
            if (!userFile.exists()) {
                System.out.println("Error: User file for '" + user + "' not found.");

            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile, true))){

            // bw.write(a);
            bw.write("item: "+a + " Quantity: "+ b+ " Request: "+ req);
            bw.newLine();  // Move to the next line after adding the item
            // System.out.println("Item added to " + user + "'s file.");
            // return true;
            bw.flush(); 
        } catch (IOException e) {
            e.printStackTrace();
            // return false;
        }
            
        }
        else if(t==1){
            Vhistory.add(a);
        }
    }                
                orders.remove(0);
                quantity.remove(0);
                request.remove(0);
                oby.remove(0);
                Username.remove(0);
                System.out.println("status changed successfully!");
    
}


public void ordstatus(int t){   // for user
    if(t == 0){
        if(Corders.size()>0){
        for(int i = 0; i<Corders.size(); i++){
            if(Coby.get(i) == 0){
                System.out.println(Corders.get(i));
                System.out.println("Status: Completed\n");
            }
        }
    }
        if(orders.size()> 0) {
        for(int j = 0; j<orders.size(); j++){
            if(oby.get(j) == 0){
                System.out.println(orders.get(j));
                System.out.println("Status: Processing\n");
            }
        }
    }

        if(Dorders.size()>0){
        for(int k = 0; k<Dorders.size(); k++){
            if(Doby.get(k) == 0){
                System.out.println(Dorders.get(k));
                System.out.println("Status: Denied\n");
            }
        }
    }
    }
    else if(t == 1){
        if(Corders.size()>0){
        for(int i = 0; i<Corders.size(); i++){
            if(Coby.get(i) == 1){
                System.out.println(Corders.get(i));
                System.out.println("Status: Completed\n");
            }
        }
    }
        for(int j = 0; j<orders.size(); j++){
            if(oby.get(j) == 1){
                System.out.println(orders.get(j));
                System.out.println("Status: Processing\n");
            }
        }

        if(Dorders.size()>0){
        for(int k = 0; k<Dorders.size(); k++){
            if(Doby.get(k) == 1){
                System.out.println(Dorders.get(k));
                System.out.println("Status: Denied\n");
            }
        }
    }
    }

}

public void seehis(int t,String user){
    if(t == 0){
    //     for(String e : Chistory){
    //         System.out.println(e);
    //     }
    // }
    // else{
    //     for(String e : Vhistory){
    //         System.out.println(e);
    //     }
    File file = new File(user + ".txt");
    if (!file.exists()) {
        System.out.println("File not found: " + user);
    }   
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    System.out.println();
}

public void total(){
    int earning = ctotal + vtotal;
    System.out.println("Todays earning: $"+earning);
    System.out.println("Total orders: "+ totalorders);
    System.out.println("most popular item-");

    int max = Collections.max(numoford);

    ArrayList<Integer> inds = new ArrayList<Integer>();
    for (int i = 0; i < numoford.size(); i++) {
        if (numoford.get(i) == max) {
            inds.add(i);  
        }
    }
    for(int e : inds){
        System.out.println(items.get(e));
    }
}

public void mvout(int t){
    if(t == 0){

        System.out.println("Amount paid: $"+ctotal);
        ArrayList<Integer> arr = new ArrayList<Integer>(); 

        for(int i = 0; i < Coby.size(); i++){
            if(Coby.get(i)==0){
                arr.add(i);
            }
        }
        Collections.sort(arr, Collections.reverseOrder());
        for (int index : arr) {
            if (index < Corders.size()) {
                Corders.remove(index);
            }
        }
    }
    else{
        System.out.println("Amount paid: $"+vtotal);
        ArrayList<Integer> arr = new ArrayList<Integer>(); 

        for(int i = 0; i < Coby.size(); i++){
            if(Coby.get(i)==1){
                arr.add(i);
            }
        }
        Collections.sort(arr, Collections.reverseOrder());
        for (int index : arr) {
            if (index < Corders.size()) {
                Corders.remove(index);
            }
        }
    }
    System.out.println("Checkout completed!\n");
}

}


