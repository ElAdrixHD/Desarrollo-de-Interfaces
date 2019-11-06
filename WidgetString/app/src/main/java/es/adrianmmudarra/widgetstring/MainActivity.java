package es.adrianmmudarra.widgetstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rb_Empresa, rb_Particular;
    View empresa, particular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        rb_Empresa = findViewById(R.id.rb_Empresa);
        rb_Particular = findViewById(R.id.rbParticular);
        empresa = findViewById(R.id.include_emp);
        particular = findViewById(R.id.include_part);
        rb_Empresa.setOnClickListener(this);
        rb_Particular.setOnClickListener(this);
        empresa.setVisibility(View.GONE);
        particular.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (rb_Empresa.isChecked()){
            empresa.setVisibility(View.VISIBLE);
            particular.setVisibility(View.GONE);
        }else{
            empresa.setVisibility(View.GONE);
            particular.setVisibility(View.VISIBLE);
        }
    }
}
