
package com.company;
import java.sql.*;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 *
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class JavaMysqlSelectExample
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.1.10/feedback";

    //  Database credentials

    static final String USER = "sqluser";
    static final String PASS = "sqluserpw";

    public static void main(String[] args)
    {
        // Connection conn = null;
        Statement  stmt = null;
        try
        {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date dateCreated = rs.getDate("date_created");
                boolean isAdmin = rs.getBoolean("is_admin");
                int numPoints = rs.getInt("num_points");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}