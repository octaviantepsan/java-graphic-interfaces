package ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Octavian
 */
public class Fereastra7 extends JFrame{
    private JTextField t;
    private JRadioButton[] b;
    
    public Fereastra7(){
        setTitle("Stilul unui font");
        
        t = new JTextField("Modificarea stilului unui text");
        t.setHorizontalAlignment(JTextField.CENTER);
        add(new JPanel().add(t));
        
        JPanel p = new JPanel();
        String[] etichete = {"Normal", "Italic", "Bold", "Bold/Italic"};
        ButtonGroup bg = new ButtonGroup();
        b = new JRadioButton[4];
        
        var a = new Ascultator();
        
        for(int i = 0; i < 4; i++){
            b[i] = new JRadioButton(etichete[i], false);
            bg.add(b[i]);
            p.add(b[i]);
            
            b[i].addActionListener(a);
        }
        this.add(p, BorderLayout.SOUTH);
        b[0].setEnabled(true);
    }
    
    private class Ascultator implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == b[0])
                t.setFont(t.getFont().deriveFont(Font.PLAIN));
            else
                if(e.getSource() == b[1])
                t.setFont(t.getFont().deriveFont(Font.ITALIC));//ii dam proprietatea textfield-ului (font) si o schimbam
            else
                if(e.getSource() == b[2])
                t.setFont(t.getFont().deriveFont(Font.BOLD));
            else
                if(e.getSource() == b[3])
                t.setFont(t.getFont().deriveFont(Font.ITALIC + Font.BOLD));
        }
    }
    
    public static void main(String[] args){
        JFrame f = new Fereastra7();
        f.setSize(300, 150);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
