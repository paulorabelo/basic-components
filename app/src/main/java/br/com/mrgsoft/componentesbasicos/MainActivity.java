package br.com.mrgsoft.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.TextureView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    //Checkbox
    private CheckBox checkVerde, checkBranco, checkVermelho;

    //RadioButton
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;

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

        //RadioButton
        sexoFeminino    = findViewById(R.id.rbFeminino);
        sexoMasculino   = findViewById(R.id.rbMasculino);
        opcaoSexo       = findViewById(R.id.radioGroupSexo);
        radiobutton();

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

    public void radiobutton(){

        /* --> Método sem listener
        if ( sexoMasculino.isChecked() ) {
            textoResultado.setText("Masculino");
        } else if ( sexoFeminino.isChecked() ) {
            textoResultado.setText("Feminino");
        }
         */

        //Método usando listener
        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if ( checkedId == R.id.rbFeminino){
                    textoResultado.setText("Feminino");
                }else if ( checkedId == R.id.rbMasculino){
                    textoResultado.setText("Masculino");
                }
            }
        });

    }

    public void enviar(View view){

//        radiobutton();//Usando método sem o listener

//        checkbox();

//        nomeEmail();

    }

    public void limpar(View view){

        campoNome.setText("");
        campoEmail.setText("");

    }
}