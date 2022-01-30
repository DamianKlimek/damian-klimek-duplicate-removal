import java.util.Scanner;

public class DuplicateRemoval {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DigitalIO digitalIO = new DigitalIO();

        boolean condition = true;
        boolean secondCodition = true;
        System.out.print("Type how many data you want to collect: ");
        long howMany = scanner.nextLong();
        int checkHowMany = 0;

        System.out.println();
        System.out.println("Press 1 to start getting input data from a sensor.");

        while (condition) {
            int start = scanner.nextInt();
            switch (start) {
                case 1 -> {
                    System.out.println();
                    while (secondCodition) {
                        digitalIO.gatheringData();
                        if (howMany-1 == checkHowMany){
                            secondCodition = false;
                        }
                        checkHowMany++;
                    }
                    System.out.println("Successfully gathered " + howMany + " data!" + "\n");
                    System.out.println("Press 2 to check answer.");
                    System.out.println("Press 3 to exit.");
                }
                case 2 -> {
                    System.out.println();
                    digitalIO.answerShow();
                }
                case 3 -> condition = false;
            }
        }
    }
}
