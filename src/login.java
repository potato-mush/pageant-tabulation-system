import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton LOGINButton;
    private JButton CANCELButton;

    public login() {
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

                info = DBConn(username, password);
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

    public loginInfo DBConn(String username, String password){
        String url = "jdbc:mysql://localhost/pageant_db?serverTimezone=UTC";
        String user = "root";
        String pass = "";
        String query = "SELECT * FROM tbl_login WHERE username=? AND password=?";
        loginInfo info = null;

        try{
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                info = new loginInfo();
                info.username = rs.getString("username");
                info.password = rs.getString("password");

                JOptionPane.showMessageDialog(null, "Successfully Login!", "System Notice", JOptionPane.INFORMATION_MESSAGE);

                dispose();
                dashboard db = new dashboard();
                db.show();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "System Notice", JOptionPane.ERROR_MESSAGE);
            }

            ps.close();
            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return info;
    }


    public static void main(String[] args) {
        new login();
    }
}
