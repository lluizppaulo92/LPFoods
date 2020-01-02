package lpfoods.lluizppaulo.com.br.lpfoods;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormularioCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cadastro);

        TextInputLayout textInputNomeCompleto = findViewById(R.id.formulario_cadastro_campo_nome_completo);
        EditText campoNomeCompleto = textInputNomeCompleto.getEditText();
//        validaCampoVazio(campoNomeCompleto);
        adicionaValidacaoPadao(textInputNomeCompleto);

        final TextInputLayout textInputCpf = findViewById(R.id.formulario_cadastro_campo_cpf);
        final EditText campoCpf = textInputCpf.getEditText();
        campoCpf.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus){
                    if (!hasFocus) {
                        if (campoCpf.getText().toString().isEmpty()) {
                            textInputCpf.setError("Campo obrigatório!");
                            return;
                        }else{
                            textInputCpf.setError(null);
                            textInputCpf.setErrorEnabled(false);
                        }

                        if(campoCpf.getText().toString().length() < 11){
                            textInputCpf.setError("O CPF precisa ter 11 digitos!");
                        }else{
                            textInputCpf.setError(null);
                            textInputCpf.setErrorEnabled(false);
                        }
                    }
                }
            }
        });

        TextInputLayout textInputTelefone = findViewById(R.id.formulario_cadastro_campo_telefone);
        EditText campoTelefone = textInputTelefone.getEditText();
        validaCampoVazio(campoTelefone);

        TextInputLayout textInputEmail = findViewById(R.id.formulario_cadastro_campo_email);
        EditText campoEmail = textInputEmail.getEditText();
        validaCampoVazio(campoEmail);

        TextInputLayout textInputSenha = findViewById(R.id.formulario_cadastro_campo_senha);
        EditText campoSenha = textInputSenha.getEditText();
        validaCampoVazio(campoSenha);


    }


    private void adicionaValidacaoPadao(final TextInputLayout textInputLayout){
        final EditText campo = textInputLayout.getEditText();
        campo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    if (campo.getText().toString().isEmpty()) {
                        textInputLayout.setError("Campo obrigatório!");
                    }else{
                        textInputLayout.setError(null);
                        textInputLayout.setErrorEnabled(false);
                    }
                }
            }
        });
    }

    public void validaCampoVazio(final EditText campo) {
        campo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    if (campo.getText().toString().isEmpty()) {
                        campo.setError("Campo obrigatório!");
                    }
                }
            }
        });
    }

    public boolean isEmailvalido(String email){
       if (email.matches(".+@.+\\..+")){
           return true;
       }else{
           return  false;
       }
    }
}
