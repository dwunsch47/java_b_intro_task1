import java.util.*;

public class Main {
    public static void main() {
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> uniqueCountries = new HashSet<>();
        int overallCost = 0;

        costPerAddress.put(new Address("Россия", "Москва"), 1000);
        costPerAddress.put(new Address("Россия", "Санкт-Петербург"), 750);
        costPerAddress.put(new Address("Чехия", "Прага"), 2500);

        Scanner scanner = new Scanner(System.in);
        String country, city;
        int weight, cost;
        Address currentOrder;
        while (true) {
            System.out.print("Заполнение нового заказа.\nВведите страну: ");
            country = scanner.nextLine();
            if (country.equals("end")) break;
            System.out.print("Введите город: ");
            city = scanner.nextLine();
            if (city.equals("end")) break;
            uniqueCountries.add(country); // поздно т.к. пользователь может до этого момента отменить
            System.out.print("Введите вес (кг): ");
            weight = Integer.parseInt(scanner.nextLine());
            currentOrder = new Address(country, city);
            if (!costPerAddress.containsKey(currentOrder)) {
                System.out.println("Доставки по этому адресу нет");
            } else {
                cost = weight * costPerAddress.get(currentOrder);
                overallCost += cost;
                System.out.println("Стоимость доставки составит: " + cost + " руб.");
            }
            System.out.println("Общая стоимость всех доставок: " + overallCost + " руб.");
            System.out.println("Количество уникальных стран: " + uniqueCountries.size());
            System.out.println();
        }
    }
}
