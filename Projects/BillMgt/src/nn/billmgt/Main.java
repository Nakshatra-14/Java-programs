package nn.billmgt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Main {

    // BillInfo
    private static JLabel lblBillNo = new JLabel();
    private static JTextField txtFdBillDate = new JTextField(10);
    private static JTextField txtFdcustName = new JTextField(20);
    private static JTextField txtFdcustPhone = new JTextField(13);

    // itemMgt
    private static JList<String> lst;
    private static JTable tabDetails;
    private static JButton btnAdd = new JButton("Add");
    private static JButton btnRemove = new JButton("Remove");

    // paymentDetail
    private static JComboBox<String> cmdItem;
    private static JTextField txtFdItemQuant = new JTextField(10);
    private static JLabel lblItemPrice = new JLabel("TestValue");
    private static JLabel lblItemDiscount = new JLabel("TestValue");
    private static JLabel lblGrandTot = new JLabel("TestValue");
    private static JLabel lblGrandDis = new JLabel("TestValue");
    private static JLabel lblRoundOff = new JLabel("TestValue");
    private static JLabel lblBillAmt = new JLabel("TestValue");
    private static JButton btnSave = new JButton("Save");
    private static JButton btnPrint = new JButton("Print");

    // navigationAndCRUD
    private static JButton btnPrev = new JButton("Previous Bill");
    private static JButton btnNext = new JButton("Next Bill");
    private static JButton btnNewBill = new JButton("New Bill");
    private static JButton btnEditBill = new JButton("Edit Bill");
    private static JButton btnDeleteBill = new JButton("Delele Bill");
    private static JButton btnCancel = new JButton("Cancel");
    private static int curIndex = -1;

    private static record BillInfo(int billNo, Date billDt, String custName, String custPhone) {
    }

    private static record Item(int slNo, String itemName, int quantity, double price, double discount) {
        @Override
        public final String toString() {
            return String.format(" %-21d | %-46s | %-23d | %-24.2f | %.2f%%", slNo, itemName, quantity, price,
                    discount);
        }
    }

    private static ArrayList<BillInfo> bill;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static JPanel itemAddPanel = new JPanel();
    private static char aen = 'n';

    public static void main(String[] args) throws SQLException, ParseException {

        lst = new JList<>();
        lst.setFont(new Font("Monospaced", Font.PLAIN, 15));
        DefaultListModel<String> model = new DefaultListModel<>();
        lst.setModel(model);

        tabDetails = new JTable();

        bill = getALLBillInfo();

        cmdItem = new JComboBox<>(getItemsNames());
        curIndex = 0;

        JFrame frm = new JFrame();
        Insets insets = new Insets(5, 5, 5, 5);
        GridBagConstraints gbc;
        JPanel p;
        JPanel billInfoPanel = new JPanel(new GridBagLayout());
        // JPanel a = new JPanel();
        // a.add(new JLabel("Bill No.:"));
        // a.add(billNo);
        // billInfoPanel.add(a);
        // a = new JPanel();
        // a.add(new JLabel("Bill Date:"));
        // a.add(lblBillDate);
        // billInfoPanel.add(a);
        // a = new JPanel();
        // a.add(new JLabel("Customer Name:"));
        // a.add(txtFdcustName);
        // billInfoPanel.add(a);
        // a = new JPanel();
        // a.add(new JLabel("Phone:"));
        // a.add(txtFdcustPhone);
        // billInfoPanel.add(a);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        // JPanel p = new JPanel(new GridLayout(2, 2, 20, 10));
        gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        billInfoPanel.add(new JLabel("Bill no.:"), gbc);
        gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        billInfoPanel.add(lblBillNo, gbc);
        gbc = new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        billInfoPanel.add(new JLabel("Bill Date:"), gbc);
        gbc = new GridBagConstraints(3, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        billInfoPanel.add(txtFdBillDate, gbc);
        gbc = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        billInfoPanel.add(new JLabel("Customer Name:"), gbc);
        gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        billInfoPanel.add(txtFdcustName, gbc);
        gbc = new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        billInfoPanel.add(new JLabel("Phone:"), gbc);
        gbc = new GridBagConstraints(3, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        billInfoPanel.add(txtFdcustPhone, gbc);
        billInfoPanel.setBorder(border);
        // JPanel p = new JPanel(new GridLayout(2, 2, 20, 10));
        // JPanel p2 = new JPanel();
        // p2.add(new JLabel("Bill no.:"));
        // p2.add(txtFdBillNo);
        // p.add(p2);
        // p2 = new JPanel();
        // p2.add(new JLabel("Bill Date:"));
        // p2.add(txtFdBillDate);
        // p.add(p2);
        // p2 = new JPanel();
        // p2.add(new JLabel("Customer Name:"));
        // p2.add(txtFdcustName);
        // p.add(p2);
        // p2 = new JPanel();
        // p2.add(new JLabel("Phone:"));
        // p2.add(txtFdcustPhone);
        // p.add(p2);
        // billInfoPanel.add(p);

        JPanel itemMgtPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0,
                0);
        itemMgtPanel.add(new JLabel("Sl.No."), gbc);
        gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0,
                0);
        itemMgtPanel.add(new JLabel("Item Name"), gbc);
        gbc = new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        itemMgtPanel.add(new JLabel("Quantity"), gbc);
        gbc = new GridBagConstraints(3, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        itemMgtPanel.add(new JLabel("Price"), gbc);
        gbc = new GridBagConstraints(4, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        itemMgtPanel.add(new JLabel("Discount......"), gbc);
        gbc = new GridBagConstraints(0, 1, 5, 2, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0,
                0);
        // itemMgtPanel.add(new JScrollPane(lst), gbc);
        itemMgtPanel.add(new JScrollPane(tabDetails), gbc);
        gbc = new GridBagConstraints(5, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0,
                0);
        itemMgtPanel.add(btnAdd, gbc);
        gbc = new GridBagConstraints(5, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0,
                0);
        itemMgtPanel.add(btnRemove, gbc);
        itemMgtPanel.setBorder(border);

        JPanel paymentDetailPanel = new JPanel(new GridBagLayout());
        itemAddPanel = new JPanel(new GridLayout(0, 5, 90, 10));
        itemAddPanel.add(new JLabel("Product Name:"));
        itemAddPanel.add(cmdItem);
        itemAddPanel.add(txtFdItemQuant);
        itemAddPanel.add(lblItemPrice);
        itemAddPanel.add(lblItemDiscount);
        itemAddPanel.setBorder(BorderFactory.createTitledBorder("Add Item"));
        paymentDetailPanel.add(itemAddPanel);
        gbc = new GridBagConstraints(3, 1, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        paymentDetailPanel.add(new JLabel("Grand Total:"), gbc);
        gbc = new GridBagConstraints(4, 1, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        paymentDetailPanel.add(lblGrandTot, gbc);
        gbc = new GridBagConstraints(3, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        paymentDetailPanel.add(new JLabel("Grand Discount:"), gbc);
        gbc = new GridBagConstraints(4, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        paymentDetailPanel.add(lblGrandDis, gbc);
        gbc = new GridBagConstraints(3, 3, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        paymentDetailPanel.add(new JLabel("Round Off(+/-):"), gbc);
        gbc = new GridBagConstraints(4, 3, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        paymentDetailPanel.add(lblRoundOff, gbc);
        gbc = new GridBagConstraints(3, 4, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0,
                0);
        paymentDetailPanel.add(new JLabel("Bill Amount:"), gbc);
        gbc = new GridBagConstraints(4, 4, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        paymentDetailPanel.add(lblBillAmt, gbc);
        gbc = new GridBagConstraints(3, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        paymentDetailPanel.add(btnSave, gbc);
        gbc = new GridBagConstraints(4, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        paymentDetailPanel.add(btnPrint, gbc);
        gbc = new GridBagConstraints(5, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                insets, 0, 0);
        paymentDetailPanel.add(new JLabel(""), gbc);
        paymentDetailPanel.setBorder(border);

        JPanel navigationAndCRUDPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        p = new JPanel(new GridLayout(0, 2, 10, 10));
        p.add(btnPrev);
        p.add(btnNext);
        p.setBorder(BorderFactory.createTitledBorder("Navigation"));
        navigationAndCRUDPanel.add(p);
        p = new JPanel(new GridLayout(0, 3, 10, 10));
        p.add(btnNewBill);
        p.add(btnEditBill);
        p.add(btnDeleteBill);
        p.setBorder(BorderFactory.createTitledBorder("Operation"));
        navigationAndCRUDPanel.add(p);
        navigationAndCRUDPanel.add(new JPanel().add(btnCancel));
        navigationAndCRUDPanel.setBorder(border);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets,
                0, 0);
        mainPanel.add(billInfoPanel, gbc);
        gbc = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0,
                0);
        mainPanel.add(itemMgtPanel, gbc);
        gbc = new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0,
                0);
        mainPanel.add(paymentDetailPanel, gbc);
        gbc = new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0,
                0);
        mainPanel.add(navigationAndCRUDPanel, gbc);
        mainPanel.setBorder(border);
        frm.add(mainPanel);

        ActionListener navAl = ev -> {
            JButton btn = (JButton) ev.getSource();
            switch (btn.getText()) {
                case "Previous Bill" -> {
                    curIndex--;
                    if (curIndex < 0)
                        curIndex = bill.size() - 1;
                    model.removeAllElements();
                }
                case "Next Bill" -> {
                    curIndex++;
                    if (curIndex > bill.size() - 1)
                        curIndex = 0;
                    model.removeAllElements();
                }
            }
            showData(curIndex, model);
        };

        addBtnActionListener(btnPrev, navAl);
        addBtnActionListener(btnNext, navAl);

        ActionListener operationAl = ev -> {
            JButton btn = (JButton) ev.getSource();

            switch (btn.getText()) {
                case "New Bill" -> {
                    aen = 'a';
                    blankDataForNew(model);
                }
                case "Edit Bill" -> {
                    aen = 'e';
                    enableEditForEdit();

                }
                case "Save" -> {
                    addNewData();

                }
                case "Delele Bill" -> {
                    bill.remove(curIndex);
                        showData(curIndex, model);
                }
                
                case "Cancel" -> {
                    if (aen == 'a')
                        cancelWorkWhileNew(model);              
                    else if (aen == 'e')
                        cancelWorkWhileEdit(model);
                        showData(curIndex, model);
                    
                    aen = 'n';
                
                }
            }
        };

        addBtnActionListener(btnNewBill, operationAl);
        addBtnActionListener(btnEditBill, operationAl);
        addBtnActionListener(btnSave, operationAl);
        addBtnActionListener(btnDeleteBill, operationAl);
        addBtnActionListener(btnCancel, operationAl);

        onStartButtons();
        showData(curIndex, model);

        frm.setVisible(true);
        frm.pack();
        frm.setResizable(false);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void addBtnActionListener(JButton btn, ActionListener al) {
        btn.addActionListener(al);
    }

    public static void showData(int curIndex, DefaultListModel<String> model) {
        // billInfo
        int billNo = bill.get(curIndex).billNo();
        Date billDt = bill.get(curIndex).billDt();
        String custName = bill.get(curIndex).custName();
        String custPhone = bill.get(curIndex).custPhone();
        lblBillNo.setText(String.valueOf(billNo));
        txtFdBillDate.setText(sdf.format(billDt));
        txtFdcustName.setText(custName);
        txtFdcustPhone.setText(custPhone);

        // itemMgt
        double grandTot = 0;
        double grandDis = 0;
        ArrayList<Item> listItem = getCustItems(billNo);
        for (Item i : listItem) {
            model.addElement(i.toString());
            grandTot += i.price();
            grandDis += i.discount();
        }
        lblGrandTot.setText(String.format("%.2f", grandTot));
        lblGrandDis.setText(String.format("%.2f", grandDis) + "%");
        lblRoundOff.setText(String.format("%.2f", Math.round(grandTot) - grandTot));
        lblBillAmt.setText(String.format("%.2f", grandTot - (grandTot * (grandDis / 100))));
    }

    public static void addNewData() {
        Date billDt = null;
        int billno = Integer.parseInt(lblBillNo.getText());
        String custName = txtFdcustName.getText();
        try {
            billDt = sdf.parse(txtFdBillDate.getText());
        } catch (ParseException ex) {ex.printStackTrace();}
        String custPhone = txtFdcustPhone.getText();
        BillInfo b = new BillInfo(billno, billDt, custName, String.valueOf(custPhone));
        bill.add(b);
        
    }

    public static ArrayList<Item> getCustItems(int billNo) {
        ArrayList<Item> al = new ArrayList<>();
        try (
                Connection con = MySQL_Connector.getConnection("bill");
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("select sd.SlNo, i.itemName, sd.Qty, i.itemPrice, i.discount\n" + //
                    "from salesDetails sd, item i, sales s\n" + //
                    "where sd.itemId = i.itemId and sd.billId = s.BillId and s.BIllNo = " + billNo + "\n" + //
                    "order by 1");
            while (rs.next())
                al.add(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5)));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return al;
    }

    public static ArrayList<BillInfo> getALLBillInfo() throws SQLException {
        ArrayList<BillInfo> al = new ArrayList<>();
        try (
                Connection con = MySQL_Connector.getConnection("bill");
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("select BillNo, BillDt, CustName, CustPhone, BillAmt\n" + //
                    "from sales\n" + //
                    "order by 1");
            while (rs.next())
                al.add(new BillInfo(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4)));
        }
        return al;
    }

    public static String[] getItemsNames() throws SQLException {
        List<String> al = new ArrayList<>();
        try (
                Connection con = MySQL_Connector.getConnection("bill");
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("select itemName\n" + //
                    "from item\n" + //
                    "order by 1");
            while (rs.next())
                al.add(rs.getString(1));
        }
        String arr[] = new String[al.size()];
        return al.toArray(arr);
    }

    public static void onStartButtons() {
        btnAdd.setEnabled(false);
        btnRemove.setEnabled(false);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        itemAddPanel.setEnabled(false);
        Component c[] = itemAddPanel.getComponents();
        for (Component comp : c)
            comp.setEnabled(false);
        txtFdBillDate.setEditable(false);
        txtFdcustName.setEditable(false);
        txtFdcustPhone.setEditable(false);
    }

    public static void blankDataForNew(DefaultListModel<String> model) {
        lblBillNo.setText(String.valueOf(bill.get(bill.size() - 1).billNo + 1));
        txtFdcustName.setText("");
        txtFdBillDate.setText(sdf.format(new Date()));
        txtFdcustPhone.setText("");
        btnAdd.setEnabled(true);
        btnRemove.setEnabled(true);
        btnSave.setEnabled(true);
        btnEditBill.setEnabled(false);
        btnPrint.setEnabled(false);
        btnDeleteBill.setEnabled(false);
        btnPrev.setEnabled(false);
        btnNext.setEnabled(false);
        btnCancel.setEnabled(true);
        itemAddPanel.setEnabled(true);
        Component c[] = itemAddPanel.getComponents();
        for (Component comp : c)
            comp.setEnabled(true);
        txtFdBillDate.setEditable(true);
        txtFdcustName.setEditable(true);
        txtFdcustPhone.setEditable(true);
        model.removeAllElements();
    }

    public static void cancelWorkWhileNew(DefaultListModel<String> model) {
        showData(curIndex, model);
        btnAdd.setEnabled(false);
        btnRemove.setEnabled(false);
        btnSave.setEnabled(false);
        btnEditBill.setEnabled(true);
        btnPrint.setEnabled(true);
        btnDeleteBill.setEnabled(true);
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        btnCancel.setEnabled(false);
        itemAddPanel.setEnabled(false);
        Component c[] = itemAddPanel.getComponents();
        for (Component comp : c)
            comp.setEnabled(false);
        txtFdBillDate.setEditable(false);
        txtFdcustName.setEditable(false);
        txtFdcustPhone.setEditable(false);
    }

    public static void enableEditForEdit() {
        btnAdd.setEnabled(true);
        btnRemove.setEnabled(true);
        btnSave.setEnabled(true);
        btnEditBill.setEnabled(true);
        btnNewBill.setEnabled(false);
        btnPrint.setEnabled(false);
        btnDeleteBill.setEnabled(false);
        btnPrev.setEnabled(false);
        btnNext.setEnabled(false);
        btnCancel.setEnabled(true);
        itemAddPanel.setEnabled(true);
        Component c[] = itemAddPanel.getComponents();
        for (Component comp : c)
            comp.setEnabled(true);
        txtFdBillDate.setEditable(true);
        txtFdcustName.setEditable(true);
        txtFdcustPhone.setEditable(true);
    }

    public static void cancelWorkWhileEdit(DefaultListModel<String> model) {
        showData(curIndex, model);
        btnAdd.setEnabled(false);
        btnRemove.setEnabled(false);
        btnSave.setEnabled(false);
        btnNewBill.setEnabled(true);
        btnEditBill.setEnabled(true);
        btnPrint.setEnabled(true);
        btnDeleteBill.setEnabled(true);
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        btnCancel.setEnabled(false);
        itemAddPanel.setEnabled(false);
        Component c[] = itemAddPanel.getComponents();
        for (Component comp : c)
            comp.setEnabled(false);
        txtFdBillDate.setEditable(false);
        txtFdcustName.setEditable(false);
        txtFdcustPhone.setEditable(false);
    }
}
