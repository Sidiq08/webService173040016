package sab.ifunpas.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if (username.trim().equalsIgnoreCase("")) {
                    editTextUsername.setError("Username tidak boleh kosong");
                    editTextUsername.requestFocus();
                } else if (password.trim().equalsIgnoreCase("")) {
                    editTextPassword.setError("Password tidak boleh kosong");
                    editTextPassword.requestFocus();
                } else {

//disini kita akan melakukan 2 user yg bisa login yaitu
//  (u:173040107, p:admin) untuk mahasiswa dan
//  (u:admin, p:admin) untuk administrator

                    if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name", "Mahasiswa");
                        startActivity(intent);
                        LoginActivity.this.finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Username dan Password tidak sesuai", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
