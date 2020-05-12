package sg.edu.rp.soi.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Moduleadapter extends ArrayAdapter<Module> {

    private ArrayList<Module> module;
    private Context context;
    private TextView tvCode, tvName;

    public Moduleadapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);

        module = objects;

        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listitem2, parent, false);
        tvCode =  rowView.findViewById(R.id.tv1);
        tvName = rowView.findViewById(R.id.tv2);
        Module currentModule= module.get(position);
        tvCode.setText(currentModule.getCode());
        tvName.setText(currentModule.getName());
        return rowView;
    }
}