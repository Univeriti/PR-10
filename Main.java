import java.util.Scanner;

class SimpleAuth {
    static String[] usernames = new String[15];
    static String[] passwords = new String[15];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1 - Додати користувача");
            System.out.println("2 - Видалити користувача");
            System.out.println("3 - Вхід користувача");
            System.out.println("4 - Вихід");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addUser();
            } else if (choice.equals("2")) {
                deleteUser();
            } else if (choice.equals("3")) {
                loginUser();
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Невідома команда");
            }
        }
    }

    static void addUser() {
        try {
            System.out.print("Ім’я користувача: ");
            String name = scanner.nextLine();
            if (name.length() < 5 || name.contains(" ")) {
                throw new Exception("Неправильне ім’я");
            }

            System.out.print("Пароль: ");
            String pass = scanner.nextLine();
            if (pass.length() < 10 || pass.contains(" ")) {
                throw new Exception("Неправильний пароль");
            }

            int count = 0;
            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i] != null) count++;
            }

            if (count >= 15) {
                throw new Exception("Більше не можна додати користувачів");
            }

            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i] == null) {
                    usernames[i] = name;
                    passwords[i] = pass;
                    System.out.println("Користувача додано");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    static void deleteUser() {
        try {
            System.out.print("Ім’я для видалення: ");
            String name = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i] != null && name.equals(usernames[i])) {
                    usernames[i] = null;
                    passwords[i] = null;
                    found = true;
                    System.out.println("Користувача видалено");
                    break;
                }
            }
            if (!found) {
                throw new Exception("Користувача не знайдено");
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    static void loginUser() {
        try {
            System.out.print("Ім’я: ");
            String name = scanner.nextLine();
            System.out.print("Пароль: ");
            String pass = scanner.nextLine();

            boolean ok = false;
            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i] != null && passwords[i] != null) {
                    if (name.equals(usernames[i]) && pass.equals(passwords[i])) {
                        ok = true;
                        break;
                    }
                }
            }

            if (ok) {
                System.out.println("Успішний вхід");
            } else {
                throw new Exception("Невірні дані");
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
