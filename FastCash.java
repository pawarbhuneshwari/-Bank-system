package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    FastCash(String pin){

        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1400,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(-50,5,1400,650);
        add(image);

        JLabel l1=new JLabel("  SELECT WITHDRAWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,20));
        l1.setBounds(400,150,400,25);
        image.add(l1);

        b1=new JButton("Rs. 100");
        b1.setBounds(370,210,150,30);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        image.add(b1);

        b2=new JButton("Rs. 500");
        b2.setBounds(600,210,170,30);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        image.add(b2);

        b3=new JButton("Rs. 1000");
        b3.setBounds(370,250,150,30);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        image.add(b3);

        b4=new JButton("Rs. 2000");
        b4.setBounds(600,250,170,30);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        image.add(b4);

        b5=new JButton("Rs. 5000");
        b5.setBounds(370,290,150,30);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        image.add(b5);

        b6=new JButton("Rs. 10000");
        b6.setBounds(600,290,170,30);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        image.add(b6);

        b7=new JButton("BACK");
        b7.setBounds(600,330,170,30);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        image.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7){
            setVisible(false);
            new main_Class(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn c=new Conn();
            Date date=new Date();

            try {
                ResultSet resultSet = c.s.executeQuery("Select * from bank where pin='"+pin+"'");
                int balance=0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -=Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                String num="17";

                if (e.getSource()!= b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                c.s.executeUpdate("insert into bank values('"+pin+"','"+date+"','withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin);

        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
