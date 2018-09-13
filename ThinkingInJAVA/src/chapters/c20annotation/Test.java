package chapters.c20annotation;

public class Test {

    public static void main(String[] args) {
//        test01("Member");

        test01("chapters.c20annotation.database.Member");
    }

    public static void test01(String className){
        try {
            Class<?> cl = Class.forName(className);
            System.out.println(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
