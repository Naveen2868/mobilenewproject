package utils;

public class Abc {

    String str = "Java is a programing language";
    String str2 = "an";

    public static void compare1(String one, String two) {
        one = one.replace(" ", "");
        char words2[] = two.toCharArray();
        char words[] = one.toCharArray();
        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; i < words2.length; j++) {

                if (words[i] == words2[j]) {
                    one.replace(words2[j], words[i]);
                }

                System.out.println(one);
            }

        }
    }


    public static void a1(){
        String str ="abc";
        String str2 = new String ("abc");
        System.out.println(" str==str2 " +str==str2);
        System.out.println(" str.equals(str2) " +str.equals(str2));

    }
    public static void main(String args[]) {
        a1();

    }

}
