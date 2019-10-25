package com.example.caravanas1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonSignInClick(View view) {
        EditText edEmail = findViewById(R.id.edit_email);
        EditText edPassword = findViewById(R.id.edit_password);
        String login = edEmail.getText().toString();
        String passwd = edPassword.getText().toString();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(login, passwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String msg = task.isSuccessful() ? "SIGN IN OK!":
                                "SIGN IN ERROR!";
                        Toast.makeText(MainActivity.this, msg,
                                Toast.LENGTH_SHORT).show();

                        if(msg == "SIGN IN OK!"){
                            openHome();
                        }
                    }
                });
    }

    public void buttonRegisterCLick(View view){
        openRegister();
    }

    public void openHome(){
        Intent intentLogin = new Intent(this, MapsActivity.class);
        startActivity(intentLogin);
    }

    public void openRegister(){
        Intent intentRegister = new Intent(this, SignUpActivity.class);
        startActivity(intentRegister);
    }
}
