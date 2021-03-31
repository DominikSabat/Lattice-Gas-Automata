import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainWindow extends JFrame{
    private DataManager dm;
    private JPanel mainPanel;
    private JPanel buttonPanel;

    private JCanvasPanel canvasPanel;

    private JTextField widthField;
    private JTextField heightField;

    private JButton makeImageBut;

    private JButton animateBut;

    private JButton iterationBut;



    public MainWindow (String title) {
        super(title);

        dm = new DataManager();


        //==============================================================================================
        try {
            BufferedImage bg = ImageIO.read(new File("obrazek.bmp"));
            dm.img = bg;
        } catch (IOException e) {
            e.printStackTrace();
        }



        //==================================================================

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        animateBut = new JButton("Zanimuj "); animateBut.setBackground(Color.BLACK); animateBut.setForeground(Color.WHITE);

        iterationBut= new JButton("Wydrukuj iteracje ");

        makeImageBut = new JButton("Zastosuj wymiary"); makeImageBut.setBackground(Color.WHITE.brighter()); makeImageBut.setForeground(Color.BLACK.darker());

        widthField = new JTextField("375");
        widthField.setBorder(new TitledBorder("Szerokosc"));

        heightField = new JTextField("375");
        heightField.setBorder(new TitledBorder("Wysokosc"));


        buttonPanel = new JPanel();
        buttonPanel.setSize(0,0);
        buttonPanel.setLayout(new GridLayout(5,1));

        buttonPanel.add(widthField);
        buttonPanel.add(heightField);
        buttonPanel.add(makeImageBut);

        buttonPanel.add(animateBut);
        buttonPanel.add(iterationBut);


        canvasPanel = new JCanvasPanel(dm);

        mainPanel.add(BorderLayout.CENTER, canvasPanel);
        mainPanel.add(BorderLayout.EAST, buttonPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        this.setSize(new Dimension(650, 450));
        this.setLocationRelativeTo(null);

        makeImageBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility util = new Utility(dm);

                dm.img=new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
                dm.width=1;
                dm.height=1;
                util.Initial();

                dm.img=new BufferedImage(Integer.parseInt(widthField.getText()),Integer.parseInt(heightField.getText()),BufferedImage.TYPE_INT_RGB);
                dm.width=Integer.parseInt(widthField.getText());
                dm.height=Integer.parseInt(heightField.getText());
                util.Initial();

                canvasPanel.repaint();
            }
        });




        animateBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility util = new Utility(dm);

                int tempWidth=Integer.parseInt(widthField.getText());
                int tempHeight=Integer.parseInt(heightField.getText());
                dm.width=dm.img.getWidth();
                dm.height=dm.img.getHeight();
                dm.particleLast = new Cell[dm.width][dm.height];
                dm.particleCurrent = new Cell[dm.width][dm.height];

                util.generateParticles();

                final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {

                         util.animateLGA();

                    }
                }, 0, 1, TimeUnit.MILLISECONDS);



                final ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
                executorService2.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {

                        canvasPanel.repaint();

                        if(Integer.parseInt(widthField.getText())!=tempWidth || Integer.parseInt(heightField.getText())!=tempHeight)  {

                            executorService.shutdown();
                            executorService2.shutdown();
                        }

                    }
                }, 0, 1, TimeUnit.MILLISECONDS);

            }
        });

        iterationBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility util = new Utility(dm);

                util.showIteration();
            }
        });


    }

    public static void main(String[] args){
        MainWindow mw = new MainWindow("Automat komorkowy");
        mw.setVisible(true);
        mw.canvasPanel.repaint();
        

    }
}
