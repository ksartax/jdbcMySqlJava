/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Stępniak
 */
public class ConnectDatabase extends ParametrDatabase implements ConnectDatabaseInpl {

    protected Statement stat;
    protected Connection conn;

    public ConnectDatabase(String driver, String username, String password, String url) throws SQLException {
        super(driver, username, password, url);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(super.url, super.username, super.password);
    }

    @Override
    public void connect() throws SQLException {
        conn = getConnection();
        stat = conn.createStatement();
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }

    @Override
    public Statement getStatement() throws SQLException {
        if (conn == null) {
            throw new SQLException();
        }
        return stat;
    }

    @Override
    public ResultSet select(String query) throws SQLException {
        return stat.executeQuery(query);
    }

    @Override
    public boolean delete(String query) throws SQLException {
        stat.executeUpdate(query);
        System.out.println(stat.getResultSet());
        return true;
    }

    @Override
    public Object update(String query) throws SQLException {
        return stat.executeUpdate(query);
    }

    @Override
    public Object create(String query) throws SQLException {
        return stat.executeUpdate(query);
    }

    // PreparedStatement stat1 = conn.prepareStatement("Insert into user vales(null, ?, ?)");
    // stat1.setString(1, firstName);
    // stat1.setString(2, LastName);
    // ResultSet rs = stat1.executeQuery();
    @Override
    public void transaction() {
        try {
            conn.setAutoCommit(false);
            stat.executeUpdate("Insert into user values(null,'Damian21','Seba1')");
            Savepoint svp = conn.setSavepoint();
            stat.executeUpdate("Insert into user values(null,'Damian2','Seba2')");
            conn.rollback(svp);
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
