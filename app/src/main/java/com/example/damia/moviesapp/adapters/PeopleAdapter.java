package com.example.damia.moviesapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.data.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by damia on 15.03.2018.
 */

public class PeopleAdapter extends ArrayAdapter<Person> {

    public PeopleAdapter(@NonNull Context context, @NonNull List<Person> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // get the data for this position
        Person person = getItem(position);
        // check if an existing view is being reused, otherwise inflate the view
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.person_item, parent, false);
        }
        // lookup view for data population
        if(person != null) {
            ImageView ivPhoto = convertView.findViewById(R.id.iv_person_img);
            TextView tvName = convertView.findViewById(R.id.tv_person_firstname);
            TextView tvSurname = convertView.findViewById(R.id.tv_person_lastname);
            TextView tvDate = convertView.findViewById(R.id.tv_person_birthday);

            ivPhoto.setImageResource(person.getImgResource());
            tvName.setText(person.getFirstName());
            tvSurname.setText(person.getLastName());
            tvDate.setText(birthday(person));
        }
        return convertView;
    }

    private String birthday(Person person) {
        GregorianCalendar day = person.getDayOfBirth();
        StringBuilder date = new StringBuilder();
        date.append(day.get(Calendar.DAY_OF_MONTH))
                .append("/")
                .append(day.get(Calendar.MONTH))
                .append("/")
                .append(day.get(Calendar.YEAR));
        return date.toString();
    }
}