package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.midterm.lasalle.timercalculationproject2.R;

import java.util.List;

public class Custom extends ArrayAdapter<StoreInformation> {


    private Context myContext;
    int myResource;


    public Custom(Context context, int resource, List<StoreInformation> objects) {
        super(context, resource, objects);
        myContext = context;
        myResource = resource;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        String question = getItem(position).getQuestion();
        int answer = getItem(position).getAnswer();
        int elapsedTime = getItem(position).getElapsedTime();
        String status = getItem(position).getStatus();
        StoreInformation si = new StoreInformation(question,answer,elapsedTime,status);

        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);
        TextView tOperation = (TextView) convertView.findViewById(R.id.textViewLOperation);
        TextView tAnswer = (TextView) convertView.findViewById(R.id.textViewLAnswer);
        TextView tElapsedTime = (TextView) convertView.findViewById(R.id.textViewLTime);
        TextView tStatus = (TextView) convertView.findViewById(R.id.textViewLStatus);

        tOperation.setText(question);
        tAnswer.setText(String.valueOf(answer));
        tElapsedTime.setText(String.valueOf(elapsedTime));
        tStatus.setText(status);

        return convertView;
    }
}
