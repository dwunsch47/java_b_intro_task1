import java.sql.SQLOutput;
import java.util.Scanner;

class Main {

    public static int checkNumOfDays(int year) {
        return ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) ? 366 : 365;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose mode: check or game");
        String mode = scanner.nextLine();
        if (mode.equals("check")) {
            System.out.println("Введите год в формате yyyy");
            int year = scanner.nextInt();
            System.out.println("Количество дней " + checkNumOfDays(year));
        } else if (mode.equals("game")) {
            int score = 0;
            while (true) {
                System.out.println("Введите год");
                int year = scanner.nextInt();
                System.out.println("Введите количество дней");
                int days = scanner.nextInt();
                if (days != checkNumOfDays(year)) {
                    System.out.println("Неправильно! В этом году " + checkNumOfDays(year));
                    System.out.println("Набрано очков: " + score);
                    break;
                }
                score++;
            }
        }
    }
}
