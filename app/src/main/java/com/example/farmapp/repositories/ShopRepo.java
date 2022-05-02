package com.example.farmapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farmapp.models.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("orders");
    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts(){

        if (mutableProductList == null){
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }

        return mutableProductList;
    }

    private void loadProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Tractor", 1299, true, "C:\\Users\\Obed\\AndroidStudioProjects\\FarmApp\\app\\src\\main\\res\\drawable\\tractor.png" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Water Pump", 700, true, "C:\\Users\\Obed\\AndroidStudioProjects\\FarmApp\\app\\src\\main\\res\\drawable\\water_pump.png" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Horse Pipe", 450, false, "C:\\Users\\Obed\\AndroidStudioProjects\\FarmApp\\app\\src\\main\\res\\drawable\\horsepipe.png" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Tractor Cart", 1500, true, "C:\\Users\\Obed\\AndroidStudioProjects\\FarmApp\\app\\src\\main\\res\\drawable\\tractor_cart.png" ));

        mutableProductList.postValue(productList);
    }
}
