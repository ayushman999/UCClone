package com.ayushman999.urbanclapclone.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.widget.Toast;

import com.ayushman999.urbanclapclone.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    static int USER_CHOICE;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        mFirebaseAuth=FirebaseAuth.getInstance();
        setContentView(binding.getRoot());
        Intent transfer=getIntent();
        USER_CHOICE=transfer.getIntExtra("choice",0);
        setListener();
    }

    private void setListener() {
        if(USER_CHOICE==1)
        {
            binding.choiceValue.setText("User Login");
        }
        else
        {
            binding.choiceValue.setText("Seller Login");
        }
        binding.checkboxLoginpass.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(!isChecked)
            {
                binding.loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            else
            {
                binding.loginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
        binding.intentSignup.setOnClickListener(v -> {
            Intent transfer=new Intent(LoginActivity.this,SignUpActivity.class);
            startActivity(transfer);
        });
        binding.loginBtn.setOnClickListener(v -> callLogin());
        binding.resetLink.setOnClickListener(v -> {
            Intent transfer=new Intent(LoginActivity.this,ForgotPassword.class);
            startActivity(transfer);
        });
    }

    private void callLogin() {
        String email=binding.loginEmail.getText().toString().trim();
        String password=binding.loginPassword.getText().toString().trim();
        if(email.isEmpty())
        {
            Toast.makeText(this,"Enter your email!",Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this,"Enter a valid email address!",Toast.LENGTH_SHORT).show();
        }
        else if(password.isEmpty())
        {
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            final ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Logging in...");
            progressDialog.show();
            mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful())
                    {
                        FirebaseUser user=task.getResult().getUser();
                        startMainActivity(user);
                    }
                    else
                    {

                        if(task.getException() instanceof FirebaseAuthInvalidUserException)
                        {
                            createAlert("Error","This email is not registered","OK");
                        }
                        else if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                        {
                            createAlert("Error","Wrong Password!","OK");
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"Unable to login.",Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();
                        }
                    }
                }
            });
        }
    }

    private void createAlert(String heading, String message, String possitive) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(heading)
                .setMessage(message)
                .setPositiveButton(possitive,null)
                .create().show();
    }

    private void startMainActivity(FirebaseUser user) {
        if(user!=null)
        {
            if(USER_CHOICE==1)
            {
                Intent transfer=new Intent(this,HomeScreenUser.class);
                transfer.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(transfer);
            }
            else
            {
                Intent transfer=new Intent(this,HomeScreenSeller.class);
                transfer.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(transfer);
            }
            finish();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mFirebaseAuth.getCurrentUser();
        startMainActivity(user);
    }
}
