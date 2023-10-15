import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class dashboard extends JFrame{
    private JTable table1;
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JButton UPDATEButton;
    private JButton REFRESHButton;
    private JLabel lbl_signout;
    private JLabel lblIcon;

    public dashboard(){
        add(mainPanel);
        setSize(900, 600);
        setTitle("SCOREBOARD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        lblIcon.setIcon(new ImageIcon(new ImageIcon("images/crown.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));

        table1.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "No.", "Candidate's Name", "Content & Delivery", "Clarification", "Poise & Projection", "Total"
                }
        ));

        table2.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "No.", "Candidate's Name", "Poise & Smartness", "Confidence", "Audience Impact", "Total"
                }
        ));

        table3.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "No.", "Candidate's Name", "Poise & Smartness", "Confidence", "Audience Impact", "Total"
                }
        ));

        table4.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "No.", "Candidate's Name", "Intelligence", "Beauty", "Poise & Bearing", "Total"
                }
        ));

        displayTalentScore();
        displayGownScore();
        displaySwimsuitScore();
        displayFinalScore();

        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int row = 0; row < table1.getRowCount(); row++) {
                    Object value2 = table1.getValueAt(row, 2);
                    Object value3 = table1.getValueAt(row, 3);
                    Object value4 = table1.getValueAt(row, 4);

                    try {
                        int intValue2 = Integer.parseInt(value2.toString());
                        int intValue3 = Integer.parseInt(value3.toString());
                        int intValue4 = Integer.parseInt(value4.toString());
                        if (intValue2 >= 0 && intValue2 <= 100 && intValue3 >= 0 && intValue3 <= 100 && intValue4 >= 0 && intValue4 <= 100) {
                            setUpdateTbl1();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Score : Enter a number between 1-100", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Score : Data is not an integer", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                for (int row = 0; row < table2.getRowCount(); row++) {
                    Object value2 = table2.getValueAt(row, 2);
                    Object value3 = table2.getValueAt(row, 3);
                    Object value4 = table2.getValueAt(row, 4);

                    try {
                        int intValue2 = Integer.parseInt(value2.toString());
                        int intValue3 = Integer.parseInt(value3.toString());
                        int intValue4 = Integer.parseInt(value4.toString());
                        if (intValue2 >= 0 && intValue2 <= 100 && intValue3 >= 0 && intValue3 <= 100 && intValue4 >= 0 && intValue4 <= 100) {
                            setUpdateTbl2();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Score : Enter a number between 1-100", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Score : Data is not an integer", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                for (int row = 0; row < table3.getRowCount(); row++) {
                    Object value2 = table3.getValueAt(row, 2);
                    Object value3 = table3.getValueAt(row, 3);
                    Object value4 = table3.getValueAt(row, 4);

                    try {
                        int intValue2 = Integer.parseInt(value2.toString());
                        int intValue3 = Integer.parseInt(value3.toString());
                        int intValue4 = Integer.parseInt(value4.toString());
                        if (intValue2 >= 0 && intValue2 <= 100 && intValue3 >= 0 && intValue3 <= 100 && intValue4 >= 0 && intValue4 <= 100) {
                            setUpdateTbl3();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Score : Enter a number between 1-100", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Score : Data is not an integer", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                for (int row = 0; row < table4.getRowCount(); row++) {
                    Object value2 = table4.getValueAt(row, 2);
                    Object value3 = table4.getValueAt(row, 3);
                    Object value4 = table4.getValueAt(row, 4);

                    try {
                        int intValue2 = Integer.parseInt(value2.toString());
                        int intValue3 = Integer.parseInt(value3.toString());
                        int intValue4 = Integer.parseInt(value4.toString());
                        if (intValue2 >= 0 && intValue2 <= 100 && intValue3 >= 0 && intValue3 <= 100 && intValue4 >= 0 && intValue4 <= 100) {
                            setUpdateTbl4();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Score : Enter a number between 1-100", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Score : Data is not an integer", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                DefaultTableModel tbl1 = (DefaultTableModel) table1.getModel();
                tbl1.setRowCount(0);
                DefaultTableModel tbl2 = (DefaultTableModel) table2.getModel();
                tbl2.setRowCount(0);
                DefaultTableModel tbl3 = (DefaultTableModel) table3.getModel();
                tbl3.setRowCount(0);
                DefaultTableModel tbl4 = (DefaultTableModel) table4.getModel();
                tbl4.setRowCount(0);
                displayTalentScore();
                displayGownScore();
                displaySwimsuitScore();
                displayFinalScore();
            }
        });
        REFRESHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tbl1 = (DefaultTableModel) table1.getModel();
                tbl1.setRowCount(0);
                DefaultTableModel tbl2 = (DefaultTableModel) table2.getModel();
                tbl2.setRowCount(0);
                DefaultTableModel tbl3 = (DefaultTableModel) table3.getModel();
                tbl3.setRowCount(0);
                DefaultTableModel tbl4 = (DefaultTableModel) table4.getModel();
                tbl4.setRowCount(0);
                displayTalentScore();
                displayGownScore();
                displaySwimsuitScore();
                displayFinalScore();
            }
        });
        lbl_signout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                main Main = new main();
                Main.show();
            }
        });
    }

    public void displayTalentScore(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pageant_db?serverTimezone=UTC","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_talent");

            while(rs.next()) {
                Integer number = rs.getInt( "id");
                String fullname = rs.getString("fullname");
                Integer content_delivery = rs.getInt( "content_delivery");
                Integer clarification = rs.getInt( "clarification");
                Integer poise_projection = rs.getInt( "poise_projection");
                Integer total = rs.getInt( "talent_total");

                String tbData [] = {String.valueOf(number), fullname, String.valueOf(content_delivery), String.valueOf(clarification), String.valueOf(poise_projection), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table1.getModel();

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
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_gown");

            while(rs.next()) {
                Integer number = rs.getInt( "id");
                String fullname = rs.getString("fullname");
                Integer poise_smartness = rs.getInt( "poise_smartness");
                Integer confidence = rs.getInt( "confidence");
                Integer audience_impact = rs.getInt( "audience_impact");
                Integer total = rs.getInt( "gown_total");

                String tbData [] = {String.valueOf(number), fullname, String.valueOf(poise_smartness), String.valueOf(confidence), String.valueOf(audience_impact), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table2.getModel();

                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displaySwimsuitScore(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pageant_db?serverTimezone=UTC","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_swimsuit");

            while(rs.next()) {
                Integer number = rs.getInt( "id");
                String fullname = rs.getString("fullname");
                Integer poise_smartness = rs.getInt( "poise_smartness");
                Integer confidence = rs.getInt( "confidence");
                Integer audience_impact = rs.getInt( "audience_impact");
                Integer total = rs.getInt( "swimsuit_total");

                String tbData [] = {String.valueOf(number), fullname, String.valueOf(poise_smartness), String.valueOf(confidence), String.valueOf(audience_impact), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table3.getModel();

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
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_finals");

            while(rs.next()) {
                Integer number = rs.getInt( "id");
                String fullname = rs.getString("fullname");
                Integer intelligence = rs.getInt( "intelligence");
                Integer beauty = rs.getInt( "beauty");
                Integer poise_bearing = rs.getInt( "poise_bearing");
                Integer total = rs.getInt( "finals_total");

                String tbData [] = {String.valueOf(number), fullname, String.valueOf(intelligence), String.valueOf(beauty), String.valueOf(poise_bearing), String.valueOf(total)};
                DefaultTableModel tblModel = (DefaultTableModel)table4.getModel();

                tblModel.addRow(tbData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setUpdateTbl1() {
        final String DB_URL = "jdbc:mysql://localhost/pageant_db?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            for(int i = 0; i < model.getRowCount(); i++){

                int No = Integer.valueOf(model.getValueAt(i, 0).toString());
                int content_delivery = Integer.valueOf(model.getValueAt(i, 2).toString());
                int clarification = Integer.valueOf(model.getValueAt(i, 3).toString());
                int poise_projection = Integer.valueOf(model.getValueAt(i, 4).toString());

                int talent_total = (content_delivery + clarification + poise_projection) / 3;

                String updateQuery = "UPDATE tbl_talent SET `content_delivery`='"+content_delivery+"',`clarification`='"+clarification+"',`poise_projection`='"+poise_projection+"',`talent_total`='"+talent_total+"' WHERE `id` = " +No;

                st.addBatch(updateQuery);
            }
            int[] updatedRow = st.executeBatch();
            System.out.println(updatedRow.length);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void setUpdateTbl2() {
        final String DB_URL = "jdbc:mysql://localhost/pageant_db?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            for(int i = 0; i < model.getRowCount(); i++){

                int No = Integer.valueOf(model.getValueAt(i, 0).toString());
                int poise_smartness = Integer.valueOf(model.getValueAt(i, 2).toString());
                int confidence = Integer.valueOf(model.getValueAt(i, 3).toString());
                int audience_impact = Integer.valueOf(model.getValueAt(i, 4).toString());

                int gown_total = (poise_smartness + confidence + audience_impact) / 3;

                String updateQuery = "UPDATE tbl_gown SET `poise_smartness`='"+poise_smartness+"',`confidence`='"+confidence+"',`audience_impact`='"+audience_impact+"',`gown_total`='"+gown_total+"' WHERE `id` = " +No;

                st.addBatch(updateQuery);
            }
            int[] updatedRow = st.executeBatch();
            System.out.println(updatedRow.length);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void setUpdateTbl3() {
        final String DB_URL = "jdbc:mysql://localhost/pageant_db?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        DefaultTableModel model = (DefaultTableModel) table3.getModel();
        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            for(int i = 0; i < model.getRowCount(); i++){

                int No = Integer.valueOf(model.getValueAt(i, 0).toString());
                int poise_smartness = Integer.valueOf(model.getValueAt(i, 2).toString());
                int confidence = Integer.valueOf(model.getValueAt(i, 3).toString());
                int audience_impact = Integer.valueOf(model.getValueAt(i, 4).toString());

                int swimsuit_total = (poise_smartness + confidence + audience_impact) / 3;

                String updateQuery = "UPDATE tbl_swimsuit SET `poise_smartness`='"+poise_smartness+"',`confidence`='"+confidence+"',`audience_impact`='"+audience_impact+"',`swimsuit_total`='"+swimsuit_total+"' WHERE `id` = " +No;

                st.addBatch(updateQuery);
            }
            int[] updatedRow = st.executeBatch();
            System.out.println(updatedRow.length);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setUpdateTbl4() {
        final String DB_URL = "jdbc:mysql://localhost/pageant_db?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        DefaultTableModel model = (DefaultTableModel) table4.getModel();
        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            for(int i = 0; i < model.getRowCount(); i++){

                int No = Integer.valueOf(model.getValueAt(i, 0).toString());
                int intelligence = Integer.valueOf(model.getValueAt(i, 2).toString());
                int beauty = Integer.valueOf(model.getValueAt(i, 3).toString());
                int poise_bearing = Integer.valueOf(model.getValueAt(i, 4).toString());

                int finals_total = (intelligence + beauty + poise_bearing) / 3;

                String updateQuery = "UPDATE tbl_finals SET `intelligence`='"+intelligence+"',`beauty`='"+beauty+"',`poise_bearing`='"+poise_bearing+"',`finals_total`='"+finals_total+"' WHERE `id` = " +No;

                st.addBatch(updateQuery);
            }
            int[] updatedRow = st.executeBatch();
            System.out.println(updatedRow.length);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new dashboard();
    }
}
