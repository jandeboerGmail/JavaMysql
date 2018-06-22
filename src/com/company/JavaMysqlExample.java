
package com.company;
import java.sql.*;
//import org.json.simple.JSONObject;



/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 *
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class JavaMysqlExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.1.10/feedback";

    //  Database credentials

    static final String USER = "sqluser";
    static final String PASS = "sqluserpw";

    private static void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
        }
    }

    private static void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    /*

    private static void TestJSON() {
        JSONParser parser = new JSONParser();
        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

        try{
            Object obj = parser.parse(s);
            JSONArray array = (JSONArray)obj;

            System.out.println("The 2nd element of array");
            System.out.println(array.get(1));
            System.out.println();

            JSONObject obj2 = (JSONObject)array.get(1);
            System.out.println("Field \"1\"");
            System.out.println(obj2.get("1"));

            s = "{}";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,]";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,,2]";
            obj = parser.parse(s);
            System.out.println(obj);
        }catch(ParseException pe){

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }

*/

    public static void main(String[] args) {


        Connection conn = null;
        PreparedStatement preparedStatement = null;
        // ResultSet resultSet = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Select from Users...");
            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
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

            System.out.println("Insert some Users...");
            // PreparedStatements can use variables and are more efficient
            preparedStatement = conn.prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1

            for (int i = 0; i < 10; i++) {
                // System.out.println(i);
                preparedStatement.setString(1, "Test1");
                preparedStatement.setString(2, "TestEmail1");
                preparedStatement.setString(3, "TestWebpage1");
                preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
                preparedStatement.setString(5, "TestSummary1");
                preparedStatement.setString(6, "TestComment1");
                preparedStatement.executeUpdate();
            }

            System.out.println("Report new User...");
            preparedStatement = conn.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            rs = preparedStatement.executeQuery();
            writeResultSet(rs);

            // Statements allow to issue SQL queries to the database
            st = conn.createStatement();
            // Result set get the result of the SQL query
            System.out.println("Select from comments...");
            rs = st.executeQuery("select * from feedback.comments");
            writeResultSet(rs);
            System.out.println("Metadata from Select from comments...");
            writeMetaData(rs);

            //TestJSON();


        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }

    }

}