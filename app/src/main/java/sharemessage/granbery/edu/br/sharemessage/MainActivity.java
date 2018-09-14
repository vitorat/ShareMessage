package sharemessage.granbery.edu.br.sharemessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StatusActivity";
    private static final int TEXT_SIZE_LIMIT = 140;
    private EditText mensagem;
    private Button enviarMsg;
    private TextView caracteres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensagem = findViewById(R.id.mensagem);
        enviarMsg = findViewById(R.id.enviarMsg);
        caracteres = findViewById(R.id.caracteres);

        enviarMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = mensagem.getText().toString();
                Log.d(TAG, "onClicked with status: " + status);
            }
        });

        mensagem.addTextChangedListener(
                new TextLimitTextWatcher(mensagem, caracteres, TEXT_SIZE_LIMIT)
        );

    }
}
