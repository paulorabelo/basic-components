package br.com.mrgsoft.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    private CheckBox checkVerde, checkBranco, checkVermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Campo nome e e-mail
        campoNome       = findViewById(R.id.editNome);
        campoEmail      = findViewById(R.id.editEmail);
        textoResultado  = findViewById(R.id.textResultado);

        //Checkbox
        checkVerde      = findViewById(R.id.checkVerde);
        checkBranco     = findViewById(R.id.checkBranco);
        checkVermelho   = findViewById(R.id.checkVermelho);

    }
    public void nomeEmail(){

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        textoResultado.setText( "nome: " + nome +" email: " + email);
    }

    public void checkbox(){

        String texto = "";
        if ( checkVerde.isChecked() ){
            String corSelecionada = checkVerde.getText().toString();//Recuperando a cor do botão
            texto = corSelecionada + " Selecionado - ";
        }
        if ( checkBranco.isChecked() ){
            texto = texto + "Branco Selecionado - ";
        }
        if ( checkVermelho.isChecked() ){
            texto = texto + "Vermelho Selecionado";
        }

        textoResultado.setText( texto );

    }

    public void enviar(View view){

        checkbox();

//        nomeEmail();

    }

    public void limpar(View view){

        campoNome.setText("");
        campoEmail.setText("");

    }
}