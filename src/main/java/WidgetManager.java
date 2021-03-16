import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WidgetManager extends GardenCreator{
    GardenCreator gardenCreator = new GardenCreator();
    final Font SUBTITLEFONT =new Font("Verdana", Font.BOLD, 18);

    public void loadGarden(JPanel p){
        System.out.println("Load Garden Test");
        gardenCreator.makeVisible();
    }

    public void createNewGarden(JPanel p){
        System.out.println("New Garden Test");
        gardenCreator.makeVisible();

    }

    public void addPlant(ArrayList<JTextField> fields){
        //in charge of managing plant information and adding to database
        System.out.println("Add Plant Test");
        checkNewPlant(fields);

    }
    private void checkNewPlant(ArrayList<JTextField> fields){
        JFrame plantFrame = new JFrame();
        plantFrame.setSize(700,700);
        JPanel checkPanel = new JPanel(new GridLayout(9,1));

        JLabel name = new JLabel("Plant Name:  "+fields.get(0).getText());
        name.setFont(SUBTITLEFONT);
        JLabel type = new JLabel("Plant Type:  "+fields.get(1).getText());
        type.setFont(SUBTITLEFONT);
        JLabel depth = new JLabel("Planting Depth:  "+fields.get(2).getText());
        depth.setFont(SUBTITLEFONT);
        JLabel singleSpacing = new JLabel("Spacing Single Plants:  "+fields.get(3).getText());
        singleSpacing.setFont(SUBTITLEFONT);
        JLabel rowSpacing = new JLabel("Row Spacing:  "+fields.get(4).getText());
        rowSpacing.setFont(SUBTITLEFONT);
        JLabel plantingInstructions = new JLabel("Planting Instructions:  "+fields.get(5).getText());
        plantingInstructions.setFont(SUBTITLEFONT);
        JLabel start = new JLabel("Start of planting Month:  "+fields.get(6).getText());
        start.setFont(SUBTITLEFONT);
        JLabel end = new JLabel("end of planting Month:  "+fields.get(7).getText());
        end.setFont(SUBTITLEFONT);

        checkPanel.add(name);
        checkPanel.add(type);
        checkPanel.add(depth);
        checkPanel.add(singleSpacing);
        checkPanel.add(rowSpacing);
        checkPanel.add(plantingInstructions);
        checkPanel.add(start);
        checkPanel.add(end);


        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton confirm, cancel;
        confirm = new JButton("Confirm");
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                plantFrame.setVisible(false);
            }
        });
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                plantFrame.setVisible(false);
            }
        });
        btnPanel.add(confirm);
        btnPanel.add(cancel);
        checkPanel.add(btnPanel);

        plantFrame.add(checkPanel);

        plantFrame.setVisible(true);
    }

    public void searchPlant(String plantName){

        System.out.println(plantName);
    }

    public void shareGarden(JPanel p){
        gardenCreator.makeVisible();
        System.out.println("Share Garden Test");

    }
}
