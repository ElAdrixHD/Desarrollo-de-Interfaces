package es.adrianmmudarra.recycleruserview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.adrianmmudarra.recycleruserview.adapter.RecyclerUserAdapter;
import es.adrianmmudarra.recycleruserview.model.User;

public class MainActivity extends AppCompatActivity implements RecyclerUserAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private FloatingActionButton btn;
    RecyclerUserAdapter adapter;
    private RecyclerUserAdapter.OnUserClickListener onUserClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        recyclerView = findViewById(R.id.recycleruser);
        btn = findViewById(R.id.fab_recycler);
        adapter = new RecyclerUserAdapter(this);
        onUserClickListener = new RecyclerUserAdapter.OnUserClickListener() {
            @Override
            public void onClick(User user) {
                Toast.makeText(MainActivity.this,user.getEmail(), Toast.LENGTH_LONG).show();
            }
        };
        adapter.setOnUserClickListener(onUserClickListener);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onClick(View v) {
        User u = adapter.getUser(recyclerView.getChildAdapterPosition(v));

        Toast.makeText(this,u.getEmail(), Toast.LENGTH_LONG).show();
    }
}
