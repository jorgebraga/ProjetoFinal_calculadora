package projetofinal.mobile.com.projetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class NavegadorActivity extends AppCompatActivity {
    EditText url;
    Button buttonEntrar;
    WebView webview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);
        url = (EditText) findViewById(R.id.url);
        buttonEntrar = (Button) findViewById(R.id.entrar);
        webview = (WebView) findViewById(R.id.navegador);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());



        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://"+url.getText().toString());

            }
        });

    }


}
