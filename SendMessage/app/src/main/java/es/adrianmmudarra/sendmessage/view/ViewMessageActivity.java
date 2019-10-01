package es.adrianmmudarra.sendmessage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

import es.adrianmmudarra.sendmessage.R;
import es.adrianmmudarra.sendmessage.model.Message;

/**
 * <h1>Clase ViewMessage</h1>
 * <p>Esta clase tiene como función recibir datos de otra activity para mostrarlo en pantalla.</p>
 *
 * @author Adrian Muñoz
 * @version 1.0
 * @see SendMessageActivity
 */
public class ViewMessageActivity extends AppCompatActivity {

    private TextView tvViewMessage;
    private TextView tvViewAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        initialize();
        viewMessage();
    }

    /**
     * <h1>Metodo viewMessage</h1>
     * <p>Esta activity recibe el mensaje por la actvity y lo muestra por pantalla.</p>
     * @see Bundle
     */
    private void viewMessage() {
        Message message = (Message)getIntent().getSerializableExtra(SendMessageActivity.MASTER_KEY);
        /*
        tvViewMessage.setText(b.getString(SendMessageActivity.KEY_MESSAGE));
        tvViewAuthor.setText(b.getString(SendMessageActivity.KEY_AUTHOR));
         */
        tvViewMessage.setText(message.getMessage());
        tvViewAuthor.setText(message.getAuthor());
    }

    /**
     * <h1>Metodo initialize</h1>
     * <p>Este metodo tiene como función inicializar en la clase los objetos de la vista.</p>
     */
    private void initialize() {
        tvViewMessage = findViewById(R.id.tvViewMessage);
        tvViewAuthor = findViewById(R.id.tvViewAuthor);
    }
}
