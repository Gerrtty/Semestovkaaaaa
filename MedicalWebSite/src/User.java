import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class User {
    private int id;
    private String email;
    private String name;
    private String sername;
    private Password password;
    private boolean sex;
    private int phone; // int ?
    private Date birth_date;
    private DataBase dataBase;

    public User(String email,
                String name,
                String sername,
                Password password,
                boolean sex,
                int phone) {

        this.email = email;
        this.name = name;
        this.sername = sername;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
//        this.birth_date = birth_date;

    }


    public void addToDataBase() {
        dataBase = new DataBase();

        String query = "User " + "(email, name, sername, password, sex, phone, birth_date)"  + " values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = dataBase.add(query);
        try {
//            preparedStatement.set
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, sername);
            preparedStatement.setString(4, password.getPassword());
            preparedStatement.setBoolean(5, sex);
            preparedStatement.setInt(6, phone);
//            preparedStatement.setNull(7,);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        preparedStatement.setDate(6, birth_date);



        dataBase.closeConnection();

    }

    private boolean isExsists() {
        return false;
    }
}
