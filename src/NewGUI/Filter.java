/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NewGUI;

import Control.ComboxRender;
import Control.Database;
import Control.ImportExport;
import Control.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author dodan_000
 */
public class Filter extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Statistics statistics;
    User user = new User();
    ImportExport importExport = new ImportExport();
    ArrayList<String> importList;
    ArrayList<String> exportList;
    ArrayList<String> userList;
    public Filter() {
        initComponents();
        initFilter();
    }
    public Filter(Statistics statistics,User user){
        this.statistics = statistics;
        this.user = user;
        initComponents();
        initFilter();
    }
    
    public DefaultListModel modelCategory= new DefaultListModel();    
    public DefaultListModel modelAccount= new DefaultListModel(); 
    public void initFilter(){
        //init ListIncome
        Database.setState();
        userList = user.getUserList();
        importList = importExport.getImportTypeList();
        exportList = importExport.getExportTypeList();
                 
        //init ListCategory
          
        for(String s:importList){
            modelCategory.addElement(s);
        }
        listCategory.setModel(modelCategory);
        listCategory.setCellRenderer(new ComboxRender("src/image/import_type/",1));
        
        //init cboxAccount
        
        for(String s:userList){
            modelAccount.addElement(s);
        }
        listAccount.setModel(modelAccount);     
       
    }
    
    public Date getDateFrom(){
        return jdcFrom.getDate();
    }
    
    public void setDateFrom(Date date){
        jdcFrom.setDate(date);
    }
    
    public Date getDateTo(){
        return jdcTo.getDate();
    }
    
    public void setDateTo(Date date){
        jdcTo.setDate(date);
    }
    
    
    public String getDescription(){
        return txtDescription.getText();
    }
    
    public void setDescription(String s){
        txtDescription.setText(s);
    }
    
    public String getInfo(){
        return txtInfo.getText();
    }
    
    public void setInfo(String s){
        txtInfo.setText(s);
    }
    
    public int getAmountFrom(){
        return (int)spinFrom.getValue();
    }
    
    public void setAmountFrom(int i){
        spinFrom.setValue(i);
    }
    
    public int getAmountTo(){
        return (int)spinTo.getValue();
    }
    
    public void setAmountTo(int i){
        spinTo.setValue(i);
    }
    
    public ArrayList<Integer> getListAcount(){
        ArrayList<Integer> list= new ArrayList<>();
        List<String> listItem = listAccount.getSelectedValuesList();
        
        for(int i=0;i<listItem.size();i++){  
            list.add(user.getUserId(listItem.get(i)));
        }
        return list;    
    }
    
    public ArrayList<Integer> getListCategory(){
        ArrayList<Integer> list = new ArrayList<>();
        List<String> listItem = listCategory.getSelectedValuesList();
        if (cboxType.getSelectedIndex() == 0) {
            for (int i = 0; i < listItem.size(); i++) {
                list.add(importExport.getImportId(listItem.get(i)));
            }
        } else {
            for (int i = 0; i < listItem.size(); i++) {
                list.add(importExport.getExportId(listItem.get(i)));
            }
        }
        return list;

    }
    public int getOptionDate(){
        return cboxOptionDate.getSelectedIndex();
    }
    
    public void setOptionDate(int i){
        cboxOptionDate.setSelectedIndex(i);
    }
    
    public int getOptionAmount(){
        return cboxOptionAmount.getSelectedIndex();
    }
    
    public void setOptionAmount(int i){
        cboxOptionAmount.setSelectedIndex(i);
    }
    
    public int getOptionText(){
        return cboxOptionText.getSelectedIndex();
    }
    
    public void setOptionText(int i){
        cboxOptionText.setSelectedIndex(i);
    }
    
    public int setOptionCategory(){
        return cboxOptionCategory.getSelectedIndex();
    }
    
    public void setOptionCategory(int i){
        cboxOptionCategory.setSelectedIndex(i);
    }
    
    public int getOptionAccount(){
        return cboxOptionAccount.getSelectedIndex();
    }
    
    public void setOptionAccount(int i){
        cboxOptionAccount.setSelectedIndex(i);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cboxOptionDate = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcFrom = new com.toedter.calendar.JDateChooser();
        jdcTo = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboxOptionAmount = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtInfo = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        spinFrom = new javax.swing.JSpinner();
        spinTo = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        cboxOptionText = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboxOptionAccount = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        cboxType = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listCategory = new javax.swing.JList();
        jLabel13 = new javax.swing.JLabel();
        cboxOptionCategory = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAccount = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(837, 482));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboxOptionDate.setEditable(true);
        cboxOptionDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxOptionDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Include", "Exclude" }));
        cboxOptionDate.setMaximumSize(new java.awt.Dimension(115, 28));
        cboxOptionDate.setMinimumSize(new java.awt.Dimension(115, 28));
        cboxOptionDate.setPreferredSize(new java.awt.Dimension(115, 28));
        cboxOptionDate.setRenderer(new Control.ComboxRender("src/image/main/option/",1));
        cboxOptionDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxOptionDateItemStateChanged(evt);
            }
        });
        jPanel1.add(cboxOptionDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Option:");
        jLabel1.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 34, 48, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("To:");
        jLabel2.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 109, 48, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("From:");
        jLabel3.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 73, 48, -1));

        jdcFrom.setDateFormatString("yyyy-MM-dd");
        jdcFrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jdcFrom.setMinimumSize(new java.awt.Dimension(115, 25));
        jdcFrom.setPreferredSize(new java.awt.Dimension(115, 25));
        jdcFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcFromPropertyChange(evt);
            }
        });
        jdcFrom.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jdcFromInputMethodTextChanged(evt);
            }
        });
        jPanel1.add(jdcFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jdcTo.setDateFormatString("yyyy-MM-dd");
        jdcTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jdcTo.setMinimumSize(new java.awt.Dimension(115, 25));
        jdcTo.setPreferredSize(new java.awt.Dimension(115, 25));
        jdcTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcToPropertyChange(evt);
            }
        });
        jdcTo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jdcToInputMethodTextChanged(evt);
            }
        });
        jPanel1.add(jdcTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Filter Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Filter Amount");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        cboxOptionAmount.setEditable(true);
        cboxOptionAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxOptionAmount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactive", "Include", "Exclude" }));
        cboxOptionAmount.setMaximumSize(new java.awt.Dimension(115, 28));
        cboxOptionAmount.setMinimumSize(new java.awt.Dimension(115, 28));
        cboxOptionAmount.setPreferredSize(new java.awt.Dimension(115, 28));
        cboxOptionAmount.setRenderer(new Control.ComboxRender("src/image/main/option/",0));
        cboxOptionAmount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxOptionAmountItemStateChanged(evt);
            }
        });
        jPanel1.add(cboxOptionAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));
        if(cboxOptionAmount.getSelectedIndex()==0){
            spinFrom.setEnabled(false);
            spinTo.setEnabled(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Option:");
        jLabel6.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 48, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("From:");
        jLabel7.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 48, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("To:");
        jLabel8.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 48, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Filter Text");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Description:");
        jLabel10.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 76, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Info:");
        jLabel11.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 48, -1));

        txtInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtInfo.setMaximumSize(new java.awt.Dimension(200, 25));
        txtInfo.setMinimumSize(new java.awt.Dimension(200, 25));
        txtInfo.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel1.add(txtInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescription.setMaximumSize(new java.awt.Dimension(200, 25));
        txtDescription.setMinimumSize(new java.awt.Dimension(200, 25));
        txtDescription.setPreferredSize(new java.awt.Dimension(200, 25));
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        spinFrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinFrom.setMaximumSize(new java.awt.Dimension(115, 25));
        spinFrom.setMinimumSize(new java.awt.Dimension(115, 25));
        spinFrom.setPreferredSize(new java.awt.Dimension(115, 25));
        jPanel1.add(spinFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        spinTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinTo.setMaximumSize(new java.awt.Dimension(115, 25));
        spinTo.setMinimumSize(new java.awt.Dimension(115, 25));
        spinTo.setPreferredSize(new java.awt.Dimension(115, 25));
        jPanel1.add(spinTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Option:");
        jLabel15.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 48, -1));

        cboxOptionText.setEditable(true);
        cboxOptionText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxOptionText.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactive", "Include", "Exclude" }));
        cboxOptionText.setMaximumSize(new java.awt.Dimension(115, 28));
        cboxOptionText.setMinimumSize(new java.awt.Dimension(115, 28));
        cboxOptionText.setPreferredSize(new java.awt.Dimension(115, 28));
        cboxOptionText.setRenderer(new Control.ComboxRender("src/image/main/option/",0));
        cboxOptionText.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxOptionTextItemStateChanged(evt);
            }
        });
        jPanel1.add(cboxOptionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 200, -1));
        if(cboxOptionText.getSelectedIndex()==0){
            txtDescription.setEnabled(false);
            txtInfo.setEnabled(false);
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Filter Category");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Option:");
        jLabel16.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 48, -1));

        cboxOptionAccount.setEditable(true);
        cboxOptionAccount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxOptionAccount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactive", "Include", "Exclude" }));
        cboxOptionAccount.setMaximumSize(new java.awt.Dimension(115, 28));
        cboxOptionAccount.setMinimumSize(new java.awt.Dimension(115, 28));
        cboxOptionAccount.setPreferredSize(new java.awt.Dimension(115, 28));
        cboxOptionAccount.setRenderer(new Control.ComboxRender("src/image/main/option/",0));
        cboxOptionAccount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxOptionAccountItemStateChanged(evt);
            }
        });
        jPanel1.add(cboxOptionAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 200, -1));
        if(cboxOptionAccount.getSelectedIndex()==0){
            listAccount.setEnabled(false);
        }

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Account:");
        jLabel17.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 62, -1));

        cboxType.setEditable(true);
        cboxType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Income", "Expense" }));
        cboxType.setMaximumSize(new java.awt.Dimension(150, 25));
        cboxType.setMinimumSize(new java.awt.Dimension(150, 25));
        cboxType.setPreferredSize(new java.awt.Dimension(150, 25));
        cboxType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxTypeItemStateChanged(evt);
            }
        });
        jPanel1.add(cboxType, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 200, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Category:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, 30));

        listCategory.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        listCategory.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listCategory);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 200, 190));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Option:");
        jLabel13.setPreferredSize(new java.awt.Dimension(34, 28));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 70, -1));

        cboxOptionCategory.setEditable(true);
        cboxOptionCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxOptionCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactive", "Include", "Exclude" }));
        cboxOptionCategory.setMaximumSize(new java.awt.Dimension(115, 28));
        cboxOptionCategory.setMinimumSize(new java.awt.Dimension(115, 28));
        cboxOptionCategory.setPreferredSize(new java.awt.Dimension(115, 28));
        cboxOptionCategory.setRenderer(new Control.ComboxRender("src/image/main/option/",0));
        cboxOptionCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxOptionCategoryItemStateChanged(evt);
            }
        });
        jPanel1.add(cboxOptionCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 200, -1));
        if(cboxOptionCategory.getSelectedIndex()==0){
            cboxType.setEnabled(false);
            listCategory.setEnabled(false);
        }

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Type:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, 30));

        listAccount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listAccount.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAccount);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 200, 170));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Filter Account");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 80, -1));

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 80, -1));

        jTabbedPane1.addTab("Genalral", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxOptionCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxOptionCategoryItemStateChanged
        // TODO add your handling code here:
        if(cboxOptionCategory.getSelectedIndex()==0){
            cboxType.setEnabled(false);
            listCategory.setEnabled(false);   
            statistics.cboxType.setEnabled(true);
            statistics.cboxCategory.setEnabled(true);
        }
        else{
            cboxType.setEnabled(true);
            listCategory.setEnabled(true);    
            statistics.cboxType.setEnabled(false);
            statistics.cboxCategory.setEnabled(false);
        }
    }//GEN-LAST:event_cboxOptionCategoryItemStateChanged

    private void cboxOptionAccountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxOptionAccountItemStateChanged
        // TODO add your handling code here:
        if(cboxOptionAccount.getSelectedIndex()==0){
            listAccount.setEnabled(false);
            statistics.cboxAccount.setEnabled(true);
        }
        else{
            listAccount.setEnabled(true);
            statistics.cboxAccount.setEnabled(false);
        }
    }//GEN-LAST:event_cboxOptionAccountItemStateChanged

    private void cboxOptionTextItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxOptionTextItemStateChanged
        // TODO add your handling code here:
        if(cboxOptionText.getSelectedIndex()==0){
            txtDescription.setEnabled(false);
            txtInfo.setEnabled(false);
        }
        else{
            txtDescription.setEnabled(true);
            txtInfo.setEnabled(true);
        }
    }//GEN-LAST:event_cboxOptionTextItemStateChanged

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void cboxOptionAmountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxOptionAmountItemStateChanged
        // TODO add your handling code here:
        if(cboxOptionAmount.getSelectedIndex()==0){
            spinFrom.setEnabled(false);
            spinTo.setEnabled(false);
        }
        else{
            spinFrom.setEnabled(true);
            spinTo.setEnabled(true);
        }
    }//GEN-LAST:event_cboxOptionAmountItemStateChanged

    private void jdcFromInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jdcFromInputMethodTextChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_jdcFromInputMethodTextChanged

    private void cboxOptionDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxOptionDateItemStateChanged
        // TODO add your handling code here:
        if(cboxOptionDate.getSelectedIndex()==0){
            statistics.jdcFrom.setEnabled(true);
            statistics.jdcTo.setEnabled(true);       
        }
        else{
            statistics.jdcFrom.setEnabled(false);
            statistics.jdcTo.setEnabled(false);
        }
    }//GEN-LAST:event_cboxOptionDateItemStateChanged

    private void cboxTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxTypeItemStateChanged
        // TODO add your handling code here:
        statistics.cboxType.setSelectedIndex(cboxType.getSelectedIndex());
        
        DefaultListModel model = new DefaultListModel();
        listCategory.removeAll();
        if (cboxType.getSelectedIndex() == 0) {

            for (String s : importList) {
                model.addElement(s);
            }
            listCategory.setModel(model);
            listCategory.setCellRenderer(new ComboxRender("src/image/import_type/", 1));
        } else {
            for (String s : exportList) {
                model.addElement(s);
            }
            listCategory.setModel(model);
            listCategory.setCellRenderer(new ComboxRender("src/image/export_type/", 1));
        }
    }//GEN-LAST:event_cboxTypeItemStateChanged

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        if(statistics.jtabpanelView.getSelectedIndex()==0){
            statistics.getListResult();
        }
        else if(statistics.jtabpanelView.getSelectedIndex()==1){
            statistics.setChart(statistics.isChartBar);
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void jdcToInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jdcToInputMethodTextChanged
        // TODO add your handling code here:
        statistics.jdcTo.setDate(jdcTo.getDate());
    }//GEN-LAST:event_jdcToInputMethodTextChanged

    private void jdcFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcFromPropertyChange
        try {
            // TODO add your handling code here:
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            statistics.jdcFrom.setDate(df.parse(df.format(jdcFrom.getDate())));
            //statistics.jdcFrom.setDate(new Date(2013, 11, 11));
        } catch (Exception ex) {
            //Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("loi");
        }
        

    }//GEN-LAST:event_jdcFromPropertyChange

    private void jdcToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcToPropertyChange
        try {
            // TODO add your handling code here:
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            statistics.jdcTo.setDate(df.parse(df.format(jdcTo.getDate())));

        } catch (Exception ex) {
            //Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jdcToPropertyChange

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
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    public javax.swing.JComboBox cboxOptionAccount;
    public javax.swing.JComboBox cboxOptionAmount;
    public javax.swing.JComboBox cboxOptionCategory;
    public javax.swing.JComboBox cboxOptionDate;
    public javax.swing.JComboBox cboxOptionText;
    public javax.swing.JComboBox cboxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public com.toedter.calendar.JDateChooser jdcFrom;
    public com.toedter.calendar.JDateChooser jdcTo;
    public javax.swing.JList listAccount;
    public javax.swing.JList listCategory;
    public javax.swing.JSpinner spinFrom;
    public javax.swing.JSpinner spinTo;
    public javax.swing.JTextField txtDescription;
    public javax.swing.JTextField txtInfo;
    // End of variables declaration//GEN-END:variables
}
