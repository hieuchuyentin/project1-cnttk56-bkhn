
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    User user = new User();
    ImportExport importExport = new ImportExport();
    BorrowLend borrowLend = new BorrowLend();
    ArrayList<String> importTypeList = new ArrayList<String>();
    ArrayList<String> exportTypeList = new ArrayList<String>();
    ArrayList<String> userList = new ArrayList<String>();
    
    public Main() {
        Database.setState();// test
        initComponents();
        setImportTypeList(importExport.getImportTypeList());
        setExportTypeList(importExport.getExportTypeList());
        setUserList(user.getUserList());         
    }
    
    private void setImportTypeList(ArrayList<String> importTypeList){
        this.importTypeList = importTypeList;
    }
    private void setExportTypeList(ArrayList<String> exportTypeList){
        this.exportTypeList = exportTypeList;
    }
    private void setUserList(ArrayList<String> userList){
        for(String s: userList){
            cboxUser.addItem(s);
        }
    }
    public void setUser(String userName){
        user.userName = userName;
        user.id = user.getUserId(userName);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        btnAddImportExport = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jpImportExport = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        cboxType = new javax.swing.JComboBox();
        txtValue = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbImportExport = new javax.swing.JTable();
        cboxIE = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        btnView = new javax.swing.JButton();
        cboxUser = new javax.swing.JComboBox();
        jpBorrowLend = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddImportExport.setText("Add Import/Export");

        jButton2.setText("Add Borrow/Lend");

        jButton3.setText("View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMainLayout = new javax.swing.GroupLayout(jpMain);
        jpMain.setLayout(jpMainLayout);
        jpMainLayout.setHorizontalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMainLayout.createSequentialGroup()
                        .addComponent(btnAddImportExport, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpMainLayout.setVerticalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMainLayout.createSequentialGroup()
                        .addComponent(btnAddImportExport, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMainLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cboxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Type" }));
        cboxType.setMaximumSize(new java.awt.Dimension(1000, 20));
        cboxType.setMinimumSize(new java.awt.Dimension(200, 40));
        cboxType.setName(""); // NOI18N
        cboxType.setPreferredSize(new java.awt.Dimension(500, 20));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tbImportExport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "User", "Date", "Type", "Value", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbImportExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbImportExportMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbImportExport);

        cboxIE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Import", "Export" }));
        cboxIE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxIEItemStateChanged(evt);
            }
        });

        jLabel1.setText("Value");

        jLabel2.setText("Date");

        jLabel3.setText("Note");

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        cboxUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No User" }));

        javax.swing.GroupLayout jpImportExportLayout = new javax.swing.GroupLayout(jpImportExport);
        jpImportExport.setLayout(jpImportExportLayout);
        jpImportExportLayout.setHorizontalGroup(
            jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImportExportLayout.createSequentialGroup()
                .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpImportExportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpImportExportLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnAdd)
                        .addGap(31, 31, 31)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpImportExportLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel3))
                    .addGroup(jpImportExportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpImportExportLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(cboxType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpImportExportLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnView)))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jpImportExportLayout.setVerticalGroup(
            jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImportExportLayout.createSequentialGroup()
                .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpImportExportLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpImportExportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpImportExportLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpImportExportLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboxIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jpImportExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(cboxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout jpBorrowLendLayout = new javax.swing.GroupLayout(jpBorrowLend);
        jpBorrowLend.setLayout(jpBorrowLendLayout);
        jpBorrowLendLayout.setHorizontalGroup(
            jpBorrowLendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jpBorrowLendLayout.setVerticalGroup(
            jpBorrowLendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("Option");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(jpImportExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1073, 1073, 1073)
                .addComponent(jpBorrowLend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpImportExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpBorrowLend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboxIEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxIEItemStateChanged
          
                String type = (String) cboxIE.getSelectedItem();
                if(type.equals("Import")){   
                    cboxType.removeAllItems();
                    cboxType.addItem("All");
                    for(String s : importTypeList){
                        cboxType.addItem(s);
                    }
                    
                }
                else if(type.equals("Export")){
                    cboxType.removeAllItems();
                    cboxType.addItem("All");
                    for(String s : exportTypeList){
                        cboxType.addItem(s);
                    }
                }
    }//GEN-LAST:event_cboxIEItemStateChanged
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(tbImportExport.isColumnSelected(0)){   
            int i = cboxIE.getSelectedIndex();
            boolean isImport;
            if(i==1){
                JOptionPane.showMessageDialog(jpImportExport, "Ban vua bam nut Add cho Import");
                isImport=true;           
                InfoImportExport infoIE = new InfoImportExport(txtDate.getText(),Integer.parseInt(txtValue.getText()),txtNote.getText(),user.id,cboxType.getSelectedIndex(),isImport);
                if(importExport.insert(infoIE)) JOptionPane.showMessageDialog(jpImportExport, "Add thanh cong");
                else JOptionPane.showMessageDialog(jpImportExport, "Add that bai");
            }
            else if(i==2){
                JOptionPane.showMessageDialog(jpImportExport, "Ban vua bam nut Add cho Export");
                isImport=false;
                InfoImportExport infoIE = new InfoImportExport(txtDate.getText(),Integer.parseInt(txtValue.getText()),txtNote.getText(),user.id,cboxType.getSelectedIndex(),isImport);           
                if(importExport.insert(infoIE)) JOptionPane.showMessageDialog(jpImportExport, "Add thanh cong");
                else JOptionPane.showMessageDialog(jpImportExport, "Add that bai");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(tbImportExport.isColumnSelected(0)){
            int i = cboxIE.getSelectedIndex();
            boolean isImport;
            int row = tbImportExport.getSelectedRow();
            if(i==1){
                JOptionPane.showMessageDialog(jpImportExport, "Ban vua bam nut Update cho Import");
                isImport=true;
                InfoImportExport infoIE = new InfoImportExport(txtDate.getText(),Integer.parseInt(txtValue.getText()), txtNote.getText(),user.getUserId(tbImportExport.getValueAt(row, 1).toString()), cboxType.getSelectedIndex(),isImport);           
                if(importExport.update((int)tbImportExport.getValueAt(tbImportExport.getSelectedRow(), 0), infoIE)) JOptionPane.showMessageDialog(jpImportExport, "Update thanh cong");
                else JOptionPane.showMessageDialog(jpImportExport, "Update thanh cong");
            }
            else if(i==2){
                JOptionPane.showMessageDialog(jpImportExport, "Ban vua bam nut Update cho Export");
                isImport=false;
                InfoImportExport infoIE = new InfoImportExport(txtDate.getText(),Integer.parseInt(txtValue.getText()),txtNote.getText(),user.id,cboxType.getSelectedIndex(),isImport);           
                if(importExport.update((int)tbImportExport.getValueAt(tbImportExport.getSelectedRow(), 0), infoIE)) JOptionPane.showMessageDialog(jpImportExport, "Update thanh cong");
                else JOptionPane.showMessageDialog(jpImportExport, "Update that bai");     
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(tbImportExport.isColumnSelected(0)){
            int i = cboxIE.getSelectedIndex();
            boolean isImport;
            if(i==1){
                JOptionPane.showMessageDialog(jpImportExport, "Ban vua bam nut Delete cho Import");
                isImport=true;
                if(importExport.delete((int)tbImportExport.getValueAt(tbImportExport.getSelectedRow(), 0), isImport)) JOptionPane.showMessageDialog(jpImportExport, "Delete Thanh cong");
                else JOptionPane.showMessageDialog(jpImportExport, "Delete That bai");

            }
            else if(i==2){
                JOptionPane.showMessageDialog(jpImportExport, "Ban vua bam nut Delete cho Export");
                isImport=false;
                if(importExport.delete((int)tbImportExport.getValueAt(tbImportExport.getSelectedRow(), 0), isImport)) JOptionPane.showMessageDialog(jpImportExport, "Delete Thanh cong");
                else JOptionPane.showMessageDialog(jpImportExport, "Delete That bai");          
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int i = cboxIE.getSelectedIndex();
        boolean isImport;
        if(i==1){
                ResultSet rs = importExport.getData(user.id, user.getUserId((String)cboxUser.getSelectedItem()),cboxType.getSelectedIndex(), true);
                tbImportExport.setModel(new rsTableModel(rs));
          
        }          
        else if(i==2){
            ResultSet rs = importExport.getData(user.id, user.getUserId((String)cboxUser.getSelectedItem()),cboxType.getSelectedIndex(), false);
            tbImportExport.setModel(new rsTableModel(rs));
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void tbImportExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbImportExportMouseClicked
       if(evt.getButton()==MouseEvent.BUTTON1){
           int row = tbImportExport.getSelectedRow();
           txtValue.setText(tbImportExport.getValueAt(row, 4).toString());
           txtDate.setText(tbImportExport.getValueAt(row, 2).toString());
           try{
               txtNote.setText(tbImportExport.getValueAt(row, 5).toString());
           }catch(Exception ex){
               txtNote.setText("");
           }
       }
       
    }//GEN-LAST:event_tbImportExportMouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddImportExport;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox cboxIE;
    private javax.swing.JComboBox cboxType;
    private javax.swing.JComboBox cboxUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBorrowLend;
    private javax.swing.JPanel jpImportExport;
    private javax.swing.JPanel jpMain;
    private javax.swing.JTable tbImportExport;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
