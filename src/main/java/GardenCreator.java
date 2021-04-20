import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
public class GardenCreator extends JFrame {

    JFrame gardenFrame;
//    private Graphics g;

    public GardenCreator(){
//        initializeGarden();

    }
    public void initializeGarden(){
        System.out.println("Garden Creator MAIN");
        List<JTextField> dimensions = new ArrayList<JTextField>();
        gardenFrame = new JFrame();
        gardenFrame.setSize(400,200);
        JPanel gardenPanel = new JPanel();
        gardenPanel.setLayout(new BoxLayout(gardenPanel, BoxLayout.Y_AXIS));

        JPanel sizePane = new JPanel();
        sizePane.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel length = new JLabel("Height (inches):");
        length.setFont(new Font("Verdana", Font.BOLD, 14));
        JTextField lengthInput = new JTextField("100",30);
        dimensions.add(lengthInput);

        JLabel width = new JLabel("Width (inches):");
        width.setFont(new Font("Verdana", Font.BOLD, 14));
        JTextField widthInput = new JTextField("150",30);
        dimensions.add(widthInput);

        JButton create = new JButton("Create Garden");
        create.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gardenPanel.removeAll();
                gardenPanel.repaint();
                createGarden(dimensions);
                gardenFrame.setVisible(false);
            }
        });
        sizePane.add(length);
        sizePane.add(lengthInput);
        sizePane.add(width);
        sizePane.add(widthInput);
        sizePane.add(create);

        gardenPanel.add(sizePane);

        gardenFrame.add(gardenPanel);
    }
    public void makeVisible(){
        initializeGarden();
        gardenFrame.setVisible(true);

    }

    public void createGarden(List<JTextField> dims){
        JFrame theGarden = new JFrame();
//        gardenFrame.removeAll();
//        gardenFrame = new JFrame();

        System.out.println(dims.get(0).getText());
        System.out.println(dims.get(1).getText());
        int height = Integer.parseInt(dims.get(0).getText());
        int width = Integer.parseInt(dims.get(1).getText());
        theGarden.setSize(width*10,height*10);
        theGarden.setVisible(true);
        drawGarden(height, width, theGarden);
        JPanel gardenView = new JPanel();
        gardenView.setLayout(new FlowLayout(FlowLayout.LEFT));
//        JLabel test = new JLabel("Dimensions: "+dims.get(0).getText()+"in by "+dims.get(1).getText()+ "in");
//        test.setFont(new Font("Verdana", Font.BOLD, 14));
//        gardenView.add(test);
        theGarden.add(gardenView);
        theGarden.repaint();
//        gardenFrame.repaint();
    }

    public void drawGarden(int height, int width, JFrame tg){
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(height/6, width/6));
        for (int i = 0; i < (height*width)/36; i++) {
            JButton button = new JButton();
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pickPlant(button);
                }
            });
            pane.add(button);
        }
        tg.getContentPane().add(pane);
        tg.setVisible(true);
//        tg.repaint();
    }

    public void pickPlant(JButton btn){
        JFrame plantSelect = new JFrame();
        JPanel searchPane = new JPanel();
        searchPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        plantSelect.setSize(700,400);
        plantSelect.setVisible(true);
        JLabel searchHeader = new JLabel("Enter Plant Name:");
        searchHeader.setFont(new Font("Verdana", Font.BOLD, 14));
        JTextField searchInput = new JTextField("",30);
        JButton selectBtn = new JButton("Select");
        selectBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                plantSelect.setVisible(false);
                btn.setText("P");
            }
        });
        searchPane.add(searchHeader);
        searchPane.add(searchInput);
        searchPane.add(selectBtn);

        plantSelect.add(searchPane);
    }
}
