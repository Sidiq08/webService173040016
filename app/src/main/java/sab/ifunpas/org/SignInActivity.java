package sab.ifunpas.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    EditText us, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        us = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = us.getText().toString().trim();
                String pswd = pass.getText().toString().trim();

                if(user.equalsIgnoreCase("Admin") && pswd.equalsIgnoreCase("Admin")) {
                    Session.createSignInSession(SignInActivity.this, user);
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignInActivity.this, "user invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
