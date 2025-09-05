import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;

public class WeekTwoMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file = "answers.txt";

        while (true) {
                    printMenu();
                    String choice = scanner.nextLine().trim();
        
                    switch (choice) {
                        case "1":
                            String record = runQuestionnaire(scanner);  
                            appendToFile(file, record);             
                            System.out.println("Entry saved.\n");
                            break;
        
                        case "2":
                            printAll(file);                         
                            break;
        
                        case "3":
                            System.out.println("Exiting the program. Bai :3!");
                            scanner.close();
                            return;
        
                        default:
                            System.out.println("Please enter 1, 2, or 3.\n");
                    }
                }
            }
        
            private static void printMenu() {
                System.out.println("Illness Pre-Screening Menu");
                System.out.println("1. Pre-screening Test");
                System.out.println("2. Results");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
            }
        
            private static String runQ(Scanner scanner) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
        
                int age = readInt(scanner, "Age (whole number): ");
                double temp = readDouble(scanner, "Temperature (e.g., 98.6): ");
        
                boolean traveled = readYesNo(scanner, "Have you traveled recently? (y/n): ");
                boolean exposure = readYesNo(scanner, "Recent exposure to someone who tested positive? (y/n): ");
        
                return name + " | Age: " + age + " | Temp: " + temp + " | Traveled: " + (traveled ? "Yes" : "No") + " | Exposure: " + (exposure ? "Yes" : "No");
            }
        
            private static int readInt(Scanner scanner, String prompt) {
                while (true) {
                    System.out.print(prompt);
                    String s = scanner.nextLine().trim();
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid whole number.");
                    }
                }
            }
        
            private static double readDouble(Scanner scanner, String prompt) {
                while (true) {
                    System.out.print(prompt);
                    String s = scanner.nextLine().trim();
                    try {
                        return Double.parseDouble(s);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid numeric value.");
                    }
                }
            }
        
            private static boolean readYesNo(Scanner scanner, String prompt) {
                while (true) {
                    System.out.print(prompt);
                    String s = scanner.nextLine().trim().toLowerCase();
                    if (s.equals("y") || s.equals("yes")) return true;
                    if (s.equals("n") || s.equals("no"))  return false;
                    System.out.println("Please answer with y or n.");
                }
            }
        
            private static void appendToFile(String file, String line) {
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write(line + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
            }
        
            private static void printAll(String file) {
                try (Scanner reader = new Scanner(Paths.get(file))) {
                    System.out.println("\n==== Saved Results ====");
                    if (!reader.hasNextLine()) {
                        System.out.println("(No entries yet.)");
                    }
                    while (reader.hasNextLine()) {
                        System.out.println(reader.nextLine());
                    }
                    System.out.println("=======================\n");
                } catch (IOException e) {
                    System.out.println("No results file found yet.");
                }
            }
        }
