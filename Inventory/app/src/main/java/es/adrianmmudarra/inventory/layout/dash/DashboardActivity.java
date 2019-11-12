package es.adrianmmudarra.inventory.layout.dash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.layout.dependency.DependencyListActivity;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnDependency, btnSectors, btnInventory, btnProducts, btnProfile, btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initialize();
    }

    private void initialize() {
        btnDependency = findViewById(R.id.btnDashDependency);
        btnDependency.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDashDependency:
                startActivity(new Intent(DashboardActivity.this, DependencyListActivity.class));
                break;
                default:
                    break;
        }
    }
}
