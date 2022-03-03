package repository;

import connection.JpaPersistence;
import domain.Pessoa;

import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class PessoaRepository {

    private JpaPersistence jpaPersistence = new JpaPersistence();

    public void savePessoa(Pessoa pessoa){
        jpaPersistence.getEntityManager().getTransaction().begin();
        jpaPersistence.getEntityManager().persist(pessoa);
        jpaPersistence.getEntityManager().getTransaction().commit();
    }

    public Pessoa findById(UUID id){
        return jpaPersistence.getEntityManager().find(Pessoa.class, id);
    }

    public List<Pessoa> getAll(){
      Query query = jpaPersistence.getEntityManager().createNamedQuery("pessoas.GetAll");
      return query.getResultList();
    }

    public List<Pessoa> getStateByUF(String state){
      Query query = jpaPersistence.getEntityManager().createNamedQuery("pessoas.OfPB");
      query.setParameter("estado", state);
      return query.getResultList();
    }


}
