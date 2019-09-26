package es.adrianmmudarra.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Clase que envia un mensaje a otra activity
 */
public class SendMessageActivity extends AppCompatActivity {

    // Clave para el Bundle
    public static String KEY = "claveToWapa";
    private EditText edMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        initialize();
    }

    /**
     * Metodo en el que se inicializa los elementos
     */
    private void initialize() {
        edMessage = findViewById(R.id.edMessage);
    }

    /**
     * Metodo para enviar un mensaje
     * @param v
     */
    public void sendMessage(View v){
        Intent i = new Intent(SendMessageActivity.this, ViewMessageActivity.class);

        Bundle b = new Bundle();
        b.putString(KEY, edMessage.getText().toString());
        i.putExtras(b);

        startActivity(i);
    }
}
