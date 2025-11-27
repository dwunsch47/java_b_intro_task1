import java.util.Scanner;

class Main {
    public static double INCOME_TAX = 0.06;
    public static double DIFFERENCE_TAX = 0.15;

    public static int incomeTaxCalc(int income) {
        return (int) (income * INCOME_TAX);
    }

    public static int differenceTaxCalc(int income, int spending) {
        int difference = income - spending;
        return (difference >= 0 ? (int) (difference * DIFFERENCE_TAX) : 0);
    }

    public static void chooseBestTax(int incomeTax, int differenceTax) {
        if (incomeTax == differenceTax) {
            System.out.println("Можете выбрать любую систему налогообложения");
            return;
        }
        int taxDiff = incomeTax - differenceTax;
        boolean isIncomeTaxBetter = taxDiff < 0;
        System.out.println("\nМы советуем вам " + (isIncomeTaxBetter ? "УСН доходы" : "УСН доходы минус расходы"));
        System.out.println("Ваш налог составит: " + (isIncomeTaxBetter ? incomeTax : differenceTax));
        System.out.println("Налог на другой системе: " + (!isIncomeTaxBetter ? incomeTax : differenceTax));
        System.out.println("Экономия: " + Math.abs(taxDiff));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int income = 0;
        int spending = 0;
        while (true) {
            System.out.println("\nВыберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход\n2. Добавить новый расход\n3. Выбрать систему налогообложения");
            System.out.print("Введите команду: ");
            String command = sc.nextLine();
            if (command.equals("end")) {
                break;
            }
            switch (command) {
                case "1":
                    System.out.print("Введите сумму дохода: ");
                    income += Integer.parseInt(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Введите сумму раходов: ");
                    spending += Integer.parseInt(sc.nextLine());
                    break;
                case "3":
                    chooseBestTax(incomeTaxCalc(income), differenceTaxCalc(income, spending));
                    break;
                default:
                    System.out.println("Неправильная команда");
                    break;
            }
        }
    }
}
