package production_cods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.*;


public class LoginSource {
    private static final Logger logger =  Logger.getLogger(LoginSource.class.getName());
    boolean found = false;
    boolean scenario;
    boolean passFound =false;
    String workRole;
    private int checkValid = 0;

    public int getCheckValid() {
        return checkValid;
    }

    public void setCheckValid(int checkValid) {
        this.checkValid = checkValid;
    }

    public void checkLoginValidInFile(String userName, String pass) {
        String filePath = "Accounts.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if ((parts.length >= 4) && (parts[0].equals(userName))) {
                        found = true;
                        if (parts[3].equals(pass)) {
                            passFound = true;
                            setCheckValid(1);
                        }
                        workRole =parts[4];
                        break;
                }
            }
            scenario = found && passFound;
            if (scenario){
                setCheckValid(1);
            }else{
                setCheckValid(0);
            }


        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }


    public  boolean getFoundAccount()
    {
        return scenario;
    }
}