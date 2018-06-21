package projetofinal.mobile.com.projetofinal;


public class ScriptSQL {

    public static String getDDLTableContato(){
        StringBuilder scriptSQL = new StringBuilder();
        scriptSQL.append("CREATE TABLE CONTATO ( ");
        scriptSQL.append(" ID       INTEGER       NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        scriptSQL.append(" TELEFONE VARCHAR (14), ");
        scriptSQL.append(" NOME     VARCHAR (100)); ");
        return scriptSQL.toString();



    }
}
