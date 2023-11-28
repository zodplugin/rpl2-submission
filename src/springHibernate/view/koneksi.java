package springHibernate.view;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author Zeqeela
 */
public class koneksi {
    static Connection c;
    
    public static Connection connection() throws SQLException{
        if(c == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_praktikum");
            data.setUser("root");
            data.setPassword("");
            
            try{
                c = data.getConnection();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return c;
    }
}
    

