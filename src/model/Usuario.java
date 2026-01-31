    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jogom
 */

    public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    // getters e setters

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    
    public void setSenha(String senha) {
       this.senha = senha; 
    }
    
    public void setNome(String nome){
        this.nome = nome;
             }
   public void setTipoCLiente(){this.tipo = "CLIENTE";}  
  
}
