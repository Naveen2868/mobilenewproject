import java.util.HashMap;
import java.util.Random;

public class TestDemo {

    public static void main(String args[]){

        System.out.println(TestDemo.generateUserInfo());
    }

    public static HashMap<String, String> generateUserInfo() {

        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 4;
        Random random1 = new Random();
        String generatedString = random1.ints(leftLimit, rightLimit + 1).
                limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String streetAddress = randomNumber + " " + generatedString + " Street";

        for (int i = 0; i <= generatedString.length()-1; i++)
            for (int j = i + 1; j <= generatedString.length()-1; j++)
                if (generatedString.toLowerCase().charAt(i) == generatedString.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
                    streetAddress = randomNumber + " " + generatedString + " Street";
                }

        String firstName = "A" + "" + generatedString + "o";
        for (int i = 0; i <= firstName.length()-1; i++)
            for (int j = i + 1; j <= firstName.length()-1; j++)
                if (firstName.toLowerCase().charAt(i) == firstName.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1)
                            .limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString();
                    firstName = "A" + "" + generatedString + "o";
                }

        String middleName = generatedString + "yu";
        for (int i = 0; i <= middleName.length()-1; i++)
            for (int j = i + 1; j <= middleName.length()-1; j++)
                if (middleName.toLowerCase().charAt(i) == middleName.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1)
                            .limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString();
                    middleName = generatedString + "yu";
                }

        String lastName = "R" + "" + generatedString + "y";
        for (int i = 0; i <= lastName.length()-1; i++)
            for (int j = i + 1; j <= lastName.length()-1; j++)
                if (lastName.toLowerCase().charAt(i) == lastName.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1)
                            .limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString();
                    lastName = "R" + "" + generatedString + "y";
                }


        HashMap<String, String> userInfoMap = new HashMap<>();
        userInfoMap.put("StreetAddress", streetAddress);
        userInfoMap.put("firstName", firstName);
        userInfoMap.put("middleName", middleName);
        userInfoMap.put("lastName", lastName);

        return userInfoMap;
    }

}
