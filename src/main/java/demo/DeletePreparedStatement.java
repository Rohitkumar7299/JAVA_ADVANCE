package demo;

import java.sql.*;

public class DeletePreparedStatement {

        private static String url  = "jdbc:postgresql://localhost:5433/jdbc_demo?user=postgres&password=123";
        /*private static String user = "postgres";
        private static String pswd = "123";*/

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver is loaded and registered.");
                Connection connection = DriverManager.getConnection(url);
                System.out.println("connection established");
                //System.out.println(connection);

                String sql = "Delete from connection where id = ?";

                java.sql.PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1,110);

                System.out.println("statement created.");
                int res = st.executeUpdate();
                if (res != 0) {
                    System.out.println("data got deleted");}

                System.out.println("executed");
                st.close();
                connection.close();
                System.out.println("connection destroyed");

            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch(SQLException e){
                e.printStackTrace();
                //throw new RuntimeException(e);
            }}}









