package com.ayushman999.urbanclapclone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ayushman999.urbanclapclone.databinding.ActivityLoginChoiceBinding;

public class LoginChoice extends AppCompatActivity {
    ActivityLoginChoiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginChoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();
    }

    private void setListener() {
        binding.customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfer=new Intent(getApplicationContext(),LoginActivity.class);
                transfer.putExtra("choice",1);
                startActivity(transfer);
            }
        });
        binding.sellerBtn.setOnClickListener(v->{
            Intent transfer= new Intent(getApplicationContext(),LoginActivity.class);
            transfer.putExtra("choice",0);
            startActivity(transfer);
        });

    }
}