package production_cods;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class SignupSource {
    private static final Logger logger = Logger.getLogger(SignupSource.class.getName());
    private final ArrayList<User> user = new ArrayList<>();
    private boolean passRepeated;
    private int checkRepeated = 0;

    public int getCheckRepeated() {
        return checkRepeated;
    }

    public void setCheckRepeated(int checkRepeated) {
        this.checkRepeated = checkRepeated;
    }

    public void setAnAccount(String username, String city, String email, String password, String role) {
        checkForRepeatedPass(password);
        if (!getRepeatedPass()) {
            setCheckRepeated(1);
            user.add(new User(username, city, email, password, role));
        } else {
            setCheckRepeated(0);
        }
    }

    public boolean validUserInputData(String username, String email, String password, String confirmPass) {
        return isValidUsername(username) && isValidEmail(email) && isValidPassword(password, confirmPass);
    }

    private boolean isValidUsername(String username) {
        String usernameRegex = "[A-Z][a-zA-Z0-9]{0,15}";
        return Pattern.matches(usernameRegex, username);
    }

    private boolean isValidEmail(String email) {
        if (!email.endsWith("@gmail.com")) return false;
        String emailPrefix = email.substring(0, email.indexOf("@gmail.com"));
        return emailPrefix.length() >= 4;
    }

    private boolean isValidPassword(String password, String confirmPass) {
        if (password.length() > 10) return false;
        boolean containsLetter = password.chars().anyMatch(Character::isLetter);
        return containsLetter && password.equals(confirmPass);
    }

    public boolean isValidRole(String role) {
        String[] validRoles = {"Admin", "user", "raw material provider", "store owner", "dashboard"};
        for (String validRole : validRoles) {
            if (validRole.equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }

    public boolean emailUsed(String email) {
        return user.stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
    }

    public void checkForRepeatedPass(String pass) {
        boolean passFound;
        passFound = readAccountsFromFile().stream()
                .anyMatch(parts -> parts.length >= 4 && parts[3].equals(pass));
        passRepeated = passFound;
    }

    public boolean getRepeatedPass() {
        return passRepeated;
    }

    private List<String[]> readAccountsFromFile() {
        List<String[]> accounts = new ArrayList<>();
        String filePath = "Accounts.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                accounts.add(line.split(","));
            }
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }
        return accounts;
    }
}
