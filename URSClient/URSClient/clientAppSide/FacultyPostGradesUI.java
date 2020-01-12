
package clientAppSide;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FacultyPostGradesUI extends javax.swing.JDialog
{
	private static ArrayList<String> ungradedEntries = new ArrayList<String>();
	private static String selection, entry;
	private static ArrayList<String> gradedEntries = new ArrayList<String>();
 
    public FacultyPostGradesUI()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents()
    {
    	/*****************************************************************************************************************/

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Post Grades");

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Ungraded Students");
        
        /*****************************************************************************************************************/

        jButton5.setText("View Student");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Selections Made!", "Info", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String operationName = "viewUserProfile";
                	String requestingUI = "studentUserViewProfile";
                	String studentid = jList1.getSelectedValue().substring(jList1.getSelectedValue().length() - 6);
                	
                	ArrayList<String> serverInfo = new ArrayList<String>();
                	
                	serverInfo.add(operationName);
                	serverInfo.add(requestingUI);
                	serverInfo.add(studentid);
                    ClientConsole.accept(serverInfo);
            	}
            }
        });
        
        /*****************************************************************************************************************/

        jButton1.setText("Assign Grades");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList1.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Student Selected!", "Info", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String[] options = {"A", "B", "C", "D", "E", "F"};
                    String grade = (String) JOptionPane.showInputDialog(null, jList1.getSelectedValue(), "Select Student Grade", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                  
                    if (grade != null)
                    {
                    	String selection = jList1.getSelectedValue();
                    	entry = selection + " - " + grade;
                    	gradedEntries.add(entry);
                    	displayGradedList();
                    	ungradedEntries.remove(jList1.getSelectedValue().toString());
                    	displayUngradedList();
                        return;
                    }
            	}
            }
        });

        /*******************************************************************************/
        
        jTextField2.setEditable(false);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Graded Students");
        
        /*****************************************************************************************************************/

        jButton3.setText("Update Grades");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList2.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Student Selected!", "Info", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String[] options = {"Remove Grade", "A", "B", "C", "D", "E", "F"};
                    String grade = (String) JOptionPane.showInputDialog(null, jList2.getSelectedValue(), "Select Student Grade", JOptionPane.YES_NO_CANCEL_OPTION, null, options, options[0]);

                    if (grade != null)
                    {
                    	if(grade.equals("Remove Grade"))
                        {
                        	String entry = jList2.getSelectedValue().substring(0, jList2.getSelectedValue().length() - 4);
                        	ungradedEntries.add(entry);
                        	displayUngradedList();
                        	gradedEntries.remove(jList2.getSelectedValue().toString());
                        	displayGradedList();
                        	return;
                        }
                    	else
                    	{
                    		String student = jList2.getSelectedValue().substring(0, jList2.getSelectedValue().length() - 4);
                        	//entry = selection + " - " + grade;
                        	entry = student + " - " + grade;
                        	gradedEntries.remove(jList2.getSelectedValue());
                        	gradedEntries.add(entry);
                        	displayGradedList();
                            return;
                    	}
                    }
            	}
            }
        });
        
        /*****************************************************************************************************************/

        jButton2.setText("View Student");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(jList2.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Selections Made!", "Info", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String operationName = "viewUserProfile";
                	String requestingUI = "studentUserViewProfile";
                	
                	String memberid = jList2.getSelectedValue().substring(0, jList2.getSelectedValue().length() - 4);
                	String studentid = memberid.substring(memberid.length() - 6);
                	
                	ArrayList<String> serverInfo = new ArrayList<String>();
                	
                	serverInfo.add(operationName);
                	serverInfo.add(requestingUI);
                	serverInfo.add(studentid);
                    ClientConsole.accept(serverInfo);
            	}
            }
        });
        
        /*****************************************************************************************************************/

        jList1.setModel(new javax.swing.AbstractListModel<String>()
    	{
            public int getSize() 
            { 
            	return ungradedEntries.size(); 
            }
            public String getElementAt(int i) 
            { 
            	return ungradedEntries.get(i); 
            }
        });
        
        jScrollPane1.setViewportView(jList1);
        jScrollPane2.setViewportView(jList2);
 
        /*****************************************************************************************************************/
        //This section is auto generated by java swing Net-beans

        jButton4.setText("SUBMIT");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	if(gradedEntries.isEmpty())
            	{
            		JOptionPane.showMessageDialog(null, "No Grades Entered Yet!", "Info", JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		String operationName = "postGrades";
                	String courseName = selection;
                	ArrayList<String> serverInfo = new ArrayList<String>();
                	
                	serverInfo.add(operationName);
                	serverInfo.add(courseName);
                	
                	for(int i=0; i<gradedEntries.size(); i++)
                	{
                		serverInfo.add(gradedEntries.get(i).substring(gradedEntries.get(i).length() - 10));
                	}
         	
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
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                .addComponent(jTextField1))
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        pack();
    }
    /*****************************************************************************************************************/

    public static void displayUngradedList()
    {
    	jList1.setModel(new javax.swing.AbstractListModel<String>() 
    	{
            public int getSize() 
            { 
            	return ungradedEntries.size(); 
            }
            
            public String getElementAt(int i) 
            { 
            	return ungradedEntries.get(i);
            }
        });
    }
    
    /*****************************************************************************************************************/

    public static void displayGradedList()
    {
    	jList2.setModel(new javax.swing.AbstractListModel<String>() 
    	{
            public int getSize() 
            { 
            	return gradedEntries.size(); 
            }
            
            public String getElementAt(int i) 
            { 
            	return gradedEntries.get(i);
            }
        });
    }
    
    /*****************************************************************************************************************/

    public static void displayEnrolledStudents(ArrayList<String> list)
    {
    	selection = list.get(2);
    	
    	list.subList(0, 3).clear();
    	
    	ungradedEntries = list;
    	
    	display();
    }
    
    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    public static void display() 
    {
        try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}} 
        catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(FacultyPostGradesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) {java.util.logging.Logger.getLogger(FacultyPostGradesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(FacultyPostGradesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(FacultyPostGradesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new FacultyPostGradesUI().setVisible(true);}});
    }

    /*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JList<String> jList1;
    private static javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    
    /*****************************************************************************************************************/
}