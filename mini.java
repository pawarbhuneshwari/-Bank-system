package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class mini extends JFrame implements ActionListener {

    String pin;
    JButton button;

    mini(String pin){

        this.pin=pin;

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(new Color(255,204,204));
        setLayout(null);

        JLabel label1=new JLabel();
        label1.setBounds(20,110,400,250);
        add(label1);

        JLabel label2=new JLabel("Central Bank");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3=new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4=new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try {

            Conn c=new Conn();
            ResultSet resultSet =c.s.executeQuery("select * from  loginn where pin ='"+pin+"'");

            while (resultSet.next()){
                label3.setText("Card Number:  "+resultSet.getString("card_Number").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_Number").substring(12));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            int balance =0;
            Conn c=new Conn();
            ResultSet resultSet = c.s.executeQuery("Select * from bank where pin='"+pin+"'");
            while (resultSet.next()){
                label1.setText(label1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            String num="17";

            label4.setText("Your Total Balance is Rs "+balance);

        }catch (Exception e){
            e.printStackTrace();
        }

        button=new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);


    }

    public static void main(String[] args) {
        new mini("");
    }
}
