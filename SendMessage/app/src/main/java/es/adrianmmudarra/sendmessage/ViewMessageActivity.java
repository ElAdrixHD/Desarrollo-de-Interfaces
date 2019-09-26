package es.adrianmmudarra.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Clase que recibe un mensaje de otra activity
 */
public class ViewMessageActivity extends AppCompatActivity {

    private TextView tvViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        initialize();
        getMessage();
    }

    /**
     * Metodo donde saca el texto del Bundle con la clave de SendMessage
     */
    private void getMessage() {
        Bundle b = getIntent().getExtras();
        tvViewMessage.setText(b.getString(SendMessageActivity.KEY));
    }

    /**
     * Metodo que inicializa los elementos
     */
    private void initialize() {
        tvViewMessage = findViewById(R.id.tvViewMessage);
    }
}
