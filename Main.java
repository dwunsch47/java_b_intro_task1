import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] options = {"Молоко", "Хлеб", "Гречка"};
        int[] prices = {50, 14, 80};

        int[] amount = new int[options.length];

        while (true) {
            System.out.println("Выберите товар и количество или введите end: ");
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] split_input = input.split(" ");
            amount[(Integer.parseInt(split_input[0]) - 1)] += Integer.parseInt(split_input[1]);
        }

        int finalPrice = 0;

        System.out.println("Ваша корзина:");
        for (int i = 0; i < amount.length; i++) {
            if (amount[i] > 0) {
                int priceForAmount = amount[i] * prices[i];
                finalPrice += priceForAmount;
                System.out.println(options[i] + ' '+ amount[i] + " шт " + prices[i] + " руб/шт, "
                        + priceForAmount + " руб в сумме");
            }
        }
        System.out.println("Итого: " + finalPrice);
    }
}