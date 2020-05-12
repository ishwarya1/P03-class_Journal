package sg.edu.rp.soi.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvModules;
    ArrayAdapter aa;
    ArrayList<Module> module;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvModules = findViewById(R.id.lvmod);
        module = new ArrayList<Module>();
        module.add(new Module("C302", "Web Services"));
        module.add(new Module("C347", "Android Programming II"));
        aa = new Moduleadapter(this, R.layout.listitem2, module);
        lvModules.setAdapter(aa);
        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module m = module.get(position);
                Intent i = new Intent(getApplicationContext(), ModuleActivity.class);
                i.putExtra("module", m.getCode());
                startActivity(i);
            }
        });
    }

}

