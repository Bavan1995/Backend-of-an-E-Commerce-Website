package com.sievehq.demo_project.daoImpl;

import com.sievehq.demo_project.dao.CartDao;
import com.sievehq.demo_project.models.Cart;
import com.sievehq.demo_project.models.Product;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CartDaoImpl extends SieveGenericDAOImpl<Cart> implements CartDao {

    @Override
    public List<Cart> findById(Long id) {
        String queryString = "from Cart as c where c.id = :id";
        TypedQuery <Cart> query = this.getEntityManager().createQuery(queryString,Cart.class);
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public Cart findByUsername(String username) {
        String queryString = "from Cart as c where c.userName :username";
        TypedQuery<Cart> query = this.getEntityManager().createQuery(queryString, Cart.class);
        query.setParameter("username",username);
        List<Cart> resultList = query.getResultList();
        if(resultList.isEmpty()){
            return null;
        }else {
            return resultList.get(0);
        }
    }

    @Override
    public  void removeCart(Long id){
        String queryString = "select from Cart as c where c.id = :id";
        TypedQuery<Cart> query = this.getEntityManager().createQuery(queryString,Cart.class);
        query.setParameter("id",id);
        List<Cart> carts = query.getResultList();
        Cart cart = carts.get(0);
        List<Product> products = cart.getProducts();
        products.clear();
        cart.setProducts(products);
        this.getSession().save(cart);
    }

    @Override
    public void removeProductFromCart(Long id, Long productId){
        String queryString = "from Cart as c where c.id = :id";
        TypedQuery<Cart> query = this.getEntityManager().createQuery(queryString,Cart.class);
        query.setParameter("id",id);
        List<Cart> carts = query.getResultList();
        Cart cart = carts.get(0);
        List<Product> products = cart.getProducts();
        int counter = 0;
        for(Product product : products){
            if(product.getId()==productId){
                products.remove(product);
                break;
            }
            counter++;
        }
        System.out.println(products);
        cart.setProducts(products);
        this.getSession().update(cart);
    }
}