package sg.edu.rp.soi.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleActivity extends AppCompatActivity {
    int requestCodeForC347 = 1;
    int requestCodeForC302 = 2;
    ListView lvgrades;
    Button btnadd, btninfo, btnemail;
    ArrayAdapter a;
    ArrayList<Grade> DG = new ArrayList<Grade>();
    ArrayList<Grade> DG2 = new ArrayList<Grade>();
    String module;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module);
        Bundle oi = getIntent().getExtras();
        module = oi.getString("module");
        setTitle("Info for "+ module);
        lvgrades = findViewById(R.id.lvGrade);
        btnadd = findViewById(R.id.btnadd);
        btninfo = findViewById(R.id.btninfo);
        btnemail = findViewById(R.id.btnmail);

        if(module.equals("C347")){
            a = new customAdapter(this, R.layout.listitem, DG);
            lvgrades.setAdapter(a);
        }
        else{
            a = new customAdapter(this, R.layout.listitem, DG2);
            lvgrades.setAdapter(a);
        }




        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(module.equals("C347")){
                    int num = DG.size();
                    Intent i = new Intent(getApplicationContext(), AddModule.class);
                    i.putExtra("module", module);
                    i.putExtra("wk", num);
                    startActivityForResult(i, requestCodeForC347);
                }
                else if(module.equals("C302")){
                    int num = DG2.size();
                    Intent i = new Intent(getApplicationContext(), AddModule.class);
                    i.putExtra("module", module);
                    i.putExtra("wk", num);
                    startActivityForResult(i, requestCodeForC302);
                }
            }
        });
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(module.equals("C347")){
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                    startActivity(rpIntent);
                }
                else if(module.equals("C302")){
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/home"));
                    startActivity(rpIntent);

                }
            }
        });
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(module.equals("C347")){
                    Intent email = new Intent(Intent.ACTION_SEND);

                    email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT,
                            "Test Email from "+module);
                    String msg = "";
                    for(int i = 0; i<DG.size(); i++){
                        Grade grades = DG.get(i);
                        msg += "Week "+grades.getWeek()+": DG: "+grades.getGrade()+"\n";
                    }
                    email.putExtra(Intent.EXTRA_TEXT, "Hi faci, \n\n"+"I am Ishwarya \n"+"Please see my remarks so far, thank you!\n\n"+msg);

                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email,
                            "Choose an Email client :"));
                }
                else if(module.equals("C302")){
                    Intent email = new Intent(Intent.ACTION_SEND);

                    email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT,
                            "Test Email from "+module);
                    String msg = "";
                    for(int i = 0; i<DG2.size(); i++){
                        Grade grades = DG2.get(i);
                        msg += "Week "+grades.getWeek()+": DG: "+grades.getGrade()+"\n";
                    }
                    email.putExtra(Intent.EXTRA_TEXT, "Hi faci, \n\n"+"I am Ishwarya \n"+"Please see my remarks so far, thank you!\n\n"+msg);
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email,
                            "Choose an Email client :"));

                }
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == RESULT_OK){
            if (data != null) {

                int Week = data.getIntExtra("wk", 0);
                String module = data.getStringExtra("module");
                String grade = data.getStringExtra("grade");
                if(requestCode == requestCodeForC347){
                    DG.add(new Grade(grade, module, Week));
                    a.notifyDataSetChanged();
                }
                if(requestCode == requestCodeForC302){
                    DG2.add(new Grade(grade, module, Week));
                    a.notifyDataSetChanged();
                }


            }
        }
    }
}


