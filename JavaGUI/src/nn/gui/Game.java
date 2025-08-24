package nn.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame implements ActionListener {

    JButton btnAr[] = new JButton[9];
    JLabel showScore, showTime;
    int score = 0;
    int t = 30;
    Random rnd = new Random();
    int objOn;
    boolean running;

    public void addAllButton(JPanel p, JButton btnAr[], ActionListener lsn) {
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton("");
            btn.setActionCommand(String.valueOf(i));
            btn.addActionListener(lsn);
            p.add(btn);
            btnAr[i] = btn;
        }
    }

    public Game() {
        setTitle("Game");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel boxPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        showScore = new JLabel("Your score: " + score);
        scorePanel.add(showScore);
        showTime = new JLabel("Time: " + t);
        scorePanel.add(showTime);

        addAllButton(boxPanel, btnAr, this);

        mainPanel.add(scorePanel, BorderLayout.NORTH);
        mainPanel.add(boxPanel, BorderLayout.CENTER);
        add(mainPanel);

        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                t = t - 1;
                showTime.setText("Time: " + t);
                endGame();
            }
        }).start();

        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                makeRandom();
                cleanBoard();
                btnAr[objOn].setText("A");
            }
        }).start();

        running = true;
    }
    
    public static void main(String[] args) {
        new Game().setVisible(true);
    }
    
    public void makeRandom() {
        objOn = rnd.nextInt(9);
        // btnAr[objOn].setText("A");
    }
    
    public void cleanBoard()
    {
        for (JButton btn : btnAr) {
            btn.setText("");
        }
    }
    
    public void updateScore(int actioncmd)
    {
        int objActionCmd = Integer.parseInt(btnAr[objOn].getActionCommand());
        if(actioncmd == objActionCmd)
        {
            score = score + 100;
            showScore.setText("Your score: " + score);
        }
    }

    public void endGame()
    {
        if(t == 0)
        {
            JOptionPane.showMessageDialog(this, "Time up\nYour Score: " + score);
            running = false;    
        }
    }

    public void resetGame()
    {
        score = 0;
        t = 30; 
        running = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        updateScore(Integer.parseInt(btn.getActionCommand()));

        if(running == false)
        {
            resetGame();
            return;
        }
            
    }

}
