import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Counter extends Info_storage implements ActionListener {
    JFrame frame;
    CardLayout cardLayout;
    JLabel label;
    JButton add_user_button;
    JLabel existing_users;
    JPanel panel;

    public Counter(){
        // frame setup
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Counter");
        frame.setSize(720, 720);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 1));

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        //labels
        label = new JLabel("Counter");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setBorder(new EmptyBorder(50, 0, 100, 0));

        panel.add(label);

        // add user button
        add_user_button = new JButton("Add new user");
        add_user_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        add_user_button.setBorder(new EmptyBorder(50, 70, 50, 70));
        add_user_button.addActionListener(this);
        panel.add(add_user_button);

        container.add(panel);

        //displaying existing user info
        JPanel user_info_panel = new JPanel();
        user_info_panel.setLayout(new GridLayout(user_info.size(),3));
        for(String user: user_info.keySet()){
            JTextField user_name = new JTextField();
            user_name.setEditable(false);
            JTextField so_count = new JTextField();
            so_count.setEditable(false);
            JTextField uh_count = new JTextField();
            uh_count.setEditable(false);

            user_name.setText(user);
            uh_count.setText(String.valueOf(user_info.get(user).get(0)));
            so_count.setText(String.valueOf(user_info.get(user).get(1)));

            user_info_panel.add(user_name);
            user_info_panel.add(uh_count);
            user_info_panel.add(so_count);
        }

        container.add(user_info_panel);

        frame.add(container);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add_user_button){
            frame.dispose();
            Participant participant = new Participant();
        }
    }
}
