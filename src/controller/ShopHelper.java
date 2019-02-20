package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Shop;

public class ShopHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserShopLists");
			public void insertShopper(Shop s) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
			}
			public List<Shop> showAllShoppers() {
			EntityManager em = emfactory.createEntityManager();
			List<Shop> allShops = em.createQuery("SELECT s FROM Shop s").getResultList();
			return allShops;
			}
			public Shop searchForShopperByName(String shopName) {
				// TODO Auto-generated method stub
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<Shop> typedQuery = em.createQuery("select s from Shop s where s.shopName = :selectedName", Shop.class);
				typedQuery.setParameter("selectedName", shopName);
				typedQuery.setMaxResults(1);

				Shop found = typedQuery.getSingleResult();
				em.close();
				return found;
			}
}
