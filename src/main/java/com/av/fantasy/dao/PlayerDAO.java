package com.av.fantasy.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.av.fantasy.model.FantasyUtil;
import com.av.fantasy.model.Player;

public class PlayerDAO {

	
	public Player save(Player player){
		SessionFactory sf = FantasyUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(player);
		session.getTransaction().commit();
		session.clear();
		
		return player;
	}

	public Player remove(Player player) {
		Transaction transaction = null;
        Session session = FantasyUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(player);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction failed");
                return null;
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return player;
		
	}
	
	public Player updatePlayer(Player player) {
        Transaction transaction = null;
        Session session = FantasyUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(player);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.flush();
            session.close();
        }
        return player;
    }
	
	public Player getPlayerByName(String name) {
        Player player = null;
        Session session = FantasyUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String queryString = "from Player where name = :name";
            Query query = session.createQuery(queryString);
            query.setParameter("name", name);
            player = (Player) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return player;
    }
	
}
