/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HP
 */
public class Ropa {
    private String marca;
    private String codigo;
    private String modelo;
    private String talla;
    private String tipo;
    private String color;
    private int stock;

    public Ropa(String codigo, String marca, String modelo, String talla, String tipo, String color, int stock) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.tipo = tipo;
        this.color = color;
        this.stock = stock;
    } 

    public static Ropa [] agregarRopa (Ropa[] arreglo, Ropa nvaRopa){
        Ropa[] nvoArreglo = new Ropa[arreglo.length +1];
        
        for(int i=0; i<arreglo.length;i++){
            nvoArreglo[i] = arreglo[i];  // copia el arreglo al nvo arreglo
        }
        nvoArreglo[nvoArreglo.length - 1] = nvaRopa;  //añade la nueva ropa al nuevo arreglo
        
        return nvoArreglo; // retorna el nuevo arreglo con la nueva ropa agregado
    }
    
    public static Ropa [] eliminarRopa(Ropa[] arreglo, String codigo){
        Ropa[] nvoArreglo = new Ropa[arreglo.length -1];
        int index = 0;
        
        for(int i=0; i<arreglo.length; i++){
            if(arreglo[i].codigo == null ? codigo == null : arreglo[i].codigo.equals(codigo)){
                index = i;
                break;
            } else {
                nvoArreglo[i] = arreglo[i]; 
            }
        }
        for(int i=index+1; i<arreglo.length;i++){
            nvoArreglo[i] = arreglo[i];
        }
        
        return nvoArreglo;
    } 
        
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
