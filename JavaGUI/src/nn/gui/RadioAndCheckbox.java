package nn.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioAndCheckbox {
    JCheckBox chkLunch = new JCheckBox("Want Lunch");
    JCheckBox chkDinner = new JCheckBox("Want Dinner");

    JRadioButton radBiryani = new JRadioButton("Biriyani");
    JRadioButton radFriedRice = new JRadioButton("Fried Rice");
    JRadioButton radPuri = new JRadioButton("Puri");
    JRadioButton radParatha = new JRadioButton("Paratha");

    JRadioButton radMale = new JRadioButton("Male");
    JRadioButton radFemale = new JRadioButton("Female");

    JButton btnGo = new JButton("Go");

    private void enableDisableMeal(boolean enabled)
    {
        radBiryani.setEnabled(enabled);
        radFriedRice.setEnabled(enabled);
        radPuri.setEnabled(enabled);
        radParatha.setEnabled(enabled);
    }

    public RadioAndCheckbox() {
        JFrame frm = new JFrame("Radio Btn and Chk Tester");

        JPanel maiPanel = new JPanel();

        chkLunch.addActionListener( _ -> enableDisableMeal(chkLunch.isSelected()));

        // chkLunch.addActionListener(new ActionListener() {

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
               
        //         enableDisableMeal(chkLunch.isSelected());
        //     }
        
        // });

        btnGo.addActionListener(_ -> 
        {
            String meal;
            if(radBiryani.isSelected())
                meal = radBiryani.getText();
            else if(radFriedRice.isSelected())
                meal = radFriedRice.getText();
            else if(radPuri.isSelected())
                meal = radPuri.getText();
            else
                meal = radParatha.getText();

            String gender;
            if(radMale.isSelected())
                gender = radMale.getText();
            else
                gender = radFemale.getText();

            System.out.println("Meal is: " + meal + " and gender is selected as " + gender);
        });

        radBiryani.setSelected(true);
        radFemale.setSelected(true);

        chkLunch.setSelected(true);

        maiPanel.add(chkLunch);
        maiPanel.add(chkDinner);

        ButtonGroup grpBtn = new ButtonGroup();
        grpBtn.add(radBiryani);
        grpBtn.add(radFriedRice);
        grpBtn.add(radPuri);
        grpBtn.add(radParatha);

        JPanel mealPanel = new JPanel();
        mealPanel.setBorder(BorderFactory.createTitledBorder("Meal"));
        mealPanel.add(radBiryani);
        mealPanel.add(radFriedRice);
        mealPanel.add(radPuri);
        mealPanel.add(radParatha);

        ButtonGroup grpGender = new ButtonGroup();
        grpGender.add(radFemale);
        grpGender.add(radMale);

        JPanel genderPanel = new JPanel();
        genderPanel.setBorder(BorderFactory.createTitledBorder("Gender"));
        genderPanel.add(radFemale);
        genderPanel.add(radMale);

        maiPanel.add(mealPanel);
        maiPanel.add(genderPanel);
        maiPanel.add(btnGo);

        frm.add(maiPanel);
        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new RadioAndCheckbox();
    }
}