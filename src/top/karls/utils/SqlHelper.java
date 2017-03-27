package top.karls.utils;

/**
 * Created by karlind on 9/25/16.
 */
import java.sql.*;

public class SqlHelper {
    private static String url = "jdbc:mysql://localhost:3306/mockzhihu";
    private static String user = "mockzhihu";
    private static String password = "123456789";

    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection succeed.");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection fail!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return con;
    }

    // Get item amount by passing a type
    // type represents:
    //      1: question
    //      2: answer
    public static int getItemAmount(int type){
        if(type<1 || type>2){
            return -1;
        }
        String sql = "select count(id) as amount from "+(type==1?"question":"answer");
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt("amount");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
