package projetofinal.mobile.com.projetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {
    private static final String[] opcoes = { "Escolha uma opção", "Somar(+)", "Subtrair(-)", "Dividir(/)", "Multiplicar(*)","Porcentagem(%)" };
    private ArrayAdapter<String> aOpcoes;
    private Spinner spinner;
    private EditText ETnumero1;
    private EditText ETnumero2;
    private TextView TVresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        // modelo do meu spinner
        aOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcoes);
        spinner = (Spinner) findViewById(R.id.operacoes);
        spinner.setAdapter(aOpcoes);
    }


    public void calcular(View view){
        String resultado;
        // aqui eu recupero as posições selecionadas
        switch (spinner.getSelectedItemPosition()) {
            case 1:
                TVresultado = (TextView) findViewById(R.id.resultado);
                resultado = "Resultado: " + somar();
                TVresultado.setText(resultado);
                break;

            case 2:
                TVresultado = (TextView) findViewById(R.id.resultado);
                resultado = "Resultado: " + subtrair();
                TVresultado.setText(resultado);
                break;

            case 3:
                TVresultado = (TextView) findViewById(R.id.resultado);
                resultado = "Resultado: " + dividir();
                TVresultado.setText(resultado);
                break;

            case 4:
                TVresultado = (TextView) findViewById(R.id.resultado);
                resultado = "Resultado: " + multiplicar();
                TVresultado.setText(resultado);
                break;

            case 5:
                TVresultado = (TextView) findViewById(R.id.resultado);
                resultado = "Resultado: " + porcentagem();
                TVresultado.setText(resultado);
                break;

        }
    }

    private double porcentagem() {
        preencherEditTextNumbers();

        double numero1 =  Double.parseDouble(ETnumero1.getText().toString());
        double numero2 =  Double.parseDouble(ETnumero2.getText().toString());
        return numero1 * (numero2/100);
    }


    private double multiplicar() {
        preencherEditTextNumbers();

        double numero1 =  Double.parseDouble(ETnumero1.getText().toString());
        double numero2 =  Double.parseDouble(ETnumero2.getText().toString());
        return numero1 * numero2;
    }

    private double dividir() {
        preencherEditTextNumbers();

        double numero1 =  Double.parseDouble(ETnumero1.getText().toString());
        double numero2 =  Double.parseDouble(ETnumero2.getText().toString());
        return numero1 / numero2;
    }

    private double subtrair() {
        preencherEditTextNumbers();

        double numero1 =  Double.parseDouble(ETnumero1.getText().toString());
        double numero2 =  Double.parseDouble(ETnumero2.getText().toString());
        return numero1 - numero2;
    }

    public double somar(){
        preencherEditTextNumbers();

        double numero1 =  Double.parseDouble(ETnumero1.getText().toString());
        double numero2 =  Double.parseDouble(ETnumero2.getText().toString());
        return numero1 + numero2;

    }


    public void preencherEditTextNumbers(){
        ETnumero1 = (EditText) findViewById(R.id.campoNum1);
        ETnumero2 = (EditText) findViewById(R.id.campoNum2);
    }
}
