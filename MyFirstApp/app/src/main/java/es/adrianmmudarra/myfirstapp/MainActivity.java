package es.adrianmmudarra.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * ACTIVITY CON LA FOTO DE LUCARIO
 * @author Adrián Muñoz Mudarra
 * @version 0.1;
 */

public class MainActivity extends AppCompatActivity {

    //Variable con el objeto del TextView de la vista
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        textView.setText(R.string.pkmnGO);
    }

    /**
     * METODO DONDE SE INICIALIZA LAS VARIABLES U OBJETOS;
     */
    private void initialize(){
        textView = findViewById(R.id.tv_lucario);
    }
}
