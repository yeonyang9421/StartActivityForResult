package kr.co.woobi.imyeon.startactivityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String textCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSend=(Button)findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextValue=(EditText)findViewById(R.id.editTextValue);
        CheckBox checkBoxRice, checkBoxBread;
        checkBoxRice=(CheckBox)findViewById(R.id.checkBoxRice);
        checkBoxBread=(CheckBox)findViewById(R.id.checkBoxBread);
        if(checkBoxRice.isChecked()){
            textCheck=checkBoxRice.getText().toString();
        }
        if(checkBoxBread.isChecked()){
            textCheck=textCheck+checkBoxBread.getText().toString();
        }
        String text=editTextValue.getText().toString()+"\n";
        String text2=textCheck;
        Bundle bundle=new Bundle();
        bundle.putString("key",text);
        bundle.putString("key2",text2);
        Intent intent=new Intent(this, ExplicitActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data.hasExtra("resultValue")) {
            Toast.makeText(getApplicationContext(), data.getStringExtra("resultValue"), Toast.LENGTH_SHORT).show();
            TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
            textViewResult.setText(data.getStringExtra("resultValue"));
        }
    }

}
