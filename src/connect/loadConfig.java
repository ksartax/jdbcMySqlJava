/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author Damian Stępniak
 */
public class loadConfig {

    private Properties props;

    public loadConfig() {
       props = new Properties();
    }

    public void load(String text) throws IOException {
        Path p = Paths.get(text);
        try (InputStream in = Files.newInputStream(p)) {
            props.load(in);
        }
    }

    public Properties getProp() {
        if (props == null) {
            throw new NullPointerException();
        }
        return props;
    }

}
