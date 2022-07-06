package javaprac;

public class CommandLineExample {


    //perfect number
    public void perfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        if (number == sum)
            System.out.println("Given number is perfect number");
        else
            System.out.println("Given number is not perfect number");
    }

    //some of the factors of the given number
    public void sumOfTheFactors(int number) {
        int x = 0, sum = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                /// sum=sum+i;
                // System.out.println(i);
                x++;
            }
        }

        if (x == 2)
            System.out.println("Given number is prime");
        else
            System.out.println("given number is not prime");

    }

    public void xyz(int number){
        int sum=0;
        int rem=0;
        int temp = number;

        while(number!=0){
            rem = number%10;
            sum= sum+rem*rem*rem;
            number=number/10;
        }

        System.out.println(sum+" "+temp);

        if (sum == temp)
            System.out.println("Given number is Strong number");
        else
            System.out.println("given number is not Strong number");

    }

    public static void main(String args[]) {
        CommandLineExample cle = new CommandLineExample();
        // cle.perfectNumber(28);
        //cle.sumOfTheFactors(9);
        cle.xyz(12);
    }
}
