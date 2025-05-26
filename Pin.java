package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){
        this.pin=pin;


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1400,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(-50,5,1400,650);
        add(image);

        JLabel l1=new JLabel("CHANGE YOUR PIN");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(400,120,400,25);
        image.add(l1);


        JLabel l2=new JLabel("New PIN");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(400,150,400,25);
        image.add(l2);

        p1=new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(580,150,180,25);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(p1);

        JLabel l3=new JLabel("Re-Enter  New PIN");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setBounds(400,180,400,25);
        image.add(l3);

        p2=new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(580,185,180,25);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(p2);

        b1=new JButton("CHANGE");
        b1.setBounds(600,280,150,30);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        image.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(600,320,150,30);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        image.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            String pin1= p1.getText();
            String pin2=p2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN ");
                    return;


                }if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN ");
                    return;

                }
                Conn c=new Conn();
                String q1="update bank set pin ='"+pin1+"' where pin = '"+pin+"'";
                String q2="update loginn set pin ='"+pin1+"' where pin = '"+pin+"'";
                String q3="update signupthree set pin ='"+pin1+"' where pin = '"+pin+"'";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new main_Class(pin);

            }
            else if (e.getSource()==b2){
                new main_Class(pin);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Pin("");
    }
}
