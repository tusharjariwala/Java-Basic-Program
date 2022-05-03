/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tushar Jariwala
 */
@Entity
@Table(name = "countemploye", catalog = "test1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countemploye.findAll", query = "SELECT c FROM Countemploye c"),
    @NamedQuery(name = "Countemploye.findById", query = "SELECT c FROM Countemploye c WHERE c.id = :id"),
    @NamedQuery(name = "Countemploye.findByIPAddress", query = "SELECT c FROM Countemploye c WHERE c.iPAddress = :iPAddress"),
    @NamedQuery(name = "Countemploye.findByCount", query = "SELECT c FROM Countemploye c WHERE c.count = :count")})
public class Countemploye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IPAddress", nullable = false, length = 255)
    private String iPAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Count", nullable = false)
    private int count;

    public Countemploye() {
    }

    public Countemploye(Integer id) {
        this.id = id;
    }

    public Countemploye(Integer id, String iPAddress, int count) {
        this.id = id;
        this.iPAddress = iPAddress;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countemploye)) {
            return false;
        }
        Countemploye other = (Countemploye) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demp.Countemploye[ id=" + id + " ]";
    }
    
}
