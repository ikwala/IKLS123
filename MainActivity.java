package ikwala.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLOutput;

import static ikwala.com.Variabels.user;
import static ikwala.com.Variabels.ordersList;
import static ikwala.com.Variabels.orderNumber;

public class MainActivity extends AppCompatActivity {
    Button btnNewWash;
    Button btnRecord;
    Button btnTrack;
    Button btnBalance;
    IKLSModulator iklsModulator;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iklsModulator = IKLSModulator.getsIKIklsModulator(getApplicationContext());
        user = iklsModulator.getUsers();
        try {
            ordersList = iklsModulator.getOrder();
            orderNumber = ordersList.size();

        }
        catch (Exception e)
        {
            System.out.println("not fount");
        }
//        ordersList = iklsModulator.getOrder();
//        orderNumber = ordersList.size();

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);

        if (!user.isEmpty()) {
            for (int i = 0; i < user.size(); i++) {
                tvWelcome.setText("Welcome " + user.get(i).getFirstName());

            }
        }



        btnNewWash = (Button) findViewById(R.id.btnNewWash);
        btnNewWash.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (user != null)
            {
                Intent i = new Intent(MainActivity.this, NewWashActivity.class);
                 startActivity(i);
                finish();
           }
                if (user.isEmpty())
           {
               Intent i = new Intent(MainActivity.this, CheckActivity.class);
               startActivity(i);
               finish();
           }

                                          }
                                      }
        );
        btnRecord = (Button) findViewById(R.id.btnRecord);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RecordActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onRestart() {
        orderNumber = ordersList.size();
        super.onRestart();
    }
}
