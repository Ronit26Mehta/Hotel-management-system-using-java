import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.awt.print.*;
import javafx.print.Printer;*/
import java.io.*;
import java.io.IOException;
public class Hotel extends Frame{
   JLabel l1, l2, l3,l4,l5,l6,l7,l8;
   JTextField tf1, tf2, tf3,tf4;
   JTextArea area2;
   JRadioButton rb1, rb2,p1,p2;
   JFileChooser f1;
   JComboBox cb1,cb2;
   JButton b1,b2,b3;
  
   Hotel(){
    l1 = new JLabel("Hotel Bill Generator Manager");
    l1.setBounds(700, 50, 500, 100);
	l1.setFont(new Font("Airal",Font.PLAIN,30));
    l2 = new JLabel("Name of the visitor:");
	l2.setBounds(50, 150, 250, 20);
    tf1 = new JTextField();
	tf1.setBounds(250, 150, 250, 20);
    l3 = new JLabel("Phone number of the visitor:");
	l3.setBounds(50, 200, 250, 20);
    tf2 = new JTextField();
    tf2.setBounds(250, 200, 250, 20);
    l4 = new JLabel("Email address of the visitor");
    l4.setBounds(50, 250, 250, 20);
    tf3 = new JTextField();
    tf3.setBounds(250,250,250,20);
    l5 = new JLabel("Select the proper payment mehtod");
    l5.setBounds(50,300,250,20);
    String payment[]
			= { "Cash","Card","Token","Voucher","Emi" };
            final JComboBox list2=new JComboBox(payment);
		list2.setBounds(
			250, 300, 250, 20);

  l6= new JLabel("Select suitable room option:");
  l6.setBounds(50,350,250,20);
  
	    rb1 = new JRadioButton("Deluxe:-10000");
		rb2 = new JRadioButton("Semi deluxe:-2000");
        JRadioButton rb3 = new JRadioButton("Normal:-1000");
        JRadioButton rb4 = new JRadioButton("Shared:-500");
		rb1.setBounds(300,350, 110, 30);
		rb2.setBounds(300, 375, 130, 30);
        rb3.setBounds(300,400,130,30);
        rb4.setBounds(300,425,100,30);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
        bg.add(rb3);
		bg.add(rb4);
     l7= new JLabel("Enter the suitable amount of the days:-");
     l7.setBounds(50, 465, 250, 20);
    tf4 = new JTextField();
    tf4.setBounds(300,465,250,20);
    l8 = new JLabel("Do you want to park a  car or bike");
    l8.setBounds(50, 500, 250, 20);
    p1= new JRadioButton("Yes");
    p2 = new JRadioButton("No");
    ButtonGroup bg1=new ButtonGroup();
    bg1.add(p1);
    bg1.add(p2);
    p1.setBounds(250, 500, 100, 30);
    p2.setBounds(250, 525, 100, 30);
    JButton Receipt = new JButton("Generate Receipt");
		Receipt.setBounds(600, 490, 150, 30);
		JButton b2 = new JButton("Reset");
		b2.setBounds(750, 490, 150, 30);
		JButton Print = new JButton("Print");
		Print.setBounds(900, 490, 150, 30);
		area2 = new JTextArea();
		area2.setBounds(600, 540, 450, 240);
       add(l1);add(l2);add(tf1);add(l3);add(tf2);add(l4);add(tf3);add(l5);add(list2);add(l6);add(rb1);add(rb2);add(rb3);add(rb4);add(l7);add(l8);add(tf4);
       add(p1);add(p2);add(Receipt);add(b2);add(Print);add(area2);
       setSize(800, 800);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);
        // Reset the text fields
		b2.addActionListener(
			new ActionListener() {
				public void actionPerformed(
					ActionEvent e)
				{
					area2.setText("");
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
				}
			});
/*
            Print.addActionListener(
			new ActionListener() {
				public void actionPerformed(
					ActionEvent e)
				{
					try {
						area2.print();
					}
					catch (java.awt.print
							.PrinterException a) {
						System.err.format(
							"NoPrinter Found",
							a.getMessage());
					}
				}
			});
            // Generating the receipt
            */
		Receipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
               int total,cost,tc;
                  total=0;
                  tc=0;
                 String s1=tf4.getText();
                    int days=Integer.parseInt(s1);
				area2.setText(
					"--------------------------------"
					+ "-----------bill---------------"
					+ "--------------------------"
					+ "--------------------------"
					+ "-------------------\n");

				area2.setText(area2.getText()
							+ "Visitor Name: "
							+ tf1.getText()
							+ "\n");
				area2.setText(area2.getText()
							+ "Phone Number: "
							+ tf2.getText()
							+ "\n");
				area2.setText(area2.getText()
							+ "Email address: "
							+ tf3.getText()
							+ "\n");
				area2.setText(area2.getText()
							+ "Days: "
							+ tf4.getText()
							+ "\n");
				area2.setText(area2.getText()
							+ "Way to Payment: "
							+list2.getSelectedItem()
									.toString()
							+ "\n");
                          
				if (rb1.isSelected()) {
                     cost=10000;
                     total=cost*days;
					area2.setText(area2.getText()
								+ "Price "
								+ "="
								+ "10000 \n");
				}
				if (rb2.isSelected()) {
                     cost =2000;
                     total= cost*days;
					area2.setText(area2.getText()
								+ "Price "
								+ "= "
								+ "2000 \n");
				}
				if (rb3.isSelected()) {
                       cost =1000;
                      total=cost*days;
					area2.setText(area2.getText()
								+ "Price "
								+ "="
                                +"1000 \n");
				}
				if (rb4.isSelected()) {
                       cost = 500;
                      total=cost*days;
					area2.setText(area2.getText()
								+ "Price "
								+ "="+" 500\n");
				}
                int parking;
                if (p1.isSelected()) {
                  parking = 100;
                  tc=total+(parking*days);
					area2.setText(area2.getText()
								+ "Parking"
								+ "="
								+ "100 \n");
				}
				if (p2.isSelected()) {
					area2.setText(area2.getText()
								+ "Parking "
								+ "= "
								+ "0\n");
				}
                System.out.println(tc);
                area2.setText(area2.getText()+"Total Cost:-"+tc+"/n");
				if (e.getSource() == Receipt) {
					try {
						FileWriter fw
							= new FileWriter(
								"java.txt", true);
						fw.write(area2.getText());
						fw.close();
					}
					catch (Exception ae) {
						System.out.println(ae);
					}
				}

				JOptionPane.showMessageDialog(
					area2, "DATA SAVED SUCCESSFULLY");
			};
		});
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(
					WindowEvent we)
				{
					System.exit(0);
				}
			});
   }
public static void main (String args[]){
   new  Hotel();
}

}