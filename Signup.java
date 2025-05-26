package bank.management.system;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener{

    JRadioButton r1,r2,m1,m2,m3;
    JButton next;
    JTextField textname,textfather,textEmail,textAd,textC,textPin;
    JDateChooser dateChooser;
    Random ran=new Random();
    long first4=(ran.nextLong()%9000L) +1000L;
    String first=" " +Math.abs(first4);

    Signup(){
        super("APPLICATION FORM");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1=new JLabel("APPLICATION FORM NO"+first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2=new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3=new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelName=new JLabel("Name:");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(50,150,100,30);
        add(labelName);

        textname=new JTextField();
        textname.setFont(new Font("Releway",Font.BOLD,14));
        textname.setBounds(300,150,400,30);
        add(textname);

        JLabel fatherName=new JLabel("FatherName:");
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(50,200,200,30);
        add(fatherName);

        textfather=new JTextField();
        textfather.setFont(new Font("Releway",Font.BOLD,14));
        textfather.setBounds(300,200,400,30);
        add(textfather);

        JLabel DOB=new JLabel("Death of Birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(50,300,300,30);
        add(DOB);

        dateChooser=new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,300,400,30);
        add(dateChooser);


        JLabel labelG=new JLabel("Gender:");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(50,250,200,30);
        add(labelG);

        r1 =new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,250,60,30);
        add(r1);

        r2 =new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(450,250,90,30);
        add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail=new JLabel("Email address:");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(50,350,200,30);
        add(labelEmail);

        textEmail=new JTextField();
        textEmail.setFont(new Font("Releway",Font.BOLD,14));
        textEmail.setBounds(300,350,400,30);
        add(textEmail);

        JLabel labelms=new JLabel("Married status:");
        labelms.setFont(new Font("Raleway",Font.BOLD,20));
        labelms.setBounds(50,400,200,30);
        add(labelms);

        m1 =new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(300,400,80,30);
        add(m1);

        m2 =new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,400,100,30);
        add(m2);

        m3 =new JRadioButton("Other");
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setBackground(new Color(214, 239, 214));
        m3.setBounds(635,400,70,30);
        add(m3);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labelad=new JLabel("Address:");
        labelad.setFont(new Font("Raleway",Font.BOLD,20));
        labelad.setBounds(50,450,200,30);
        add(labelad);

        textAd=new JTextField();
        textAd.setFont(new Font("Releway",Font.BOLD,14));
        textAd.setBounds(300,450,400,30);
        add(textAd);

        JLabel labelc=new JLabel("City:");
        labelc.setFont(new Font("Raleway",Font.BOLD,20));
        labelc.setBounds(50,500,200,30);
        add(labelc);

        textC=new JTextField();
        textC.setFont(new Font("Releway",Font.BOLD,14));
        textC.setBounds(300,500,400,30);
        add(textC);

        JLabel labelP=new JLabel("Pin Code:");
        labelP.setFont(new Font("Raleway",Font.BOLD,20));
        labelP.setBounds(50,550,200,30);
        add(labelP);

        textPin=new JTextField();
        textPin.setFont(new Font("Releway",Font.BOLD,14));
        textPin.setBounds(300,550,400,30);
        add(textPin);



        next =new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,590,80,40);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(222, 200, 94));
        setLayout(null);
        setSize(800,850);
        setLocation(260,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent E ) {

        String formno=first;
        String name=textname.getText();
        String fname=textfather.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if (r1.isSelected()){
            gender="Male";
        }else if (r2.isSelected()){
            gender="Female";

            
        }
        String email=textEmail.getText();
        String married=null;
        if (m1.isSelected()){
            married="Married";
        }else if (m2.isSelected()){
            married="Unmarried";
        }else if (m3.isSelected()){
            married="Other";
        }
        String address=textAd.getText();
        String city=textC.getText();
        String pincode=textPin.getText();

        try {

            if(textname.getText().equals("")){
                JOptionPane.showMessageDialog(null, "fill all the fields");
            }else {
                Conn con1 = new Conn();
                String q = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + married + "','" + address + "','" + city + "','" + pincode + "')";
                con1.s.executeUpdate(q);
                new signup2(formno);
                setVisible(false);
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        new Signup().setVisible(true);


    }
}
