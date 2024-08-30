package Project.PassWordGenerator;

import java.util.Random;

import static java.lang.Math.random;

public class PasswordGenerator {
    private static Random random = new Random();
    private static String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*(){}[]_-?><";
    public static void generator(int len)
    {
        StringBuffer password = new StringBuffer();
        for(int i =1;i<=len;i++){
            char ch = str.charAt(random.nextInt(str.length()-1));
            password.append(ch);
        }
        System.out.println("Your generated password is : "+password);
    }

    public static void main(String[] args) {
       generator(10);
    }
}
