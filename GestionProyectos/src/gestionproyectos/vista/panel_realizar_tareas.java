/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.vista;

import PatronesDiseño.PrincipalVisitador;
import gestionproyectos.controlador.PrincipalController;
import gestionproyectos.modelo.Proyectos;
import gestionproyectos.modelo.Tareas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author gianlucasorem
 */
public class panel_realizar_tareas extends javax.swing.JPanel {

    /**
     * Creates new form panel_realizar_tareas
     */
    public panel_realizar_tareas() {
        initComponents();
        CrearModelo2();
        
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
        tabla = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jToggleButton1.setText("Ok");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jToggleButton1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
            
            int inicio = (int) System.currentTimeMillis();            
            PrincipalController.getInstance().tiempoInicio(inicio);
            int sel=tabla.getSelectedRow();
            Tareas tarea = PrincipalController.getInstance().obtenerTareaRealizar(sel);
            PrincipalController.getInstance().setTareaRealizar(tarea);
            
            visitador.cargarInformacion3();
            visitador.CambiarTarjetaB("ModificarTarea");
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
   private PrincipalVisitador visitador;
   
   DefaultTableModel modelo2;

    private void CrearModelo2() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "ID", "Nombre Tarea",
                        "Descripcion", "Estado"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class

                   
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false , false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo2) ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }
    
    public void cargarInformacion1(){
    
        try {
            System.out.println("aca vamos carg info panel tareas");
            Object O[]=null;
            List<Tareas> listP = PrincipalController.getInstance().getTareasSolic();
            
            
            
            for (int i = 0; i < listP.size(); i++) {
                System.out.println(listP.get(i).getNombreTarea());
                
                modelo2.addRow(O);
                
                if(listP.get(i).getEstadoTarea()==1){System.out.println("esta completa");}
                else if(listP.get(i).getEstadoTarea()==0){
                    modelo2.setValueAt(listP.get(i).getIdTarea(),i, 0);
                    modelo2.setValueAt(listP.get(i).getNombreTarea(), i, 1);
                    modelo2.setValueAt(listP.get(i).getDescripcionTarea(), i, 2);
                    modelo2.setValueAt("incompleta", i, 3);}
                
                
                      
            }
            
        } catch (Exception e) {
        }
    }
   

    public void setVisitador(PrincipalVisitador visitador) {
        this.visitador = visitador;
    }
   
   
    
}
