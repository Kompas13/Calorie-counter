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
                System.out.println("��������, ����� ������� ���.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("��� �� ������ �������?");
        System.out.println("1 - ������ ���������� ����� �� ����������� ����;");
        System.out.println("2 - �������� ���� �� ���������� ����� � ����;");
        System.out.println("3 - ���������� ���������� �� ����������� �����;");
        System.out.println("0 - ����� �� ����������.");
    }
}

