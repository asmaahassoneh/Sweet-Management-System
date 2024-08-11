package production_cods;

import com.example.asmaasweet.User;

import java.io.*;
import java.util.Vector;

public class MANAGE_AccSource {
    private final Vector<User> PullUser = new Vector<>();
    private boolean UserFound=false;
    private final boolean UserDelete=false;
private  boolean ValidINput=false;
    private  boolean EmailUpdated=false;
    private  boolean CityUpdated=false;
    SignupSource sign=new SignupSource();
    public Vector<User> PullTheUsersFromFile() {
        String filePath = "Accounts.txt";
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        User user = new User(parts[0], parts[1], parts[2], parts[3],null, parts[4]);
                        PullUser.add(user);
                    }
                    UserFound=true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PullUser;
    }

    public void ADDNewAccount(String User_name, String City, String Email, String Pass, String Role)
    {
    ValidINput=sign.validUserInputData(User_name,City,Email,Pass,Pass);

    if(ValidINput)
    {
        sign.SetanAccount(User_name,City,Email,Pass,Pass,Role);
    }
    }

    public boolean isValidINput() {
        return ValidINput;
    }

    public int getCheckDelete() {
        return checkDelete;
    }

    public void setCheckDelete(int checkDelete) {
        this.checkDelete = checkDelete;
    }

    private int checkDelete = 0;
    public boolean DeleteUser(String password) {
        String filePath = "Accounts.txt";
        File file = new File(filePath);

        StringBuilder contentBuilder = new StringBuilder();

        // Read the file and build the content without the line containing the search string
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the search string
                if (line.contains(password)) {
                    UserFound = true;
                } else {
                    contentBuilder.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            setCheckDelete(0);
            return false;
        }

        // Write the modified content back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            setCheckDelete(0);
            return false;
        }
        setCheckDelete(1);
        return UserFound;
    }

    public int getCheckUpdatedEmail() {
        return checkUpdatedEmail;
    }

    public void setCheckUpdatedEmail(int checkUpdatedEmail) {
        this.checkUpdatedEmail = checkUpdatedEmail;
    }

    private int checkUpdatedEmail = 0;
    public boolean UpdateEmail(String Email,String User_name,String Role,String City, String pass) {

        String filePath = "Accounts.txt";
        File file = new File(filePath);

        EmailUpdated = false;
        StringBuilder contentBuilder = new StringBuilder();

        // Read the file and build the updated content
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pass)) {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        parts[0]=User_name;
                        parts[1]=City;
                        parts[2]=Email;
                        parts[3]=pass;
                        parts[4] = Role;
                        line = String.join(",", parts); // Update the line with the new email
                    }
                    EmailUpdated = true;
                    setCheckUpdatedEmail(1);
                }
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
            setCheckUpdatedEmail(0);
            return false;
        }

        // Write the updated content back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            setCheckUpdatedEmail(0);
            return false;
        }
        setCheckUpdatedEmail(1);
        return EmailUpdated;
    }




    private int checkUpdateCity = 0;

    public int getCheckUpdateCity() {
        return checkUpdateCity;
    }

    public void setCheckUpdateCity(int checkUpdateCity) {
        this.checkUpdateCity = checkUpdateCity;
    }

    // Method to update the city for the user based on their password
    public boolean CityUpdate(String City, String pass) {
        String filePath = "Accounts.txt";
        File file = new File(filePath);

        CityUpdated = false;
        StringBuilder contentBuilder = new StringBuilder();

        // Read the file and build the updated content
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pass)) {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        parts[1] = City;
                        line = String.join(",", parts); // Update the line with the new city
                    }
                    CityUpdated = true;
                    setCheckUpdateCity(1);
                }
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
            setCheckUpdateCity(0);
            return false;
        }

        // Write the updated content back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            setCheckUpdateCity(0);
            return false;
        }

        setCheckUpdateCity(1);
        return CityUpdated;
    }
}
