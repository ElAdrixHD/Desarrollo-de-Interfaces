package es.adrianmmudarra.sendmessage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import es.adrianmmudarra.sendmessage.model.Message;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private static String TAG = "SendMessage";
    private EditText edAuthor;
    private EditText edMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        initialize();
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * <h1>Metodo initialize</h1>
     * <p>Este metodo tiene como función inicializar en la clase los objetos de la vista.</p>
     */
    private void initialize() {
        edMessage = findViewById(R.id.edMessage);
        edAuthor = findViewById(R.id.edAuhor);
        btnSend = findViewById(R.id.btEnviar);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emptyMessageOrAuthor()){
                    sendMessage(v);
                }else{
                    showError("No has introducido los datos");
                }

            }
        });
        btnSend.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showError("HAS HECHO UNA PULSACIÓN LARGA");
                return false;
            }
        });
        Log.d(TAG, "initialize");
    }

    /**
     * <h1>Metodo emptyMessageOrAuthor</h1>
     * <p>Comprueba si los campos de mensaje o autor estan vacios. En caso afirmativo, devuelve false.</p>
     */
    private boolean emptyMessageOrAuthor() {
        Log.d(TAG, "emptyMessageOrAuthor");
        if (edAuthor.getText().toString().isEmpty() | edMessage.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * <h1>Metodo showError</h1>
     * <p>Muestra un Toast con el mensaje que pases por parametro.</p>
     */
    private void showError(String error){
        Toast.makeText(SendMessageActivity.this,error,Toast.LENGTH_LONG).show();
        Log.d(TAG, "showError");
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

        Log.d(TAG, "sendMessage");

        startActivity(i);
    }


}
