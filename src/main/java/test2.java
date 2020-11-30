import java.sql.*;

public class test2{
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            c.setAutoCommit(false);
            String plantInput = "INSERT INTO PLANTS (NAME,PLANTING_SEASON_START,PLANTING_SEASON_END,"+
                    "HARVEST_SEASON_START,HARVEST_SEASON_END,SOW)"+
                    "VALUES('Almond', 'March 15', 'May 15', 'July 1', 'October 15', "+
                    "'Make a wide hole, mulch after planting, and put a wire cage for increased protection')";
            stmt.executeUpdate(plantInput);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
