package repository;

import connection.JpaPersistence;
import domain.Contato;

import java.util.UUID;

public class ContatoRepository {

    JpaPersistence jpaPersistence = new JpaPersistence();

    public Contato contatoById(UUID id){
        return jpaPersistence.getEntityManager().find(Contato.class, id);
    }

    public void saveOrUpdateContato(Contato contato){
        jpaPersistence.getEntityManager().getTransaction().begin();
        jpaPersistence.getEntityManager().merge(contato);
        jpaPersistence.getEntityManager().getTransaction().commit();
    }
}
