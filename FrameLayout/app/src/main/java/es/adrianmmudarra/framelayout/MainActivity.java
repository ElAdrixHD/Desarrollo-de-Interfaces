package es.adrianmmudarra.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnVisibility;
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        tvText = findViewById(R.id.tvText);
        btnVisibility = findViewById(R.id.btnVisibility);
        btnVisibility.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVisibility:
                tvText.setVisibility((tvText.getVisibility()==View.VISIBLE)?View.INVISIBLE:View.VISIBLE);
                break;
        }
    }
}
