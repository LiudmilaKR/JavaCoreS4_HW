package ru.gb.lesson4.task4;

public class Program {
//    Проверка логина и пароля
    public static void main(String[] args) {
        String[][] credentials = {
                {"ivan", "1i2v3a4n5i6v7a8n91011", "1i2v3a4n5i6v7a8n91011"}, //correct
                {"1i2v3a4n5i6v7a8n91011", "", ""}, //wrong login length
                {"ivan", "1i2v3a4n5i6v7a8n91011", "1i2v3a4n5"}, //confirm mismatch
                {"ivan", "1i2v3a4n5", "1i2v3a4n5"},//wrong password length
                {"ivan", "1i2v3a4n5", "1i"} //wrong password length and confirm mismatch
                };
        for (int i = 0; i < credentials.length; i++) {
            try {
                System.out.println(checkCredentials(credentials[i][0], credentials[i][1], credentials[i][2]));
            } catch (WrongLoginException e) {
                e.printStackTrace();
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        boolean conf = password.equals(confirmPassword);
        int llen = login.length();
        int plen = password.length();
        if (llen >= 20) throw new WrongLoginException(llen);
        else if (plen < 20 || !conf) throw new WrongPasswordException(plen, conf);
        else return true;
    }
}
