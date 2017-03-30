/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

/**
 *
 * @author Damian Stępniak
 */
public abstract class ParametrDatabase {
    
    protected String driver;
    protected String username;
    protected String password;
    protected String url;

    public ParametrDatabase(String driver, String username, String password, String url) {
        this.driver = driver;
        this.username = username;
        this.password = password;
        this.url = url;
    }
}
