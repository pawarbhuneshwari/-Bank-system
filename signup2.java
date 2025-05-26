package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup2 extends JFrame implements ActionListener {

    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textpan,textAadhar,textstate;
    JRadioButton r1,r2,A1,A2;
    JButton next;
    String formno;
    signup2(String formno){
        super("APPLICATION FORM");


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formno=formno;

        JLabel labelP=new JLabel("State:");
        labelP.setFont(new Font("Raleway",Font.BOLD,20));
        labelP.setBounds(100,120,100,30);
        add(labelP);

        textstate=new JTextField();
        textstate.setFont(new Font("Releway",Font.BOLD,14));
        textstate.setBounds(350,120,320,30);
        add(textstate);

        JLabel l1=new JLabel("Page 2:-");
        l1.setFont(new Font("Releway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2=new JLabel("Additional Details");
        l2.setFont(new Font("Relway",Font.BOLD,22));
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3=new JLabel("Religion:");
        l3.setFont(new Font("Releway",Font.BOLD,18));
        l3.setBounds(100,170,100,30);
        add(l3);

        String religion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        comboBox=new JComboBox(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Releway",Font.BOLD,14));
        comboBox.setBounds(350,170,320,30);
        add(comboBox);

        String category[]={"General","OBC","SC","ST","Other"};
        comboBox2=new JComboBox(category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Releway",Font.BOLD,14));
        comboBox2.setBounds(350,220,320,30);
        add(comboBox2);

        JLabel l4=new JLabel("Category:");
        l4.setFont(new Font("Releway",Font.BOLD,18));
        l4.setBounds(100,220,100,30);
        add(l4);

        JLabel l5=new JLabel("Income:");
        l5.setFont(new Font("Releway",Font.BOLD,18));
        l5.setBounds(100,270,100,30);
        add(l5);

        String income[]={"Null","<1,50,000","<2,50,000","5,00,000","Upto 10,00,000","Above 10,00,000"};
        comboBox3=new JComboBox(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Releway",Font.BOLD,14));
        comboBox3.setBounds(350,270,320,30);
        add(comboBox3);

        JLabel l6=new JLabel("Educational:");
        l6.setFont(new Font("Releway",Font.BOLD,18));
        l6.setBounds(100,320,150,30);
        add(l6);

        String educational[]={"Not Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        comboBox4=new JComboBox(educational);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Releway",Font.BOLD,14));
        comboBox4.setBounds(350,320,320,30);
        add(comboBox4);

        JLabel l7=new JLabel("Occupation:");
        l7.setFont(new Font("Releway",Font.BOLD,18));
        l7.setBounds(100,370,150,30);
        add(l7);

        String occupation[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
        comboBox5=new JComboBox(occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Releway",Font.BOLD,14));
        comboBox5.setBounds(350,370,320,30);
        add(comboBox5);

        JLabel l8=new JLabel("PAN Number:");
        l8.setFont(new Font("Releway",Font.BOLD,18));
        l8.setBounds(100,420,150,30);
        add(l8);

        textpan=new JTextField();
        textpan.setFont(new Font("Releway",Font.BOLD,18));
        textpan.setBounds(350,420,320,30);
        add(textpan);

        JLabel l9=new JLabel("Aadhar Number:");
        l9.setFont(new Font("Releway",Font.BOLD,18));
        l9.setBounds(100,470,180,30);
        add(l9);

        textAadhar=new JTextField();
        textAadhar.setFont(new Font("Releway",Font.BOLD,18));
        textAadhar.setBounds(350,470,320,30);
        add(textAadhar);

        JLabel l10=new JLabel("Senior Citizen:");
        l10.setFont(new Font("Releway",Font.BOLD,18));
        l10.setBounds(100,520,180,30);
        add(l10);

        r1=new JRadioButton("Yes");
        r1.setFont(new Font("Releway",Font.BOLD,14));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(350,520,100,30);
        add(r1);

        r2=new JRadioButton("No");
        r2.setFont(new Font("Releway",Font.BOLD,14));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(450,520,100,30);
        add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel l11=new JLabel("Existing Account:");
        l11.setFont(new Font("Releway",Font.BOLD,18));
        l11.setBounds(100,570,180,30);
        add(l11);

        A1=new JRadioButton("Yes");
        A1.setFont(new Font("Releway",Font.BOLD,14));
        A1.setBackground(new Color(252,208,76));
        A1.setBounds(350,570,100,30);
        add(A1);

        A2=new JRadioButton("No");
        A2.setFont(new Font("Releway",Font.BOLD,14));
        A2.setBackground(new Color(252,208,76));
        A2.setBounds(450,570,100,30);
        add(A2);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(A1);
        buttonGroup1.add(A2);

        JLabel l12=new JLabel("Form No:");
        l12.setFont(new Font("Releway",Font.BOLD,18));
        l12.setBounds(700,10,100,30);
        add(l12);

        JLabel l13=new JLabel(formno);
        l13.setFont(new Font("Releway",Font.BOLD,18));
        l13.setBounds(780,10,60,30);
        add(l13);

        next=new JButton("Next");
        next.setFont(new Font("Releway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(620,600,80,40);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(260,10);
        getContentPane().setBackground(new Color(250, 208, 76));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String state=textstate.getText();
        String rel=(String) comboBox.getSelectedItem();
        String cate=(String) comboBox2.getSelectedItem();
        String income=(String) comboBox3.getSelectedItem();
        String edu=(String) comboBox4.getSelectedItem();
        String occ =(String) comboBox5.getSelectedItem();

        String pan=textpan.getText();
        String aadhar=textAadhar.getText();

        String scitizen=null;
        if (r1.isSelected()){
            scitizen="Yes";
        }else if (r2.isSelected()){
            scitizen="No";
        }

        String eAccount =null;
        if (r1.isSelected()){
            eAccount="Yes";
        }else if (r2.isSelected()){
            eAccount="No";
        }

        try {
            if (textpan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill All The Filds");
            }else {
                Conn c1 = new Conn();
                String q = "insert into signupttwo values('"+formno+"','" + state + "','" + rel + "','" + cate + "','" + income + "','" + edu + "','" + occ + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eAccount + "')";
                c1.s.executeUpdate(q);
                new signup3(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new signup2("");

    }
}
