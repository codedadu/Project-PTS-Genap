package ind.std.codedadu.pts.floatingactionbutton;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ind.std.codedadu.pts.R;

public class FloatingButtonActivity extends AppCompatActivity {


    Calendar newCalendar;
    DatePickerDialog.OnDateSetListener setDate;

    String getDatefromAccess;
    @BindView(R.id.fab_calendargetDate)
    FloatingActionButton fabCalendargetDate;
    @BindView(R.id.fab_calendargetTime)
    FloatingActionButton fabCalendargetTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_button);
        ButterKnife.bind(this);

        newCalendar = Calendar.getInstance();
        setDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                newCalendar.set(Calendar.YEAR, year);
                newCalendar.set(Calendar.MONTH, monthOfYear);
                newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                getDate();
            }
        };

    }

    private void getDate() {
        //String formatDateSQL = "yyyy/MM/dd";
        String formatTanggalUmum = "dd, MMMM yyyy";
        SimpleDateFormat sdfOfDate = new SimpleDateFormat(formatTanggalUmum, Locale.US);
        String getDatefromAccess = sdfOfDate.format(newCalendar.getTime());
        Toast.makeText(this, "Date get is set " + getDatefromAccess, Toast.LENGTH_SHORT).show();
    }

    public void method_getDate() {
        new DatePickerDialog(FloatingButtonActivity.this, setDate,
                newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void method_getTime() {
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog;
        timePickerDialog = new TimePickerDialog(FloatingButtonActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int setHour, int setMinute) {
                String getTimeset = setHour + ":" + setMinute;
                Toast.makeText(FloatingButtonActivity.this, "Time set is " + getTimeset, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, true); // Set Time is 24 Hour
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    @OnClick({R.id.fab_calendargetDate, R.id.fab_calendargetTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab_calendargetDate:
                method_getDate();
                break;
            case R.id.fab_calendargetTime:
                method_getTime();
                break;
        }
    }
}
