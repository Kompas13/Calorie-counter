public class Converter {

    //��������� ����� � ���������:
    public int convertStepsToKm(int steps) {
        return (steps * 75) / 100000;
    }

    //��������� ����� � �����������:
    public int convertStepsToKilocalories(int steps) {
        return (steps * 50) / 1000;
    }

}
