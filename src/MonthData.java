public class MonthData {
    int[] days = new int[30];

    //Количество пройденных шагов по дням:
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i+1)+" день: "+days[i]);
        }
    }

    //Общее количество шагов за месяц:
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    //Максимальное количество шагов в месяц:
    int searchMaxStepsFromMonth() {  //названия методов поменял, но такие названия были даны в ТЗ.
        int maxSteps = 0;
        for (int day : days) {
            if (maxSteps < day) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    //Среднее количество шагов (в шаге 9 ТЗ указанного метода нет, но в шаге 11 ТЗ требуется вывод указанной информации):
    int countMonthlyAverageSteps(){
        return sumStepsFromMonth()/30;
    }

    // Поиск лучшей серии:
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
