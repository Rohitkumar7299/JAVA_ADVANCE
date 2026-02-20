package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pooling {

        static Connection connection;
        private static List<Connection> pool = new ArrayList<>();

        static {
            try {
                Class.forName("org.postgresql.Driver");
                for (int i = 0; i <= 10; i++) {
                    pool.add( DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_demo?user=postgres&password=123"));
                    //receiveConnection(connection);
                }
                System.out.println("Connection pool created");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static Connection getConnection() {
            if (pool.isEmpty()) create();
                return pool.remove(pool.size() - 1);


        }
            public static void receiveConnection (Connection connection){
                pool.add(connection);

            }
            private static void create () {

                try {
                    //Class.forName("org.postgresql.Driver");
                    for (int i = 0; i <= 5; i++) {
                        pool.add(DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_demo?user=postgres&password=123"));
                        //receiveConnection(connection);
                    }
                    System.out.println("Connection pool created");
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }