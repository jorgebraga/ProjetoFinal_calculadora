package projetofinal.mobile.com.projetofinal;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.database.sqlite.*;
import android.database.*;

public class AgendaTelefonicaActivity extends AppCompatActivity {
    private FabricaDatabase fabricaDatabase;
    private SQLiteDatabase conection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_telefonica);
        setFabricaDatabase(new FabricaDatabase(this));
        try{
            setConection(getFabricaDatabase().getWritableDatabase());
            RepositorioContatos repo = new RepositorioContatos(conection);
        }catch(SQLException sql){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Problemas ao criar a conexão com o banco de dados!" + sql.getMessage());
            dlg.setNeutralButton("OK",null);
            dlg.show();


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Método responsavel por abrir a tela de novo contato
     * @param view
     */
    public void openNovoContatoOnClick(View view){
        Intent ActivityNovoContato = new Intent(AgendaTelefonicaActivity.this, AgentaTelefonicaNovoActivity.class);
        startActivity(ActivityNovoContato);
    }

    /**
     * Método responsavel por abrir a tela de listar contato
     * @param view
     */
    public void openListarContatosOnClick(View view){
        Intent ActivityListarContatos = new Intent(AgendaTelefonicaActivity.this, AgendaTelefonicaListarActivity.class);
        startActivity(ActivityListarContatos);
    }


    public FabricaDatabase getFabricaDatabase() {
        return fabricaDatabase;
    }

    public void setFabricaDatabase(FabricaDatabase fabricaDatabase) {
        this.fabricaDatabase = fabricaDatabase;
    }

    public SQLiteDatabase getConection() {
        return conection;
    }

    public void setConection(SQLiteDatabase conection) {
        this.conection = conection;
    }
}
