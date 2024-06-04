 package gui;

import connect.Connect;
import java.awt.AlphaComposite;                       
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.TaiKhoan_Dao;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import swing.*;

public class Login extends JFrame implements ActionListener {

    private JPanel contentPane;
    private TextField tfUsername;
    private PasswordField password;
    private Button btnLogin;
    private Button btnExits;
    private CheckBox chkPass;
    private TaiKhoan tk = null;
    private TaiKhoan_Dao tk_dao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

//		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/logo.jpeg")));
        setTitle("Login");
        setResizable(false);
        setAutoRequestFocus(false);
        setBackground(new Color(240, 240, 240));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 538, 324);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(204, 204, 255));
        getContentPane().requestFocusInWindow();
        JLabel lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setBounds(10, 44, 215, 164);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo_login.png"));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        lblLogo.setIcon(scaleIcon);
        contentPane.add(lblLogo);

        JLabel lblNewLabel = new JLabel("XIN CHÀO!");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(304, 32, 123, 31);
        contentPane.add(lblNewLabel);
        tfUsername = new TextField();
        tfUsername.setCaretColor(new Color(0, 0, 0));
        tfUsername.setText("Username");
        tfUsername.setOpaque(false);
        tfUsername.setBorder(new EmptyBorder(5, 5, 5, 50));
        tfUsername.setSelectedTextColor(new Color(80, 199, 255));
        tfUsername.setBackground(new Color(255, 255, 255, 0));

        tfUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfUsername.getText().equals("Username")) {
                    tfUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfUsername.getText().equals("")) {
                    tfUsername.setText("Username");
                }
            }
        });
        tfUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfUsername.setBounds(250, 74, 225, 31);
        contentPane.add(tfUsername);
        tfUsername.setColumns(10);

        password = new PasswordField();
        password.setText("password");
        password.setOpaque(false);
        password.setBorder(new EmptyBorder(5, 5, 5, 50));
        password.setBackground(new Color(255, 255, 255, 0));
        password.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(password.getPassword()).equals("password")) {
                    password.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(password.getPassword()).equals("")) {
                    password.setText("password");
                }
            }
        });
        password.setBounds(250, 116, 225, 31);
        contentPane.add(password);

        btnLogin = new Button(Color.BLUE);
        btnLogin.setText("Đăng Nhập");
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setContentAreaFilled(false);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(new EmptyBorder(10, 20, 10, 20));
        btnLogin.setBounds(250, 180, 225, 31);
        btnLogin.setFocusPainted(false);
        contentPane.add(btnLogin);

        btnExits = new Button(Color.red);
        btnExits.setText("Thoát");
        btnExits.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExits.setContentAreaFilled(false);
        btnExits.setForeground(Color.WHITE);
        btnExits.setBorder(new EmptyBorder(10, 20, 10, 20));
        btnExits.setBounds(250, 222, 225, 29);
        btnExits.setFocusPainted(false);
        contentPane.add(btnExits);

        chkPass = new CheckBox();
        chkPass.setHorizontalAlignment(SwingConstants.CENTER);
        chkPass.setBounds(257, 150, 21, 23);
        contentPane.add(chkPass);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icon/eye-16.png")));
        lblNewLabel_1.setBounds(278, 150, 21, 23);
        contentPane.add(lblNewLabel_1);

        tk_dao = new TaiKhoan_Dao();

        chkPass.addActionListener(this);
        btnExits.addActionListener(this);
        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj.equals(chkPass)) {
            if (chkPass.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        } else if (obj.equals(btnExits)) {
            int lick = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát Khỏi Chương Trình Hay Không?",
                    "Thông Báo", 2);
            if (lick == JOptionPane.OK_OPTION) {
                System.exit(0);
            } else {
                if (lick == JOptionPane.CANCEL_OPTION) {
                    this.setVisible(true);
                }
            }
        } else if (obj.equals(btnLogin)) {
            tk = tk_dao.getTKDN(tfUsername.getText().trim(), String.valueOf(password.getPassword()));
            System.out.println(tk);
            if (tk != null) {
                Main.tkDN = tk;
                this.setVisible(false);
                new Main().setVisible(true);
            }
        }
    }

    class TextField extends JTextField {

        @Override
        protected void paintComponent(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setColor(Color.white);
            g2.fillRoundRect(0, 0, width, height, height, height);
            super.paintComponent(g);
            super.paintComponent(g);
        }
    }

    class PasswordField extends JPasswordField {

        @Override
        protected void paintComponent(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setColor(Color.white);
            g2.fillRoundRect(0, 0, width, height, height, height);
            super.paintComponent(g);
        }
    }

    class Button extends JButton {

        private Color color;

        public Button(Color color) {
            super();
            this.color = color;
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            int width = getWidth();
            int height = getHeight();
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillRoundRect(0, 0, width, height, height, height);
            grphcs.drawImage(img, 0, 0, null);
            super.paintComponent(grphcs);
        }
    }
}
