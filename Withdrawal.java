package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Withdrawal(String pin){
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1400,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(-50,5,1400,650);
        add(image);

        JLabel l1=new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(400,130,700,25);
        image.add(l1);

        JLabel l2=new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(400,160,400,25);
        image.add(l2);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(400,200,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(textField);

        b1=new JButton("WITHDRAWAL");
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
        if (e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdrawal");

                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient");
                        return;

                    }
                    c.s.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawal','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs." + amount + "Debited Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if (e.getSource()==b2){
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
