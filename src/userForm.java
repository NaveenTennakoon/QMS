import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class userForm extends javax.swing.JFrame {

    public userForm() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
        req_txtfield.setEditable(false);
        yes_rb.setActionCommand("Yes");
        no_rb.setActionCommand("No");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "SELECT productService FROM call_quotations WHERE status='open'";
            PreparedStatement state = conn.prepareStatement(sql);
            ResultSet rs = state.executeQuery();
            product_cmbBox.addItem("--select--");
            while (rs.next()){
                String proSer = rs.getString("productService");
                product_cmbBox.addItem(proSer);
            }  
            product_cmbBox.setSelectedItem("--select--");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        product_cmbBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        addquotation_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        company_txtfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        qty_txtfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notes_text = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        price_txtfield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        yes_rb = new javax.swing.JRadioButton();
        no_rb = new javax.swing.JRadioButton();
        req_txtfield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        product_cmbBox.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        product_cmbBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                product_cmbBoxItemStateChanged(evt);
            }
        });
        product_cmbBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_cmbBoxMouseClicked(evt);
            }
        });
        product_cmbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_cmbBoxActionPerformed(evt);
            }
        });
        jPanel1.add(product_cmbBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 37));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Product/Service");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        addquotation_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        addquotation_btn.setText("Apply");
        addquotation_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addquotation_btnActionPerformed(evt);
            }
        });
        jPanel1.add(addquotation_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 520, 90, 35));

        logout_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        jPanel1.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 90, 36));

        company_txtfield.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        company_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                company_txtfieldActionPerformed(evt);
            }
        });
        jPanel1.add(company_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 145, 307, 34));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Company Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 44));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        qty_txtfield.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jPanel1.add(qty_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, 34));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unit Price (Rs.)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        notes_text.setColumns(20);
        notes_text.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        notes_text.setRows(5);
        jScrollPane1.setViewportView(notes_text);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 660, 190));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Have you given us quotations previously?");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 284, -1, -1));
        jPanel1.add(price_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 234, 70, 34));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Notes/Comments");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        yes_rb.setBackground(new java.awt.Color(0, 0, 0));
        btngrp.add(yes_rb);
        yes_rb.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        yes_rb.setForeground(new java.awt.Color(255, 255, 255));
        yes_rb.setText("Yes");
        yes_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yes_rbActionPerformed(evt);
            }
        });
        jPanel1.add(yes_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        no_rb.setBackground(new java.awt.Color(0, 0, 0));
        btngrp.add(no_rb);
        no_rb.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        no_rb.setForeground(new java.awt.Color(255, 255, 255));
        no_rb.setText("No");
        no_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_rbActionPerformed(evt);
            }
        });
        jPanel1.add(no_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        req_txtfield.setEditable(false);
        req_txtfield.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        req_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                req_txtfieldActionPerformed(evt);
            }
        });
        jPanel1.add(req_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 70, 37));

        jButton1.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 89, 35));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Units Required");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        SelectUser selectuser = new SelectUser();
        selectuser.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void company_txtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_company_txtfieldActionPerformed
        
    }//GEN-LAST:event_company_txtfieldActionPerformed

    private void no_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_rbActionPerformed
        
    }//GEN-LAST:event_no_rbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        company_txtfield.setText("");
        qty_txtfield.setText("");
        price_txtfield.setText("");
        notes_text.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addquotation_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addquotation_btnActionPerformed
        if(company_txtfield.getText().trim().isEmpty() || qty_txtfield.getText().trim().isEmpty() || price_txtfield.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Required fields must be filled to add quotation");
            company_txtfield.setText("");
            qty_txtfield.setText("");
            price_txtfield.setText("");
            notes_text.setText("");
        }
        else{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
                String presql = "SELECT SID FROM call_quotations WHERE productService=?";
                String sql = "INSERT INTO quotations (SID,companyName,quantity,unitPrice,prevQuotations,notes) VALUES (?,?,?,?,?,?) ";
                PreparedStatement prestate = conn.prepareStatement(presql);
                Object selectedItem = product_cmbBox.getSelectedItem();
                if (selectedItem != null){
                    String selectedItemStr = selectedItem.toString();
                    prestate.setString(1, selectedItemStr);
                }
                ResultSet rs = prestate.executeQuery();
                PreparedStatement state = conn.prepareStatement(sql);
                while(rs.next()){
                    String sid = String.valueOf(rs.getInt("SID"));
                    state.setString(1, sid);
                }
                state.setString(2, company_txtfield.getText());
                state.setString(3, qty_txtfield.getText());
                state.setString(4, price_txtfield.getText());
                state.setString(5, btngrp.getSelection().getActionCommand());
                state.setString(6, notes_text.getText());
                state.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Quotation successfully sent to the Provider");
                    company_txtfield.setText("");
                    qty_txtfield.setText("");
                    price_txtfield.setText("");
                    notes_text.setText("");
                    conn.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_addquotation_btnActionPerformed

    private void req_txtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_req_txtfieldActionPerformed
        
    }//GEN-LAST:event_req_txtfieldActionPerformed

    private void product_cmbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_cmbBoxActionPerformed
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "SELECT quantity FROM call_quotations WHERE productService=?";
            PreparedStatement state = conn.prepareStatement(sql);       
            Object selectedItem = product_cmbBox.getSelectedItem();
            if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            if(selectedItem.toString()=="--select--"){
                req_txtfield.setText("");
            }
            else{
                ResultSet rs = state.executeQuery();
                while(rs.next()){
                    String proSer = String.valueOf(rs.getInt("quantity"));
                    req_txtfield.setText(proSer);
                } 
            } 
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_product_cmbBoxActionPerformed

    private void product_cmbBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_product_cmbBoxItemStateChanged
        
    }//GEN-LAST:event_product_cmbBoxItemStateChanged

    private void product_cmbBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_cmbBoxMouseClicked
        
    }//GEN-LAST:event_product_cmbBoxMouseClicked

    private void yes_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yes_rbActionPerformed
        
    }//GEN-LAST:event_yes_rbActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addquotation_btn;
    private javax.swing.ButtonGroup btngrp;
    private javax.swing.JTextField company_txtfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JRadioButton no_rb;
    private javax.swing.JTextArea notes_text;
    private javax.swing.JTextField price_txtfield;
    private javax.swing.JComboBox<String> product_cmbBox;
    private javax.swing.JTextField qty_txtfield;
    private javax.swing.JTextField req_txtfield;
    private javax.swing.JRadioButton yes_rb;
    // End of variables declaration//GEN-END:variables
}
