package production_cods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginSource {
    boolean found = false;
    boolean senario;
    boolean passFound =false;
    String workRole;
    private int checkValid = 0;

    public int getCheckValid() {
        return checkValid;
    }

    public void setCheckValid(int checkValid) {
        this.checkValid = checkValid;
    }

    public void checkLoginValidInFile(String UserName, String pass) {
        String filePath = "Accounts.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    if (parts[0].equals(UserName)) {
                        found = true;

                        if (parts[3].equals(pass)) {
                            passFound = true;
                            setCheckValid(1);
                        }

                        workRole =parts[4];
                        break;
                    }

                }
            }
            senario = found && passFound;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWorkRole() {
        return workRole;
    }

    public  boolean getFoundAccount()
    {
        return senario;
    }











}
//package production_cods;
//
//import java.io.BufferedReader;
//        import java.io.FileReader;
//        import java.io.IOException;
//
//public class LoginSource {
//    private boolean found = false;
//    private boolean passFound = false;
//    private String workRole;
//
//    public boolean checkLoginValidInFile(String userName, String pass) {
//        if (userName == null || pass == null) {
//            return false;
//        }
//
//        String filePath = "Accounts.txt";
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length >= 4) {
//                    if (parts[0].equals(userName)) {
//                        found = true;
//
//                        if (parts[3].equals(pass)) {
//                            passFound = true;
//                            workRole = parts[4];
//                            return true;
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public String getWorkRole() {
//        return workRole;
//    }
//}
