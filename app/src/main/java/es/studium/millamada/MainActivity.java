package es.studium.millamada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnLlamar;
    EditText textTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar=findViewById(R.id.btnLlamada);
        textTelefono=findViewById(R.id.textTelefono);
        //Le añadimos el Listener correspondiente
        btnLlamar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==(R.id.btnLlamada)){
            marcarTelefono(v, textTelefono);
        }
    }

    private void marcarTelefono(View v,EditText textTelefono) {
        Intent intent =new Intent(Intent.ACTION_DIAL);
        Intent intent2 =new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+Integer.parseInt(textTelefono.getText().toString())));
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent2);
        }
    }
}