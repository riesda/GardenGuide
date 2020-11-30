import java.sql.*;


public class test{
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            c.setAutoCommit(false);
            String tableMake = "CREATE TABLE PLANTS " +
                    "(NAME TEXT PRIMARY KEY NOT NULL, " +
                    "PLANTING_SEASON_START CHAR(12), " +
                    "PLANTING_SEASON_END CHAR(12), " +
                    "HARVEST_SEASON_START CHAR(12), " +
                    "HARVEST_SEASON_END CHAR(12), " +
                    "SOW CHAR(100))";
            stmt.executeUpdate(tableMake);
            String plantInput = "INSERT INTO PLANTS (NAME,PLANTING_SEASON_START,PLANTING_SEASON_END,"+
                    "HARVEST_SEASON_START,HARVEST_SEASON_END,SOW)"+
                    "VALUES('Apple (Large)', 'April 1', 'May 15', 'July 15', 'October 15', "+
                    "'Make a large hole by breaking up the soil and adding compost/organic matter')";
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
