/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 41583469
 */
@Entity
@Table(name = "PALESTRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestra.findAll", query = "SELECT p FROM Palestra p")
    , @NamedQuery(name = "Palestra.findByIdPalestra", query = "SELECT p FROM Palestra p WHERE p.idPalestra = :idPalestra")
    , @NamedQuery(name = "Palestra.findByTema", query = "SELECT p FROM Palestra p WHERE p.tema = :tema")
    , @NamedQuery(name = "Palestra.findByDescricao", query = "SELECT p FROM Palestra p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Palestra.findByPalestrante", query = "SELECT p FROM Palestra p WHERE p.palestrante = :palestrante")})
public class Palestra implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PALESTRA")
    private Long idPalestra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TEMA")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PALESTRANTE")
    private String palestrante;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Participante> participantes;
    
    public Palestra() {
    }
    
    public Palestra(Long idPalestra) {
        this.idPalestra = idPalestra;
    }
    
    public Palestra(Long idPalestra, String tema, String descricao, String palestrante) {
        this.idPalestra = idPalestra;
        this.tema = tema;
        this.descricao = descricao;
        this.palestrante = palestrante;
    }
    
    public Long getIdPalestra() {
        return idPalestra;
    }
    
    public void setIdPalestra(Long idPalestra) {
        this.idPalestra = idPalestra;
    }
    
    public String getTema() {
        return tema;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getPalestrante() {
        return palestrante;
    }
    
    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalestra != null ? idPalestra.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestra)) {
            return false;
        }
        Palestra other = (Palestra) object;
        if ((this.idPalestra == null && other.idPalestra != null) || (this.idPalestra != null && !this.idPalestra.equals(other.idPalestra))) {
            return false;
        }
        return true;
    }
    
    public List<Participante> getParticipantes() {
        return participantes;
    }
    
    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void addParticipante(Participante p) {
        this.participantes.add(p);
    }
    
    @Override
    public String toString() {
        return "Palestra{" + "idPalestra=" + idPalestra + ", tema=" + tema + ", descricao=" + descricao + ", palestrante=" + palestrante + ", participantes=" + participantes + '}';
    }
    
}
