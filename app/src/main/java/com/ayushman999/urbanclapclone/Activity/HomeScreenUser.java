package com.ayushman999.urbanclapclone.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ayushman999.urbanclapclone.Adapter.SellingAdapter;
import com.ayushman999.urbanclapclone.Listener.ClickListener;
import com.ayushman999.urbanclapclone.Model.Seller;
import com.ayushman999.urbanclapclone.R;
import com.ayushman999.urbanclapclone.databinding.ActivityHomeScreenUserBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeScreenUser extends AppCompatActivity implements ClickListener {
    ActivityHomeScreenUserBinding binding;
    SellingAdapter adapter;
    FirebaseFirestore firestore;
    static ArrayList sellerList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenUserBinding.inflate(getLayoutInflater());
        firestore=FirebaseFirestore.getInstance();
        setContentView(binding.getRoot());
        adapter = new SellingAdapter(sellerList, HomeScreenUser.this);
        binding.sellerList.setAdapter(adapter);
        fetchSellers();
    }

    private void fetchSellers() {
        if (sellerList.size()!=0) {
            return;
        } else {
            sellerList = new ArrayList<>();
            firestore.collection("sellers").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (QueryDocumentSnapshot snapshot : queryDocumentSnapshots) {
                        Seller seller = snapshot.toObject(Seller.class);
                        sellerList.add(seller);
                    }
                    binding.sellerList.setAdapter(new SellingAdapter(sellerList,HomeScreenUser.this::onSellerClick));

                }
            });

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out: {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(HomeScreenUser.this, "Sign out!", Toast.LENGTH_SHORT).show();
                Intent transfer = new Intent(HomeScreenUser.this, LoginChoice.class);
                startActivity(transfer);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSellerClick(Seller seller) {
        Toast.makeText(this, seller.getName(), Toast.LENGTH_SHORT).show();
    }
}