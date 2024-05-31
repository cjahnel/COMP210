package assn07;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();

        String input;

        do {
            System.out.println("Enter Master Password");
            input = scanner.nextLine();
        } while (!passwordManager.checkMasterPassword(input));

        boolean exited = false;

        while (!exited) {
            String command = scanner.nextLine();
            String websiteName;
            String password;
            switch (command) {
                case "New password":
                    websiteName = scanner.nextLine();
                    password = scanner.nextLine();
                    passwordManager.put(websiteName, password);
                    System.out.println("New password added");
                    break;
                case "Get password":
                    websiteName = scanner.nextLine();
                    password = passwordManager.get(websiteName);
                    if (password == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println(password);
                    }
                    break;
                case "Delete account":
                    websiteName = scanner.nextLine();
                    password = passwordManager.remove(websiteName);
                    if (password == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println("Account deleted");
                    }
                    break;
                case "Check duplicate password":
                    password = scanner.nextLine();
                    List<String> duplicates = passwordManager.checkDuplicate(password);
                    if (duplicates.isEmpty()) {
                        System.out.println("No account uses that password");
                    } else {
                        System.out.println("Websites using that password:");
                        for (String duplicate : duplicates) {
                            System.out.println(duplicate);
                        }
                    }
                    break;
                case "Get accounts":
                    System.out.println("Your accounts:");
                    Set<String> accounts = passwordManager.keySet();
                    for (String account : accounts) {
                        System.out.println(account);
                    }
                    break;
                case "Generate random password":
                    int length = scanner.nextInt();
                    scanner.nextLine();
                    String generatedPassword = passwordManager.generatesafeRandomPassword(length);
                    System.out.println(generatedPassword);
                    break;
                case "Exit":
                    exited = true;
                    break;
                default:
                    System.out.println("Command not found");
            }
        }
    }
}
