package production_cods;
import java.io.*;

public class ManageAccountSource {
    private boolean userFound =false;
    private  boolean validInput =false;
    public static final String ACCOUNTS_TXT = "Accounts.txt";
    SignupSource sign=new SignupSource();

    public void addNewAccount(String userName, String city, String email, String pass, String role)
    {
        validInput =sign.validUserInputData(userName,email,pass,pass);

        if(validInput){
            sign.setAnAccount(userName,city,email,pass,role);
        }
    }

    public boolean isValidInput() {
        return validInput;
    }

    public int getCheckDelete() {
        return checkDelete;
    }

    public void setCheckDelete(int checkDelete) {
        this.checkDelete = checkDelete;
    }

    private int checkDelete = 0;
    public boolean deleteUser(String password) {
        File file = new File(ACCOUNTS_TXT);

        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(password)) {userFound = true;
                } else {
                    contentBuilder.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {return false;
        }
        setCheckDelete(1);
        return userFound;
    }

    public int getCheckUpdatedEmail() {
        return checkUpdatedEmail;
    }

    public void setCheckUpdatedEmail(int checkUpdatedEmail) {
        this.checkUpdatedEmail = checkUpdatedEmail;
    }

    private int checkUpdatedEmail = 0;
    public boolean updateEmail(String email, String userName, String role, String city, String pass) {
        File file = new File(ACCOUNTS_TXT);

        boolean emailUpdated = false;
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pass)) {
                    String[] parts = line.split(",");if (parts.length == 5) {
                        parts[0]=userName;parts[1]=city;parts[2]=email;parts[3]=pass;parts[4] = role;line = String.join(",", parts);
                    }emailUpdated = true;setCheckUpdatedEmail(1);
                }
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {return false;
        }
        setCheckUpdatedEmail(1);
        return emailUpdated;
    }

    private int checkUpdateCity = 0;

    public int getCheckUpdateCity() {
        return checkUpdateCity;
    }

    public void setCheckUpdateCity(int checkUpdateCity) {
        this.checkUpdateCity = checkUpdateCity;
    }

    public boolean cityUpdate(String city, String pass) {
        File file = new File(ACCOUNTS_TXT);

        boolean cityUpdated = false;
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pass)) {
                    String[] parts = line.split(",");if (parts.length == 5) {parts[1] = city;line = String.join(",", parts); // Update the line with the new city
                    }
                    cityUpdated = true;setCheckUpdateCity(1);
                }
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {return false;
        }

        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        setCheckUpdateCity(1);
        return cityUpdated;
    }
}
