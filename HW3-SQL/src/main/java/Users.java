public class Users {

    private int id;
    private String username;
    private String user_password;
    private String email_address;
    private int age;


    public Users(int id, String username, String user_password, String email_address, int age) {
        this.id = id;
        this.username = username;
        this.user_password = user_password;
        this.email_address = email_address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", email_address='" + email_address + '\'' +
                ", age=" + age +
                '}';
    }
}
