package com.chinh.wherefoodapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



public class RegisterApp extends AppCompatActivity implements View.OnClickListener{

    private EditText reg_email,reg_pass,reg_name,reg_phone;
    private ImageView reg_back;
    private TextView ok_register,reg_login_ima;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_app);


        reg_back=(ImageView) this.findViewById(R.id.reg_back);
        reg_back.setOnClickListener(this);

        ok_register=(TextView) this.findViewById(R.id.ok_register);
        ok_register.setOnClickListener(this);

        reg_login_ima=(TextView) this.findViewById(R.id.reg_login_ima);
        reg_login_ima.setOnClickListener(this);

        reg_name=(EditText) this.findViewById(R.id.reg_name);
        reg_phone=(EditText) this.findViewById(R.id.reg_phone);
        reg_email=(EditText) this.findViewById(R.id.reg_email);
        reg_pass=(EditText) this.findViewById(R.id.reg_pass);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case  R.id.reg_back  :
                startActivity(new Intent(this,Login.class));
                break;
            case R.id.reg_login_ima :
                startActivity(new Intent(this,Login.class));
                break;
            case R.id.ok_register:
                registerUser();
                break;
        }
    }

    private void registerUser() {

        String name = reg_name.getText().toString().trim();
        String phone = reg_phone.getText().toString().trim();
        String email = reg_email.getText().toString().trim();
        String pass  = reg_pass.getText().toString().trim();


        if (name.isEmpty())
        {
            reg_name.setError("Name is reqired!");
            reg_name.requestFocus();
            return;
        }
        if (phone.isEmpty())
        {
            reg_phone.setError("Name is reqired!");
            reg_phone.requestFocus();
            return;
        }
        if (email.isEmpty())
        {
            reg_email.setError("Email is reqired!");
            reg_email.requestFocus();
            return;
        }
        if (pass.isEmpty())
        {
            reg_pass.setError("Pass is reqired!");
            reg_pass.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            reg_email.setError("Email is reqired!");
            reg_email.requestFocus();
            return;
        }
        if (pass.length() < 6)
        {
            reg_pass.setError("Min pass length should be 6 characters!");
            reg_pass.requestFocus();
            return;
        }


//        mAuth.createUserWithEmailAndPassword(email,pass)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful())
//                        {
//                            User user = new User (email);
//                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
//                            String userId = mDatabase.push().getKey();
//
//                            mDatabase.child(userId).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if(task.isSuccessful())
//                                    {
//                                        Toast.makeText(Register.this,"Corrected to register User!",Toast.LENGTH_LONG).show();
//
//                                    }
//                                    else {
//                                        Toast.makeText(Register.this,"Failed to register User!",Toast.LENGTH_LONG).show();
//
//                                    }
//                                }
//                            });
//
//                        }
//                        else
//                        {
//                            Toast.makeText(Register.this,"Fail to register User!",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
    }
}