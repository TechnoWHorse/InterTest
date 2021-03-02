package mistycalShop;
interface CorCl{

}
public class CorporateClient extends Client implements CorCl{
    public CorporateClient(String name) {
        super(name);
    }
    private int firmId;
    public int firmPublicId;
//    public CorporateClient(String userName, String password, BankAccount bankAccount, String name, int age) {
//        super(userName, password, bankAccount, name, age);
//    }
}
