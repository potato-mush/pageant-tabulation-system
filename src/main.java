import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class main extends JFrame {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JButton CONFIRMButton;
    private JButton EXITButton;
    private JLabel header;

    public main(){
        add(mainPanel);
        setTitle("Pageant Tabulation System");
        setSize(865, 620);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


        CONFIRMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cbUser = (String) comboBox1.getSelectedItem();
                if (cbUser == "JUDGE"){
                    dispose();
                    login lg = new login();
                    lg.show();
                } else if (cbUser == "ADMINISTRATOR") {
                    dispose();
                    adminLogin al = new adminLogin();
                    al.show();
                } else if (cbUser == "CONTESTANT") {
                    dispose();
                    registrationForm rg = new registrationForm();
                    rg.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Select an account", "System Notice", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new main();
    }
}
