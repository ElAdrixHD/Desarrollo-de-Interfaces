package es.adrianmmudarra.inventory.layout.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import es.adrianmmudarra.inventory.R;

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.dnav_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setUpNavegationView(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.btnMenuAboutMe:
                        Toast.makeText(BaseActivity.this, "About Me", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btnMenuHelp:
                        Toast.makeText(BaseActivity.this, "Ayuda", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btnMenuSettings:
                        Toast.makeText(BaseActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
            }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }
    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
               break;
        }
        return super.onOptionsItemSelected(item);
    }
}
