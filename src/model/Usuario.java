package model;


public class Usuario {
    public int id;
    public String nome;
    public String email;
    public String senha;
    public String tipo;

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

    public void setTipo(String string) {
        this.tipo = tipo;
    }

    public void setId(int aInt) {
        this.id = id;
    }
  
}
