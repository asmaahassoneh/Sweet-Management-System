package production_cods;

public class User {
    private String userName;
    public String email;
    private String passWord;
    private  String role;
    private  String city;

    public String getCity() {
        return city;
    }
    public User(String userName,String city, String email, String passWord ,String role) {
        this.userName = userName;
        this.city =city;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }



    public String getPassWord() {
        return passWord;
    }
    public String getRole() {
        return role;
    }

}
