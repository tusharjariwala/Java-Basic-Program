/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package sessionBean;

import demp.Countemploye;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tushar Jariwala
 */
@Stateless
public class CountEmp implements CountEmpLocal {
 @PersistenceContext(unitName="Ass1_2-ejbPU")
     private EntityManager em;
    @Override
    public String insert(Countemploye employe) {
         try {
            em.persist(employe);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Countemploye> showall() {
   try {
             List<Countemploye> employelist=em.createNamedQuery("Countemploye.findAll").getResultList();
       return employelist;
        } catch (Exception e) {
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
