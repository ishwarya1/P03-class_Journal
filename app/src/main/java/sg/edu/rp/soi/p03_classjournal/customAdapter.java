package sg.edu.rp.soi.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customAdapter extends ArrayAdapter<Grade> {
    private ArrayList<Grade> DG;
    private Context context;
    private TextView tvWeek, tvGrade;
    public customAdapter(Context context, int resource, ArrayList<Grade> objects){
        super(context, resource, objects);
        DG = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listitem, parent, false);
        tvWeek =  rowView.findViewById(R.id.tvwk1);
        tvGrade =  rowView.findViewById(R.id.tvgrade);
       Grade currentGrade= DG.get(position);
        tvWeek.setText("Week "+ currentGrade.getWeek());
        tvGrade.setText(currentGrade.getGrade());
        return rowView;
    }
}