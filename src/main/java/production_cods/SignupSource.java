package production_cods;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
import java.util.Vector;

import com.example.najehfxsoftware.LoginPageControl;

import javax.swing.*;
/*
  // Validate Username
    // (1) The first letter must be capitalized
    // (2) The username should not contain spaces
    // (3) The maximum length of the username should be 16 characters


 // Validate Email
    // (1) Email must end with "@gmail.com"
    // (2) There must be at least 4 characters before "@gmail.com"



  // Validate Password
    // (1) Password must be at most 10 characters long
    // (2) Password must contain at least one letter

 */

public class SignupSource {

LoginPageControl log=new LoginPageControl();

private  boolean EmailTest;
    private Vector<User> user = new Vector<>();

    String[] reson = new String[10];
    String[]temp=new String[10];

    boolean found = false;

    boolean  passfound=false;




    boolean passRepated;

    public void SetanAccount(String username, String email, String password, String confirmPass,String role)
    {
        User newUserAccount=new User(username,email,password,confirmPass,role);

        user.add(newUserAccount);
        checkForRepatedpass(password);
        if(getRepatedpass()==false) {//measn that the pass word that the user entered not repated
            SetaccountTFile();
            JOptionPane.showMessageDialog(null,"You have been Successfully Create your account  ");
        }
        else {
            JOptionPane.showMessageDialog(null,"please use Another passWord");
        }
    }


    public boolean validUserInputData(String username, String email, String password, String confirmPass) {


        String usernameRegex = "[A-Z][a-zA-Z0-9]{0,15}";
        Pattern usernamePattern = Pattern.compile(usernameRegex);
        Matcher usernameMatcher = usernamePattern.matcher(username);
        if (!usernameMatcher.matches()) {

            JOptionPane.showMessageDialog(null,"Username is invalid"," Error",JOptionPane.ERROR_MESSAGE);
            return false; // Username is invalid
        }
        // Validate Email
        if (!email.endsWith("@gmail.com")) {

            JOptionPane.showMessageDialog(null,"Email must end with @gmail.com"," Error",JOptionPane.ERROR_MESSAGE);
            return false; // Email must end with @gmail.com
        }
        String emailPrefix = email.substring(0, email.indexOf("@gmail.com"));
        if (emailPrefix.length() < 4) {

            JOptionPane.showMessageDialog(null,"Email prefix must be at least 4 characters long"," Error",JOptionPane.ERROR_MESSAGE);
            return false; // Email prefix must be at least 4 characters long
        }

        // Validate Password
        if (password.length() > 10) {

            JOptionPane.showMessageDialog(null,"Password must be at most 10 characters long"," Error",JOptionPane.ERROR_MESSAGE);
            return false; // Password must be at most 10 characters long
        }
        boolean containsLetter = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                containsLetter = true;
                break;
            }
        }
        if (!containsLetter) {

            JOptionPane.showMessageDialog(null,"Password must contain at least one letter"," Error",JOptionPane.ERROR_MESSAGE);
            return false; // Password must contain at least one letter
        }

        // Confirm Password
        if (!password.equals(confirmPass)) {

            JOptionPane.showMessageDialog(null,"Passwords do not match"," Error",JOptionPane.ERROR_MESSAGE);
            return false; // Passwords do not match
        }

        // All validations passed
        return true;
    }

    public boolean isValidRole(String role) {
        // Define the valid roles
        String[] validRoles = {"Admin", "user", "raw material provider", "store owner", "dashboard"};

        // Check if the input role matches any of the valid roles
        for (String validRole : validRoles) {
            if (validRole.equalsIgnoreCase(role)) {
                return true; // Role is valid
            }
        }

        return false; // Role is invalid
    }


public  boolean Emailused(String email)
{
    for(int i=0; i<user.size();i++)
    {
System.out.println(user.get(i));
       EmailTest  = user.get(i).getEmail().equalsIgnoreCase(email);
       if (EmailTest==true)

           break;


    }



    return EmailTest;

}










public void SetaccountTFile()
{
    String filePath = "Accounts.txt";
    File file = new File(filePath);

    // Use try-with-resources to ensure the file is closed properly
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

        for(int i=0;i< user.size();i++) {
            writer.write(user.get(i).getUserName()+","+user.get(i).getEmail()
                    +","+user.get(i).getPassWord()+","+user.get(i).getRole());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public void checkForRepatedpass(String pass) {
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
                if (parts[2].equals(pass)) {
                    passfound = true;
                }
                break;
            }
        }
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }

    if (passfound) {
        passRepated = true;
    } else {
        passRepated = false; // Reset to false if either check fails
    }

}




public  boolean getRepatedpass()
{

    return passRepated;
}









}









