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

    public static List<String[]> grabAllPlants(){
        Connection c = null;
        Statement stmt = null;
        List<String[]> listRet = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:plantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            c.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PLANTS ORDER BY NAME;" );
            String[] tempStore = new String[14];
            while (rs.next()){

                tempStore[0] = rs.getString("Plant_Name");
                tempStore[1] = rs.getString("Plant_Type");
                tempStore[2] = rs.getString("Planting_Depth");
                tempStore[3] = rs.getString("Start_Time");
                tempStore[4] = rs.getString("End_Time");
                tempStore[5] = rs.getString("Spacing_Single");
                tempStore[6] = rs.getString("Spacing_Plant_Row");
                tempStore[7] = rs.getString("Row_Gap_Spacing");
                tempStore[8] = rs.getString("Sow_and_Plant");
                tempStore[9] = rs.getString("Harvesting");
                tempStore[10] = rs.getString("Feeding");
                tempStore[11] = rs.getString("Soil_Hardiness");
                tempStore[12] = rs.getString("Sun_Exposure");
                tempStore[13] = rs.getString("Soil_Type");
                listRet.add(tempStore);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return listRet;
    }

    public static List<String[]> grabPlantNameSpecific(String input){
        Connection c = null;
        Statement stmt = null;
        List<String[]> listRet = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:plantdb.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            c.setAutoCommit(false);
//            String sqInput = "SELECT * FROM PLANTS WHERE Plant_Name LIKE ?";
            String sqInput = String.format("SELECT * FROM PLANTS  WHERE Plant_Name LIKE '%s", input);
            sqInput +="%'";
            String[] tempStore = new String[14];
//            System.out.println(sqInput);
            ResultSet rs = stmt.executeQuery(sqInput);
            while (rs.next()){

                tempStore[0] = rs.getString("Plant_Name");
                tempStore[1] = rs.getString("Plant_Type");
                tempStore[2] = rs.getString("Planting_Depth");
                tempStore[3] = rs.getString("Start_Time");
                tempStore[4] = rs.getString("End_Time");
                tempStore[5] = rs.getString("Spacing_Single");
                tempStore[6] = rs.getString("Spacing_Plant_Row");
                tempStore[7] = rs.getString("Row_Gap_Spacing");
                tempStore[8] = rs.getString("Sow_and_Plant");
                tempStore[9] = rs.getString("Harvesting");
                tempStore[10] = rs.getString("Feeding");
                tempStore[11] = rs.getString("Soil_Hardiness");
                tempStore[12] = rs.getString("Sun_Exposure");
                tempStore[13] = rs.getString("Soil_Type");
                listRet.add(tempStore);

//                System.out.println(name);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return listRet;
    }

}