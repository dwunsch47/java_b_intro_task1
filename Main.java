import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main() {
        List<String> jobList = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int mode;
        boolean isDeleteSuccessful;
        while(true) {
            System.out.print("Выберите операцию:\n\n0. Выход из программы\n1. Добавить дело\n2. Показать дела\n3. Удалить дело по номеру\n4. Удалить дело по названию\n5. Удалить слово\nВаш выбор: ");
            mode = Integer.parseInt(scanner.nextLine());
            if (mode == 0) {
                break;
            }
            switch (mode) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    jobList.addLast(scanner.nextLine());
                    System.out.println("\nДобавлено!");
                    break;

                case 2:
                    break;

                case 3:
                    System.out.print("Введите номер для удаления: ");
                    jobList.remove(Integer.parseInt(scanner.nextLine()) - 1);
                    break;

                case 4:
                    System.out.print("Введите задачу для удаления: ");
                    isDeleteSuccessful = jobList.remove(scanner.nextLine());
                    System.out.println('\n' + (isDeleteSuccessful ? "Удалено!" : "Такой задачи нет"));
                    break;

                case 5:
                    System.out.println("Введите слово для удаления: ");
                    removeWord(jobList, scanner.nextLine());
                    break;
            }
            displayJobList(jobList);
        }
    }

    public static void displayJobList(List<String> jL) {
        System.out.println("\nВаш сприсок дел:");
        int counter = 1;
        for (String job : jL) { // через обычный for пришлось бы каждый раз брать с помощью .get(), что, насколько я понимаю, приводило бы к сложности n на каждой итерации
            System.out.println(counter++ + ". " + job);
        }
        System.out.println();
    }

    public static void removeWord(List<String> jL, String word) {
        for (Iterator<String> it = jL.iterator(); it.hasNext();) {
            if (it.next().contains(word)) {
                it.remove();
            }
        }
    }
}
