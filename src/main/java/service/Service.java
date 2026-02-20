package service;

import entity.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service{
    private static Connection connection;
    private static String url  = "jdbc:postgresql://localhost:5433/jdbc_demo?user=postgres&password=123";
static {
    try{
        Class.forName("org.postgresql.Driver");
        //connection= DriverManager.getConnection(url);
         connection = Pooling.getConnection();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    //catch (SQLException e) {e.printStackTrace();

    //}
}
public int save(Entity st){
    int res=0;
    String sql = "insert into connection values (?,?,?)";
    try{
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1,st.getId());
        pstm.setString(2,st.getName());
        pstm.setInt(3,st.getAge());
        res= pstm.executeUpdate();}
    catch (SQLException e) {e.printStackTrace();

    }return res;
}
public static int update(Entity st){
    int res = 0;
    String sql = "update connection set name = ? where id=? ";
try{
    PreparedStatement pstm = connection.prepareStatement(sql);
    pstm.setString(1, st.getName());
    pstm.setInt(2,st.getAge());
    pstm.setInt(2,st.getId());
    res= pstm.executeUpdate();
} catch (SQLException e) {e.printStackTrace();

}
return res;

}
//public  void fetch()  {
//    String sql = "SELECT *FROM connection";
//    try {
//        PreparedStatement pstm= connection.prepareStatement(sql);
//        ResultSet rs= pstm.executeQuery();
//        while (rs.next()){
//            System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3));
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//}
    public List<Entity> fetch(){
        String sql = "select * from connection";
        List<Entity> list = new ArrayList<>();


        try {
        Statement   st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                list.add(new Entity(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
public static int delete(int id)  {
    int res = 0;
    String sql = "delete from connection where id =?";
    try{
    PreparedStatement pstm = connection.prepareStatement(sql);
    pstm.setInt(1,id);
    res=pstm.executeUpdate();

} catch (SQLException e) {
        e.printStackTrace();
    }
    return  res;


    }
}