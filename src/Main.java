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
                    int tax;
                    int taxDif;
                    String taxName;
                    if (taxEarnings(earnings) < taxEarningsMinusSpendings(earnings, spendings)) {
                        tax = taxEarnings(earnings);
                        taxDif = taxEarningsMinusSpendings(earnings, spendings) - taxEarnings(earnings);
                        taxName = "УСН доходы";
                    } else {
                        tax = taxEarningsMinusSpendings(earnings, spendings);
                        taxDif = taxEarnings(earnings) - taxEarningsMinusSpendings(earnings, spendings);
                        taxName = "УСН доходы минус расходы";
                    }
                    System.out.println("Мы советуем вам " + taxName);
                    System.out.println("Ваш налог составит: " + tax + " рублей");
                    System.out.println("Налог на другой системе: " + (tax + taxDif) + " рублей");
                    System.out.println("Экономия: " + taxDif + " рублей");
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}
