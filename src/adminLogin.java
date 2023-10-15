import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class adminLogin extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LOGINButton;
    private JButton CANCELButton;

    public adminLogin() {
        add(mainPanel);
        setSize(350, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setVisible(true);
        setLocationRelativeTo(null);
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());

                info = DBConn2(username, password);
            }
        });
        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                main Main = new main();
                Main.show();
            }
        });
    }
    public loginInfo info;

    public loginInfo DBConn2(String username, String password){
        String url = "jdbc:mysql://localhost/pageant_db?serverTimezone=UTC";
        String user = "root";
        String pass = "";
        String query2 = "SELECT * FROM tbl_admin WHERE username=? AND password=?";
        loginInfo info = null;

        try{
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1, username);
            ps2.setString(2, password);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()){
                info = new loginInfo();
                info.username = rs2.getString("username");
                info.password = rs2.getString("password");

                JOptionPane.showMessageDialog(null, "Successfully Login!", "System Notice", JOptionPane.INFORMATION_MESSAGE);

                dispose();
                admin Admin = new admin();
                Admin.show();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "System Notice", JOptionPane.ERROR_MESSAGE);
            }

            ps2.close();
            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return info;
    }


    public static void main(String[] args) {
        new adminLogin();
    }
}
