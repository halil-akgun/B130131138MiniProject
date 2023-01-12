package loginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> userNames = new ArrayList<>();

    List<String> emails = new ArrayList<>();

    List<String> passwords = new ArrayList<>();

    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.println("ad-soyad girin:");
        String name = input.nextLine();
        String userName;
        boolean existUsername;
        do {
            System.out.println("kullanıcı ad girin:");
            userName = input.nextLine();
            existUsername = this.userNames.contains(userName);
            if (existUsername) {
                System.out.println("bu username kullanılmış. başka bir username deneyin.");
            }
        } while (existUsername);

        String email;
        boolean existEmail;
        boolean isValid;
        do {
            System.out.println("email girin:");
            email = input.nextLine().trim();
            isValid = validateEmail(email);
            existEmail = this.emails.contains(email);
            if (existEmail) {
                System.out.println("bu email kullanılmış. başka bir email deneyin.");
                isValid = false;
            }
        } while (!isValid);

        String password;
        boolean isValidPassword;
        do {
            System.out.println("şifrenizi girin:");
            password = input.next().trim();
            isValidPassword = validatePassword(password);
        } while (!isValidPassword);

        User user1 = new User(name, userName, email, password);

        this.userNames.add(user1.userName);
        this.emails.add(user1.email);
        this.passwords.add(user1.password);
        System.out.println("işlem başarılı.");
        System.out.println("username veya email ile sisteme giriş yapabilirsiniz");

    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("kullanıcı adı veya email girin:");
        String userNameOrEmail = input.next();

        boolean isUserName = this.userNames.contains(userNameOrEmail);
        boolean isEmail = this.emails.contains(userNameOrEmail);

        if (isUserName || isEmail) {
            boolean isWrong = true;
            while (isWrong) {
                System.out.println("şifrenizi girin:");
                String password = input.next();
                int index;
                if (isUserName) {
                    index = this.userNames.indexOf(userNameOrEmail);
                } else {
                    index = this.emails.indexOf(userNameOrEmail);
                }
                if (this.passwords.get(index).equals(password)) {
                    System.out.println("giriş başarılı.");
                    isWrong = false;
                } else {
                    System.out.println("şifre hatalı.");
                }
            }
        } else {
            System.out.println("kullanıcı bulunamadı.");
        }
    }

    public boolean validateEmail(String email) {
        boolean isValid;
        boolean space = email.contains(" ");
        boolean isContainsAt = email.contains("@");
        if (space) {
            System.out.println("email boşluk içeremez.");
            isValid = false;
        }
        if (!isContainsAt) {
            System.out.println("email @ sembolü içermelidir.");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            int notValid = firstPart.replaceAll("[A-Za-z0-9-_.]", "").length();
            boolean checkStart = notValid == 0;

            boolean checkEnd = secondPart.equals("google.com") ||
                    secondPart.equals("yahoo.com") ||
                    secondPart.equals("hotmail.com");

            if (!checkStart)
                System.out.println("email kullanıcı adı büyük-küçük harf, rakam, -._ dışında karakter içeremez.");
            if (!checkEnd) System.out.println("email google.com, yahoo.com veya hotmail.com ile bitmeli");
            isValid = checkStart && checkEnd;
        }
        if (!isValid) System.out.println("geçersiz email, tekrar deneyin.");
        return isValid;
    }

    public boolean validatePassword(String password) {
        boolean isValid;
        String upperLetter = password.replaceAll("[^A-Z]", "");
        String lowerLetter = password.replaceAll("[^a-z]", "");
        String digit = password.replaceAll("[\\D]", "");
        String symbol = password.replaceAll("[\\P{Punct}]", ""); // P semboller dışındakiler
        boolean space = password.contains(" ");
        boolean lengthGt6 = password.length() >= 6;
        boolean existsUpper = upperLetter.length() > 0;
        boolean existsLower = lowerLetter.length() > 0;
        boolean existsDigit = digit.length() > 0;
        boolean existsSymbol = symbol.length() > 0;

        if (space) System.out.println("şifre boşluk içeremez");
        if (!lengthGt6) System.out.println("şifre en az 6 karakterli olmalı");
        if (!existsUpper) System.out.println("şifre en az 1 tane büyük harf içermeli");
        if (!existsLower) System.out.println("şifre en az 1 tane küçük harf içermeli");
        if (!existsDigit) System.out.println("şifre en az 1 tane rakam içermeli");
        if (!existsSymbol) System.out.println("şifre en az 1 tane sembol içermeli");

        isValid = !space && lengthGt6 && existsUpper && existsLower && existsDigit && existsSymbol;
        if (!isValid) System.out.println("geçersiz password, tekrar deneyin.");

        return isValid;
    }

}
