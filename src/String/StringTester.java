package String;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
interface Isum{
    int getSum(int a,int b);
}
interface Lamb{
    String getStr(String forTestLamb);
}
class TestClass{
    public String name = "Yury";
}
public class StringTester {
//    int age = 15;
    public static void main(String[] args) {
        System.out.println(new StringTester().hashCode());
        

    }
    public void isArgsChanged(TestClass tc){

    }
    public int getLambd(Isum arg){
        return arg.getSum(5,5);
    }
    public static void getLambdOne(Lamb lamb){
        System.out.println(lamb);
    }
    public int taskSplitterCounter(String arg) {
        int count = 0;
        List<String> uniqueWords = new ArrayList<>();
        for (String word : arg.split(" ")) {
            if (Pattern.compile("([a-z])++([\\D])+").matcher(word).matches() && !uniqueWords.contains(word)) {
                uniqueWords.add(word);
                ++count;
                System.out.println(word);

            }

        }
        return count;

    }
    public void findTest(String str){
        Pattern pattern = Pattern.compile("[a-z]++");
        Matcher match = pattern.matcher(str);
        while (match.find()){
            for (int i = 0; i < match.groupCount()+1; i++) {
//                System.out.println(i);
                System.out.println("["+match.group()+"]");
//                System.out.println("["+match.group(i)+"]");

            }
        }
    }
}

/* This string from comments just for
test parser!
 */