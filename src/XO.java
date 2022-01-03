import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class XO implements ActionListener {
    
    
    Random ran = new Random();
    JFrame frame = new JFrame();
    JPanel text_panal = new JPanel();
    JPanel grid_panel = new JPanel();
    JLabel label = new JLabel(); 
    JButton[] buttons = new JButton[9];
    boolean turn1;
    String s = new String();
    int cnt = 0;
    boolean change = true;
    String fis = new String();
    String sec = new String();

    XO(String s1, String s2){
        fis = s1;
        sec = s2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setForeground(new Color(125, 125, 125));
        label.setBackground(Color.BLACK);
        label.setText("Tic-Tac-Toe");
        label.setFont(new Font("comic sans", Font.BOLD, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);

        text_panal.setLayout(new BorderLayout());
        text_panal.setBounds(0, 0, 100, 600);
        
        grid_panel.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            grid_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this); 
        }

        text_panal.add(label);
        frame.add(text_panal, BorderLayout.NORTH);
        frame.add(grid_panel);


        start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9 ; i++){
            if(e.getSource() == buttons[i]){
                if(turn1){
                    if(buttons[i].getText() == ""){
                        cnt++;
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        turn1 = false;
                        check();
                        if(change){
                            if(s == fis){
                                s = sec;
                            }else s = fis;
                            label.setText(s);
                        }
                    }
                }else{
                    if(buttons[i].getText() == ""){
                        cnt++;
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        turn1 = true;
                        check();
                        if(change){
                            if(s == fis){
                                s = sec;
                            }else s = fis;
                            label.setText(s);
                        }
                    }
                }
            }
        }
    }

    public void start(){
        if(ran.nextInt(2) == 1){
            turn1 = true;
            s = fis;
            label.setText(s);
        }else{
            turn1 = false;
            s = sec;
            label.setText(s);
        }
    }

    public void check(){
        if((buttons[0].getText() == buttons[1].getText() && buttons[1].getText() == buttons[2].getText() && buttons[1].getText() != ""))
            win(0,1,2);
        else if((buttons[3].getText() == buttons[4].getText() && buttons[4].getText() == buttons[5].getText() && buttons[4].getText() != ""))
            win(3,4,5);
        else if ((buttons[6].getText() == buttons[7].getText() && buttons[7].getText() == buttons[8].getText() && buttons[7].getText() != ""))
            win(6,7,8);
        else if((buttons[0].getText() == buttons[3].getText() && buttons[3].getText() == buttons[6].getText() && buttons[3].getText() != ""))
            win(0,3,6);
        else if((buttons[1].getText() == buttons[4].getText() && buttons[4].getText() == buttons[7].getText() && buttons[4].getText() != ""))
            win(1,4,7);
        else if((buttons[2].getText() == buttons[5].getText() && buttons[5].getText() == buttons[8].getText() && buttons[5].getText() != ""))
            win(2,5,8);
        else if((buttons[0].getText() == buttons[4].getText() && buttons[4].getText() == buttons[8].getText() && buttons[4].getText() != ""))
            win(0,4,8);
        else if((buttons[2].getText() == buttons[4].getText() && buttons[4].getText() == buttons[6].getText() && buttons[4].getText() != ""))
            win(2,4,6);
        
        if(cnt == 9 && change)
            tie();
    }

    public void win(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
        label.setText(s + " wins");
        label.setForeground(Color.GREEN);
        change = false;
        restart();
    }

    public void tie(){
        for(int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
            label.setText("Tie");
        change = false;
        restart();
    }

    public void restart(){
        int x = JOptionPane.showConfirmDialog(null, "Play again?", "Restart", JOptionPane.YES_NO_OPTION);
        if(x == 0){
            frame.dispose();
            new XO(fis, sec);
        }else{
            frame.dispose();
            new intro();
        }
    }
    
}
