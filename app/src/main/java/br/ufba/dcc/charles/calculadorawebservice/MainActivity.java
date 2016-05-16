package br.ufba.dcc.charles.calculadorawebservice;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements GridView.OnClickListener, Runnable {

    private EditText edValor1;
    private EditText edValor2;
    private Button btnCalcular;
    private TextView txtResultado;
    private Handler handler = new Handler();
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edValor1 = (EditText) findViewById(R.id.edValor1);
        edValor2 = (EditText) findViewById(R.id.edValor2);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        dialog = new ProgressDialog(this);
        dialog.setMessage("Processando...");
        dialog.setTitle("xemplo webservice");
        dialog.show();

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        int valor1 =  Integer.parseInt(edValor1.getText().toString());
        int valor2 =  Integer.parseInt(edValor2.getText().toString());

        try {

            CalculadoraWS ws = new CalculadoraWS();
            final String resultado = ws.somar(valor1, valor2);

            handler.post(new Runnable(){

                @Override
                public void run() {
                    txtResultado.setText(resultado);
                }
            });


        }catch (Exception er){
            Log.e("Activity", "Erro", er);
        }
        finally {
            dialog.dismiss();
        }


    }
}
