package mistycalShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ShopLauncher {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final HashMap<String, NoAccessedClient> authorizationMap = new HashMap<>();

    public ShopLauncher() throws IOException {
        start();
    }

    public static void main(String[] args) {
        try {
            ShopLauncher shopLauncher = new ShopLauncher();
        } catch (IOException e) {
            System.out.println("IN MAIN IO");
            e.printStackTrace();
        }

    }

    public void start() throws IOException {
        System.out.println("Write >login< or >registration<");
        String tempChoise = reader.readLine();
        if (tempChoise.equals("login")) {
            System.out.println("loggining");
            logging(3);
        } else if (tempChoise.equals("registration")) {
            System.out.println("registration");
            registration();
        } else {
            System.out.println("MISSED BLOCK");
        }
        start();
    }

    public void logging(int tryLimit) {      //  HAVE NO IDEA HOW NULL CAN BE HERE
        int tryCounter = tryLimit;
        AccessedClient accessedClient = null;
        try {
            accessedClient = ShopLauncher.authorizationMap.get(reader.readLine()).getAccess(reader.readLine());
        } catch (Exception e) {
            if (tryCounter == 0) {
                e.printStackTrace();
                return;
            }
            logging(--tryLimit);
        }

        AccessedClient ac = new Client("oleg");
        if (null != accessedClient) {
            System.out.println("Inside the acc " + accessedClient.getBankAccount());  // <<<<==== ????
        }
    }

    public void registration() {            // CAN TRY TEST FABRIC
        System.out.println("Choice user name");
        String tName = null;
        try {
            tName = reader.readLine();
            if (!ShopLauncher.authorizationMap.containsKey(tName)) {
                Client tempClient = new Client(tName);
                tempClient.setPassword(3);
                tempClient.setBankAccount(new BankAccount(3));
                tempClient.setAge(3);
                tempClient.setName(3);
                ShopLauncher.authorizationMap.put(tempClient.getUserName(), tempClient);
            } else {
                System.out.println("UserName already used");
                registration();
            }

        } catch (IOException e) {
            System.out.println("Wrong input");
            registration();
        } catch (NullPointerException e) {
            System.out.println("NULL???");
            System.exit(1);
        }
    }
}

//        System.out.println("Choice user name");
//        String tName = null;
//        Client tempClient = null;
//        try {
//            tName = reader.readLine();
//        } catch (IOException e) {
//            System.out.println("Wrong input");
//            registration();
//        }
//        if (ShopLauncher.authorizationMap.containsKey(tName)) {
//            tempClient = new Client(tName);
//        } else {
//            System.out.println("UserName already used");
//            registration();
//        }
//        try {
//            assert tempClient != null;
//            tempClient.setPassword(3);
//        } catch (IOException e) {
//            registration();
//        }
