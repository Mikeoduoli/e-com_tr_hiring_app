package com.example.farmapp.models;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private double price;
    private boolean isAvailable;
    private String imageUrl;

    Product(){



    }

    public Product(String id, String name, double price, boolean isAvailable, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 && isAvailable() == product.isAvailable() && getId().equals(product.getId()) && getName().equals(product.getName()) && getImageUrl().equals(product.getImageUrl());
    }

    public static DiffUtil.ItemCallback<Product> itemCallback = new DiffUtil.ItemCallback<Product>() {
      @Override
      public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
          return oldItem.getId().equals(newItem.getId());
      }

      @Override
      public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
          return oldItem.equals(newItem);
      }
  };
    @BindingAdapter("android:productImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(imageUrl)
                .fitCenter()
                .into(imageView);
    }

}

//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.databinding.BindingAdapter;
//import androidx.recyclerview.widget.DiffUtil;
//
//import com.bumptech.glide.Glide;
//
//
//public class Product {
//    private final String id;
//    private final String name;
//    private final double price;
//    private final boolean isAvailable;
//    private final String imageUrl;
//
//    public Product(String id, String name, double price, boolean isAvailable, String imageUrl) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.isAvailable = isAvailable;
//        this.imageUrl = imageUrl;
//    }
//
//    public String getId() {
//        return this.id;
//    }
//
//    public String setId() { return this.id; }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public String setName() {
//        return this.name;
//    }
//
//    public double setPrice() {
//        return this.price;
//    }
//
//    public double getPrice() {
//        return this.price;
//    }
//
//    public boolean setIsAvailable() {
//        return this.isAvailable;
//    }
//
//    public boolean getIsAvailable() {
//        return this.isAvailable;
//    }
//
//    public String getImageUrl() {
//        return this.imageUrl;
//    }
//
//    public String setImageUrl() {
//        return this.imageUrl;
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", isAvailable=" + isAvailable +
//                ", imageUrl='" + imageUrl + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return Double.compare(product.getPrice(), getPrice()) == 0 && getIsAvailable() == product.getIsAvailable() && getId().equals(product.getId()) && getName().equals(product.getName()) && getImageUrl().equals(product.getImageUrl());
//    }
//
//
//
//    public static DiffUtil.ItemCallback<Product> itemCallback = new DiffUtil.ItemCallback<Product>() {
//        @Override
//        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
//            return oldItem.getId().equals(newItem.getId());
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
//            return oldItem.equals(newItem);
//        }
//    };
//    @BindingAdapter("android:productImage")
//    public static void loadImage(ImageView imageView, String imageUrl){
//        Glide.with(imageView)
//                .load(imageUrl)
//                .fitCenter()
//                .into(imageView);
//    }
//
//}

