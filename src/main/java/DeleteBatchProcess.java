import java.sql.*;
public class DeleteBatchProcess {
        private static String url  = "jdbc:postgresql://localhost:5433/jdbc_demo?user=postgres&password=123";
        /*private static String user = "postgres";
        private static String pswd = "123";*/

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver is loaded and registered.");
                Connection connection = DriverManager.getConnection(url);
                System.out.println("connection established");

                String sql = "Delete from connection where id = ?";

                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1,107);

                st.addBatch();
                st.setInt(1,106);

                st.addBatch();
                st.setInt(1,105);
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








