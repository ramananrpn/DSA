import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import helper.InputHelper;
import service.ProcessorService;

// TAGS: phonepe, trie
public class Main {
    ProcessorService processorService = new ProcessorService();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int condition = 0;
        do{
            try {
                System.out.println("\n 1 - Execute Testcases \n 2 - startTracking \n 3 - getCounts  \n 4 - stopTracking  \n 5 - Exit \n Provide input :");
                condition = scanner.nextInt();

                main.processInput(condition);
            } catch (InputMismatchException exception) {
                System.out.println("\n Unsupported Input. Please retry with valid input");
                scanner.next();
            }
        } while(condition != 5);
    }

    private void processInput(int condition) {
        try {
            switch (condition) {
                case 1 : {
                    processTestCase();
                    break;
                }
                case 2 : {
                    System.out.println("Processing startTracking");
                    processStartTracking();
                    break;
                }
                case 3: {
                    System.out.println("Processing getCounts");
                    processGetCounts();
                    break;
                }
                case 4 : {
                    System.out.println("Processing stopTracking");
                    processStopTracking();
                    break;
                }
                case 5 : {
                    return;
                }
                default: {
                    System.out.println("Unsupported Operation. Please retry with valid input");
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Invalid Input. Please retry with valid input");
            scanner.next();
        } catch (Exception exception) {
            System.out.println("Exception occurred :: " + exception.getMessage());
        }
    }

    private void processTestCase() {
        processorService.startTracking(1112, List.of("UPI", "Karnataka", "Bangalore"));
        processorService.startTracking(1112, List.of("UPI", "Karnataka", "Bangalore"));
        processorService.startTracking(2451, List.of("UPI", "Karnataka", "Mysore"));
        processorService.startTracking(3421, List.of("UPI", "Rajasthan", "Jaipur"));
        processorService.startTracking(1221, List.of("Wallet", "Karnataka", "Bangalore"));

        processorService.getCounts(List.of("UPI"));
        processorService.getCounts(List.of("UPI", "Karnataka"));
        processorService.getCounts(List.of("UPI", "Karnataka", "Bangalore"));
        processorService.getCounts(List.of("Bangalore"));

        processorService.startTracking(4221, List.of("Wallet", "Karnataka", "Bangalore"));

        processorService.stopTracking(1112);
        processorService.stopTracking(1112);
        processorService.stopTracking(2451);

        processorService.getCounts(List.of("UPI"));
        processorService.getCounts(List.of("Wallet"));
        processorService.getCounts(List.of("UPI", "Karnataka", "Bangalore"));
    }

    private void processStopTracking() {
        // reading id
        System.out.println(" \n -- Provide id --");

        int id = scanner.nextInt();
        processorService.stopTracking(id);
    }

    private void processGetCounts() {
        // reading tags
        System.out.println(" \n -- Provide tags -- ");
        String[] tags = InputHelper.convertCommaSeperatedStringToArray(scanner.nextLine());

        if (InputHelper.isTagsValid(tags)) {
            processorService.getCounts(Arrays.asList(tags));
        }
    }

    private void processStartTracking() {
        // reading id
        System.out.println(" \n -- Provide id --");
        int id = scanner.nextInt();

        // reading tags
        System.out.println(" \n -- Provide tags -- ");
        String[] tags = InputHelper.convertCommaSeperatedStringToArray(scanner.nextLine());

        if (InputHelper.isTagsValid(tags)) {
            processorService.startTracking(id, Arrays.asList(tags));
        }
    }
}