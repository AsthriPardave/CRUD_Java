/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ropa;
import View.RopaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class RopaController {
    RopaView fr;
    Ropa [] ropas;
    
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
                
                Ropa ropa = new Ropa(codigo, marca, modelo, talla, tipo, color, stock);
                //If registration success, reloads the table and clear all input fields
                
                ropas = Ropa.agregarRopa(ropas, ropa);
                llenarTabla();
            }
        });
       
       this.fr.BtnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = fr.InputCodigo.getText();
                for(int i = 0; i<ropas.length; i++ ){
                    if(id == null ? ropas[i].getCodigo() == null : id.equals(ropas[i].getCodigo())){
                        fr.InputCodigo.setText(ropas[i].getCodigo());
                        fr.InputModelo.setText(ropas[i].getModelo());
                        fr.InputMarca.setText(ropas[i].getMarca());
                        fr.InputTipo.setText(ropas[i].getTipo());
                        fr.InputColor.setText(ropas[i].getColor());
                        fr.cbTalla.setSelectedItem(ropas[i].getTalla());
                        fr.InputStock.setValue(ropas[i].getStock());
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
                for(int i = 0; i<ropas.length; i++ ){
                    if(codigo == null ? ropas[i].getCodigo() == null : codigo.equals(ropas[i].getCodigo())){
                        ropas[i] = new Ropa(codigo, marca, modelo, talla, tipo, color, stock);
                    }
                }    
                llenarTabla();
            }
        });
       
       this.fr.BtnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String id = fr.InputCodigo.getText();
               ropas = Ropa.eliminarRopa(ropas, id);
               llenarTabla(); 
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
