package kr.co.woobi.imyeon.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitActivity extends AppCompatActivity {
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        bundle=getIntent().getExtras();
        TextView textViewResultShow=(TextView)findViewById(R.id.textViewResultShow);
        textViewResultShow.setText(bundle.getString("key", "NO DATA"));

        TextView textViewResultShow2=(TextView)findViewById(R.id.textViewResultShow2);
        textViewResultShow2.setText(bundle.getString("key2", "NO DATA"));
        EditText editTextValue=(EditText)findViewById(R.id.editTextValue);
    }


    @Override
    public void finish() {
        EditText editTextValue=(EditText)findViewById(R.id.editTextValue);
        Intent intent=new Intent();
        String text=editTextValue.getText().toString();
        Bundle bundle=new Bundle();
        bundle.putString("resultValue",text);
        intent.putExtras(bundle);
        setResult(1000, intent);
        super.finish();
    }
}
