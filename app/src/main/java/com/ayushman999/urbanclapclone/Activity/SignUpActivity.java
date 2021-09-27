package com.ayushman999.urbanclapclone.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import com.ayushman999.urbanclapclone.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

public class SignUpActivity extends AppCompatActivity {
    String uniqueID,name,email,password,phoneNum;
    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    /*private void registerUser() {
        name=.getText().toString().trim();
        email=mEmail.getText().toString().trim();
        password=mPassword.getText().toString().trim();
        uniqueID=mUniqueId.getText().toString().trim();
        phoneNum=mPhoneNum.getText().toString().trim();
        final String phoneNum=mPhoneNum.getText().toString().trim();
        if(name.equals(""))
        {
            Toast.makeText(this,"Enter your name!",Toast.LENGTH_SHORT).show();
        }
        else if(email.isEmpty())
        {
            Toast.makeText(this,"Please Enter your email",Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this,"Please enter a valid email address",Toast.LENGTH_SHORT).show();
        }
        else if(password.isEmpty())
        {
            Toast.makeText(this,"Enter a password!",Toast.LENGTH_SHORT).show();
        }
        else if(password.length()<6)
        {
            Toast.makeText(this,"Password must be greater than equal to 6 characters",Toast.LENGTH_SHORT).show();
        }
        else if(phoneNum.isEmpty())
        {
            Toast.makeText(this,"Enter your phone number!",Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.PHONE.matcher(phoneNum).matches())
        {
            Toast.makeText(this,"Please enter a valid phone number.",Toast.LENGTH_SHORT).show();
        }
        else
        {

            mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    progressDialog.dismiss();
                    Toast.makeText(User_SignIn.this, "Welcome to Max Fitness", Toast.LENGTH_SHORT).show();
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(User_SignIn.this,"Unable to signup.",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            });
        }
    }*/
}