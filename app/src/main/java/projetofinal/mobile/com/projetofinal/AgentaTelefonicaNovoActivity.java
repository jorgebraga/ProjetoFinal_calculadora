package projetofinal.mobile.com.projetofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgentaTelefonicaNovoActivity extends AppCompatActivity {

    private EditText ETNomeContato;
    private EditText ETNumeroContato;
    private Button buttonGravar;
    private RepositorioContatos repositorioContatos;
    private SQLiteDatabase conn;
    private FabricaDatabase fabricaDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_novo_contato);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Método chamado ao apertar o botão GRAVAR.
     * @param view
     */
    public void gravarOnClick(View view){
        setETNomeContato((EditText) findViewById(R.id.nome_usuario));
        setETNumeroContato((EditText) findViewById(R.id.telefone_usuario));
        fabricaDatabase = new FabricaDatabase(this);
        conn = fabricaDatabase.getWritableDatabase();
        repositorioContatos = new RepositorioContatos(conn);
        repositorioContatos.inserirContato(getETNomeContato().getText().toString(),getETNumeroContato().getText().toString());

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("Contato Inserido com Sucesso!");
        dlg.setNeutralButton("OK",null);
        dlg.show();

        //Intent AgendaTelefonicaActivity = new Intent(AgentaTelefonicaNovoActivity.this, AgendaTelefonicaActivity.class);
       // startActivity(AgendaTelefonicaActivity);

        //Gravar Contato no Banco de Dados
    }



    public EditText getETNomeContato() {
        return ETNomeContato;
    }

    public void setETNomeContato(EditText ETNomeContato) {
        this.ETNomeContato = ETNomeContato;
    }

    public EditText getETNumeroContato() {
        return ETNumeroContato;
    }

    public void setETNumeroContato(EditText ETNumeroContato) {
        this.ETNumeroContato = ETNumeroContato;
    }

    public Button getButtonGravar() {
        return buttonGravar;
    }

    public void setButtonGravar(Button buttonGravar) {
        this.buttonGravar = buttonGravar;
    }
}
