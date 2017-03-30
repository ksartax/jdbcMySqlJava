/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.LinkedList;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Damian Stępniak
 */
public interface ConnectDatabaseInpl<T> {
    public void connect() throws SQLException;
    public void close() throws SQLException;
    public Statement getStatement() throws SQLException;
    public ResultSet select(String query) throws SQLException;
    public boolean delete(String query) throws SQLException;
    public T update(String query) throws SQLException;
    public T create(String query) throws SQLException;
    public void transaction();
}
