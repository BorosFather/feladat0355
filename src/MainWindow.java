import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Font;
import java.lang.Math;


public class MainWindow extends JFrame {
    JLabel about;
    JLabel fela;
    JLabel task;
    JLabel aside;
    JTextField atext;
    JLabel bside;
    JTextField btext;
    JLabel cside;
    JTextField ctext;
    JLabel megold;
    JTextField megoldtext;
    JPanel mainPanel;
    JPanel buttonPanel;
    JButton gomb;
    JButton del;
    JButton exit;

    public MainWindow() {
        setCompoment();
        setButtonPanel();
        setMainPanel();
        setFrame();
       
    }
    private void setCompoment(){
        about = new JLabel("Borosfather, 2022-06-13, Szoft I N");
        fela = new JLabel("Feladat 0355");
        task = new JLabel("Háromszögbe írható kör");
        aside = new JLabel("A oldal");
        atext = new JTextField();
        bside = new JLabel("B oldal");
        btext = new JTextField();
        cside = new JLabel("C oldal");
        ctext = new JTextField();
        megold = new JLabel("Eredmény");
        megoldtext = new JTextField();
        gomb = new JButton("Számít");
        del = new JButton("Törlés");
        exit = new JButton("Kilépés");

        Font font = new Font("sans serif", Font.ITALIC,20);
        about.setFont(font);
        fela.setFont(font);
        gomb.addActionListener(e -> onClick());
        del.addActionListener(e -> onClickDel());
        exit.addActionListener(e -> onClickExit());

    }

    private void setMainPanel(){
        mainPanel = new JPanel();
        mainPanel.add(about, BorderLayout.CENTER);
        mainPanel.add(fela, BorderLayout.CENTER);
        mainPanel.add(task, BorderLayout.CENTER);
        mainPanel.add(aside);
        mainPanel.add(atext);
        mainPanel.add(bside);
        mainPanel.add(btext);
        mainPanel.add(cside);
        mainPanel.add(ctext);
        mainPanel.add(megold);
        mainPanel.add(megoldtext);
        mainPanel.add(buttonPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        EmptyBorder border = new EmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(border);
        
    }

    private void setButtonPanel(){
        buttonPanel = new JPanel();
        buttonPanel.add(gomb);
        buttonPanel.add(del);
        buttonPanel.add(exit);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
    }

    private void setFrame(){
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1000, 700);
        this.pack();
        this.setVisible(true);

    }

    private void onClick(){
        String asideStr = atext.getText();
        String bsideStr = btext.getText();
        String csideStr = ctext.getText();
        double aside = Double.parseDouble(asideStr);
        double bside = Double.parseDouble(bsideStr);
        double cside = Double.parseDouble(csideStr);
        if(!asideStr.matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "nem szám");
            return;
        }
        if(!bsideStr.matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "nem szám");
            return;
        }
        if(!csideStr.matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "nem szám");
            return;
        }

        double s = (aside + bside + cside) / 2;
        double area = Math.sqrt(s * (s - aside) * (s - bside) * (s - cside));
        Double r = Math.pow(area, 2) / (aside + bside + cside);
        megoldtext.setText(r.toString());
        
    }

   
    private void onClickDel(){
        this.atext.setText("");
        this.btext.setText("");
        this.ctext.setText("");

    }

    private void onClickExit(){
        System.exit(0);
    }

    
}
