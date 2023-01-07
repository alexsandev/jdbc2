package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {
    public static void main(String[] args){
        Statement st = null;
        ResultSet rs = null;
        try{
            st = DB.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM  department");
            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DB.closeConnection();
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
