package ikwala.com;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static ikwala.com.Variabels.*;

public class NewWashActivity extends AppCompatActivity {
    Spinner spClothes1;
    Spinner spClothes2;
    Spinner spClothes3;
    Spinner spClothes4;

    EditText etNumberOfClothes1;
    EditText etNumberOfClothes2;
    EditText etNumberOfClothes3;
    EditText etNumberOfClothes4;
    EditText etSpecialRequist;

    FloatingActionButton fabAdd;

    LinearLayout llClothes2;
    LinearLayout llClothes3;
    LinearLayout llClothes4;

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_wash);

        date = setDate();

        spClothes1 = (Spinner)findViewById(R.id.spClothes1);
        spClothes1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cloth1 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spClothes2 = (Spinner)findViewById(R.id.spClothes2);
        spClothes2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cloth2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spClothes3 = (Spinner)findViewById(R.id.spClothes3);
        spClothes3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cloth3 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spClothes4 = (Spinner)findViewById(R.id.spClothes4);
        spClothes4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cloth4 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etNumberOfClothes1 = (EditText)findViewById(R.id.etNumberOfClothes1);
        etNumberOfClothes2 = (EditText)findViewById(R.id.etNumberOfClothes2);
        etNumberOfClothes3 = (EditText)findViewById(R.id.etNumberOfClothes3);
        etNumberOfClothes4 = (EditText)findViewById(R.id.etNumberOfClothes4);
        etSpecialRequist = (EditText)findViewById(R.id.etSpecialRequist);


        llClothes2 = (LinearLayout)findViewById(R.id.llClothes2);
        llClothes3 = (LinearLayout)findViewById(R.id.llClothes3);
        llClothes4 = (LinearLayout)findViewById(R.id.llClothes4);

        fabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (llClothes2.getVisibility() != View.VISIBLE)
                {
                    llClothes2.setVisibility(View.VISIBLE);
                    return;
                }

                if (llClothes3.getVisibility() != View.VISIBLE)
                {
                    llClothes3.setVisibility(View.VISIBLE);
                    return;
                }

                if (llClothes4.getVisibility() != View.VISIBLE)
                {
                    llClothes4.setVisibility(View.VISIBLE);
                    return;
                }

                if (llClothes2.getVisibility() == View.VISIBLE && llClothes3.getVisibility() == View.VISIBLE &&
                llClothes4.getVisibility() == View.VISIBLE)
                {
                    Toast.makeText(getApplicationContext(),"No more than 4 Item can be held",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

        btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numCloth1 = Integer.parseInt(etNumberOfClothes1.getText().toString());
                numCloth2 = Integer.parseInt(etNumberOfClothes2.getText().toString());
                numCloth3 = Integer.parseInt(etNumberOfClothes3.getText().toString());
                numCloth4 = Integer.parseInt(etNumberOfClothes4.getText().toString());
                specialRequist = etSpecialRequist.getText().toString();

                Intent i = new Intent(NewWashActivity.this,MapsActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    public String setDate()
    {
        String date;
        int day;
        int month;
        int year;

        Calendar calendar = new GregorianCalendar();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        date = " " + day + " / " + month + " / " + year + " ";

        return date;
    }
}
