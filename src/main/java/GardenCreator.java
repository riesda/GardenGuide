import java.awt.*;
import javax.swing.*;
public class GardenCreator {

    JFrame gardenFrame;
    public GardenCreator(){
        gardenFrame = new JFrame();
        gardenFrame.setSize(700,700);
        JLabel comingSoon = new JLabel("Coming Soon");
        comingSoon.setFont(new Font("Verdana", Font.BOLD, 22));
        gardenFrame.add(comingSoon);


    }
    public void makeVisible(){
        gardenFrame.setVisible(true);
    }
}
