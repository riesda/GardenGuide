import java.sql.*;

public class interactTest{
    public static void main(String[] args){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            c.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PLANTS ORDER BY NAME;" );
            while (rs.next()){

                String name = rs.getString("name");
                String plantingSeasonStart = rs.getString("planting_season_start");
                String plantingSeasonEnd = rs.getString("planting_season_end");
                String harvestSeasonStart = rs.getString("harvest_season_start");
                String harvestSeasonEnd = rs.getString("harvest_season_end");
                String sowInstructions = rs.getString("sow");

                System.out.println("Name = " + name);
                System.out.println("Start planting at " + plantingSeasonStart);
                System.out.println("Stop planting at " + plantingSeasonEnd);
                System.out.println("Harvest starting from " + harvestSeasonStart);
                System.out.println("Harvest season ends at " + harvestSeasonEnd);
                System.out.println("Instructions on planting: " + sowInstructions + "\n");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}