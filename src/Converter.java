public class Converter {

    //Конвертер шагов в километры:
    public int convertStepsToKm(int steps) {
        return (steps * 75) / 100000;
    }

    //Конвертер шагов в килокалории:
    public int convertStepsToKilocalories(int steps) {
        return (steps * 50) / 1000;
    }

}
