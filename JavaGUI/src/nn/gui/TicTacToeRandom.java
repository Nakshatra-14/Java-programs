package nn.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class TicTacToeRandom extends JFrame implements ActionListener {

    int player = 1, moveCount = 0;
    Random rnd = new Random();
    JLabel playerNo, playwith;
    JButton btnAr[] = new JButton[9];
    Font font = new Font("Michroma", Font.PLAIN, 100);

    // int mat[][] = new int[3][3];
    int arr[] = new int[9];

    public void makeMatrix() {
        for (int i = 0; i < 9; i++)
            arr[i] = -1;
        // for(int j = 0 ; j < 3 ; j++)
        // mat[i][j] = 0;
    }

    public void resetGame() {
        // this.dispose();
        // new TicTacToe().setVisible(true);
        for (JButton b : btnAr) {
            b.setText("");
        }
        player = 1;
        makeMatrix();
        moveCount = 0;
    }

    public void systemMove() {
        print("System Move");
        int r = 0;
        do {
            r = rnd.nextInt(9);
        } while (arr[r] != -1);
        print("r = " + r);
        btnAr[r].doClick();
    }

    private void addAllButton(JPanel p, JButton btnAr[], ActionListener lsn) {
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton("");
            btn.setActionCommand(String.valueOf(i));
            btn.addActionListener(lsn);
            btn.setFont(font);
            p.add(btn);
            btnAr[i] = btn;
        }
    }

    public String playerMove() {
        if (player == 1)
            return "X";
        else
            return "O";
    }

    public void changePlayer(int p) {
        if (p == 1)
            player = 2;
        else
            player = 1;
    }

    public void updateMatrix(int i) {
        if (playerMove().equals("X"))
            arr[i] = 1;
        else
            arr[i] = 0;
    }

    public void print(String str) {
        System.out.println(str);
    }

    public boolean checkWinner() {
        int v = 1;
        if (player == 2)
            v = 0;
        return ((arr[0] == v && arr[0] == arr[1] && arr[1] == arr[2]) ||
                (arr[3] == v && arr[3] == arr[4] && arr[4] == arr[5]) ||
                (arr[6] == v && arr[6] == arr[7] && arr[7] == arr[8]) ||

                (arr[0] == v && arr[0] == arr[3] && arr[3] == arr[6]) ||
                (arr[1] == v && arr[1] == arr[4] && arr[4] == arr[7]) ||
                (arr[2] == v && arr[2] == arr[5] && arr[5] == arr[8]) ||

                (arr[0] == v && arr[0] == arr[4] && arr[4] == arr[8]) ||
                (arr[2] == v && arr[2] == arr[4] && arr[4] == arr[6])); 
    }

    public TicTacToeRandom() {
        setTitle("Tic Tac Toe");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel b = new JPanel(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(3, 3));
        JPanel f = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 30));
        // JPanel p = new JPanel(new GridLayout(3, 3, 10, 10));

        // for(int i = 0; i < 9 ; i++)
        // addButton(p, "", String.valueOf(i), this, true);
        addAllButton(p, btnAr, this);
        b.add(p, BorderLayout.CENTER);

        playerNo = new JLabel("");
        playwith = new JLabel("");

        // playerNo = new JButton("");
        // playwith = new JButton("");

        f.add(playerNo);
        f.add(playwith);

        b.add(f, BorderLayout.SOUTH);

        add(b);

        playerNo.setText("Player: " + player);
        playwith.setText("With: " + playerMove());

        makeMatrix();
    }

    public static void main(String[] args) {
        new TicTacToeRandom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (!btn.getText().isEmpty())
            return;
        moveCount++;
        btn.setText(playerMove());

        updateMatrix(Integer.parseInt(btn.getActionCommand()));

        boolean isWin = checkWinner();
        if(isWin)
        {
            if (player == 1) {
                print("Player 1 win");
                JOptionPane.showMessageDialog(this, "Player 1 win");
            } else {
                print("Player 2 win");
                JOptionPane.showMessageDialog(this, "Player 2 win");

            }
        }
        else if(moveCount == 9)
            JOptionPane.showMessageDialog(this, "Game is Draw");


        if(isWin || moveCount == 9)
        {
            resetGame();
            return;
        }

        changePlayer(player);

        playerNo.setText("Player: " + player);
        playwith.setText("With: " + playerMove());

        System.out.println(Arrays.toString(arr));

        System.out.println("Player: " + player + "\nMoveCount: " + moveCount) ;
        if (player == 2)
            systemMove();
    }
}
