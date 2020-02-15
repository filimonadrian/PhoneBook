
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.Timer;

public class Aspect extends javax.swing.JFrame {

    CarteDeTelefon m = new CarteDeTelefon();
    private File cale;

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String nume_tabela = "";

    Timer tm;
    Timer t;
    int x = 0;

//Images Path In Array
    String[] list = {
        "D:\\Java_Projects\\Proiect_final\\src\\Resurse\\Reclama\\1.png",
        "D:\\Java_Projects\\Proiect_final\\src\\Resurse\\Reclama\\2.jpg",
        "D:\\Java_Projects\\Proiect_final\\src\\Resurse\\Reclama\\3.jpg",
        "D:\\Java_Projects\\Proiect_final\\src\\Resurse\\Reclama\\5.jpg",
        "D:\\Java_Projects\\Proiect_final\\src\\Resurse\\Reclama\\8.png",
        "D:\\Java_Projects\\Proiect_final\\src\\Resurse\\Reclama\\11.jpg"
    };

    public void SetImageSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(lReclame.getWidth(), lReclame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        lReclame.setIcon(newImc);
    }

    String tabel;
    Statement st = null;

    public Aspect() {

        initComponents();
        l.setModel(m);
        setIcon();
        SetImageSize(1);

        //timer pentru reclame
        tm = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if (x >= list.length) {
                    x = 0;
                }
            }
        });

        //thread-ul pentru salvare
        t = new Timer(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save(m, cale);
                } catch (IOException ex) {
                    eroare("NU se pot salva automat contactele");
                }
            }
        });

        add(lReclame);
        tm.start();
        setLayout(null);

        bInregistrare.setEnabled(true);
        miOpen.setEnabled(false);
        miSave.setEnabled(false);
        bCautare.setEnabled(false);
        bStergeCautare.setEnabled(false);
        tfCautare.setEnabled(false);

        bCautare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lTextCautare.getText().length() != 0) {
                    lTextCautare.setText("Ati cautat: " + tfCautare.getText());
                }

                if (lTextCautare.getText().length() == 0) {
                    lTextCautare.setText("");
                }

            }
        });

        tfCautare.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (lTextCautare.getText().length() != 0) {
                        lTextCautare.setText("Ati cautat: " + tfCautare.getText());
                        m.cautare(tfCautare.getText());
                    }
                    if (lTextCautare.getText().length() == 0) {
                        lTextCautare.setText("");
                    }

                }
            }

        });

        tfPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                }
            }

        });

        tfCNP.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    

                }
            }

        });
        

    }

    //aplicatia porneste in mod shareware. Daca utilizatorul se conecteaza cu succes atunci
    //se va apela metoda care porneste si celelalte functionalitati ale aplicatiei
    private void acc() {
        bInregistrare.setEnabled(false);
        miOpen.setEnabled(true);
        miSave.setEnabled(true);
        bCautare.setEnabled(true);
        bStergeCautare.setEnabled(true);
        tfCautare.setEnabled(true);
        // t.start();
        tm.stop();
        lReclame.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ordonareCriterii = new javax.swing.ButtonGroup();
        fc = new javax.swing.JFileChooser();
        jInregistrare = new javax.swing.JDialog();
        bLogin = new javax.swing.JButton();
        tfUser = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bCreare = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        l = new javax.swing.JList<>();
        abonatiFrame = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        tfNume = new javax.swing.JTextField();
        tfPrenume = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfCNP = new javax.swing.JTextField();
        tfNrTel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bAdauga = new javax.swing.JButton();
        bGoleste = new javax.swing.JButton();
        bSterge1 = new javax.swing.JButton();
        bModifica = new javax.swing.JButton();
        jAbonati = new javax.swing.JLabel();
        bDeleteAll = new javax.swing.JButton();
        bDeselectare = new javax.swing.JButton();
        lReclame = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tfCautare = new javax.swing.JTextField();
        bCautare = new javax.swing.JButton();
        bStergeCautare = new javax.swing.JButton();
        lTextCautare = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ordNume = new javax.swing.JRadioButton();
        ordPrenume = new javax.swing.JRadioButton();
        ordNrTel = new javax.swing.JRadioButton();
        ordCNP = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miOpen = new javax.swing.JMenuItem();
        miSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bIesire = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        bInregistrare = new javax.swing.JMenuItem();
        bAbout = new javax.swing.JMenuItem();

        jInregistrare.setTitle("Inregistrare");
        jInregistrare.setLocation(new java.awt.Point(255, 255));
        jInregistrare.setMaximumSize(new java.awt.Dimension(311, 214));
        jInregistrare.setMinimumSize(new java.awt.Dimension(311, 137));
        jInregistrare.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jInregistrare.setPreferredSize(new java.awt.Dimension(311, 237));
        jInregistrare.setResizable(false);
        jInregistrare.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jInregistrareComponentShown(evt);
            }
        });

        bLogin.setText("Login");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        jLabel7.setText("Parola:");

        jLabel5.setText("Nume utilizator:");

        bCreare.setText("Creare");
        bCreare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInregistrareLayout = new javax.swing.GroupLayout(jInregistrare.getContentPane());
        jInregistrare.getContentPane().setLayout(jInregistrareLayout);
        jInregistrareLayout.setHorizontalGroup(
            jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInregistrareLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInregistrareLayout.createSequentialGroup()
                        .addComponent(bCreare)
                        .addGap(18, 18, 18)
                        .addComponent(bLogin))
                    .addGroup(jInregistrareLayout.createSequentialGroup()
                        .addGroup(jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jInregistrareLayout.setVerticalGroup(
            jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInregistrareLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInregistrareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLogin)
                    .addComponent(bCreare))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jInregistrare.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");

        l.setPreferredSize(new java.awt.Dimension(400, 400));
        l.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                lAncestorResized(evt);
            }
        });
        l.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(l);

        abonatiFrame.setResizable(true);
        abonatiFrame.setVisible(true);
        abonatiFrame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                abonatiFrameKeyPressed(evt);
            }
        });

        jLabel1.setText("Nume:");

        tfNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeActionPerformed(evt);
            }
        });

        jLabel2.setText("Prenume:");

        jLabel3.setText("CNP:");

        jLabel4.setText("Nr. telefon:");

        bAdauga.setText("Adauga");
        bAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaActionPerformed(evt);
            }
        });

        bGoleste.setText("Goleste");
        bGoleste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGolesteActionPerformed(evt);
            }
        });

        bSterge1.setText("Sterge contactul");
        bSterge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSterge1ActionPerformed(evt);
            }
        });

        bModifica.setText("Modifica");
        bModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificaActionPerformed(evt);
            }
        });

        jAbonati.setText("Abonati");

        bDeleteAll.setText("Sterge toate contactele");
        bDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteAllActionPerformed(evt);
            }
        });

        bDeselectare.setText("Deselectare");
        bDeselectare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeselectareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abonatiFrameLayout = new javax.swing.GroupLayout(abonatiFrame.getContentPane());
        abonatiFrame.getContentPane().setLayout(abonatiFrameLayout);
        abonatiFrameLayout.setHorizontalGroup(
            abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abonatiFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abonatiFrameLayout.createSequentialGroup()
                        .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(abonatiFrameLayout.createSequentialGroup()
                                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, abonatiFrameLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNume)
                            .addComponent(tfCNP)
                            .addComponent(tfPrenume)))
                    .addGroup(abonatiFrameLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(tfNrTel))
                    .addGroup(abonatiFrameLayout.createSequentialGroup()
                        .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(abonatiFrameLayout.createSequentialGroup()
                                .addComponent(bAdauga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bGoleste))
                            .addComponent(bSterge1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDeleteAll)
                            .addGroup(abonatiFrameLayout.createSequentialGroup()
                                .addComponent(bModifica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDeselectare)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abonatiFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jAbonati)
                .addGap(150, 150, 150))
        );
        abonatiFrameLayout.setVerticalGroup(
            abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abonatiFrameLayout.createSequentialGroup()
                .addComponent(jAbonati)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNrTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAdauga)
                    .addComponent(bGoleste)
                    .addComponent(bModifica)
                    .addComponent(bDeselectare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(abonatiFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSterge1)
                    .addComponent(bDeleteAll))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        tfCautare.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tfCautareCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        tfCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCautareActionPerformed(evt);
            }
        });

        bCautare.setText("Cautare");
        bCautare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCautareMouseClicked(evt);
            }
        });
        bCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCautareActionPerformed(evt);
            }
        });

        bStergeCautare.setText("Sterge filtre");
        bStergeCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStergeCautareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTextCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bCautare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bStergeCautare, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfCautare)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bStergeCautare)
                            .addComponent(lTextCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bCautare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))))
        );

        jLabel6.setText("Se ordoneaza dupa:");

        ordonareCriterii.add(ordNume);
        ordNume.setText("Nume");
        ordNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordNumeActionPerformed(evt);
            }
        });

        ordonareCriterii.add(ordPrenume);
        ordPrenume.setText("Prenume");
        ordPrenume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordPrenumeActionPerformed(evt);
            }
        });

        ordonareCriterii.add(ordNrTel);
        ordNrTel.setText("Numar telefon");
        ordNrTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordNrTelActionPerformed(evt);
            }
        });

        ordonareCriterii.add(ordCNP);
        ordCNP.setText("CNP");
        ordCNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordCNPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ordNume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ordPrenume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ordNrTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ordCNP))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordNume)
                    .addComponent(ordPrenume)
                    .addComponent(ordNrTel)
                    .addComponent(ordCNP))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setText("File");

        miOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        miOpen.setText("Open");
        miOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenActionPerformed(evt);
            }
        });
        jMenu1.add(miOpen);

        miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSave.setText("Save");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveActionPerformed(evt);
            }
        });
        jMenu1.add(miSave);
        jMenu1.add(jSeparator1);

        bIesire.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        bIesire.setText("Iesire");
        bIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIesireActionPerformed(evt);
            }
        });
        jMenu1.add(bIesire);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jMenu2ComponentShown(evt);
            }
        });

        bInregistrare.setText("Inregistrare");
        bInregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInregistrareActionPerformed(evt);
            }
        });
        jMenu2.add(bInregistrare);

        bAbout.setText("About");
        bAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAboutActionPerformed(evt);
            }
        });
        jMenu2.add(bAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(abonatiFrame)
                    .addComponent(lReclame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(abonatiFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lReclame, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        abonatiFrame.getAccessibleContext().setAccessibleName("Abonati");
        abonatiFrame.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIesireActionPerformed
        int answer = JOptionPane.showConfirmDialog(
                this,
                "Sunteti sigur ca doriti sa parasiti aplicatia??",
                "Are you sure?",
                JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_bIesireActionPerformed
    /*
    private void adauga() {

        String nume = tfNume.getText();
        String prenume = tfPrenume.getText();
        String NrTel = tfNrTel.getText();
        String CNP = tfCNP.getText();
        try {
            m.adauga(new Abonat(nume, prenume, NrTel, CNP));
            // m.adauga(nume, prenume, NrTel, CNP); 
            golesteCampuri();
        } catch (NrTelException | CnpException | NumeException e) {
            eroare(e.getMessage());
        }
 }
     */
    private void bAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdaugaActionPerformed
        // adauga();
        String nume = tfNume.getText();
        String prenume = tfPrenume.getText();
        String NrTel = tfNrTel.getText();
        String CNP = tfCNP.getText();
        m.adauga(nume, prenume, NrTel, CNP);
        try {
            Connection conn = MySqlConnect.connectDB(); 
          
           PreparedStatement insert_information = conn.prepareStatement("INSERT INTO "+nume_tabela+
                   " VALUES ('"+nume+"', '"+prenume+"', '"+NrTel+"', '"+CNP+"')");
           
           insert_information.execute();
            conn.close();
            
        } catch (Exception e) {
            eroare(e.getMessage());
        } 
         

    }//GEN-LAST:event_bAdaugaActionPerformed

    private void bGolesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGolesteActionPerformed
        golesteCampuri();
    }//GEN-LAST:event_bGolesteActionPerformed

    public void golesteCampuri() {
        tfNume.setText("");
        tfPrenume.setText("");
        tfNrTel.setText("");
        tfCNP.setText("");
    }

    private void bSterge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSterge1ActionPerformed
        int i = l.getSelectedIndex();
        if (i >= 0) {
            int answer = JOptionPane.showConfirmDialog(
                    this,
                    "Sunteti sigur ca doriti sa stergeti acest contact??",
                    "Are you sure?",
                    JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                m.sterge(i);
            }

        }
    }//GEN-LAST:event_bSterge1ActionPerformed

    private void lValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lValueChanged
        int i = l.getSelectedIndex();
        if (i >= 0) {
            Abonat a = (Abonat) m.getElementAt(i);
            try {
                tfNume.setText(a.getNume());
                tfPrenume.setText(a.getPrenume());
                tfNrTel.setText(a.getNrTel());
                tfCNP.setText(a.getCNP());
            } catch (NrTelException | CnpException | NumeException e) {
                eroare(e.getMessage());
            }
        }
    }//GEN-LAST:event_lValueChanged

    //butonul de salvare, care apeleaza metoda de mai jos pentru a scrie in fisier
    private void miSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveActionPerformed
        fc.setDialogTitle("Salveaza fisierul");
        fc.setFileFilter(new FiltruFisier(".txt", "Text File"));
        //int result = fc.showSaveDialog(null);

        if (cale == null) {
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (fc.showSaveDialog(l) == JFileChooser.APPROVE_OPTION) {
                try {
                    cale = fc.getSelectedFile();
                    int answer = JOptionPane.showConfirmDialog(
                            this,
                            "Prin salvarea intr-un fisier deja existent se va sterge continutul precedent. " +
                                    "Sunteti sigur ca vreti sa salvati?",
                            "Are you sure?",
                            JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        save(m, cale);
                        t.start();
                    } else {
                    }

                } catch (IOException ex) {
                    eroare("Eroare la salvarea contactelor");
                }
            }
        } else {
            try {
                int answer = JOptionPane.showConfirmDialog(
                        this,
                        "Prin salvarea intr-un fisier deja existent se va sterge continutul precedent. " +
                                "Sunteti sigur ca vreti sa salvati?",
                        "Are you sure?",
                        JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    save(m, cale);
                } else {
                }
                //save(m,cale);
            } catch (IOException ex) {
                eroare("Eroare la salvarea contactelor");
            }
        }
    }//GEN-LAST:event_miSaveActionPerformed

    //Scrierea modelului in fisier 
    public static void save(CarteDeTelefon model, File f) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
        try {
            int len = model.getSize();
            for (int i = 0; i < len; i++) {
                pw.println(model.getElementAt(i).toString());
            }
        } finally {
            pw.close();
        }
    }

    public static void save(File f, String s) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
        try {
            pw.print(s);

        } finally {
            pw.close();
        }

    }

    public void returneazaFcExtensii() {
        fc.setDialogTitle("Salveaza fisierul");
        fc.setFileFilter(new FiltruFisier(".txt", "Text File"));
        // fc.setFileFilter(new FiltruFisier(".doc", "Word File"));
        // fc.setFileFilter(new FiltruFisier(".docx", "Word File"));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }
//butonul de deschidere a fisierelor
    private void miOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenActionPerformed

        returneazaFcExtensii();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File dir = fc.getSelectedFile();
            if (!dir.isFile()) {
                eroare("Selectati un fisier valid!");
            } else {
                Read_File(dir);
            }
        }

    }//GEN-LAST:event_miOpenActionPerformed
    /*fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File dir = fc.getSelectedFile();
            if (!dir.isFile()) {
                eroare("Selectati un fisier valid!");
            } else {
                if(!dir.getName().endsWith(".txt"))
                    eroare("Selectati un fisier text!");
                else
                    Read_File(dir);
               }

     */

//metoda pentru citire din fisier
    public void Read_File(File s) {
        try {

            Scanner b = new Scanner(s);
            try {
                while (b.hasNextLine()) {

                    String nume = b.next();
                    String prenume = b.next();
                    String nrTel = b.next();
                    String cnp = b.next();
                    try {
                        m.adauga(nume, prenume, nrTel, cnp);
                    } catch (NumeException e) {
                        eroare("Unul sau mai multe contacte din lista dumneavoatra au NUMELE " +
                                "sau PRENUMELE invalid si nu pot fi incarcate!!");
                    } catch (NrTelException e) {
                        eroare("Unul sau mai multe contacte din lista dumneavoatra au NUMARUL " +
                                "DE TELEFON invalid si nu pot fi incarcate!!");
                    } catch (CnpException e) {
                        eroare("Unul sau mai multe contacte din lista dumneavoatra au CNP-ul " +
                                "invalid si nu pot fi incarcate!!");
                    }

                }
            } catch (NoSuchElementException e) {
                informare("S-au incarcat fisierele valide");
            }

        } catch (FileNotFoundException ex) {
            eroare("Fisierul nu exista");
        }
        cale = s;
    }

    //metoda pentru citire din fisier. Este la fel ca cea de deasupra, cu deosebirea ca are un catch vid.
    // Este folosita pentru cautare.
    //cand se cauta un element, in model se sterg elementele care nu contin secventa de cautare si se afiseaza in JList. 
    //apoi, cand se sterge filtrul de cautare, aceasta metoda incarca datele din fisier
    // si nu vrem ca utilizatorul sa stie asta
    public void incarcaFisierCautare(File s) {
        try {

            Scanner b = new Scanner(s);
            try {
                while (b.hasNextLine()) {

                    String nume = b.next();
                    String prenume = b.next();
                    String nrTel = b.next();
                    String cnp = b.next();
                    try {
                        m.adauga(nume, prenume, nrTel, cnp);
                    } catch (NumeException e) {
                        eroare("Unul sau mai multe contacte din lista dumneavoatra au NUMELE " +
                                "sau PRENUMELE invalid si nu pot fi incarcate!!");
                    } catch (NrTelException e) {
                        eroare("Unul sau mai multe contacte din lista dumneavoatra au NUMARUL " +
                                "DE TELEFON invalid si nu pot fi incarcate!!");
                    } catch (CnpException e) {
                        eroare("Unul sau mai multe contacte din lista dumneavoatra au CNP-ul " +
                                "invalid si nu pot fi incarcate!!");
                    }

                }
            } catch (NoSuchElementException e) {
                //!!!catch ul este vid deoarece nu vrem ca utilizatorul sa stie ca atunci cand
                // sterge filtrul de cautare, se incarca datele din fisier
            }

        } catch (FileNotFoundException ex) {
            eroare("Fisierul nu exista");
        }
        cale = s;
    }

//butonul de modificare

    private void bModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificaActionPerformed
        int i = l.getSelectedIndex();
        Abonat a = (Abonat) m.getElementAt(i);
        try {
            a.setNume(tfNume.getText());
            a.setPrenume(tfPrenume.getText());
            a.setNrTel(tfNrTel.getText());
            a.setCNP(tfCNP.getText());

            int answer = JOptionPane.showConfirmDialog(
                    this,
                    "Sunteti sigur ca doriti sa modificati acest contact??",
                    "Are you sure?",
                    JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                m.ab.set(i, a);
                m.updateJlist();
            }
            // bGolesteActionPerformed(evt);
        } catch (NrTelException | CnpException e) {
            eroare(e.getMessage());
        }

    }//GEN-LAST:event_bModificaActionPerformed

    private void lAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_lAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_lAncestorResized
//butonul de about 
    private void bAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAboutActionPerformed
        String s = new String();
        s = "Aplicatia a fost realizata de Filimon Costel-Adrian si Punga Alexandru. " +
                "\n Agenda poate fi folosita pentru a va stoca toate contactele si pentru a le aduce modificari.";
        JOptionPane.showMessageDialog(
                this,
                s,
                "About",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_bAboutActionPerformed
//butonul de stergere a unui element 
    private void bDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteAllActionPerformed
        if (m.getSize() != 0) {
            int answer = JOptionPane.showConfirmDialog(
                    this,
                    "Sunteti sigur ca doriti sa stergeti toate contactele??",
                    "Are you sure?",
                    JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                m.stergeTot();
            } else {
            }
        } else {
        };
    }//GEN-LAST:event_bDeleteAllActionPerformed

// butoanele de ordonare
    private void ordNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordNumeActionPerformed
        m.sortDupaNume();
    }//GEN-LAST:event_ordNumeActionPerformed

    private void ordPrenumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordPrenumeActionPerformed
        m.sortDupaPrenume();
    }//GEN-LAST:event_ordPrenumeActionPerformed

    private void ordNrTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordNrTelActionPerformed
        m.sortDupaNrTel();
    }//GEN-LAST:event_ordNrTelActionPerformed

    private void ordCNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordCNPActionPerformed
        m.sortDupaCNP();
    }//GEN-LAST:event_ordCNPActionPerformed

    private void bStergeCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStergeCautareActionPerformed
        // m.stergeTot();
        //incarcaFisierCautare(cale);
        //m.updateJlist();
        lTextCautare.setText("");
        tfCautare.setText("");
        ordonareCriterii.clearSelection();

    }//GEN-LAST:event_bStergeCautareActionPerformed

    private void bCautareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCautareMouseClicked

    }//GEN-LAST:event_bCautareMouseClicked
//butonul de cautare
    private void bCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCautareActionPerformed

        try {
            save(m, cale);
        } catch (IOException ex) {
            Logger.getLogger(Aspect.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.cautare(tfCautare.getText());

    }//GEN-LAST:event_bCautareActionPerformed

    private void tfCautareCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tfCautareCaretPositionChanged
        bCautare.setEnabled(true);
    }//GEN-LAST:event_tfCautareCaretPositionChanged

    private void tfCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCautareActionPerformed

    }//GEN-LAST:event_tfCautareActionPerformed
//butonul de inregistrare din bara de meniu
    private void bInregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInregistrareActionPerformed

        jInregistrare.setVisible(true);

    }//GEN-LAST:event_bInregistrareActionPerformed

    private void jInregistrareComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jInregistrareComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jInregistrareComponentShown

/*  public void login(){
    // File f = new File("D:\\Java_Projects\\Proiect_final\\src\\Date_Inregistrare.txt");
       
   
    String f = new File("Date_Inregistrare.txt").getAbsolutePath();
        f.toString();
        f=f.substring(6,f.length() );
    System.out.println(f);
     */
 /*          
    URL u;
        u = Aspect.class.getResource("Date_Inregistrare.txt");
        
        String s;
        s=u.toString();
        s=s.substring(6,s.length() );
        
     File f = new File(s);

        try {
            Scanner b = new Scanner(f);
            while(b.hasNext()){
                 String user = b.next(); 
                 String parola= b.next();
                    if(tfUser.getText().equals(user) && tfPassword.getText().equals(parola) ){
                         informare("V-ati inregistrat cu succes");
                         acc();
                        
                    jInregistrare.hide();}
             else {
                eroare("Date incorecte!!");
                break;
                }
            }
        } catch (FileNotFoundException ex) {
          eroare("Nu se poate conecta");
        }
    }
     */

    private void bDeselectareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeselectareActionPerformed
        l.clearSelection();
        bGolesteActionPerformed(evt);

    }//GEN-LAST:event_bDeselectareActionPerformed

    private void tfNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeActionPerformed

    private void abonatiFrameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_abonatiFrameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_abonatiFrameKeyPressed

    private void jMenu2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenu2ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ComponentShown

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        
        
        try {
            conn = MySqlConnect.connectDB();

            String sql = "SELECT * from utilizatori where User=? and Password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, tfUser.getText());
            pst.setString(2, tfPassword.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null,"Welcome user"); 
                informare("V-ati logat cu succes");
                nume_tabela=tfUser.getText();
                acc();

                jInregistrare.hide();
            } else {
                //JOptionPane.showMessageDialog(null,"Invalid username or password", "Acces Denied", JOptionPane.ERROR_MESSAGE);
                eroare("Date incorecte!!");
            }
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * from "+nume_tabela);
  
   while (rs.next()) {
            String nume=rs.getString("Nume");
            String prenume=rs.getString("Prenume");
            String telefon=rs.getString("NrTelefon");
            String cnp=rs.getString("CNP");
            System.out.println(nume+" "+prenume+" "+telefon+" "+cnp);
            m.adauga(nume, prenume, telefon, cnp);
        }
            conn.close();
            pst.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
tabel=tfUser.getName();
    }//GEN-LAST:event_bLoginActionPerformed

    public void createTable() {
        try {
            
            Connection conn = MySqlConnect.connectDB();
            PreparedStatement adaugare_utilizator = conn.prepareStatement("INSERT INTO utilizatori " +
                    "VALUES ('" + tfUser.getText() + "' , '" + tfPassword.getText() + "')");
            PreparedStatement create = conn.prepareStatement("CREATE TABLE " + tfUser.getText() +
                    "(Nume varchar(20), Prenume varchar(20), NrTelefon varchar(13), CNP varchar(14))");
            create.executeUpdate();
            adaugare_utilizator.execute();
            nume_tabela = tfUser.getText();
            informare("V-ati inregistrat cu succes");
        } catch (Exception e) {
            System.out.println(e);
       } 
    //finally { informare("Cont creat cu succes!"); }
    }
    
    private void bCreareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreareActionPerformed
        createTable();
        
    }//GEN-LAST:event_bCreareActionPerformed

    //JOptionPane pentru erorile aparute la selectarea fisierelor, deschidere, salvare sau  pentru informare
    private void eroare(String text) {
        JOptionPane.showMessageDialog(
                this,
                text,
                "EROARE",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void informare(String text) {

        JOptionPane.showMessageDialog(
                this,
                text,
                "INFOMARE",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /*  int confirmare(String text){
        JOptionPane.showConfirmDialog(
                this,
                "Sunteti sigur ca doriti sa "+text+"??",
                "Are you sure?",
                JOptionPane.YES_NO_OPTION
        );
        return JOptionPane.YES_NO_CANCEL_OPTION;
    }
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aspect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aspect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aspect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aspect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aspect().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame abonatiFrame;
    private javax.swing.JMenuItem bAbout;
    private javax.swing.JButton bAdauga;
    private javax.swing.JButton bCautare;
    private javax.swing.JButton bCreare;
    private javax.swing.JButton bDeleteAll;
    private javax.swing.JButton bDeselectare;
    private javax.swing.JButton bGoleste;
    private javax.swing.JMenuItem bIesire;
    private javax.swing.JMenuItem bInregistrare;
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bModifica;
    private javax.swing.JButton bSterge1;
    private javax.swing.JButton bStergeCautare;
    private javax.swing.JFileChooser fc;
    private javax.swing.JLabel jAbonati;
    private javax.swing.JDialog jInregistrare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JList<String> l;
    private javax.swing.JLabel lReclame;
    private javax.swing.JLabel lTextCautare;
    private javax.swing.JMenuItem miOpen;
    private javax.swing.JMenuItem miSave;
    private javax.swing.JRadioButton ordCNP;
    private javax.swing.JRadioButton ordNrTel;
    private javax.swing.JRadioButton ordNume;
    private javax.swing.JRadioButton ordPrenume;
    private javax.swing.ButtonGroup ordonareCriterii;
    private javax.swing.JTextField tfCNP;
    private javax.swing.JTextField tfCautare;
    private javax.swing.JTextField tfNrTel;
    private javax.swing.JTextField tfNume;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPrenume;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ContactsIcon.png")));
    }
}
