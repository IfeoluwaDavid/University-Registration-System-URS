package clientAppSide;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CreateDepartmentUI extends javax.swing.JDialog {

    public CreateDepartmentUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        /*****************************************************************************************************************/

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        /*****************************************************************************************************************/

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        String operationName = "getFaculties";
    	String requestingUI = "createDepartmentFacultyOptions";
    	ArrayList<String> serverInfo = new ArrayList<String>();
    	serverInfo.add(operationName);
    	serverInfo.add(requestingUI);
        ClientConsole.accept(serverInfo);

        /*****************************************************************************************************************/

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
 
        jLabel1.setText("Create Department");
        jLabel2.setText("Department Name:");
        jLabel3.setText("Duration:");
        jLabel4.setText("Faculty:");

        /*****************************************************************************************************************/

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                String operationName = "createDepartment";
            	String departmentName = jTextField1.getText();
                String duration = jTextField2.getText();
                String faculty = String.valueOf(jComboBox1.getSelectedItem());

                ArrayList<String> serverInfo = new ArrayList<String>();

                serverInfo.add(operationName);
                serverInfo.add(departmentName);
                serverInfo.add(duration);
                serverInfo.add(faculty);

                if(Validation.validateCreateDepartment(serverInfo).equals("incomplete"))
                {
                	JOptionPane.showMessageDialog(null, "Incomplete form", "Incomplete form", JOptionPane.ERROR_MESSAGE);
                }

                if(Validation.validateCreateDepartment(serverInfo).equals("departmentNameProblem"))
                {
                	JOptionPane.showMessageDialog(null, "Invalid Dapartment Name", "Invalid Dapartment Name", JOptionPane.ERROR_MESSAGE);
                }

                if(Validation.validateCreateDepartment(serverInfo).equals("durationProblem"))
                {
                	JOptionPane.showMessageDialog(null, "Duration must be maximum of 5 years", "Invalid Duration", JOptionPane.ERROR_MESSAGE);
                }

                if(Validation.validateCreateDepartment(serverInfo).equals("valid"))
                {
                	ClientConsole.accept(serverInfo);
                }
            }
        });

        /*****************************************************************************************************************/
        //This section is auto generated by java swing Net-beans 
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pack();
    }
    
    /*****************************************************************************************************************/
    
    public static void createDepartmentFacultyOptions(ArrayList<String> facultyList)
    {
    	facultyList.subList(0, 2).clear();	
    	String[] programArray = new String[facultyList.size()];
    	programArray = facultyList.toArray(programArray);
    	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(programArray));
    }
 
    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans
    
    public static void display(Boolean action)
    {
    	try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    	if ("Nimbus".equals(info.getName())) {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}} 
    	catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(CreateDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);} 
    	catch (InstantiationException ex) {java.util.logging.Logger.getLogger(CreateDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
    	catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(CreateDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);} 
    	catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(CreateDepartmentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
    	java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new CreateDepartmentUI().setVisible(true);}});}

    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans
    
    private javax.swing.JButton jButton1;
    private static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    
    /*****************************************************************************************************************/
}