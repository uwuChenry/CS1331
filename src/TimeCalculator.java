public class TimeCalculator {
    public static void main(String[] args) {
        double homeworkTime = 3.99;
        double lectureTime = 1.25;
        int numLectures = 4;
        double breakTime = 0.53;
        double travelAdjustment = 0.08;
        double timeTotal = 0;
        timeTotal += homeworkTime / 2;
        timeTotal += lectureTime * numLectures;
        timeTotal -= breakTime / 3;
        timeTotal *= (1 + travelAdjustment);
        int temp = (int)(timeTotal * 100);
        double timeTotalTrunc = (double)temp / 100;
        System.out.printf("You're busy for %.2f hours.", timeTotalTrunc);
        int totalHours = 24;
        totalHours -= timeTotalTrunc;
        System.out.printf("\nYou have %d hours remaining in the day.", totalHours);

    }
}