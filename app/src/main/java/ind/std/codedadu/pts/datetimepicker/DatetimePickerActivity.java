package ind.std.codedadu.pts.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import ind.std.codedadu.pts.R;

public class DatetimePickerActivity extends AppCompatActivity {

    Calendar setCalendar;
    DatePickerDialog.OnDateSetListener setDate;

    EditText set_date;

    String dayString;
    @BindView(R.id.edt_placetime)
    EditText edtPlacetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datetime_picker);
        ButterKnife.bind(this);

        set_date = (EditText) findViewById(R.id.edt_tapdate);

        setCalendar = Calendar.getInstance();
        setDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                setCalendar.set(Calendar.YEAR, year);
                setCalendar.set(Calendar.MONTH, month);
                setCalendar.set(Calendar.DAY_OF_MONTH, day);

                defaultDate(set_date);
            }
        };

        set_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial_setDate();
            }
        });
    }

    public void backtoList(View view) {
    }

    public void edt_actsetTime(View view) {
        dial_setTime();
    }

    private void dial_setDate() {
        new DatePickerDialog(DatetimePickerActivity.this, setDate,

                setCalendar.get(Calendar.YEAR),
                setCalendar.get(Calendar.MONTH),
                setCalendar.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    private void dial_setTime() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(DatetimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                edtPlacetime.setText(selectedHour + ":" + selectedMinute + " WIB");
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    void defaultDate(EditText editText) {
        String formatDate = "dd MMMM yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate, Locale.US);
        editText.setText(sdf.format(setCalendar.getTime()));
    }
}
