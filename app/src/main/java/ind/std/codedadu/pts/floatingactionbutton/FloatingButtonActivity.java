package ind.std.codedadu.pts.floatingactionbutton;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ind.std.codedadu.pts.MainActivity;
import ind.std.codedadu.pts.R;

public class FloatingButtonActivity extends AppCompatActivity {

    @BindView(R.id.fab_calendar)
    FloatingActionButton fabCalendar;

    Calendar newCalendar;
    DatePickerDialog.OnDateSetListener setDate;

    String getDatefromAccess;

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

    @OnClick(R.id.fab_calendar)
    public void onViewClicked() {
        new DatePickerDialog(FloatingButtonActivity.this, setDate,
                newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void getDate() {
        //String formatDateSQL = "yyyy/MM/dd";
        String formatTanggalUmum = "dd, MMMM yyyy";
        SimpleDateFormat sdfOfDate = new SimpleDateFormat(formatTanggalUmum, Locale.US);
        String getDatefromAccess = sdfOfDate.format(newCalendar.getTime());
        Toast.makeText(this, "Date get is set " + getDatefromAccess, Toast.LENGTH_SHORT).show();
    }
}
