package production_cods;

public class User {

    private String UserName;
    private String Email;
    private String PassWord;
    private  String role;
private  String confirmPAss;


    public User(String userName, String email, String passWord, String ConfirmPass ,String role) {
        UserName = userName;
        Email = email;
        PassWord = passWord;
        this.role = role;
        confirmPAss=ConfirmPass;
    }

    public String getConfirmPAss() {
        return confirmPAss;
    }

    public void setConfirmPAss(String confirmPAss) {
        this.confirmPAss = confirmPAss;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  "UserName:"+getUserName()+"  "+"Email"+getEmail();
    }
}
