import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class adminForm extends javax.swing.JFrame {

    public adminForm() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
        status_txtfield.setEditable(false);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "SELECT productService FROM call_quotations";
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

    public ArrayList<User> userList(){
        ArrayList<User> usersList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "SELECT quotations.QID,quotations.companyName,quotations.quantity,quotations.unitPrice,quotations.prevQuotations,quotations.notes from quotations INNER JOIN call_quotations ON quotations.SID=call_quotations.SID WHERE call_quotations.productService=?";
            PreparedStatement state = conn.prepareStatement(sql);
            Object selectedItem = product_cmbBox.getSelectedItem();
            if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            ResultSet rs = state.executeQuery();
            User user;
            while(rs.next()){
                user = new User(rs.getInt("QID"), rs.getInt("quantity"), rs.getInt("unitPrice"), rs.getString("companyName"), rs.getString("prevQuotations"), rs.getString("notes"));
                usersList.add(user);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        return usersList;
    }
    
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)quote_tbl.getModel();
        Object[] row = new Object[6];
        model.setRowCount(0);
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getqid();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getqty();
            row[3] = list.get(i).getprice();
            row[4] = list.get(i).getprevq();
            row[5] = list.get(i).getnotes();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        product_cmbBox = new javax.swing.JComboBox<>();
        close_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        status_txtfield = new javax.swing.JTextField();
        open_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        qty_txtfield = new javax.swing.JTextField();
        setqty_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        quote_tbl = new javax.swing.JTable();
        delete_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        getContentPane().add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 90, 40));

        jButton1.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        jButton1.setText("Add Product/Service");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("See called quotations");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        product_cmbBox.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        product_cmbBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                product_cmbBoxItemStateChanged(evt);
            }
        });
        product_cmbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_cmbBoxActionPerformed(evt);
            }
        });
        getContentPane().add(product_cmbBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 40));

        close_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        close_btn.setText("Close quotation");
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });
        getContentPane().add(close_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 160, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        status_txtfield.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        getContentPane().add(status_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, 40));

        open_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        open_btn.setText("Re-Open quotation");
        open_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_btnActionPerformed(evt);
            }
        });
        getContentPane().add(open_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 190, 40));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Qty");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        getContentPane().add(qty_txtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 90, 40));

        setqty_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        setqty_btn.setText("Set Quantity");
        setqty_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setqty_btnActionPerformed(evt);
            }
        });
        getContentPane().add(setqty_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, 40));

        jScrollPane2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        quote_tbl.setAutoCreateRowSorter(true);
        quote_tbl.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        quote_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "QID", "Company Name", "Quantity", "Unit Price", "Any Previous Quotations?", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(quote_tbl);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 920, 330));

        delete_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        delete_btn.setText("Delete Quotation");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 170, 40));

        refresh_btn.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        SelectUser selectuser = new SelectUser();
        selectuser.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addProduct addproduct = new addProduct();
        addproduct.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        try{         
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "UPDATE call_quotations SET status='Closed' WHERE productService=?";
            PreparedStatement state = conn.prepareStatement(sql);       
            Object selectedItem = product_cmbBox.getSelectedItem();
            if(selectedItem == "--select--"){
                JOptionPane.showMessageDialog(null,"Please select an item first");
            }
            else if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            state.executeUpdate();
            sql = "SELECT status FROM call_quotations WHERE productService=?";
            state = conn.prepareStatement(sql);
            if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                status_txtfield.setText(rs.getString("status"));
            }  
            JOptionPane.showMessageDialog(null,"Status successfully updated");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_close_btnActionPerformed

    private void open_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_btnActionPerformed
        try{         
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "UPDATE call_quotations SET status='Open' WHERE productService=?";
            PreparedStatement state = conn.prepareStatement(sql);       
            Object selectedItem = product_cmbBox.getSelectedItem();
            if(selectedItem == "--select--"){
                JOptionPane.showMessageDialog(null,"Please select an item first");
            }
            else if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            state.executeUpdate(); 
            sql = "SELECT status FROM call_quotations WHERE productService=?";
            state = conn.prepareStatement(sql);
            if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                status_txtfield.setText(rs.getString("status"));
            }  
            JOptionPane.showMessageDialog(null,"Status successfully updated");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_open_btnActionPerformed

    private void product_cmbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_cmbBoxActionPerformed
  
    }//GEN-LAST:event_product_cmbBoxActionPerformed

    private void setqty_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setqty_btnActionPerformed
        try{         
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "UPDATE call_quotations SET quantity=? WHERE productService=?";
            PreparedStatement state = conn.prepareStatement(sql);       
            Object selectedItem = product_cmbBox.getSelectedItem();
            if(selectedItem == "--select--"){
                JOptionPane.showMessageDialog(null,"Please select an item first");
            }
            else if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                int qty = Integer.parseInt(qty_txtfield.getText());
                state.setInt(1, qty);
                state.setString(2, selectedItemStr);
            }
            state.executeUpdate();
            JOptionPane.showMessageDialog(null,"Quantity successfully updated");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_setqty_btnActionPerformed

    private void product_cmbBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_product_cmbBoxItemStateChanged
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "SELECT status,quantity FROM call_quotations WHERE productService=?";
            PreparedStatement state = conn.prepareStatement(sql);       
            Object selectedItem = product_cmbBox.getSelectedItem();
            if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            if(selectedItem.toString()=="--select--"){
                status_txtfield.setText("");
                qty_txtfield.setText("");
            }
            else{
                ResultSet rs = state.executeQuery();
                while(rs.next()){
                    status_txtfield.setText(rs.getString("status"));
                    qty_txtfield.setText(rs.getString("quantity"));
                }    
            }
            show_user();
            
        }
        catch(Exception ex){
        }
    }//GEN-LAST:event_product_cmbBoxItemStateChanged

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "SELECT productService FROM call_quotations";
            PreparedStatement state = conn.prepareStatement(sql);
            ResultSet rs = state.executeQuery();
            System.out.println(product_cmbBox.getItemCount());
            product_cmbBox.removeAllItems();
            product_cmbBox.addItem("--select--");
            while (rs.next()){
                String proSer = rs.getString("productService");
                product_cmbBox.addItem(proSer);
            }  
            product_cmbBox.setSelectedItem("--select--");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "");
            String sql = "DELETE FROM call_quotations WHERE productService=?";
            Object selectedItem = product_cmbBox.getSelectedItem();
            PreparedStatement state = conn.prepareStatement(sql);
            if (selectedItem != null){
                String selectedItemStr = selectedItem.toString();
                state.setString(1, selectedItemStr);
            }
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Quotation Deleted successfully");
            String postsql = "SELECT productService FROM call_quotations";
            PreparedStatement poststate = conn.prepareStatement(postsql);
            ResultSet rs = poststate.executeQuery();
            product_cmbBox.removeAllItems();
            product_cmbBox.addItem("--select--");
            while (rs.next()){
                String proSer = rs.getString("productService");
                product_cmbBox.addItem(proSer);
            }  
            product_cmbBox.setSelectedItem("--select--");
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton open_btn;
    private javax.swing.JComboBox<String> product_cmbBox;
    private javax.swing.JTextField qty_txtfield;
    private javax.swing.JTable quote_tbl;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton setqty_btn;
    private javax.swing.JTextField status_txtfield;
    // End of variables declaration//GEN-END:variables
}
