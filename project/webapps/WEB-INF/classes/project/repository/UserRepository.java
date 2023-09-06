package project.repository;

import com.sun.prism.shader.Solid_ImagePattern_Loader;
import jdk.nashorn.internal.parser.JSONParser;
import org.omg.CORBA.SetOverrideType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.StringTokenizer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.soap.SOAPPart;

public class UserRepository {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserRepository() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/student");
        this.connection = dataSource.getConnection();
        this.preparedStatement = null;
        this.resultSet = null;
    }

    public boolean loginAdmin(String id, String password) throws SQLException {
        String sql = "SELECT id, password FROM login WHERE id = ?  AND password = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, id );
        this.preparedStatement.setString(2, password);
        this.resultSet = this.preparedStatement.executeQuery();
        boolean res = this.resultSet.next();
        this.close();
        return res;
    }

    public boolean loginStudent(String id, String password) throws SQLException {
        String sql = "SELECT id, password FROM login WHERE id = ? AND password = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, id );
        this.preparedStatement.setString(2, password);
        this.resultSet = this.preparedStatement.executeQuery();
        boolean res = this.resultSet.next();
        this.close();
        return res;
    }



    public boolean register(String name, String age, String birthdate, String mobile, String email,String dept) throws SQLException {
        String pass ="Aac123@#";
        String sql = "INSERT INTO new_applicant (name, age, birthdate, mobile, email,dept,pass) VALUES (?, ?, ?, ?, ?,?,?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, name);
        this.preparedStatement.setString(2, age);
        this.preparedStatement.setString(3, birthdate);
        this.preparedStatement.setString(4, mobile);
        this.preparedStatement.setString(5, email);
        this.preparedStatement.setString(6, dept);
        this.preparedStatement.setString(7, pass);


        boolean res = this.preparedStatement.executeUpdate() > 0;

        this.close();
        return res;
    }

    public boolean changePassword(String id, String currentPassword, String newPassword) throws SQLException {
        String sql = "UPDATE login SET password = ? WHERE id = ? AND password = ?";
        String sql2 = "UPDATE student_info SET pass = ? WHERE student_id = ?";
        boolean success = false;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, newPassword);
        this.preparedStatement.setString(2, id);
        this.preparedStatement.setString(3, currentPassword);
        int rowsUpdated = this.preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            this.preparedStatement = this.connection.prepareStatement(sql2);
            this.preparedStatement.setString(1, newPassword);
            this.preparedStatement.setString(2, id);
            int rowsUpdated2 = this.preparedStatement.executeUpdate();
            if (rowsUpdated2 > 0) {
                success = true;
            }
        }
        this.close();
        return success;
    }


    public boolean add( String id) throws SQLException {
        String sql = "";
        String email = "";
        String pass="";
        System.out.println("00000000000000000");

        // insert into student_info table
        sql = "INSERT INTO student_info (id, name, age, dept, email, mobile, birthdate, pass) " +
                "SELECT id, name, age, dept, email, mobile, birthdate, pass FROM new_applicant WHERE id = ?";
        System.out.println("00000000000000000");
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, id);
        boolean res = this.preparedStatement.executeUpdate() > 0;

        System.out.println("1111111111111");
        // Get applicant's email and name
        sql = "SELECT email,pass FROM new_applicant WHERE id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, id);
        ResultSet result = this.preparedStatement.executeQuery();
        if (result.next()) {
            email = result.getString("email");
            pass = result.getString("pass");
        }

        // insert into login table
        if (res) {

            sql = "INSERT INTO login (id, email, password) VALUES (?, ?, ?)";
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, id);
            this.preparedStatement.setString(2, email);
            this.preparedStatement.setString(3, pass);
            res = this.preparedStatement.executeUpdate() > 0;
        }



        // delete from new_applicant table

            sql = "DELETE FROM new_applicant WHERE id = ?";
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, id);
            res = this.preparedStatement.executeUpdate() > 0;


        this.close();
        return res;
    }

   /* public boolean add(String id ) throws SQLException {
        String sql = "";


            sql = "INSERT INTO student_info (id, name, age, dept, email, mobile, birthdate) SELECT id, name, age, dept, " +
                    "email, mobile, birthdate FROM new_applicant WHERE id = ?";

            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1, id);


            //sql = "DELETE FROM new_applicant WHERE id = ?";
          //  this.preparedStatement = this.connection.prepareStatement(sql);
           // this.preparedStatement.setString(1, id);
            boolean res = this.preparedStatement.executeUpdate() > 0;
            this.close();
            return res;

    }*/

    public boolean deleteNew(String id) throws SQLException {
        String sql = "";

        sql = "DELETE FROM new_applicant WHERE id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, id);

        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }
    public boolean deleteStudent(String id) throws SQLException {
        String sql = "";

        sql = "DELETE FROM student_info WHERE id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, id);

        boolean res = this.preparedStatement.execute();
        this.close();
        return res;
    }

    public boolean update(String id, String name, String age, String birthdate, String mobile, String email, String dept, String pass) throws SQLException {
        String sql = "UPDATE student_info SET name = ?, age = ?, birthdate = ?, mobile = ?, email = ?, dept = ?, pass = ? WHERE id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, name);
        this.preparedStatement.setString(2, age);
        this.preparedStatement.setString(3, birthdate);
        this.preparedStatement.setString(4, mobile);
        this.preparedStatement.setString(5, email);
        this.preparedStatement.setString(6, dept);
        this.preparedStatement.setString(7, pass);
        this.preparedStatement.setString(8, id);

        boolean res = this.preparedStatement.executeUpdate() > 0;

        this.close();
        return res;
    }

    public boolean updatePassword(String id, String pass) throws SQLException {
        boolean result = false;

        // Update the password in the login table
        String loginSql = "UPDATE login SET password = ? WHERE id = ?";
        this.preparedStatement = this.connection.prepareStatement(loginSql);
        this.preparedStatement.setString(1, pass);
        this.preparedStatement.setString(2, id);
        result = this.preparedStatement.executeUpdate() > 0;
        System.out.println("data");
        if(result){
        // If the ID is less than 1000, update the password in the student_info table
        if (Integer.parseInt(id) < 1000) {
            String studentSql = "UPDATE student_info SET pass = ? WHERE id = ?";
            this.preparedStatement = this.connection.prepareStatement(studentSql);
            this.preparedStatement.setString(1, pass);
            this.preparedStatement.setString(2, id);
            result = this.preparedStatement.executeUpdate() > 0;
        }
        }

        this.close();
        return result;
    }



    public boolean CheckEmailId(String email, String id) throws SQLException {
        String sql = "SELECT id, email FROM login WHERE id = ? AND email = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, id );
        this.preparedStatement.setString(2, email);
        this.resultSet = this.preparedStatement.executeQuery();
        boolean res = this.resultSet.next();
        this.close();
        return res;
    }

    private void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }


}
