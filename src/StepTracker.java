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

    //¬вод количества шагов за определенный день:
    void addNewNumberStepsPerDay(){
        int month, day, step;
        // ввод и проверка номера мес€ца (в “« требуетс€ ввод от 0 до 11 включительно)
        System.out.println("¬ведите номер мес€ца от 0 до 11 (включительно).  (0-€нварь, 11-декабрь).");
        month=scanner.nextInt();
        if (month>11||month<0){
            System.out.println("¬веден некорректный мес€ц (меньше 0 или больше 11).");
            return;
        }

        // ввод и проверка дн€ (в “« требование, что дней от 1 до 30 включительно)
        System.out.println("¬ведите день от 1 до 30 (включительно)");
        day=scanner.nextInt();
        if (day>30||day<1){
            System.out.println("¬веден некорректный день (меньше 1 или больше 30).");
            return;
        }

        // ввод и проверка количества шагов
        System.out.println("¬ведите количество шагов");
        step=scanner.nextInt();
        if (step<0){
            System.out.println("¬веденное количество шагов меньше 0");
            return;
        }
        monthToData[month].days[day-1]=step; // сохранение данных
        System.out.println(" оличество шагов успешно занесено.");
    }

    //”становка целевого значени€ шагов:
    void changeStepGoal(){
        System.out.println("¬ведите целевое количество шагов в день:");
        int step=scanner.nextInt();
        if (step>0) {
            goalByStepsPerDay = step;
            System.out.println("÷елевое количество шагов в день установлено.");
        }
        else System.out.println("Ќовое целевое значение не установлено. Ќеобходимо ввести целевое значение шагов больше 0.");
    }

    //¬ывод статистики по мес€цу:
    void printStatistic() {
        String[] monthName = {"€нварь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сент€брь", "окт€брь", "но€брь", "декабрь"};
        System.out.println("¬ведите номер мес€ца от 0 до 11 (включительно).  (0-€нварь, 11-декабрь).");
        int month = scanner.nextInt();
        if (month>11||month<0){
            System.out.println("¬веден некорректный мес€ц (меньше 0 или больше 11).");
            return;
        }
        else {
            System.out.println("¬ывод статистики ¬аших достижений за " + monthName[month] + " мес€ц:");
            System.out.println("—татистика шагов по дн€м:");
            monthToData[month].printDaysAndStepsFromMonth();
            int sumSteps = monthToData[month].sumStepsFromMonth();// общее число шагов за мес€ц
            System.out.println("ќбщее количество шагов за мес€ц: " + sumSteps);
            System.out.println("ћаксимально пройденное количество шагов за мес€ц: " + monthToData[month].searchMaxStepsFromMonth());
            System.out.println("—реднее количество шагов за мес€ц: " + monthToData[month].countMonthlyAverageSteps());
            System.out.println("ѕройденна€ за мес€ц дистанци€ (в км): " + converter.convertStepsToKm(sumSteps));
            System.out.println(" оличество сожженных за мес€ц килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
            System.out.println("Ћучша€ сери€ за мес€ц (максимальное количество подр€д идущих дней, " +
                    "в течение которых количество шагов за день было равно или выше целевого): " + monthToData[month].findBestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}
