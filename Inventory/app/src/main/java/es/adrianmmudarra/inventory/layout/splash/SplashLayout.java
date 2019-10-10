package es.adrianmmudarra.inventory.layout.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.layout.login.LoginActivity;

public class SplashLayout extends AppCompatActivity {

    private TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
        initialize();
        goToLogin();
    }

    private void goToLogin() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(SplashLayout.this, LoginActivity.class);
                SplashLayout.this.startActivity(mainIntent);
                SplashLayout.this.finish();
            }
        }, 2000);


    }

    private void initialize() {
        tvSplash = findViewById(R.id.tvSpashInventory);
        tvSplash.setTypeface(Typeface.createFromAsset(getAssets(),"font/Karla-Regular.ttf"));
    }
}
