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
    private long id_participante;
    
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

    public Participante(String nome, String email, long id_participante) {
        this.nome = nome;
        this.email = email;
        this.id_participante = id_participante;
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

    public long getId_participante() {
        return id_participante;
    }

    public void setId_participante(long id_participante) {
        this.id_participante = id_participante;
    }

    

    @Override
    public String toString() {
        return "Participante{" + "nome=" + nome + ", email=" + email + ", id_participante=" + id_participante + '}';
    }
}
