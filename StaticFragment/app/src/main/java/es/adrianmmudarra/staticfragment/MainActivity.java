package es.adrianmmudarra.staticfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.OnSetTextSizeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSetTextSize(String text, int size) {
        Toast.makeText(this,"Boton pulsado: "+text,Toast.LENGTH_LONG).show();
    }
}
