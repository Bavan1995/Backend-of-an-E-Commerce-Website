package com.sievehq.demo_project.daoImpl;

import com.sievehq.demo_project.dao.WishListDAO;
import com.sievehq.demo_project.models.Product;
import com.sievehq.demo_project.models.WishList;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
@Component
public class WishlistDaoImpl extends SieveGenericDAOImpl<WishList> implements WishListDAO {

    @Override
    public WishList findById(Long id){
        String queryString = "from WishList as w where w.id = id";
        TypedQuery<WishList> query = this.getEntityManager().createQuery(queryString,WishList.class);
        query.setParameter("id",id);
        List<WishList> wishLists = new ArrayList<>();
        wishLists = query.getResultList();
        WishList wishList = wishLists.get(0);
        return wishList;
    }

    @Override
    public List<WishList> findByUsername(String username) {
        String queryString = "from WishList as w where w.userName = username";
        TypedQuery<WishList> query = this.getEntityManager().createQuery(queryString,WishList.class);
        query.setParameter("username",username);
        List<WishList> wishLists = new ArrayList<>();
        wishLists = query.getResultList();
        return wishLists;
    }

    @Override
    public void removeWishlist(String username){
        String queryString = "from WishList as w where w.userName = userName";
        TypedQuery<WishList> query = this.getEntityManager().createQuery(queryString,WishList.class);
        query.setParameter("username",username);
        List<WishList> wishLists = new ArrayList<>();
        wishLists = query.getResultList();
        WishList wishList = new WishList();
        wishList = wishLists.get(0);
        List<Product> products = wishList.getProduct();
        products.clear();;
        wishList.setProduct(products);
        this.getSession().save(wishList);
    }

    @Override
    public void removeProductFromWishlist(Long id, Long productId){
        String queryString = "from wishList as w where w.id = id";
        TypedQuery<WishList> query = this.getEntityManager().createQuery(queryString,WishList.class);
        query.setParameter("id",id);
        List<WishList> wishLists = query.getResultList();
        WishList wishList = wishLists.get(0);
        List<Product> products = wishList.getProduct();
        int counter = 0;
        for(Product product : products){
            if(product.getId()==productId){
                products.remove(counter);
                break;
            }
            else{
                counter++;
            }
        }
        wishList.setProduct(products);
        this.getSession().save(wishList);
    }
}