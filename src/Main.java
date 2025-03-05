import java.util.Scanner;

public class Main {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return (tax >= 0) ? tax : 0;
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        int money;

        while (true) {
            System.out.println("Выбирите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String earningsStr = scanner.nextLine();
                    money = Integer.parseInt(earningsStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String spendingsStr = scanner.nextLine();
                    money = Integer.parseInt(spendingsStr);
                    spendings += money;
                    break;
                case 3:
                    int tax1 = taxEarnings(earnings);
                    int tax2 = taxEarningsMinusSpendings(earnings, spendings);

                    if (tax1 < tax2) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax1 + " рублей");
                        System.out.println("Налог на другой системе: " + tax2 + " рублей");
                        System.out.println("Экономия: " + (tax2 - tax1) + " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + tax2 + " рублей");
                        System.out.println("Налог на другой системе: " + tax1 + " рублей");
                        System.out.println("Экономия: " + (tax1 - tax2) + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}
