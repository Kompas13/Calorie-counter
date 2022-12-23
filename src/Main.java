import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0) {
                scanner.close();
                break;
            } else {
                System.out.println("Извините, такой команды нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - ввести количество шагов за определённый день;");
        System.out.println("2 - изменить цель по количеству шагов в день;");
        System.out.println("3 - напечатать статистику за определённый месяц;");
        System.out.println("0 - выйти из приложения.");
    }
}

