package demo;

import java.sql.*;

public class SelectQueries  {
    private static String url  = "jdbc:postgresql://localhost:5433/jdbc_demo";
    private static String user = "postgres";
    private static String pswd = "123";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver is loaded and registered.");
            Connection connection =  DriverManager.getConnection(url,user,pswd);
            System.out.println("connection established");
            String sql = "SELECT * FROM connection";
           // String sql1 = "delete from connection where id = 109";
            Statement st = connection.createStatement();
            System.out.println("statement created.");
           ResultSet res =st.executeQuery(sql);
           while(res.next()){
               System.out.println(res.getInt(1));
               System.out.println(res.getString(2));
               System.out.println(res.getInt(3));
           }
           st.executeQuery(sql);
            st.close();
            connection.close();
            System.out.println("connection destroyed");

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }
}

