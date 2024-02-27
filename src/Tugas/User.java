package Tugas;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class User {
    Scanner input = new Scanner(System.in);

    private boolean admin;
    private int userIndex;
    private Object[][] userDB = {
            // nama user - password - role - status
            { "admin", "admin", 0, true },
            { "202110370311147", "UMM_a2021", 1, true },
            { "202110370311145", "UMM_a2021", 1, false }
    };

    public void login() {

        System.out.println("\n=============================================");
        System.out.println("--          Sistem Akademik UMM            --");
        System.out.println("=============================================\n");

        System.out.print("-> Masukkan username : ");
        String username = input.next();
        System.out.print("-> Masukkan password : ");
        String password = input.next();

        for (userIndex = 0; userIndex < getUserDB().length; userIndex++) {
            // Membandingkan user database dan inputan user
            setUserIndex(userIndex);
            if (username.equals(userDB[getUserIndex()][0]) && password.equals(userDB[getUserIndex()][1])) {
                System.out.println("-> Status username -- " + userDB[getUserIndex()][3]);

                if (isAdmin()) {
                    setAdmin(admin);
                } else {
                    dashboard();
                }
            }
        }

    }

    public void dashboard() {
        System.out.println("\n=============================================");
        System.out.println("-- Sistem Akademik UMM  | Portal Mahasiswa --");
        System.out.println("=============================================\n");

        System.out.println("1.) Update password mahasiswa");
        System.out.println("0.) Logout");
        System.out.print("Pilih menu : ");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                updatePassword();
                break;
            case 0:
                login();
                break;
            default:
                System.out.println("input salah, silahkan coba lagi");
                dashboard();
                break;
        }
    }

    public void updateStatus() {
        System.out.println("\n=============================================");
        System.out.println("--      Portal Admin | Update Status       --");
        System.out.println("=============================================\n");

        System.out.print("Masukkan username : ");
        String userUpdate = input.next();

        for (userIndex = 0; userIndex < userDB.length; userIndex++) {
            setUserIndex(userIndex);
            if (userUpdate.equals(userDB[getUserIndex()][0])) {
                System.out.println("Status mahasiswa :");
                System.out.println("1.) Aktif");
                System.out.println("2.) Tidak aktif");
                System.out.print("Pilih menu : ");
                int choose = input.nextInt();

                switch (choose) {
                    case 1:
                        userDB[getUserIndex()][3] = true;
                        break;
                    case 2:
                        userDB[getUserIndex()][3] = false;
                        break;
                    default:
                        System.out.println("Input salah, silahkan mengulang kembali");
                        updateStatus();
                        break;
                }
                System.out.println("\n--->");
                System.out.println("Status berhasil diupdate !");
                System.out.println("Username : " + userDB[getUserIndex()][0]);
                System.out.println("Status : " + userDB[getUserIndex()][3]);
                login();
            }

        }
        for (int i = 0; i < userDB.length; i++) {
            setUserIndex(i);
            if (!userUpdate.equals(userDB[getUserIndex()][0])) {
                System.out.println("Input salah, silahkan coba lagi !!");
                updateStatus();
            }
        }
    }

    public void updatePassword() {

        String userUpdate;
        String passwordUpdate;

        System.out.println("\n=============================================");
        System.out.println("--     Portal UMM | Update Password      --");
        System.out.println("=============================================\n");

        System.out.print("Masukkan username : ");
        userUpdate = input.next();

        System.out.print("Masukkan password baru : ");
        passwordUpdate = input.next();

        if (isPassDigit(passwordUpdate) && isPassSymbols(passwordUpdate) && isPassUpperCase(passwordUpdate)
                && isPassLowerCase(passwordUpdate)) {
            for (userIndex = 0; userIndex < userDB.length; userIndex++) {
                setUserIndex(userIndex);
                if (userUpdate.equals(userDB[getUserIndex()][0])) {
                    userDB[getUserIndex()][1] = passwordUpdate;

                    System.out.println("\n--->");
                    System.out.println("Password berhasil diupdate");
                    System.out.println("username = " + userDB[getUserIndex()][0]);
                    System.out.println("password = " + userDB[getUserIndex()][1]);
                    login();
                }
            }
        } else {
            System.out.println(
                    "Password harus mengandung digit, simbol, huruf kapital dan kecil. Silahkan mengulang kembali");
            updatePassword();
        }
    }

    public boolean isPassSymbols(String passwordUpdate) {
        String symbols = "!@#$%^&*()_+{}:\"<>?|[]\\;',./`~";

        for (int i = 0; i < passwordUpdate.length(); i++) {
            if (symbols.contains(Character.toString(passwordUpdate.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPassDigit(String passwordUpdate) {

        for (int i = 0; i < passwordUpdate.length(); i++) {
            if (Character.isDigit(passwordUpdate.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPassUpperCase(String passwordUpdate) {

        for (int i = 0; i < passwordUpdate.length(); i++) {
            if (Character.isUpperCase(passwordUpdate.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPassLowerCase(String passwordUpdate) {

        for (int i = 0; i < passwordUpdate.length(); i++) {
            if (Character.isLowerCase(passwordUpdate.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdmin() {
        if (userDB[userIndex][2].equals(0)) {
            return true;
        } else {    
            return false;
        }
    }

    public void setAdmin(boolean admin) {
        System.out.println("\n=============================================");
        System.out.println("--   Sistem Akademik UMM  | Portal Admin   --");
        System.out.println("=============================================\n");

        System.out.println("1.) Update status mahasiswa");
        System.out.println("2.) Update password mahasiswa");
        System.out.println("0.) Logout");
        System.out.print("Pilih menu : ");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                updateStatus();
                break;
            case 2:
                updatePassword();
                break;
            case 0:
                login();
                break;
            default:
                System.out.println("input salah, silahkan coba lagi");
                setAdmin(admin);
                break;
        }
    }

    public int getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(int userIndex) {
        this.userIndex = userIndex;
    }

    public Object[][] getUserDB() {
        return userDB;
    }

    public void setUserDB(Object[][] userDB) {
        this.userDB = userDB;
    }

    public static void main(String[] args) {
        User user = new User();
        user.login();
    }
}

class Anjay{
    private Calendar kalender = Calendar.getInstance();
    void mamam(){
        kalender.set(0, 0, 0);
        Date expired0 = kalender.getTime();
        kalender.set(1, 0, 0);
        Date expired1 = kalender.getTime();
        Date now = new Date();
        Date[] valiDates = {expired0, expired1};
        Boolean compare = valiDates[1].after(now);
        
    }
}