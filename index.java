package classes;

public class Data {

    private int code;
    private String name;
    private int idlocation;
    private int idmanager;

    public Data() {
    }

    public Data(int code, String name, int idlocation, int idmanager) {
        this.code = code;
        this.name = name;
        this.idlocation = idlocation;
        this.idmanager = idmanager;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(int idlocation) {
        this.idlocation = idlocation;
    }

    public int getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(int idmanager) {
        this.idmanager = idmanager;
    }

}

package classes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public int insert(Data da) {
        int n = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/java", "root",
                    "");
            Statement sentence = connection.createStatement();
            String sql = "INSERT INTO departamentos VALUES (" + da.getCode()
                    + ", '" + da.getName() + "', " + da.getIdlocation() + ", "
                    + da.getIdmanager() + ")";
            n = sentence.executeUpdate(sql);
            sentence.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return n;
    }

    public int modify(Data da) {
        int n = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/java", "root",
                    "");
            Statement sentence = connection.createStatement();
            String sql = "UPDATE departamentos SET name = '" + da.getName()
                    + "', id_location = " + da.getIdlocation()
                    + ", id_manager = " + da.getIdmanager()
                    + " WHERE code = " + da.getCode() + ";";
            n = sentence.executeUpdate(sql);
            sentence.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return n;
    }

    public int delete(Data da) {
        int n = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/java", "root",
                    "");
            Statement sentence = connection.createStatement();
            String sql = "DELETE FROM departamentos WHERE code = "
                    + da.getCode() + ";";
            n = sentence.executeUpdate(sql);
            sentence.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return n;
    }

    public String show() {
        String s = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/java", "root",
                    "");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM departamentos";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String name = resultSet.getString("name");
                int idLocation = resultSet.getInt("id_location");
                int idManager = resultSet.getInt("id_manager");
                s += "code: " + code + ", name: " + name + "\n"
                        + ", ID Location: " + idLocation + ", ID Manager: "
                        + idManager + "\n\n";
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
        }
        return s;
    }

}

package classes;

import javax.swing.JOptionPane;

public class Form extends javax.swing.JFrame {

    public Form() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {

        btninsert = new javax.swing.JButton();
        lblcode = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lbllocation = new javax.swing.JLabel();
        lblmanager = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtidl = new javax.swing.JTextField();
        txtidm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtlist = new javax.swing.JTextArea();
        btnshow = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblproductslist = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        btnmodify = new javax.swing.JButton();
        btnclean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("formulario de gestion de departamentos");

        btninsert.setText("insertar");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });

        lblcode.setText("codigo");

        lblname.setText("nombre");

        lbllocation.setText("id localizacion");

        lblmanager.setText("id manager");

        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });

        txtlist.setColumns(20);
        txtlist.setRows(5);
        jScrollPane1.setViewportView(txtlist);

        btnshow.setText("mostrar");
        btnshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowActionPerformed(evt);
            }
        });

        btnexit.setText("salir");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        lblproductslist.setText("datos del departamento");

        btndelete.setText("borrar");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnmodify.setText("modificar");
        btnmodify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifyActionPerformed(evt);
            }
        });

        btnclean.setText("limpiar");
        btnclean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblmanager, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(lbllocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btninsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtcode, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(txtname)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtidl, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(btnmodify, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidm, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnclean, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnshow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblproductslist, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblproductslist, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninsert)
                    .addComponent(btnshow)
                    .addComponent(btnexit)
                    .addComponent(btnmodify))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(btnclean))
                .addGap(30, 30, 30))
        );

        txtidm.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed

    }//GEN-LAST:event_txtcodeActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        try {
            Data da = new Data();
            da.setCode(Integer.parseInt(txtcode.getText()));
            da.setName(txtname.getText());
            da.setIdlocation(Integer.parseInt(txtidl.getText()));
            da.setIdmanager(Integer.parseInt(txtidm.getText()));
            Database db = new Database();
            int n = db.insert(da);
            if (n > 0) {
                JOptionPane.showMessageDialog(this,
                        "insercion realizada");
            } else {
                JOptionPane.showMessageDialog(this,
                        "insercion no realizada");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "datos introducidos incorrectamente",
                    "error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "error al introducir los datos: "
                    + ex.getMessage(),
                    "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btninsertActionPerformed

    private void btnshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowActionPerformed
        Database db = new Database();
        String s = db.show();
        txtlist.setText(s);
    }//GEN-LAST:event_btnshowActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try {
            int c = JOptionPane.showConfirmDialog(this,
                    "confirmar borrado",
                    "confirmacion",
                    JOptionPane.YES_NO_OPTION);
            if (c == JOptionPane.YES_OPTION) {
                Data da = new Data();
                da.setCode(Integer.parseInt(txtcode.getText()));
                Database db = new Database();
                int n = db.delete(da);
                if (n > 0) {
                    JOptionPane.showMessageDialog(this,
                            "borrado realizado");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "borrado no realizado");
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "borrado cancelado");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "datos introducidos incorrectamente",
                    "error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "error al borrar: " + ex.getMessage(),
                    "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnmodifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifyActionPerformed
        try {
            Data da = new Data();
            da.setCode(Integer.parseInt(txtcode.getText()));
            da.setName(txtname.getText());
            da.setIdlocation(Integer.parseInt(txtidl.getText()));
            da.setIdmanager(Integer.parseInt(txtidm.getText()));
            Database db = new Database();
            int n = db.modify(da);
            if (n > 0) {
                JOptionPane.showMessageDialog(this,
                        "modificación realizada");
            } else {
                JOptionPane.showMessageDialog(this,
                        "modificación no realizada");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "datos introducidos incorrectamente",
                    "error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "error al modificar: " + ex.getMessage(),
                    "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnmodifyActionPerformed

    private void btncleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncleanActionPerformed
        txtlist.setText("");
        txtcode.setText("");
        txtname.setText("");
        txtidl.setText("");
        txtidm.setText("");
    }//GEN-LAST:event_btncleanActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclean;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnmodify;
    private javax.swing.JButton btnshow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcode;
    private javax.swing.JLabel lbllocation;
    private javax.swing.JLabel lblmanager;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblproductslist;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtidl;
    private javax.swing.JTextField txtidm;
    private javax.swing.JTextArea txtlist;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}