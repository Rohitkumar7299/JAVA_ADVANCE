import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update {
        private static String url  = "jdbc:postgresql://localhost:5433/jdbc_demo";
        private static String user = "postgres";
        private static String pswd = "123";

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver is loaded and registered.");
                Connection connection =  DriverManager.getConnection(url,user,pswd);
                System.out.println("connection established");
                System.out.println(connection);
                String sql = "update connection set name = 'sonali' where id=106";
                Statement st = connection.createStatement();
                System.out.println("statement created.");
                st.execute(sql);
                System.out.println("executed");
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

