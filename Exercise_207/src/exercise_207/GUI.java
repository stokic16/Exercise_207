/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise_207;

import javax.swing.JOptionPane;

/**
 *
 * @author kilia
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private StationBl model = new StationBl();

    public GUI() {
        initComponents();
        jTable1.setModel(model);
        jTable1.setDefaultRenderer(Object.class, new CellRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AddStation = new javax.swing.JMenuItem();
        RemoveStation = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        SetTemp = new javax.swing.JMenuItem();
        SetHumidity = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Stations");

        AddStation.setText("Add Weather Station");
        AddStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStationActionPerformed(evt);
            }
        });
        jMenu1.add(AddStation);

        RemoveStation.setText("Remove Weather Station");
        RemoveStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveStationActionPerformed(evt);
            }
        });
        jMenu1.add(RemoveStation);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Values");

        SetTemp.setText("Set Temperature");
        SetTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetTempActionPerformed(evt);
            }
        });
        jMenu2.add(SetTemp);

        SetHumidity.setText("Set Humidity");
        SetHumidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetHumidityActionPerformed(evt);
            }
        });
        jMenu2.add(SetHumidity);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStationActionPerformed
        MyDialog dialog = new MyDialog(this, true);
        dialog.setVisible(true);
        try {
            if (dialog.isOk()) {
                model.addStation(dialog.getStation());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_AddStationActionPerformed

    private void RemoveStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveStationActionPerformed
        int[] idxs = jTable1.getSelectedRows();
        if (idxs.length == 0) {
            JOptionPane.showMessageDialog(this, "Nothing selected!");
        } else {
            model.removeStation(idxs);
        }
    }//GEN-LAST:event_RemoveStationActionPerformed

    private void SetTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetTempActionPerformed
        double temp = Double.parseDouble(JOptionPane.showInputDialog("Enter Temperature!"));
        if (temp >= -35 && temp <= 45) {
            model.set(jTable1.getSelectedRow(), temp);
        } else {
            JOptionPane.showMessageDialog(this, "No valid input!");
        }
    }//GEN-LAST:event_SetTempActionPerformed

    private void SetHumidityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetHumidityActionPerformed
        int hum = Integer.parseInt(JOptionPane.showInputDialog("Enter Humidity!"));
        if (hum >= 0 && hum <= 100) {
            model.set(jTable1.getSelectedRow(), hum);
        } else {
            JOptionPane.showMessageDialog(this, "No valid input!");
        }
    }//GEN-LAST:event_SetHumidityActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddStation;
    private javax.swing.JMenuItem RemoveStation;
    private javax.swing.JMenuItem SetHumidity;
    private javax.swing.JMenuItem SetTemp;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
