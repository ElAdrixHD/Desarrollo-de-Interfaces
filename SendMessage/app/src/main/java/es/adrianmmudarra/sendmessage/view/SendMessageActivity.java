package es.adrianmmudarra.sendmessage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import es.adrianmmudarra.sendmessage.model.Message;
import android.view.View;
import android.widget.EditText;

import es.adrianmmudarra.sendmessage.R;

/**
 * <h1>Clase SendMessage</h1>
 * <p>Esta clase tiene como función enviar datos a otra activity para que esta lo muestre por pantalla.</p>
 *
 * @author Adrian Muñoz
 * @version 1.0
 * @see ViewMessageActivity
 */
public class SendMessageActivity extends AppCompatActivity {

    // Clave para el Bundle
    public static String KEY_MESSAGE = "claveToWapaPaMensaje";
    public static String KEY_AUTHOR = "claveToWapaPaAutor";
    public static String MASTER_KEY = "LaFuckingClave";
    private EditText edAuthor;
    private EditText edMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        initialize();
    }

    /**
     * <h1>Metodo initialize</h1>
     * <p>Este metodo tiene como función inicializar en la clase los objetos de la vista.</p>
     */
    private void initialize() {
        edMessage = findViewById(R.id.edMessage);
        edAuthor = findViewById(R.id.edAuhor);
    }

    /**
     * <h1>Metodo sendMessage</h1>
     * <p>Este metodo se ejecuta cuando se pulsa sobre el botón de enviar. Su funcion es guardar el mensaje en un Bundle y enviarlo a la otra activity.</p>
     * @see Bundle
     */
    public void sendMessage(View v){
        Intent i = new Intent(SendMessageActivity.this, ViewMessageActivity.class);

        Bundle b = new Bundle();
        Message message = new Message(edAuthor.getText().toString(),edMessage.getText().toString());
        /*b.putString(KEY_MESSAGE, edMessage.getText().toString());
        b.putString(KEY_AUTHOR,edAuthor.getText().toString());*/
        i.putExtra(MASTER_KEY,message);

        startActivity(i);
    }
}
