
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobinda;

import java.awt.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;  


/**
 *
 * @author Jaco
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    
    public MainFrame()
    {
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Moontlik kak
        setBounds(100, 100, 1000, 600);
        
        
        
        
        Container contentPane = this.getContentPane();
        contentPane  = new JPanel();
        //contentPane.setBackground(new Color(0,0,0));
      
     //contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));//Moontlik kak
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        
         JComboBox yearSelectCombobox = new JComboBox(getYears());
         yearSelectCombobox.setBounds(10, 11, 160, 43);
         contentPane.add(yearSelectCombobox);
         
        
        
         JComboBox monthSelectCombobox = new JComboBox(getMonths());
        monthSelectCombobox.setBounds(180, 11, 160, 43);
        contentPane.add(monthSelectCombobox);
        
        JTextArea textArea = new JTextArea(10,30);
        contentPane.add(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        
        JButton btnNewButton = new JButton("Show");
        btnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                
                     System.out.println("" + yearSelectCombobox.getSelectedItem());
                      int yearSelected =  Integer.parseInt(yearSelectCombobox.getSelectedItem().toString());
                      int monthSelected = monthSelectCombobox.getSelectedIndex();// As jy maand name soek maak dit net selected items
        
                    showCalendar(yearSelected, monthSelected);
                   
            }
        });
        btnNewButton.setBounds(350, 11, 112, 43);
        contentPane.add(btnNewButton);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 76, 452, 262);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(7, 7, 0, 0));
        
        //Add event button
         JButton btnAdd = new JButton("Add event");
         btnAdd.setBounds(500, 360, 112, 43);
         
        
           
            
                 
        contentPane.add(btnAdd);
        
        
        //Add event panel
        JPanel pnlAdd = new JPanel();
        pnlAdd.setBounds(500, 70, 300, 262);
        pnlAdd.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill =GridBagConstraints.RELATIVE;
        pnlAdd.setVisible(false);
        
        //Add event panel visibility
         btnAdd.addActionListener(new ActionListener()
         {
              public void actionPerformed(ActionEvent arg0)
                 {
                     pnlAdd.setVisible(true);
                 }
         });
        
          //Add event objects
        
          /*c.gridx=0;
          c.gridy=70;
        JLabel lblAddNewEvent = new JLabel("Add a new event");
        pnlAdd.add(lblAddNewEvent,c);*/
        
        
        c.gridx=0;
        c.gridy=5;
        JLabel lblTitle = new JLabel("Title :");
        pnlAdd.add(lblTitle,c);
        
        c.gridx=2;
        
        TextField txtTitle = new TextField("",20);
        pnlAdd.add(txtTitle,c);
        
        c.gridx=0;
        c.gridy=9;
        JLabel lblTime = new JLabel("Time :");
        pnlAdd.add(lblTime,c);
        
        
         String[] times =
        {"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
        //Add event comboboxes
        
        JComboBox cmbStart = new JComboBox(times);
        JComboBox cmbEnd = new JComboBox(times);
        c.gridx=0;
        c.gridy=11;
        pnlAdd.add(cmbStart,c);
        c.gridx=2;
        c.gridy=11;
        pnlAdd.add(cmbEnd,c);
        
        JButton btnCreate = new JButton("Create Event");
        c.gridx=0;
        c.gridy=13;
        pnlAdd.add(btnCreate,c);
        
       
       
        
       contentPane.add(pnlAdd);
       //pnlAdd.setBackground(Color.red);
        
     
        
        
       
        
       
        
        
        JLabel[] labels = new JLabel[7];
        String[] dayNames = {"sat","sun","mon","Tue","wed","thu","Fri"};
        for(int i=0;i<labels.length;i++)
        {
            labels[i] = new JLabel(dayNames[i]);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            panel.add(labels[i]);
        }
        
        // Text wat buttons moet word
       
        for(int i=0;i<textFields.length;i++)
        {
            
            textFields[i]=new JTextField();
            textFields[i].setEditable(false);
            textFields[i].setHorizontalAlignment(JTextField.CENTER);
            panel.add(textFields[i]);
        }
        
      
    }
    
    
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yearSelectCombobox = new javax.swing.JComboBox<>();
        monthSelectCombobox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        yearSelectCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearSelectCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearSelectComboboxActionPerformed(evt);
            }
        });

        monthSelectCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yearSelectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addComponent(monthSelectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yearSelectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthSelectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearSelectComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearSelectComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearSelectComboboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        System.out.println("Lekker");
        int yearSelected =  Integer.parseInt(yearSelectCombobox.getSelectedItem().toString());
        int monthSelected = monthSelectCombobox.getSelectedIndex();// As jy maand name soek maak dit net selected items
        
        showCalendar(yearSelected, monthSelected);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public JTextField[] textFields = new JTextField[42];
    
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
        
      
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> monthSelectCombobox;
    private javax.swing.JComboBox<String> yearSelectCombobox;
    // End of variables declaration//GEN-END:variables

    //1900-2100
    private String[] getYears() 
    {
        String[] str = new String[201];
        for(int i= 1900,j =0 ; i<2100;i++,j++)
        {
            str[j] = String.valueOf(i);
        }
        return str;
            
    }

    private String[] getMonths() 
    {
        String[] str = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return str;
    }

    protected void showCalendar(int yearSelected, int monthSelected) 
    {
       int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
       
       int year = 1900;
       int month = 0;
       int day =2;
       
       while(colbeKina(yearSelected,monthSelected,year,month))
       {
           if(month == 1 && leapYear(year))
           {
               day+= 29;
           }else
           {
               day+= monthDays[month];
           }
           
           month++;
           if(month == 12) 
           {
               month = 0;
               year++;
           }
           
           day = day % 7;
       }
       
       
       for(int i = 0; i <textFields.length; i++)
       {
           textFields[i].setText("");
       }
       
       int lastValue = monthDays[monthSelected];
       if(monthSelected ==1 && leapYear(yearSelected))
       {
           lastValue ++;
       }
       
       for(int i=1,j=day;i<= lastValue;i++,j++)
       {
           textFields[j].setText(String.valueOf(i));
       }
       
    }

    private boolean colbeKina(int yearSelected, int monthSelected, int year, int month)
    {
        if(yearSelected==year && monthSelected == month)
        {
            return false;
        }
       return true;
    }

    private boolean leapYear(int year) 
    {
        boolean ans = false;
        
        if( year % 4 == 0)
        {
            ans = true;
        }
        if(year % 100 == 0)
        {
            ans = false;
        }
        if(year % 400 == 0)
        {
            ans = true;
        }
        return ans;
    }
    
}
