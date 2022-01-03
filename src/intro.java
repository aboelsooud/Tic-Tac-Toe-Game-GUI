import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class intro implements ActionListener{
    JFrame frame = new JFrame();
    JPanel top = new JPanel();
    JPanel center = new JPanel();
    JPanel bottom = new JPanel();
    JLabel label = new JLabel();
    JLabel firstname = new JLabel();
    JLabel secondname = new JLabel();
    JButton button = new JButton();
    JTextField fis = new JTextField();
    JTextField sec = new JTextField();

    intro(){
        ImageIcon logo = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setTitle("New Game");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setText("Tic-Tac-Toe");
        label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(80, 0, 80, 0));

        firstname.setText("First player name: ");
        firstname.setForeground(Color.RED);
        firstname.setHorizontalAlignment(JLabel.CENTER);
        fis.setPreferredSize(new Dimension(300, 30));
        secondname.setText("Second player name: ");
        secondname.setForeground(Color.BLUE);
        secondname.setHorizontalAlignment(JLabel.CENTER);
        sec.setPreferredSize(new Dimension(300,30));


        button.setText("Start");
        button.setFocusable(false);
        button.addActionListener(this);

        
    
        top.setLayout(new GridBagLayout());
        top.add(label);
        center.setLayout(new FlowLayout());
        center.add(firstname);
        center.add(fis);
        center.add(secondname);
        center.add(sec);
        bottom.setLayout(new GridBagLayout());
        bottom.add(button);
        bottom.setPreferredSize(new Dimension(100,150));
        
        frame.add(top, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.AFTER_LAST_LINE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            String s1 = fis.getText();
            String s2 = sec.getText();
            if(s1.isEmpty() && s2.isEmpty()){
                JOptionPane.showMessageDialog(null, "Player names cannot be NULL", "Erorr", JOptionPane.ERROR_MESSAGE);
            }else if(s1.isEmpty()){
                JOptionPane.showMessageDialog(null, "The first player name cannot be NULL", "Erorr", JOptionPane.ERROR_MESSAGE);
            }else if(s2.isEmpty()){
                JOptionPane.showMessageDialog(null, "The second player name cannot be NULL", "Erorr", JOptionPane.ERROR_MESSAGE);
            }else{
                frame.dispose();
                new XO(s1,s2);
            }
        }
    }
    
}
