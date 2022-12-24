import java.util.Scanner;

public class StepTracker {
    Converter converter;
    Scanner scanner;
    MonthData[] monthToData;
    private int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        this.scanner = scan;
        this.converter = new Converter();
        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }

    //���� ���������� ����� �� ������������ ����:
    void addNewNumberStepsPerDay(){
        int month, day, step;
        // ���� � �������� ������ ������ (� �� ��������� ���� �� 0 �� 11 ������������)
        System.out.println("������� ����� ������ �� 0 �� 11 (������������).  (0-������, 11-�������).");
        month=scanner.nextInt();
        if (month>11||month<0){
            System.out.println("������ ������������ ����� (������ 0 ��� ������ 11).");
            return;
        }

        // ���� � �������� ��� (� �� ����������, ��� ���� �� 1 �� 30 ������������)
        System.out.println("������� ���� �� 1 �� 30 (������������)");
        day=scanner.nextInt();
        if (day>30||day<1){
            System.out.println("������ ������������ ���� (������ 1 ��� ������ 30).");
            return;
        }

        // ���� � �������� ���������� �����
        System.out.println("������� ���������� �����");
        step=scanner.nextInt();
        if (step<0){
            System.out.println("��������� ���������� ����� ������ 0");
            return;
        }
        monthToData[month].days[day-1]=step; // ���������� ������
        System.out.println("���������� ����� ������� ��������.");
    }

    //��������� �������� �������� �����:
    void changeStepGoal(){
        System.out.println("������� ������� ���������� ����� � ����:");
        int step=scanner.nextInt();
        if (step>0) {
            goalByStepsPerDay = step;
            System.out.println("������� ���������� ����� � ���� �����������.");
        }
        else System.out.println("����� ������� �������� �� �����������. ���������� ������ ������� �������� ����� ������ 0.");
    }

    //����� ���������� �� ������:
    void printStatistic() {
        String[] monthName = {"������", "�������", "����", "������", "���", "����", "����", "������", "��������", "�������", "������", "�������"};
        System.out.println("������� ����� ������ �� 0 �� 11 (������������).  (0-������, 11-�������).");
        int month = scanner.nextInt();
        if (month>11||month<0){
            System.out.println("������ ������������ ����� (������ 0 ��� ������ 11).");
            return;
        }
        else {
            System.out.println("����� ���������� ����� ���������� �� " + monthName[month] + " �����:");
            System.out.println("���������� ����� �� ����:");
            monthToData[month].printDaysAndStepsFromMonth();
            int sumSteps = monthToData[month].sumStepsFromMonth();// ����� ����� ����� �� �����
            System.out.println("����� ���������� ����� �� �����: " + sumSteps);
            System.out.println("����������� ���������� ���������� ����� �� �����: " + monthToData[month].searchMaxStepsFromMonth());
            System.out.println("������� ���������� ����� �� �����: " + monthToData[month].countMonthlyAverageSteps());
            System.out.println("���������� �� ����� ��������� (� ��): " + converter.convertStepsToKm(sumSteps));
            System.out.println("���������� ��������� �� ����� �����������: " + converter.convertStepsToKilocalories(sumSteps));
            System.out.println("������ ����� �� ����� (������������ ���������� ������ ������ ����, " +
                    "� ������� ������� ���������� ����� �� ���� ���� ����� ��� ���� ��������): " + monthToData[month].findBestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}
