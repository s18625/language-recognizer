import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame implements ActionListener {

    JTextArea area;
//    JTextField field;
//    JPanel panel;
    JButton check,clear;
    JTextField field;
    int[] guiVecor;
    String whichleng;

    public GUI(){
        check = new JButton("check");
        clear = new JButton("clear");
        area = new JTextArea();
        field = new JTextField();


        setTitle("enter your own text");
        setSize(550,450);
        setLocation(1000,500);
        setLayout(null);

        area.setLineWrap(true);
        area.setBounds(0,0,400,300);
        check.setBounds(400,0,150,200);
        clear.setBounds(400,200,150,200);
        check.addActionListener(this);
        clear.addActionListener(this);
        clear.setForeground(Color.RED);
        check.setFont(new Font("Courier", Font.BOLD,27));
        clear.setFont(new Font("Courier", Font.BOLD,27));
        field.setBounds(0,300,400,100);
        field.setBackground(Color.GRAY);
        field.setFont(new Font("Courier", Font.BOLD,27));
        field.setHorizontalAlignment(JTextField.CENTER);


        add(field);
        add(clear);
        add(area);
        add(check);



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == check) {
            String text = area.getText();
            ReadGui readGui = new ReadGui(text);
            guiVecor = readGui.getGuiVector();
            field.setText(whichleng);

            List<Integer> guiList = new ArrayList<>();
            Main.perceptron1.yValue(guiVecor);
            guiList.add(Main.perceptron1.getY());

            Main.perceptron2.yValue(guiVecor);
            guiList.add(Main.perceptron2.getY());

            Main.perceptron3.yValue(guiVecor);
            guiList.add(Main.perceptron3.getY());


            System.out.println(guiList);
            if (area.getText().equals("")){
                whichleng= "no text entered";
            }
            else if (guiList.equals(Main.listPerceptrons.get(0))){
                whichleng = Main.keys.get(0);
            }else if (guiList.equals(Main.listPerceptrons.get(1))){
                whichleng = Main.keys.get(1);
            }
            else if (guiList.equals(Main.listPerceptrons.get(2))){
                whichleng = Main.keys.get(2);
            }else {whichleng = "can't figure out what language";}





        }else if(src == clear){
            area.setText(null);
        }

    }
}
