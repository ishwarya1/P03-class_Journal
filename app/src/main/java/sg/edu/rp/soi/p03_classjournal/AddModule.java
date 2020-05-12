package sg.edu.rp.soi.p03_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddModule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);
        setTitle("Add data for the Week");
        Button btn = (Button) findViewById(R.id.btnsubmit);
        Intent i = getIntent();
        final int wk = i.getIntExtra("wk", 0);
        TextView textView = (TextView)findViewById(R.id.tvwk);
        textView.setText("Week "+ (wk+1));
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                Intent i = getIntent();
                String module = i.getStringExtra("module");
                Intent ia = new Intent();
                i.putExtra("grade", rb.getText());
                i.putExtra("module", module);
                i.putExtra("wk", wk+1);
                setResult(RESULT_OK, i);
                finish();
            }});

    }
}
