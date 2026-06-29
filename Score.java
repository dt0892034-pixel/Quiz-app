package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame {

    Score(String name,int score){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 =i1.getImage().getScaledInstance(700,550, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel imagee = new JLabel(i3);
        imagee.setBounds(0,0,700,550);
        imagee.setLayout(null);


JLabel heading =  new JLabel("Thank you  "  + name + "  for Playing QUIZ Test");
heading.setBounds(100,80,700,25);
heading.setFont(new Font("Times New Roman",Font.BOLD,25));
imagee.add(heading);

        JLabel scoreLabel = new JLabel("Your Score is : " + score);
        scoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setBounds(180, 200, 350, 30);
        imagee.add(scoreLabel);

        JButton exit = new JButton("Exit");
        exit.setBounds(275,380,150,40);
        exit.setBackground(new Color(22,99,54));
        exit.setForeground(Color.WHITE);
        imagee.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });


        add(imagee);



        setSize(750,550);
        setLocation(400,150);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}