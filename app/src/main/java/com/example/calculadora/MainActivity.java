package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_zero, bt_um, bt_dois, bt_tres, bt_quatro, bt_cinco, bt_seis, bt_sete, bt_oito, bt_nove, bt_virgula, bt_limpar, bt_resultado, bt_adicao, bt_subtracao, bt_multiplicacao, bt_divisao;


    private TextView txtviewExpressao, txtviewResultado;

    private ImageView bt_backspace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        bt_zero.setOnClickListener(this);
        bt_um.setOnClickListener(this);
        bt_dois.setOnClickListener(this);
        bt_tres.setOnClickListener(this);
        bt_quatro.setOnClickListener(this);
        bt_cinco.setOnClickListener(this);
        bt_seis.setOnClickListener(this);
        bt_sete.setOnClickListener(this);
        bt_oito.setOnClickListener(this);
        bt_nove.setOnClickListener(this);
        bt_virgula.setOnClickListener(this);
        bt_adicao.setOnClickListener(this);
        bt_subtracao.setOnClickListener(this);
        bt_multiplicacao.setOnClickListener(this);
        bt_divisao.setOnClickListener(this);

        bt_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtviewExpressao.setText("");
                txtviewResultado.setText("");
            }
        });

        bt_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.textviewExpressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtviewResultado.setText("");
            }
        });

        bt_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expressao = new ExpressionBuilder(txtviewExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longresult = (long) resultado;

                    if (resultado == (double)longresult){
                        bt_resultado.setText((CharSequence) String.valueOf(longresult));
                    }else{
                        bt_resultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception e){

                }
            }
        });
    }

    private void IniciarComponentes(){
        bt_zero = findViewById(R.id.bt_zero);
        bt_um = findViewById(R.id.bt_um);
        bt_dois = findViewById(R.id.bt_dois);
        bt_tres = findViewById(R.id.bt_tres);
        bt_quatro = findViewById(R.id.bt_quatro);
        bt_cinco = findViewById(R.id.bt_cinco);
        bt_seis = findViewById(R.id.bt_seis);
        bt_sete = findViewById(R.id.bt_sete);
        bt_oito = findViewById(R.id.bt_oito);
        bt_nove = findViewById(R.id.bt_nove);
        bt_virgula = findViewById(R.id.bt_virgula);
        bt_limpar = findViewById(R.id.bt_limpar);
        bt_resultado = findViewById(R.id.bt_resultado);
        bt_adicao = findViewById(R.id.bt_adicao);
        bt_subtracao = findViewById(R.id.bt_subtracao);
        bt_multiplicacao = findViewById(R.id.bt_multiplicacao);
        bt_divisao = findViewById(R.id.bt_divisao);
        bt_backspace = findViewById(R.id.bt_backspace);
        txtviewExpressao = findViewById(R.id.textviewExpressao);
        txtviewResultado = findViewById(R.id.textviewResultado);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){

        if(txtviewResultado.getText().equals("")){
            txtviewExpressao.setText(" ");
        }

        if (limpar_dados){
            txtviewResultado.setText(" ");
            txtviewExpressao.append(string);
        }else{
            txtviewExpressao.append(txtviewExpressao.getText());
            txtviewExpressao.append(string);
            txtviewResultado.setText(" ");

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_zero:
                AcrescentarUmaExpressao( "0", true);
                break;

            case R.id.bt_um:
                AcrescentarUmaExpressao( "1", true);
                break;

            case R.id.bt_dois:
                AcrescentarUmaExpressao( "2", true);
                break;

            case R.id.bt_tres:
                AcrescentarUmaExpressao( "3", true);
                break;

            case R.id.bt_quatro:
                AcrescentarUmaExpressao( "4", true);
                break;

            case R.id.bt_cinco:
                AcrescentarUmaExpressao( "5", true);
                break;

            case R.id.bt_seis:
                AcrescentarUmaExpressao( "6", true);
                break;

            case R.id.bt_sete:
                AcrescentarUmaExpressao( "7", true);
                break;

            case R.id.bt_oito:
                AcrescentarUmaExpressao( "8", true);
                break;

            case R.id.bt_nove:
                AcrescentarUmaExpressao( "9", true);
                break;

            case R.id.bt_virgula:
                AcrescentarUmaExpressao( ",", false);
                break;

            case R.id.bt_adicao:
                AcrescentarUmaExpressao( "+", false);
                break;

            case R.id.bt_subtracao:
                AcrescentarUmaExpressao( "-", false);
                break;

            case R.id.bt_multiplicacao:
                AcrescentarUmaExpressao( "*", false);
                break;

            case R.id.bt_divisao:
                AcrescentarUmaExpressao( "/", false);
                break;
        }
    }
}