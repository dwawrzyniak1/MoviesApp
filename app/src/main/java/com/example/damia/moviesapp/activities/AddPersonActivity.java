package com.example.damia.moviesapp.activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.data.AppDatabase;
import com.example.damia.moviesapp.data.Person;
import com.example.damia.moviesapp.data.PersonDao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddPersonActivity extends AppCompatActivity {

    private static GregorianCalendar calendar;
    private EditText etFirstName;
    private EditText etLastName;
    private static EditText etDateOfBirth;
    private DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        initializeFields();
    }

    private void initializeFields() {
        calendar = new GregorianCalendar();
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etDateOfBirth = findViewById(R.id.et_day_of_birth);
        dialogFragment = new DatePickerFragment();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, AddPersonActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    public void showDatePickerDialog(View view){
        dialogFragment.show(getFragmentManager(), "datePicker");
    }

    public void saveData(View view){
        Person person = getPersonFromEditTexts();
        Person.addPerson(AppDatabase.getAppDatabase(getApplicationContext()), person);
        cleanInputs();
        Person[] people = AppDatabase.getAppDatabase(getApplicationContext()).personDao().loadAllPeople();
        Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
    }

    private void cleanInputs() {
        etFirstName.setText("");
        etLastName.setText("");
        etDateOfBirth.setText("");
    }

    private Person getPersonFromEditTexts() {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        return new Person(firstName, lastName, calendar);
    }

    private static void updateDateEditText(EditText editText) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        editText.setText(sdf.format(calendar.getTime()));
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK, this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            calendar.set(year, month, day);
            updateDateEditText(etDateOfBirth);
        }
    }
}
