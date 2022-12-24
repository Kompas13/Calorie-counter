public class MonthData {
    int[] days = new int[30];

    //���������� ���������� ����� �� ����:
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i+1)+" ����: "+days[i]);
        }
    }

    //����� ���������� ����� �� �����:
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    //������������ ���������� ����� � �����:
    int searchMaxStepsFromMonth() {  //�������� ������� �������, �� ����� �������� ���� ���� � ��.
        int maxSteps = 0;
        for (int day : days) {
            if (maxSteps < day) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    //������� ���������� ����� (� ���� 9 �� ���������� ������ ���, �� � ���� 11 �� ��������� ����� ��������� ����������):
    int countMonthlyAverageSteps(){
        return sumStepsFromMonth()/30;
    }

    // ����� ������ �����:
    int findBestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                bestSession = bestSession + 1;
            } else {
                bestSession = 0;
            }

            if (bestSession > countBest) {
                countBest = bestSession;
            }
        }
        return countBest;
    }
}
