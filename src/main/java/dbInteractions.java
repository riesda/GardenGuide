import java.io.*;
import java.util.*;
import java.lang.*;
import java.sql.*;
//java -classpath ".;sqlite-jdbc-3.32.3.2.jar" dbInteractions.java
public class dbInteractions {

    public static void dbUpdaterPlants (String[] stringHolder){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:plantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            c.setAutoCommit(false);
            String plantInput = "INSERT INTO PLANTS (Plant_Name,Plant_Type,Planting_Depth,Start_Time,End_Time," +
                    "Spacing_Single,Spacing_Plant_Row,Row_Gap_Spacing,Sow_and_Plant,Harvesting,Feeding," +
                    "Soil_Hardiness, Sun_Exposure,Soil_Type)" +
                    "VALUES('" + stringHolder[0] + "', '" + stringHolder[1] + "', '" + stringHolder[2] + "', '" +
                    stringHolder[3] + "', '" + stringHolder[4] + "', '" + stringHolder[5] + "', '" +
                    stringHolder[6] + "', '" + stringHolder[7] + "', '" + stringHolder[8] + "', '" +
                    stringHolder[9] + "', '" + stringHolder[10] + "', '" + stringHolder[11] + "', '" +
                    stringHolder[12] + "', '" + stringHolder[13] + "')";
            stmt.executeUpdate(plantInput);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void grabAllPlants(){
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

                String name = rs.getString("Plant_Name");
                String p_type = rs.getString("Plant_Type");
                String p_depth = rs.getString("Planting_Depth");
                String p_startT = rs.getString("Start_Time");
                String p_endT = rs.getString("End_Time");
                String p_spaceSingle = rs.getString("Spacing_Single");
                String p_spaceRow = rs.getString("Spacing_Plant_Row");
                String p_rowGapS = rs.getString("Row_Gap_Spacing");
                String p_sow = rs.getString("Sow_and_Plant");
                String p_harvest = rs.getString("Harvesting");
                String p_feed = rs.getString("Feeding");
                String p_hard = rs.getString("Soil_Hardiness");
                String p_expose = rs.getString("Sun_Exposure");
                String p_soilType = rs.getString("Soil_Type");

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void grabPlantNameSpecific(String input){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:plantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            c.setAutoCommit(false);
//            String sqInput = "SELECT * FROM PLANTS WHERE Plant_Name LIKE ?";
            String sqInput = String.format("SELECT * FROM PLANTS  WHERE Plant_Name LIKE '%s", input);
//            sqInput --;
            sqInput +="%'";
//            sqInput +="%\'";
//            String sqInput = String.format("SELECT * FROM PLANTS ORDER BY Plant_Name ASC WHERE Plant_Name LIKE '%s';", input);
            System.out.println(sqInput);
//            PreparedStatement pstmt = c.prepareStatement(sqInput);
//            System.out.println(pstmt.toString());
//            pstmt.setString(1, input);
//            System.out.println(pstmt.toString());
//            pstmt.executeUpdate();
//            System.out.println(pstmt.toString());
            ResultSet rs = stmt.executeQuery(sqInput);
            while (rs.next()){

                String name = rs.getString("Plant_Name");
                String p_type = rs.getString("Plant_Type");
                String p_depth = rs.getString("Planting_Depth");
                String p_startT = rs.getString("Start_Time");
                String p_endT = rs.getString("End_Time");
                String p_spaceSingle = rs.getString("Spacing_Single");
                String p_spaceRow = rs.getString("Spacing_Plant_Row");
                String p_rowGapS = rs.getString("Row_Gap_Spacing");
                String p_sow = rs.getString("Sow_and_Plant");
                String p_harvest = rs.getString("Harvesting");
                String p_feed = rs.getString("Feeding");
                String p_hard = rs.getString("Soil_Hardiness");
                String p_expose = rs.getString("Sun_Exposure");
                String p_soilType = rs.getString("Soil_Type");

                System.out.println(name);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void main(String args[]) throws IOException{
        grabPlantNameSpecific("Ar");
    }

}