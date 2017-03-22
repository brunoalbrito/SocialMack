package br.mack.lp3.persistence.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 41583469
 */
@Entity
//@Table(name = "lp3_userlp3")
public class Participante implements Serializable{
  
    
    private String nome,email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Renomear a coluna
//    @Column(name = "chavinha")
    private long id_userlp3;
    
//    Precisa para data
//    @Temporal(TemporalType.DATE)
//    private Date birthday;
    
    
//    Não persistente
//    @Transient
//    private int age;

    public Participante() {
    }

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Participante(String nome, String email, long id_userlp3) {
        this.nome = nome;
        this.email = email;
        this.id_userlp3 = id_userlp3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId_userlp3() {
        return id_userlp3;
    }

    public void setId_userlp3(long id_userlp3) {
        this.id_userlp3 = id_userlp3;
    }

    @Override
    public String toString() {
        return "UserLP3{" + "nome=" + nome + ", email=" + email + ", id_userlp3=" + id_userlp3 + '}';
    }
}
