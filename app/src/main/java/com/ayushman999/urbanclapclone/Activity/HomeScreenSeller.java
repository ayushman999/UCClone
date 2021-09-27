package com.ayushman999.urbanclapclone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.ayushman999.urbanclapclone.R;
import com.ayushman999.urbanclapclone.databinding.ActivityHomeScreenSellerBinding;
import com.google.firebase.auth.FirebaseAuth;

public class HomeScreenSeller extends AppCompatActivity {
    ActivityHomeScreenSellerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeScreenSellerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.sign_out:
            {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(HomeScreenSeller.this,"Sign out!",Toast.LENGTH_SHORT).show();
                Intent transfer=new Intent(HomeScreenSeller.this,LoginChoice.class);
                startActivity(transfer);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}