/**************************************************************************
 * CourseScheduleUI.java
 * 
 * Brief Description:
 * 
 * Related Documents:
 * Specification Document version 2
 * Design Document version 1
 * 
 * File created by Sushant Sharma  on October 20, 2018
 * 
 * Important variables:
 * 
 * 
 **************************************************************************/

package clientAppSide;

import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class CourseScheduleUI extends javax.swing.JDialog 
{
    public CourseScheduleUI() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        
        SpinnerDateModel modelA = new SpinnerDateModel();
        modelA.setValue(calendar.getTime());
        jSpinner1 = new javax.swing.JSpinner(modelA);
        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm a");
        jSpinner1.setEditor(de);
        
        SpinnerDateModel modelB = new SpinnerDateModel();
        modelB.setValue(calendar.getTime());
        jSpinner2 = new javax.swing.JSpinner(modelB);
        JSpinner.DateEditor de2 = new JSpinner.DateEditor(jSpinner2, "HH:mm a");
        jSpinner2.setEditor(de2);
        
        jSpinner1.setMaximumSize(new java.awt.Dimension(12, 12));
        jSpinner1.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel1.setText("Start Time:");
        jLabel2.setText("End Time:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        String weekday = CreateCourseUI.jList1.getSelectedValue();
        jLabel3.setText("Set "+ weekday + " Time Schedule");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	String starttime = de.getFormat().format(jSpinner1.getValue());
            	String endtime = de.getFormat().format(jSpinner2.getValue());
            	String schedule = (weekday+" ("+starttime+" - "+endtime+")");
            	CreateCourseUI.addScheduleToList(schedule);
            	dispose();
            }
        });

/***********************************************************************************************************/
 //This section is auto generated by java swing Net-beans
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jSpinner2))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pack();
        
/*****************************************************************************************************************/
        //This section is auto generated by java swing Net-beans

    }

    public static void display() 
    {
        try {for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {javax.swing.UIManager.setLookAndFeel(info.getClassName());break;}}} 
        catch (ClassNotFoundException ex) {java.util.logging.Logger.getLogger(CourseScheduleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (InstantiationException ex) {java.util.logging.Logger.getLogger(CourseScheduleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (IllegalAccessException ex) {java.util.logging.Logger.getLogger(CourseScheduleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {java.util.logging.Logger.getLogger(CourseScheduleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new CourseScheduleUI().setVisible(true);}});
    }

/*****************************************************************************************************************/
    //This section is auto generated by java swing Net-beans

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    
/*****************************************************************************************************************/
}
