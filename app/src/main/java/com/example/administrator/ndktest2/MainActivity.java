package com.example.administrator.ndktest2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText augend;
    EditText addend;
    Button addtion_btn;
    TextView result;
    NdkJniUtil jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        augend = (EditText) findViewById(R.id.arg1);
        addend = (EditText) findViewById(R.id.arg2);
        addtion_btn = (Button) findViewById(R.id.result_btn);
        result = (TextView) findViewById(R.id.result);

        TextView tv = (TextView) findViewById(R.id.helloJni);

        jni = new NdkJniUtil();
        tv.setText(jni.getCLanguageString());

    }

    public void calc(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        if (TextUtils.isEmpty(augend.getText()) || TextUtils.isEmpty(addend.getText())) {
            Toast.makeText(this, "You must input a number", Toast.LENGTH_LONG).show();
            return;
        }
        int au = Integer.valueOf(augend.getText().toString());
        int ad = Integer.valueOf(addend.getText().toString());
        //result.setText(String.valueOf(au+ad));
        result.setText(String.valueOf(jni.calc(au, ad)));
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
}
