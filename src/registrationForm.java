import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class registrationForm extends JFrame{
    private JButton REGISTERButton;
    private JButton CANCELButton;
    private JTextField textField1;
    private JPanel mainPanel;
    private JPanel bdayCal;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    JDateChooser birthdateCal = new JDateChooser();

    public registrationForm () {
        add(mainPanel);
        setSize(500, 650);
        setTitle("ADMIN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Calendar minDate = Calendar.getInstance();
        minDate.set(1998, 11, 31);
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(2004, 11, 31);

        //set Default date
        Calendar defaultDate = Calendar.getInstance();
        defaultDate.set(2004, 11, 31);

        birthdateCal.setMinSelectableDate(minDate.getTime());
        birthdateCal.setMaxSelectableDate(maxDate.getTime());
        birthdateCal.setDate(defaultDate.getTime());

        bdayCal.add(birthdateCal);
        setVisible(true);

        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullname = textField1.getText();
                String contact = textField2.getText();
                String country = textField3.getText();
                int age = Integer.parseInt(textField4.getText());
                SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = birthdateCal.getDate();
                String birthdate = date_format.format(date);
                int height = Integer.parseInt(textField5.getText());
                int weight = Integer.parseInt(textField6.getText());

                contestants = addContestantsDB(fullname, contact, country, age, birthdate, height, weight);

                if (height < 173){
                    JOptionPane.showMessageDialog(null, "Your height did not meet the requirements", "System Notice", JOptionPane.INFORMATION_MESSAGE);
                } else if (weight < 55 || weight > 65){
                    JOptionPane.showMessageDialog(null, "Your weight did not meet the requirements", "System Notice", JOptionPane.INFORMATION_MESSAGE);
                } else if (age < 18 && age > 25) {
                    JOptionPane.showMessageDialog(null, "Your age did not meet the requirements", "System Notice", JOptionPane.INFORMATION_MESSAGE);
                } else if (fullname.isEmpty() || contact.isEmpty() || country.isEmpty() || age == 0 || birthdate.isEmpty() || height == 0 || weight == 0){
                    JOptionPane.showMessageDialog(null, "Please fill up all fields", "System Notice", JOptionPane.INFORMATION_MESSAGE);
                } else if (contestants!=null){
                    JOptionPane.showMessageDialog(null, "Contestant successfully registered", "System Notice", JOptionPane.INFORMATION_MESSAGE);
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                    textField6.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to register contestant", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int length = String.valueOf(textField2.getText()).length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    textField2.setEditable(true);
                    if (length == 0) {
                        textField2.setEditable(true);
                    } else if (length == 11){
                        textField2.setEditable(false);
                    } else if (length < 9) {
                    }
                } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    textField2.setEditable(true);

                } else {
                    textField2.setEditable(false);
                }
            }
        });
        textField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int length = String.valueOf(textField4.getText()).length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    textField4.setEditable(true);
                    if (length == 0) {
                        textField4.setEditable(true);
                    } else if (length == 2){
                        textField4.setEditable(false);
                    } else if (length < 9) {
                    }
                } else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    textField4.setEditable(true);
                } else {
                    textField4.setEditable(false);
                }
            }
        });
    }

    public Contestants contestants;

    private Contestants addContestantsDB(String fullname, String contact, String country, int age, String birthdate, int height, int weight){
        String url = "jdbc:mysql://localhost/pageant_db?serverTimezone=UTC";
        String user = "root";
        String pass = "";

        try {
            String sql = "INSERT INTO tbl_contestants (fullname, contact, country, age, birthdate, height, weight) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, contact);
            ps.setString(3, country);
            ps.setInt(4, age);
            ps.setString(5, birthdate);
            ps.setInt(6, height);
            ps.setInt(7, weight);

            int addRows = ps.executeUpdate();
            if (addRows > 0){
                contestants = new Contestants();
                contestants.fullname = fullname;
                contestants.contact = contact;
                contestants.country = country;
                contestants.age = age;
                contestants.birthdate = birthdate;
                contestants.height = height;
                contestants.weight = weight;
            }
            ps.close();

            String sql2 = "INSERT INTO tbl_finals (fullname, intelligence, beauty, poise_bearing, finals_total) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, fullname);
            ps2.setInt(2, 0);
            ps2.setInt(3, 0);
            ps2.setInt(4, 0);
            ps2.setInt(5, 0);

            int addRows2 = ps2.executeUpdate();
            if (addRows2 > 0) {
                contestants = new Contestants();
                contestants.fullname = fullname;
            }
            ps2.close();

            String sql3 = "INSERT INTO tbl_gown (fullname, poise_smartness, confidence, audience_impact, gown_total) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setString(1, fullname);
            ps3.setInt(2, 0);
            ps3.setInt(3, 0);
            ps3.setInt(4, 0);
            ps3.setInt(5, 0);

            int addRows3 = ps3.executeUpdate();
            if (addRows3 > 0) {
                contestants = new Contestants();
                contestants.fullname = fullname;
            }
            ps3.close();

            String sql4 = "INSERT INTO tbl_swimsuit (fullname, poise_smartness, confidence, audience_impact, swimsuit_total) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps4 = con.prepareStatement(sql4);
            ps4.setString(1, fullname);
            ps4.setInt(2, 0);
            ps4.setInt(3, 0);
            ps4.setInt(4, 0);
            ps4.setInt(5, 0);

            int addRows4 = ps4.executeUpdate();
            if (addRows4 > 0) {
                contestants = new Contestants();
                contestants.fullname = fullname;
            }
            ps4.close();

            String sql5 = "INSERT INTO tbl_talent (fullname, content_delivery, clarification, poise_projection, talent_total) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps5 = con.prepareStatement(sql5);
            ps5.setString(1, fullname);
            ps5.setInt(2, 0);
            ps5.setInt(3, 0);
            ps5.setInt(4, 0);
            ps5.setInt(5, 0);

            int addRows5 = ps5.executeUpdate();
            if (addRows5 > 0) {
                contestants = new Contestants();
                contestants.fullname = fullname;
            }
            ps5.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return contestants;
    }

    public static void main(String[] args) {
        new registrationForm();
    }
}
