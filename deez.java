import java.util.Scanner;

public class yessah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double temp = 0.0;
        boolean traveled = false;
        boolean contact = false;

        int choice = 0;
        String[] questions = {"What is your temperature?", "Have you traveled recently? (yes/no): ", "Have you been around someone who has tested positive for a contagious disease? (yes/no): "};

        while (choice != 3) {
            System.out.println("\n--- Illness Pre-Screening Menu ---");
            System.out.println("1. Pre-screening Test");
            System.out.println("2. Results");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < questions.length; i++) {
                        System.out.print(questions[i]);

                        if (i == 0) {
                            temperature = scanner.nextDouble();
                            hasTemp = true;
                        } else {
                            String answer = scanner.next();
                            if (i == 1) {
                                traveled = answer.equalsIgnoreCase("yes");
                            } else if (i == 2) 
                                contact = answer.equalsIgnoreCase("yes");
                            }
                        }
                    }
                    break;

                case 2:
                    if (!hasTemp) {
                        System.out.println("Please complete the pre-screening test first.");
                        break;
                    }
                    int conditionsMet = 0;
                    if (temperature >= 99.0) conditionsMet++;
                    if (traveled) conditionsMet++;
                    if (contact) conditionsMet++;

                    if (conditionsMet >= 2) {
                        System.out.println("Result: Please take additional testing.");
                    } else {
                        System.out.println("Result: You do not need additional testing at this time.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program. Stay safe!");
                    break;
            }
        }

        scanner.close();
    }
}
