package es.adrianmmudarra.inventory.layout.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.layout.dash.DashboardActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        btnLogin = findViewById(R.id.btnLoginLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLoginLogin:
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                break;
        }
    }
}
