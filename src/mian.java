
import connect.ConnectDatabase;
import connect.ConnectDatabaseInpl;
import connect.loadConfig;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Damian Stępniak
 */
public class mian {

    public static void main(String[] args) throws IOException, SQLException {
        loadConfig config = new loadConfig();
        config.load("configuration.properties");
        ConnectDatabaseInpl connectDatabaseInpl = new ConnectDatabase(
                config.getProp().getProperty("jdbc.driver"), 
                config.getProp().getProperty("jdbc.username"), 
                config.getProp().getProperty("jdbc.password"), 
                config.getProp().getProperty("jdbc.url")
        );
        
        connectDatabaseInpl.connect();
        //connectDatabaseInpl.create("Insert into user values(null,'Damian','Seba')");
        //ResultSet rs = connectDatabaseInpl.select("Select * from user");
        //while (rs.next()) {            
            //System.out.println(rs.getString(1));
        //}
        //connectDatabaseInpl.update("update user set firstName = 'S' where id_user=2");
        connectDatabaseInpl.transaction();
    }

}
