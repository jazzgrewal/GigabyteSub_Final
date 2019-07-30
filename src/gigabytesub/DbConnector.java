
package gigabytesub;

import java.sql.*;

public class DbConnector {
    Connection conn = null;

    public static Connection ConnectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver"); //register jdbc driver
            //specifying URL
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jazz_gym3", "root", "");
            //returning the connection
            return conn;

        } catch (Exception e) {
           //default condition no error display
            return null;
        }

    }
}
