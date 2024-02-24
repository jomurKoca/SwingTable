import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTableExample extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField textFieldName;
    private JTextField textFieldAge;
    private JButton addButton;

    public SwingTableExample() {
        setTitle("Swing Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // create Tablemodel
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Alt");

        //create table and model
        table = new JTable(tableModel);

        // data input
        textFieldName = new JTextField(10);
        textFieldAge = new JTextField(10);

        // create an add button
        addButton = new JButton("add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addData();
            }
        });

        // Layout
        setLayout(new BorderLayout());

        // Buton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JLabel("Name:"));
        buttonPanel.add(textFieldName);
        buttonPanel.add(new JLabel("Age:"));
        buttonPanel.add(textFieldAge);
        buttonPanel.add(addButton);

        //add table and button panel to Frame
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // add data to Table
    private void addData() {
        String name = textFieldName.getText();
        String age = textFieldAge.getText();

        // line for data
        String[] rowData = {name, age};
        // Satırı tabloya ekle
        tableModel.addRow(rowData);

        // clean data input bereich
        textFieldName.setText("");
        textFieldAge.setText("");
    }

    public static void main(String[] args) {
        SwingTableExample example = new SwingTableExample();
        example.setVisible(true);
    }
}
