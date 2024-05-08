package ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Octavian
 */
public class Fereastra6 extends JFrame {
    private JComboBox c;
    private JPanel p1, p2;
    private String element;
    
    public Fereastra6() {
        super("Zodiac");
        p1 = new JPanel();
        p1.add(new JLabel("Alegeti o zodie"));
        
        String[] et = {"Berbec", "Gemeni", "Rac", "Leu", "Fecioara", "Balanta", "Scorpion", "Sagetator", "Capricorn", "Varsator", "Pesti"};
        c = new JComboBox(et);
        
        p1.add(c);
        
        this.add(p1, BorderLayout.NORTH);
        
        p2 = new JPanel();
        element = et[0];
        
        this.add(p2);
        
        var a = new Ascultator();
        c.addItemListener(a);
    }
    
    private class Ascultator implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            element = (String)c.getSelectedItem();
            
            repaint();
            print(p2.getGraphics());
        }
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagine = null;
        
        switch(element){
            case "Berbec" -> imagine = t.getImage("aries.jpg");
            case "Taur" -> imagine = t.getImage("taurus.jpg");
            case "Gemeni" -> imagine = t.getImage("gemini.jpg");
            case "Rac" -> imagine = t.getImage("cancer.jpg");
            case "Leu" -> imagine = t.getImage("leo.jpg");
            case "Fecioara" -> imagine = t.getImage("virgo.jpg");
            case "Balanta" -> imagine = t.getImage("libra.jpg");
            case "Scorpion" -> imagine = t.getImage("scorpio.jpg");
            case "Sagetator" -> imagine = t.getImage("sagittarius.jpg");
            case "Capricorn" -> imagine = t.getImage("capricorn.jpg");
            case "Varsator" -> imagine = t.getImage("aquarius.jpg");
            case "Pesti" -> imagine = t.getImage("pisces.jpg");
        }
        
        g.drawImage(imagine, 100, 100, null);
    }
    
    public static void main(String[] args){
        JFrame f = new Fereastra6();
        f.setSize(500, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
