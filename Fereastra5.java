package ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fereastra5 extends JFrame{
    private JLabel l1, l2;
    private JTextField t;
    private int n1, n2;
    
    public Fereastra5(){
        super("Inmultire");
        JPanel p = new JPanel();
        n1 = (int)(Math.random()*10);
        n2 = (int)(Math.random()*10);
        
        l1 = new JLabel("Cat face " + n1 + " ori " + n2 + " ?" );
        p.add(l1);
        t = new JTextField(5);
        p.add(t);
        
        this.add(p, BorderLayout.NORTH);
        
        l2 = new JLabel("");
        this.add(l2);
        
        var a = new Ascultator();
        t.addActionListener(a);
        
    }
    
    private class Ascultator implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                    if(Integer.parseInt(t.getText()) == n1 * n2){
                    l2.setText("Foarte Bine!");
                    n1 = (int)(Math.random()*10);
                    n2 = (int)(Math.random()*10);
                    
                    l1.setText("Cat face " + n1 + " ori " + n2 + " ?" );
                }
                else
                    l2.setText("Nu. Mai incearca");
                
                t.setText("");
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(Fereastra5.this, "Tasteaza un numar si apasa Enter");
                } 
            }
        }
    
    public static void main(String[] args){
        JFrame f = new Fereastra5();
        f.setSize(250, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
