import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class admin extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JLabel lblSignout;
    private JLabel lblIcon;

    public admin() {
        add(mainPanel);
        setSize(900, 600);
        setTitle("ADMIN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblIcon.setIcon(new ImageIcon(new ImageIcon("images/crown.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));

        tables();

        setLocationRelativeTo(null);
        setVisible(true);
        lblSignout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                main Main = new main();
                Main.show();
            }
        });
    }

    public void tables(){
        table1.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "No.", "Candidate's Name", "Contact", "Age", "Birth Date", "Height", "Weight"
                }
        ));
        displayContestants();
        table2.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Top", "Candidate's Name", "Content & Delivery", "Clarification", "Poise & Projection", "Total"
                }
        ));
        displayTalentScore();
        table3.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Top", "Candidate's Name", "Poise & Smartness", "Confidence", "Audience Impact", "Total"
                }
        ));
        displayGownScore();
        table4.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Top", "Candidate's Name", "Poise & Smartness", "Confidence", "Audience Impact", "Total"
                }
        ));
        displaySwimsuit();
        table5.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Top", "Candidate's Name", "Intelligence", "Beauty", "Poise & Bearing", "Total"
                }
        ));
        displayFinalScore();
    }

    public void displayContestants() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pageant_db?serverTimezone=UTC","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_contestants");

            int counter = 0;
            while(rs.next()) {
                String fullname = rs.getString("fullname");
                String contact = rs.getString("contact");
                String age = rs.getString("age");
                String birthdate = rs.getString("birthdate");
                Integer height = rs.getInt("height");
                Integer weight = rs.getInt("weight");


                String tbData [] = {String.valueOf(++counter), fullname, contact, age, birthdate, String.valueOf(height), String.valueOf(weight)};
                DefaultTableModel tblModel = (DefaultTableModel)table1.getModel();

                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayTalentScore(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pageant_db?serverTimezone=UTC","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_talent ORDER BY talent_total DESC ");

            int counter = 0;
            while(rs.next()) {
                String fullname = rs.getString("fullname");
                Integer content_delivery = rs.getInt( "content_delivery");
                Integer clarification = rs.getInt( "clarification");
                Integer poise_projection = rs.getInt( "poise_projection");
                Integer total = rs.getInt( "talent_total");

                String tbData [] = {String.valueOf(++counter), fullname, String.valueOf(content_delivery), String.valueOf(clarification), String.valueOf(poise_projection), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table2.getModel();

                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayGownScore(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pageant_db?serverTimezone=UTC","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_gown ORDER BY gown_total DESC");

            int counter = 0;
            while(rs.next()) {
                String fullname = rs.getString("fullname");
                Integer poise_smartness = rs.getInt( "poise_smartness");
                Integer confidence = rs.getInt( "confidence");
                Integer audience_impact = rs.getInt( "audience_impact");
                Integer total = rs.getInt( "gown_total");

                String tbData [] = {String.valueOf(++counter), fullname, String.valueOf(poise_smartness), String.valueOf(confidence), String.valueOf(audience_impact), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table3.getModel();

                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void displaySwimsuit(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pageant_db?serverTimezone=UTC","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_swimsuit ORDER BY swimsuit_total DESC");

            int counter = 0;
            while(rs.next()) {
                String fullname = rs.getString("fullname");
                Integer poise_smartness = rs.getInt( "poise_smartness");
                Integer confidence = rs.getInt( "confidence");
                Integer audience_impact = rs.getInt( "audience_impact");
                Integer total = rs.getInt( "swimsuit_total");

                String tbData [] = {String.valueOf(++counter), fullname, String.valueOf(poise_smartness), String.valueOf(confidence), String.valueOf(audience_impact), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table4.getModel();

                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayFinalScore(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pageant_db?serverTimezone=UTC","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_finals ORDER BY finals_total DESC");

            int counter = 0;
            while(rs.next()) {
                String fullname = rs.getString("fullname");
                Integer intelligence = rs.getInt( "intelligence");
                Integer beauty = rs.getInt( "beauty");
                Integer poise_bearing = rs.getInt( "poise_bearing");
                Integer total = rs.getInt( "finals_total");

                String tbData [] = {String.valueOf(++counter), fullname, String.valueOf(intelligence), String.valueOf(beauty), String.valueOf(poise_bearing), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table5.getModel();

                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new admin();
    }
}
