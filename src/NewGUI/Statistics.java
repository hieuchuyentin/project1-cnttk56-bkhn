/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NewGUI;

import java.util.Date;

/**
 *
 * @author dodan_000
 */
public class Statistics extends javax.swing.JFrame {

    /**
     * Creates new form Statistics
     */
    public Statistics() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnList = new javax.swing.JButton();
        btnBar = new javax.swing.JButton();
        btnPie = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        cboxType = new javax.swing.JComboBox();
        cboxCartegory = new javax.swing.JComboBox();
        jdcFrom = new com.toedter.calendar.JDateChooser();
        jdcTo = new com.toedter.calendar.JDateChooser();
        jycYear = new com.toedter.calendar.JYearChooser();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(170, 0), new java.awt.Dimension(170, 0), new java.awt.Dimension(170, 32767));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cboxMonth = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 560));
        setPreferredSize(new java.awt.Dimension(890, 560));

        jPanel1.setBackground(new java.awt.Color(245, 246, 247));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 60));
        jPanel1.setLayout(null);

        btnList.setBackground(new java.awt.Color(245, 246, 247));
        btnList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/main/list 24.png"))); // NOI18N
        btnList.setText("List");
        btnList.setAlignmentY(0.0F);
        btnList.setHideActionText(true);
        btnList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnList.setIconTextGap(1);
        btnList.setMaximumSize(new java.awt.Dimension(60, 60));
        btnList.setMinimumSize(new java.awt.Dimension(60, 60));
        btnList.setName(""); // NOI18N
        btnList.setPreferredSize(new java.awt.Dimension(60, 60));
        btnList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnList);
        btnList.setBounds(0, 0, 60, 60);

        btnBar.setBackground(new java.awt.Color(245, 246, 247));
        btnBar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/main/barchart.png"))); // NOI18N
        btnBar.setText("Bar");
        btnBar.setAlignmentY(0.0F);
        btnBar.setHideActionText(true);
        btnBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBar.setIconTextGap(1);
        btnBar.setMaximumSize(new java.awt.Dimension(60, 60));
        btnBar.setMinimumSize(new java.awt.Dimension(60, 60));
        btnBar.setName(""); // NOI18N
        btnBar.setPreferredSize(new java.awt.Dimension(60, 60));
        btnBar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnBar);
        btnBar.setBounds(60, 0, 60, 60);

        btnPie.setBackground(new java.awt.Color(245, 246, 247));
        btnPie.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/main/piechart 24.png"))); // NOI18N
        btnPie.setText("Pie");
        btnPie.setAlignmentY(0.0F);
        btnPie.setHideActionText(true);
        btnPie.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPie.setIconTextGap(1);
        btnPie.setMaximumSize(new java.awt.Dimension(60, 60));
        btnPie.setMinimumSize(new java.awt.Dimension(60, 60));
        btnPie.setName(""); // NOI18N
        btnPie.setPreferredSize(new java.awt.Dimension(60, 60));
        btnPie.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnPie);
        btnPie.setBounds(120, 0, 60, 60);

        jButton3.setBackground(new java.awt.Color(245, 246, 247));
        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/main/refresh 24.png"))); // NOI18N
        jButton3.setText("Refresh");
        jButton3.setAlignmentX(3.0F);
        jButton3.setAlignmentY(2.0F);
        jButton3.setHideActionText(true);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setIconTextGap(1);
        jButton3.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton3.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton3.setName(""); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jButton3);
        jButton3.setBounds(180, 0, 80, 60);

        btnFilter.setBackground(new java.awt.Color(245, 246, 247));
        btnFilter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/main/filter 24.png"))); // NOI18N
        btnFilter.setText("Filter");
        btnFilter.setAlignmentX(3.0F);
        btnFilter.setAlignmentY(2.0F);
        btnFilter.setHideActionText(true);
        btnFilter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFilter.setIconTextGap(1);
        btnFilter.setMaximumSize(new java.awt.Dimension(60, 60));
        btnFilter.setMinimumSize(new java.awt.Dimension(60, 60));
        btnFilter.setName(""); // NOI18N
        btnFilter.setPreferredSize(new java.awt.Dimension(60, 60));
        btnFilter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnFilter);
        btnFilter.setBounds(330, 0, 70, 60);

        btnExport.setBackground(new java.awt.Color(245, 246, 247));
        btnExport.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/main/export 24.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setAlignmentX(3.0F);
        btnExport.setAlignmentY(2.0F);
        btnExport.setHideActionText(true);
        btnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExport.setIconTextGap(1);
        btnExport.setMaximumSize(new java.awt.Dimension(60, 60));
        btnExport.setMinimumSize(new java.awt.Dimension(60, 60));
        btnExport.setName(""); // NOI18N
        btnExport.setPreferredSize(new java.awt.Dimension(60, 60));
        btnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnExport);
        btnExport.setBounds(260, 0, 70, 60);

        cboxType.setEditable(true);
        cboxType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Importing", "Exporting" }));
        cboxType.setMaximumSize(new java.awt.Dimension(125, 25));
        cboxType.setMinimumSize(new java.awt.Dimension(125, 25));
        cboxType.setPreferredSize(new java.awt.Dimension(125, 25));

        cboxCartegory.setEditable(true);
        cboxCartegory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxCartegory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Categorys" }));
        cboxCartegory.setMaximumSize(new java.awt.Dimension(125, 25));
        cboxCartegory.setMinimumSize(new java.awt.Dimension(125, 25));
        cboxCartegory.setPreferredSize(new java.awt.Dimension(125, 25));

        jdcFrom.setDateFormatString("yyyy/MM/dd");
        jdcFrom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jdcFrom.setMaximumSize(new java.awt.Dimension(125, 25));
        jdcFrom.setMinimumSize(new java.awt.Dimension(125, 25));
        jdcFrom.setPreferredSize(new java.awt.Dimension(125, 25));

        jdcTo.setDateFormatString("yyyy/MM/dd");
        jdcTo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jdcTo.setMaximumSize(new java.awt.Dimension(125, 25));
        jdcTo.setMinimumSize(new java.awt.Dimension(125, 25));
        jdcTo.setPreferredSize(new java.awt.Dimension(125, 25));

        jycYear.setToolTipText("");
        jycYear.setMaximumSize(new java.awt.Dimension(125, 25));
        jycYear.setMinimumSize(new java.awt.Dimension(125, 25));
        jycYear.setPreferredSize(new java.awt.Dimension(125, 25));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("For:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Display");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("View:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("From:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("To:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Month:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Year:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Filter");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel2.setMinimumSize(new java.awt.Dimension(700, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 450));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cboxMonth.setEditable(true);
        cboxMonth.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Month", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cboxMonth.setMaximumSize(new java.awt.Dimension(125, 25));
        cboxMonth.setMinimumSize(new java.awt.Dimension(125, 25));
        cboxMonth.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboxCartegory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(22, 22, 22)
                                        .addComponent(jdcFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(37, 37, 37)
                                        .addComponent(jdcTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26)
                                        .addComponent(jycYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxCartegory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cboxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jycYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(233, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );

        jdcFrom.setDate(new Date("2013/11/12"));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistics().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBar;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnPie;
    private javax.swing.JComboBox cboxCartegory;
    private javax.swing.JComboBox cboxMonth;
    private javax.swing.JComboBox cboxType;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jdcFrom;
    private com.toedter.calendar.JDateChooser jdcTo;
    private com.toedter.calendar.JYearChooser jycYear;
    // End of variables declaration//GEN-END:variables
}
