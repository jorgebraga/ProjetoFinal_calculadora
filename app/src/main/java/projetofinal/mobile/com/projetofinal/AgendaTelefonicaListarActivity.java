package projetofinal.mobile.com.projetofinal;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AgendaTelefonicaListarActivity extends AppCompatActivity {

    private ListView listViewContatos;
    private ArrayAdapter<String> arrayAdapterContatos;
    private RepositorioContatos repositorioContatos;
    private SQLiteDatabase conn;
    private FabricaDatabase fabricaDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_listar_contatos);
        fabricaDatabase = new FabricaDatabase(this);
        conn = fabricaDatabase.getReadableDatabase();
        repositorioContatos = new RepositorioContatos(conn);
        arrayAdapterContatos = repositorioContatos.buscaContatos(this);
        listViewContatos = (ListView) findViewById(R.id.lista_contatos);
        listViewContatos.setAdapter(arrayAdapterContatos);

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


    public ListView getListViewContatos() {
        return listViewContatos;
    }

    public void setListViewContatos(ListView listViewContatos) {
        this.listViewContatos = listViewContatos;
    }
}
