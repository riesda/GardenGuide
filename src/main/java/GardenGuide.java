import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class GardenGuide extends WidgetManager {//test comment from new machine
    JFrame mainFrame;
    WidgetManager manager = new WidgetManager();
    List<JTextField> addPlantFields = new ArrayList<JTextField>();
    int why=0;

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
        shareGardenL.setText("Share");
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
        tabbedPane.addTab("Share", shareGardenP);

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
        addTitle(p,"Search For A Plant");
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel searchPane = new JPanel();
        searchPane.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField plantName = new JTextField("Enter Plant Name",30);
        JButton searchB = new JButton("Search");
        searchB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                p.add(test(true));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                p.updateUI();
            }
        });
        searchPane.add(plantName);
        searchPane.add(searchB);
        searchPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(searchPane);


        //WILL ADD PLANT DATA BASED ON THE SQL CALL UNDERNEATH
    }
    public JPanel test(Boolean b){
        System.out.println("HERE");
        JPanel panel = new JPanel(new GridLayout(6,1));
        JLabel name = new JLabel();
        name.setText("Plant Name:  Arugula");

        JLabel type = new JLabel("Plant Type:  Vegetable");

        JLabel depth = new JLabel("Planting Depth:  .25 in");

        JLabel singleSpacing = new JLabel("Spacing Single Plants:  5 in");

        JLabel rowSpacing = new JLabel("Row Spacing:  3 in");

        JLabel plantingInstructions = new JLabel("Planting Instructions:  Sow directly in the soil in early spring, or start indoors and set out seedlings.");

        panel.add(name);
        panel.add(type);
        panel.add(depth);
        panel.add(singleSpacing);
        panel.add(rowSpacing);
        panel.add(plantingInstructions);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return panel;
    }
    public void setupMyGarden(JPanel p){
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setAlignmentX(Component.LEFT_ALIGNMENT);
        addTitle(p,"Garden Manager");
        JPanel loadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel newPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel currentGardens = new JLabel("Current Gardens:");//thumbnails for gardens will go here
        JLabel newGarden = new JLabel("Create New Garden:");
        JButton load = new JButton("Load");
        JButton newGardenBtn = new JButton("New");
        load.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                manager.loadGarden(p);
            }
        });
        newGardenBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                manager.createNewGarden(p);
            }
        });
        loadPanel.add(currentGardens);
        loadPanel.add(load);
        newPanel.add(newGarden);
        newPanel.add(newGardenBtn);

        loadPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        newPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(loadPanel);
        p.add(newPanel);

    }
    public void setupAddPlant(JPanel p){
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setAlignmentX(Component.LEFT_ALIGNMENT);
        addTitle(p,"Add A Plant to the Database");
        addTextField(p,"Plant Name:","ex. Pepper or Rose");
        addTextField(p,"Plant Type:", "ex. Vegetable or Flower");
        addTextField(p,"Planting Depth:", "in inches (ex. 1 or 2.25)");
        addTextField(p,"Spacing Single Plants:","in inches (ex. 7 or 8.25)");
        addTextField(p,"Row Spacing:","in inches (ex. 4 or 5.5)");
        addTextField(p,"Planting Instructions:","Planting information");
        addTextField(p,"Start of planting Month:", "Month Value (ex. May or September)");
        addTextField(p,"End of planting Month:", "Month Value (ex. May or September)");
        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                manager.addPlant((ArrayList<JTextField>) addPlantFields);
            }
        });


        p.add(submitBtn);
    }
    public void setupShareGarden(JPanel p){
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.setAlignmentX(Component.LEFT_ALIGNMENT);
        addTitle(p,"Share Your Garden");
        JPanel sharePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel shareLbl = new JLabel("Select garden to share");
        shareLbl.setFont(SUBTITLEFONT);
        JButton share = new JButton("Share");
        share.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                manager.shareGarden(p);
            }
        });
        sharePanel.add(shareLbl);
        sharePanel.add(share);
        sharePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(sharePanel);
    }
    public void addTextField(JPanel p, String t, String e){
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel text = new JLabel(t+" ");
        text.setFont(SUBTITLEFONT);
        JTextField field = new JTextField(e,20);
        addPlantFields.add(field);
        inputPanel.add(text);
        inputPanel.add(field);
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(inputPanel);
    }

    public void addTitle(JPanel p, String t){
        JLabel title = new JLabel(t, JLabel.CENTER);
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
