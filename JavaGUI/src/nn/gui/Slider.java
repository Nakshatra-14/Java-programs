package nn.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Slider implements ActionListener {

    static Random rnd = new Random();
    JButton btn[] = new JButton[16];
    int arr[] = new int[16];
    int moveable[] = { -1, -1 };
    JButton btnSuffle;

    // public void setZeroInArr()
    // {
    // for(int i = 0 ; i < arr.length-1 ; i++)
    // arr[i] = -1;
    // arr[arr.length - 1] = 0;
    // System.out.println(Arrays.toString(arr));
    // }

    public void suffleArr() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 14; i > 0; i--) {
            int j = rnd.nextInt(i);
            // swap arr[i], arr[j]
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public boolean checkRepeat(int ar[], int n) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] == n)
                return false;
        }
        return true;
    }

    // public void genRndArr(int ar[]) {
    // System.out.println("generating...");
    // for (int i = 0; i < ar.length - 1; i++) {
    // int n = rnd.nextInt(12);
    // while (checkRepeat(ar, n) != true)
    // n = rnd.nextInt(12);
    // ar[i] = n;
    // ar[ar.length - 1] = 0;
    // }
    // }

    private void addAllButton(JPanel p, JButton btnAr[], ActionListener lsn) {
        for (int i = 0; i < 16; i++) {
            JButton btn = new JButton();
            btn.setActionCommand(String.valueOf(i));
            btn.addActionListener(lsn);
            p.add(btn);
            btnAr[i] = btn;
        }
        btnAr[btnAr.length - 1].setVisible(false);
    }

    public void showSlider() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 16) {
                btn[i].setText(String.valueOf(arr[i]));
                btn[i].setVisible(true);
            } else {
                btn[i].setVisible(false);
            }
        }
    }

    public void execute(int index) {
        int row = index / 4;
        int col = index % 4;
        System.out.println(Arrays.toString(arr));
        // search for index of element 16
        int index16 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 16) {
                index16 = i;
                break;
            }
        }
        System.out.println("Found at " + index16);
        int row16 = index16 / 4;
        int col16 = index16 % 4;

        boolean sameRow = row == row16;
        boolean sameCol = col == col16;

        if (sameRow) {
            if (col16 > col) // 16 is on right
            {
                // shift to right
                for (int j = index16; j > index; j--) {
                    arr[j] = arr[j - 1];
                }
            }
            else //if(col16 < col) // 16 is on left
            {
                //shift to left
                for(int j = index16 ; j < index ; j++)
                {
                    arr[j] = arr[j + 1];
                }
            }
            arr[index] = 16;
            showSlider();
        }

        else if(sameCol)
        {
            if(row16 > row) // 16 is on down
            {
                //shift to down
                for(int i = index16 ; i > index ; i-=4)
                {
                    arr[i] = arr[i - 4];
                }
            }
            else //if(row16 < row) // 16 is on up
            {
                for(int i = index16 ; i < index ; i+= 4)
                {
                    arr[i] = arr[i + 4];
                }
            }
            arr[index] = 16;
            showSlider();
        }

        System.out.println(Arrays.toString(arr));

    }

    public Slider() {
        JFrame frm = new JFrame();
        frm.setTitle("Slider Game");
        frm.setSize(500, 500);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);

        suffleArr();

        JPanel sliderPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        btnSuffle = new JButton("Suffle");
        btnSuffle.addActionListener(this);

        // setZeroInArr();
        // genRndArr(arr);
        addAllButton(sliderPanel, btn, this);
        frm.add(sliderPanel, BorderLayout.CENTER);
        frm.add(btnSuffle, BorderLayout.SOUTH);
        btnSuffle.doClick();
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new Slider();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn == btnSuffle) {
            suffleArr();
            showSlider();
        }
        else
        {
            execute(Integer.parseInt(btn.getActionCommand()));
        }

    }

}
