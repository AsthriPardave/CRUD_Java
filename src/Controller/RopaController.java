/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ropa;
import View.RopaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class RopaController {
    RopaView fr;
    Ropa [] ropas;
    Ropa ropa;
    
    public RopaController(){
       fr = new RopaView();
       ropas = new Ropa[0];
       llenarTabla();
       
       this.fr.BtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = fr.InputCodigo.getText();
                String modelo = fr.InputModelo.getText();
                String marca = fr.InputMarca.getText();
                String tipo = fr.InputTipo.getText();
                String color = fr.InputColor.getText();
                String talla = (String) fr.cbTalla.getSelectedItem();
                int stock = (int) fr.InputStock.getValue();
                
                if("".equals(codigo) || "".equals(modelo) || "".equals(marca) || "".equals(tipo) || "".equals(color) || "".equals(talla) || stock < 0){
                    JOptionPane.showMessageDialog(fr, "Llenar todos los campos");
                    
                } else if(Ropa.buscarRopa(ropas, codigo) != null){
                    JOptionPane.showMessageDialog(fr, "Código existente, escribe otro");
                }else {
                    Ropa ropa = new Ropa(codigo, marca, modelo, talla, tipo, color, stock);
                    //If registration success, reloads the table and clear all input fields
                    ropas = Ropa.agregarRopa(ropas, ropa);
                    llenarTabla();
                }
            }
        });
       
       this.fr.BtnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = fr.InputCodigo.getText();
                if("".equals(id)){
                    JOptionPane.showMessageDialog(fr, "Escribe el codigo que quieres buscar, idiota");
                } else {
                    ropa = Ropa.buscarRopa(ropas, id);
                    if(ropa == null ){
                        JOptionPane.showMessageDialog(fr, "Ay, ese codigo de ropa no existe, escribe bien oe");
                    } else {
                        fr.InputCodigo.setText(ropa.getCodigo());
                        fr.InputModelo.setText(ropa.getModelo());
                        fr.InputMarca.setText(ropa.getMarca());
                        fr.InputTipo.setText(ropa.getTipo());
                        fr.InputColor.setText(ropa.getColor());
                        fr.cbTalla.setSelectedItem(ropa.getTalla());
                        fr.InputStock.setValue(ropa.getStock());
                    }
                }
            }
        });
                            
       this.fr.BtnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = fr.InputCodigo.getText();
                String modelo = fr.InputModelo.getText();
                String marca = fr.InputMarca.getText();
                String tipo = fr.InputTipo.getText();
                String color = fr.InputColor.getText();
                String talla = (String) fr.cbTalla.getSelectedItem();
                int stock = (int) fr.InputStock.getValue();
                Ropa ropa = new Ropa(codigo, marca, modelo, talla, tipo, color, stock);
                
                if("".equals(codigo) || "".equals(modelo) || "".equals(marca) || "".equals(tipo) || "".equals(color) || "".equals(talla) || stock < 0){
                    JOptionPane.showMessageDialog(fr, "Llena todos los campos crj");   
                } else {
                    ropas = Ropa.actualizarRopa(ropas, ropa);
                    llenarTabla();
                }
            }
        });
       
       this.fr.BtnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String id = fr.InputCodigo.getText();
               if("".equals(id)){
                   JOptionPane.showMessageDialog(fr, "Escribe el codigo del producto que quieres eliminar");
               } else if(Ropa.buscarRopa(ropas, id) != null){
                   ropas = Ropa.eliminarRopa(ropas, id);
                   llenarTabla();   
               } else {
                   JOptionPane.showMessageDialog(fr, "No existe este código");
               }
            }
        });
    }
    
    public void Run(){
        fr.setVisible(true);
    }
    
    public void llenarTabla(){
        String[] columnas = {"Codigo", "Modelo", "Marca", "Tipo", "Stock", "Color", "talla"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for(Ropa ropa: ropas){
            Object[] fila = {ropa.getCodigo(), ropa.getModelo(), ropa.getMarca(), ropa.getTipo(), ropa.getStock(), ropa.getColor(), ropa.getTalla()};
            modelo.addRow(fila);
        }
        fr.Table.setModel(modelo); 
    
        fr.InputCodigo.setText("");
        fr.InputColor.setText("");
        fr.InputMarca.setText("");
        fr.InputModelo.setText("");
        fr.InputTipo.setText("");
        fr.InputStock.setValue(0);
    }  
}
