package production_cods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginSource {



    boolean found = false;
    boolean senario;
    boolean  passfound=false;




    public void CheckLoginVaildinFile(String UserName, String pass) {
        // Specify the file name and path
        String filePath = "Accounts.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line by commas
                String[] parts = line.split(",");
                // Check if the line has the correct number of parts
                if (parts.length >= 3) {

                    // Check if the username matches and if the password matches the username
                    if (parts[0].equals(UserName)) {
                        found = true;

                        if (parts[2].equals(pass)) {
                            passfound = true;

                        }

                        break;
                    }

                }
            }

                if (found && passfound) {
                    senario = true;
                } else {
                    senario = false; // Reset to false if either check fails
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public  boolean getFoundaccount()
    {
//System.out.println(senario);
        return senario;
    }










}
