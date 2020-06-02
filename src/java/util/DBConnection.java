
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mehme
 */
public abstract class DBConnection {

    private Connection connection;

    public Connection connect() throws SQLException, InstantiationException, IllegalAccessException {
        if (this.connection == null || this.connection.isClosed()) {

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                 this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oemheidi", "root", "123");
                //Class.forName("org.postgresql.Driver");
                //this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oem", "postgres", "123");
            } catch (ClassNotFoundException | SQLException e) {

                System.out.println(e.getMessage());

            }
        }

        return this.connection;
    }

}
