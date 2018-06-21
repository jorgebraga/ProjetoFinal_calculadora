package projetofinal.mobile.com.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void openCalculadoraOnClick(View view){
        Intent ActivityCalculadora = new Intent(MainActivity.this, CalculadoraActivity.class);
        startActivity(ActivityCalculadora);
    }

    public void openNavegadorOnClick(View view){
        Intent ActivityNavegador = new Intent(MainActivity.this, NavegadorActivity.class);
        startActivity(ActivityNavegador);
    }


    public void openMapaOnClick(View view){
        Intent OndeEstouActivity = new Intent(MainActivity.this, OndeEstouActivity.class);
        startActivity(OndeEstouActivity);
    }

    public void openAgendaTelefonicaOnClick(View view){
        Intent AgendaTelefonicaActivity = new Intent(MainActivity.this, AgendaTelefonicaActivity.class);
        startActivity(AgendaTelefonicaActivity);
    }

}
