package mistycalShop;

import java.io.IOException;

interface AccessedClient {
    BankAccount getBankAccount();

    String getUserName();

    String getPassword();
}

interface NoAccessedClient {
    AccessedClient getAccess(String passWord) throws Exception;
}

public class Client implements NoAccessedClient, AccessedClient {
    private String userName;
    private String password;
    private BankAccount bankAccount;
    private String name;
    private int age;

    public Client(String name) {
        setUserName(name);
    }

    private Client(String userName, String password, BankAccount bankAccount, String name, int age) {
        setUserName(userName);
        setPassword(password);
        setBankAccount(bankAccount);
        setName(name);
        setAge(age);
    }


    public AccessedClient getAccess(String passWord) throws Exception {
        if (this.password.equals(passWord)) {
            return this;
        }
        throw new Exception("WRONG PASSWORD ACCESS DENIED");
    }

    public void open(int actionNum) {
        System.out.println("actionNum = " + actionNum);
    }

    public void tranthaction(BankAccount targetAccount) {

    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public void buyItem(Item item) {

    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(int tryLimit) throws IOException {
        if (tryLimit-- == 0) {
            throw new IOException();
        }
        try {
            System.out.println("set password");
            this.password = Util.input.readLine();
            System.out.println("Password Successful");
        } catch (IOException e) {
            System.out.println("Wrong input " + tryLimit + " left");
            setPassword(tryLimit);
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int tryLimit) throws IOException {
        if (tryLimit-- == 0) {
            throw new IOException();
        }
        try {
            this.bankAccount = new BankAccount(Integer.parseInt(Util.input.readLine()));
            System.out.println("Bank Acc successful");
        } catch (IOException e) {
            System.out.println("Wrong input " + tryLimit + " trys left");
            setBankAccount(tryLimit);
        }
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(int tryLimit) throws IOException {
        if (tryLimit-- == 0) {
            throw new IOException();
        }
        try {
            this.name = Util.input.readLine();
            System.out.println("Name Successful");
        } catch (IOException e) {
            System.out.println("Wrong input " + tryLimit + " left");
            setPassword(tryLimit);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setAge(int tryLimit,String forReg) throws IOException {
        if (tryLimit-- == 0) {
            throw new IOException();
        }
        try {
            this.age = Integer.parseInt(Util.input.readLine());
            System.out.println("Age Successful");
        } catch (IOException e) {
            System.out.println("Wrong input " + tryLimit + " left");
            setPassword(tryLimit);
        }
    }

}
