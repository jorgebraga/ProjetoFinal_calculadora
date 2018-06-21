package projetofinal.mobile.com.projetofinal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

public class RepositorioContatos {
    private SQLiteDatabase conn;

    public RepositorioContatos(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void inserirContato(String nome, String telefone){
        ContentValues values = new ContentValues();
        values.put("TELEFONE",telefone);
        values.put("NOME",nome);
        conn.insertOrThrow("CONTATO",null,values);



    }

    public void deletarDadosTabela(){
        conn.delete("CONTATO",null,null);

    }

    public ArrayAdapter<String> buscaContatos(Context context){
        ArrayAdapter<String> contatos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("CONTATO",null,null,null,null,null,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                String telefone = cursor.getString(1);
                String nome = cursor.getString(2);
                contatos.add(nome);
                contatos.add(telefone);
            }while(cursor.moveToNext());
        }

        return contatos;
    }
}
