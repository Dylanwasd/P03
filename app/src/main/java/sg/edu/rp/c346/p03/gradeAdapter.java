package sg.edu.rp.c346.p03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class gradeAdapter extends ArrayAdapter<Grade> {
    private ArrayList<Grade> grade;
    private Context context;
    private TextView tvgrade;
    private TextView week;

    public gradeAdapter(Context context, int resource, ArrayList<Grade> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        grade = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvgrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        // Get the ImageView object
        week = (TextView) rowView.findViewById(R.id.textViewWeek);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Grade currentGrade = grade.get(position);
        // Set the TextView to show the food

        tvgrade.setText(currentGrade.getGrade());
        // Set the image to star or nostar accordingly

        week.setText("Week " + String.valueOf(currentGrade.getWeek()));
        // Return the nicely done up View to the ListView
        return rowView;
    }
}

