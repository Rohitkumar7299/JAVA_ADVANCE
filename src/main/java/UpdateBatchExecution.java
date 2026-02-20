import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBatchExecution {

        private static String url  = "jdbc:postgresql://localhost:5433/jdbc_demo?user=postgres&password=123";
        /*private static String user = "postgres";
        private static String pswd = "123";*/

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver is loaded and registered.");
                Connection connection = DriverManager.getConnection(url);
                System.out.println("connection established");

                String sql = "update connection set name = ? where id=? ";

                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1,"ROHAN");
                st.setInt(2,102);

                st.addBatch();
                st.setString(1,"PRANIT");
                st.setInt(2,104);

                st.addBatch();
                st.setString(1,"AMAN");
                st.setInt(2,103);

                st.addBatch();
                System.out.println("statement created.");
                int[] res = st.executeBatch();
                for (int i = 0; i <res.length; i++) {
                    System.out.println(res[i]);

                }


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








