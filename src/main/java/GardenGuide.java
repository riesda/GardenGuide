import javax.swing.*;
import java.awt.*;


public class GardenGuide {

    JFrame mainFrame;
    final Font TITLEFONT = new Font("Verdana", Font.BOLD, 22);
    final Font SUBTITLEFONT =new Font("Verdana", Font.BOLD, 18);
    final Font TEXTFONT = new Font("Verdana", Font.PLAIN, 14);
    public GardenGuide(){
        mainFrame = new JFrame();
        JLabel testLBL = new JLabel();
        Dimension d = new Dimension(75,155);
        JLabel homeL, searchL, myGardenL,addPlantL, shareGardenL;
        homeL = new JLabel();
        homeL.setText("Home");
        homeL.setPreferredSize(d);
        searchL = new JLabel();
        searchL.setText("Search");
        searchL.setPreferredSize(d);
        myGardenL = new JLabel();
        myGardenL.setText("My Garden");
        myGardenL.setPreferredSize(d);
        addPlantL = new JLabel();
        addPlantL.setText("Add Plant");
        addPlantL.setPreferredSize(d);
        shareGardenL = new JLabel();
        shareGardenL.setText("Share Garden");
        shareGardenL.setPreferredSize(d);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.setBounds(0,0,1300,800);

        JPanel homeP = new JPanel();
        setupHome(homeP);
        JPanel searchP = new JPanel();
        setupSearch(searchP);
        JPanel myGardenP = new JPanel();
        setupMyGarden(myGardenP);
        JPanel addPlantP = new JPanel();
        setupAddPlant(addPlantP);
        JPanel shareGardenP = new JPanel();
        setupShareGarden(shareGardenP);

        tabbedPane.setBackground(Color.lightGray);
        tabbedPane.setForeground(Color.BLACK);

        tabbedPane.addTab("Home", homeP);
        tabbedPane.addTab("Search",searchP);
        tabbedPane.addTab("My Garden", myGardenP);
        tabbedPane.addTab("Add Plant", addPlantP);
        tabbedPane.addTab("Share Garden", shareGardenP);

        tabbedPane.setTabComponentAt(0, homeL);
        tabbedPane.setTabComponentAt(1, searchL);
        tabbedPane.setTabComponentAt(2, myGardenL);
        tabbedPane.setTabComponentAt(3, addPlantL);
        tabbedPane.setTabComponentAt(4, shareGardenL);

        mainFrame.add(tabbedPane);
        mainFrame.setSize(1315,840);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    public void setupHome(JPanel p){
        p.setLayout(new GridLayout(20,1));
        addTitle(p,"Welcome To Garden Guide");
        addSubTitle(p,"Basic Gardening Tips");
        addText(p,"*INFO");
        addText(p,"*INFO");
        addSubTitle(p,"Tips For Setting Up Your Own Raised Bed");
        addText(p,"*INFO");
        addText(p,"*INFO");
        addSubTitle(p,"Soil Information");
        addText(p,"*INFO");
        addText(p,"*INFO");
        addSubTitle(p,"Hardiness Zones");
        addText(p,"*INFO");
        addText(p,"*INFO");
    }
    public void setupSearch(JPanel p){
        p.setLayout(new GridLayout(20,2,1,1));
        addTitle(p,"Search For A Plant");
        JTextField plantName = new JTextField("Enter Plant Name");
        plantName.setPreferredSize(new Dimension(30,30));
        p.add(plantName,1,1);
        JButton searchB = new JButton("Search");
        searchB.setSize(new Dimension(30,30));
        p.add(searchB,1,2);
        //WILL ADD PLANT DATA BASED ON THE SQL CALL UNDERNEATH
    }
    public void setupMyGarden(JPanel p){
        p.setLayout(new GridLayout(20,1));
        addTitle(p,"Garden Manager");
        addSubTitle(p,"Current Gardens:");//thumbnails for gardens will go here
        addSubTitle(p, "Create garden from File:");
        JButton load = new JButton("Load");
        p.add(load);
        addSubTitle(p, "Create New Garden:");
        JButton newGarden = new JButton("Load");
        p.add(newGarden);

    }
    public void setupAddPlant(JPanel p){
        p.setLayout(new GridLayout(20,2));
        addTitle(p,"Add A Plant to the Database");
        addSubTitle(p,"Plant Name:");
        addTextField(p, "Name");
        addSubTitle(p,"Plant Type:");
        addTextField(p, "Type");
        addSubTitle(p,"Planting Depth:");
        addTextField(p, "Depth in inches");
        addSubTitle(p,"Spacing Single Plants:");
        addTextField(p, "Spacing in inches");
        addSubTitle(p,"Row Spacing:");
        addTextField(p, "Spacing in inches");
        addSubTitle(p,"Planting Instructions:");
        addTextField(p, "Written instructions");
        addSubTitle(p,"Start of planting Month:");
        addTextField(p, "Month Value");
        addSubTitle(p,"End of planting Month:");
        addTextField(p, "Month Value");

    }
    public void addTextField(JPanel p, String t){
        JTextField field = new JTextField(t);
        p.add(field);
    }
    public void setupShareGarden(JPanel p){
        p.setLayout(new GridLayout(20,1));
        addTitle(p,"Share Your Garden");
        addSubTitle(p, "Select garden to share");
        //will display the thumbnail of a user's garden
        JButton share = new JButton("Share");
        p.add(share);

    }
    public void addTitle(JPanel p, String t){
        JLabel title = new JLabel(t,JLabel.CENTER);
        title.setFont(TITLEFONT);
        p.add(title);
    }
    public void addSubTitle(JPanel p, String t){
        JLabel subTitle = new JLabel(t,JLabel.LEFT);
        subTitle.setFont(SUBTITLEFONT);
        p.add(subTitle);
    }
    public void addText(JPanel p, String t){
        JLabel subTitle = new JLabel("      "+t,JLabel.LEFT);
        subTitle.setFont(TEXTFONT);
        p.add(subTitle);
    }


    public static void main(String[]args){
        new GardenGuide();
    }
}
