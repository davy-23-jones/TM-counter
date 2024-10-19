import org.w3c.dom.xpath.XPathResult;

import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.jar.JarEntry;

public class Participant extends Counter implements ActionListener {
    JTextField counter1, counter2;
    JFrame frame;
    JPanel name_panel;
    JPanel counter_panel;
    JButton save_button, increment1, increment2, decrement1, decrement2;
    public Participant() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Add user");
        frame.setSize(720, 720);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 1));


        counter_panel = new JPanel();
        counter_panel.setLayout(new GridLayout(2, 2));
        counter_panel.setBorder(new EmptyBorder(50, 50, 50, 50));

        //Titles
        JTextField uh_textfield = new JTextField("UH...");
        JTextField so_textfield = new JTextField("SO...");

        //Buttons for first column
        increment1 = new JButton("INCREMENT");
        increment1.addActionListener(this);
        decrement1 = new JButton("DECREMENT");
        decrement1.addActionListener(this);

        //counter textfield for first column
        counter1 = new JTextField("0");

        //panel to wrap counter and buttons for first column
        JPanel wrapper1 = new JPanel();
        wrapper1.setLayout(new GridLayout(2, 1));
        wrapper1.add(counter1);

        //panel for the buttons for first column
        JPanel button_panel1 = new JPanel();
        button_panel1.setLayout(new GridLayout(1, 2));
        button_panel1.add(increment1);
        button_panel1.add(decrement1);
        wrapper1.add(button_panel1);

        //buttons for second column
        increment2 = new JButton("INCREMENT");
        increment2.addActionListener(this);
        decrement2 = new JButton("DECREMENT");
        decrement2.addActionListener(this);

        //wrapper for counter and buttons
        JPanel wrapper2 = new JPanel();
        wrapper2.setLayout(new GridLayout(2, 1));

        //textfield for counter, second column
        counter2 = new JTextField("0");
        wrapper2.add(counter2);

        //panel for buttons for the second column
        JPanel button_panel2 = new JPanel();
        button_panel2.setLayout(new GridLayout(1, 2));
        button_panel2.add(increment2);
        button_panel2.add(decrement2);

        wrapper2.add(button_panel2);


        counter_panel.add(uh_textfield);
        counter_panel.add(so_textfield);
        counter_panel.add(wrapper1);
        counter_panel.add(wrapper2);

        //save button and panel for save button
        save_button = new JButton("SAVE");
        save_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        save_button.addActionListener(this);
        JPanel save_button_panel = new JPanel();
        save_button_panel.setLayout(new BoxLayout(save_button_panel, BoxLayout.Y_AXIS));
        save_button_panel.add(save_button);

        container.add(counter_panel);
        container.add(save_button_panel);

        frame.add(container);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==save_button){
            ArrayList<String> counter_values = new ArrayList<>();
            counter_values.add(counter1.getText());
            counter_values.add(counter2.getText());
            user_info.put("user"+String.valueOf(user_index), counter_values);
            for(String user: user_info.keySet()) {
                System.out.println(user);
            }
            user_index = user_index + 1;
            frame.dispose();
            Counter counter = new Counter();
        }
        if(e.getSource()==increment1){
            counter1.setText(String.valueOf(Integer.valueOf(counter1.getText())+1));
        }
        if(e.getSource()==decrement1){
            counter1.setText(String.valueOf(Integer.valueOf(counter1.getText())-1));
        }
        if(e.getSource()==increment2){
            counter2.setText(String.valueOf(Integer.valueOf(counter2.getText())+1));
        }
        if(e.getSource()==decrement2){
            counter2.setText(String.valueOf(Integer.valueOf(counter2.getText())-1));
        }
    }
}
