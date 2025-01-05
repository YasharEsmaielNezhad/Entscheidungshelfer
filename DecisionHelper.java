import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class DecisionHelper {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<String> foodOptions = new ArrayList<>();
        ArrayList<String> movieOptions = new ArrayList<>();
        ArrayList<String> activityOptions = new ArrayList<>();
        Random randomizer = new Random();

        while (true) {
            System.out.println("Willkommen bei der Entscheidungshelfer ! :)) ");
            System.out.println("Wähle eine Kategorie (1-Essen, 2-Filme, 3-Aktivitäten):");

            int categoryChoice = inputScanner.nextInt();
            inputScanner.nextLine();
            switch (categoryChoice) {
                case 1:
                    System.out.println("Gib deine Essensoptionen(z.B Bratwurst) ein (Tippe 'done', um zu beenden):");
                    addOptions(inputScanner, foodOptions);
                    break;
                case 2:
                    System.out.println("Gib deine Filmoptionen(z.B Tatort) ein (Tippe 'done', um zu beenden):");
                    addOptions(inputScanner, movieOptions);
                    break;
                case 3:
                    System.out
                            .println("Gib deine Aktivitätsoptionen)(z.B Klettern) ein (Tippe 'done', um zu beenden):");
                    addOptions(inputScanner, activityOptions);
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Das Programm wird beendet. :( )");
                    return;
            }
            ArrayList<String> selectedCategory = null;
            if (categoryChoice == 1)
                selectedCategory = foodOptions;
            else if (categoryChoice == 2)
                selectedCategory = movieOptions;
            else if (categoryChoice == 3)
                selectedCategory = activityOptions;
            if (selectedCategory.isEmpty()) {
                System.out.println("Keine Optionen eingegeben. Das Programm wird beendet.");
            } else {
                int randomChoice = randomizer.nextInt(selectedCategory.size());
                System.out.println("Die gewählte Option ist: " + selectedCategory.get(randomChoice));
            }

            System.out.println("\nMöchtest du vielleicht von vorne beginnen?? (Ja/Nein):");
            String restart = inputScanner.nextLine();
            if (!restart.equalsIgnoreCase("Ja")) {
                System.out.println("Das Programm wird beendet.");
                break;
            }

            foodOptions.clear();
            movieOptions.clear();
            activityOptions.clear();
        }

        inputScanner.close();
    }

    public static void addOptions(Scanner scanner, ArrayList<String> options) {
        while (true) {
            System.out.print("Option: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            options.add(input);
        }
    }
}
