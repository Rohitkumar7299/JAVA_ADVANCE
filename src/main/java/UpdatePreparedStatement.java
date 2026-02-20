import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdatePreparedStatement {
        private static String url  = "jdbc:postgresql://localhost:5433/jdbc_demo?user=postgres&password=123";
        /*private static String user = "postgres";
        private static String pswd = "123";*/

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver is loaded and registered.");
                Connection connection = DriverManager.getConnection(url);
                System.out.println("connection established");
                System.out.println(connection);

                String sql = "update connection set name = ? where id = ?";

                java.sql.PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1,"aman");
                st.setInt(2,105);
                //st.setInt(3,15);
                System.out.println("statement created.");
                int res = st.executeUpdate();
                if (res != 0) {
                    System.out.println("data got updated");}

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
            }

        }}







