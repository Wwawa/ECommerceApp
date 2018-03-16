package com.oum.e_commerceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText edt_Username,edt_Password;
    Button btn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_Username = findViewById(R.id.edt_username);
        edt_Password = findViewById(R.id.edt_password);

        btn_Login = findViewById(R.id.btn_login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!edt_Username.getText().equals(" ") && !edt_Password.getText().toString().equals(" ")){

                    String username = edt_Username.getText().toString();
                    String password = edt_Password.getText().toString();

                    if(username.trim().equals("admin@gmail.com")&& password.trim().equals("admin")){

                        Intent mainIntent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(mainIntent);

                        edt_Username.setText("");
                        edt_Password.setText("");

                    }else{
                        Toast.makeText(getApplicationContext(),"Login Failure",Toast.LENGTH_LONG).show();

                    }


                }else{
                    Toast.makeText(getApplicationContext(),"Please check your credentials",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
