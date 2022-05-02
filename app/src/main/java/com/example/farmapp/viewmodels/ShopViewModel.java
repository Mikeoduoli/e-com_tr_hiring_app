package com.example.farmapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.farmapp.models.CartItem;
import com.example.farmapp.models.Product;
import com.example.farmapp.repositories.CartRepo;
import com.example.farmapp.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<Product>mutableProduct = new MutableLiveData<>();

    public LiveData<List<Product>> getProducts(){ return shopRepo.getProducts(); }
    //The method expects a return type of LiveData and
    // we return ShopRepo because it is a type of LiveData

    public void setProduct(Product product){

        mutableProduct.setValue(product);
    }

    public LiveData<Product> getProduct(){

        return mutableProduct;
    }

    public LiveData<List<CartItem>> getCart() {

        return cartRepo.getCart();
    }

    public boolean addItemToCart(Product product){

        return cartRepo.addItemToCart(product);
    }

    public void removeItemFromCart(CartItem cartItem){

        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity){
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice(){

        return cartRepo.getTotalPrice();
    }
    public void resetCart(){

        cartRepo.initCart();
    }
}
