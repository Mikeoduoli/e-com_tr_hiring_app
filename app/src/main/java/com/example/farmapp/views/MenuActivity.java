package com.example.farmapp.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.farmapp.R;
import com.example.farmapp.models.CartItem;
import com.example.farmapp.viewmodels.ShopViewModel;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";
    NavController navController;
    ShopViewModel shopViewModel;

    private int cartQuantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController);
        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        shopViewModel.getCart().observe(this, new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                int quantity = 0;
                //Log.d(TAG, "onChanged: " + cartItems.size());
                for (CartItem cartItem : cartItems) {
                    quantity += cartItem.getQuantity();
                }
                cartQuantity = quantity;
                invalidateOptionsMenu();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.cartFragment);
        View actionView = menuItem.getActionView();

        TextView cartBadgeTextView = actionView.findViewById(R.id.cart_badge_text_view);

        cartBadgeTextView.setText(String.valueOf(cartQuantity));
        cartBadgeTextView.setVisibility(cartQuantity == 0 ? View.GONE : View.VISIBLE);


        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         return NavigationUI.onNavDestinationSelected(item, navController) || super
                 .onOptionsItemSelected(item);
    }
}