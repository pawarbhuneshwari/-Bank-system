package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {
    String pin;
    JLabel l2;
    JButton b1;
    BalanceEnquriy(String pin){

        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1400,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(-50,5,1400,650);
        add(image);

        JLabel l1=new JLabel("Your Current Balance is Rs ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(370,130,700,25);
        image.add(l1);

        l2=new JLabel();
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(370,160,400,25);
        image.add(l2);

        b1=new JButton("Back");
        b1.setBounds(620,330,150,30);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        image.add(b1);

        int balance=0;
        try {
            Conn c = new Conn();
            ResultSet resultSet=c.s.executeQuery("Select * from bank where pin= '"+pin+"' ");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance +=Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -=Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        l2.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);

    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
