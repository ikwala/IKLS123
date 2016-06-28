package ikwala.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static ikwala.com.Variabels.orderPosetion;
import static ikwala.com.Variabels.ordersList;


public class InvoiceActivity extends AppCompatActivity {

    TextView tvInvClothe1;
    TextView tvInvClothe2;
    TextView tvInvClothe3;
    String str;
    TextView tvInvClothe4;
    TextView tvInvNumCloth1;
    TextView tvInvNumCloth2;
    TextView tvInvNumCloth3;
    TextView tvInvNumCloth4;
    TextView tvInvclothe1Amount;
    TextView tvInvclothe2Amount;
    TextView tvInvclothe3Amount;
    TextView tvInvclothe4Amount;
    TextView tvInvTotalNumCloth;
    TextView tvTotalInvoice;
    TextView tvInvOrderNum;

    int kandora = 10;
    int sofra = 5;
    int wazar = 3;

    Button btnPrintInvoice;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        tvInvClothe1 = (TextView)findViewById(R.id.tvInvClothe1);
        tvInvClothe2 = (TextView)findViewById(R.id.tvInvClothe2);
        tvInvClothe3 = (TextView)findViewById(R.id.tvInvClothe3);
        tvInvClothe4 = (TextView)findViewById(R.id.tvInvClothe4);
        tvInvNumCloth1 = (TextView)findViewById(R.id.tvInvNumCloth1);
        tvInvNumCloth2 = (TextView)findViewById(R.id.tvInvNumClothe2);
        tvInvNumCloth3 = (TextView)findViewById(R.id.tvInvNumCloth3);
        tvInvNumCloth4 = (TextView)findViewById(R.id.tvInvNumCloth4);
        tvInvclothe1Amount = (TextView)findViewById(R.id.tvInvclothe1Amount);
        tvInvclothe2Amount = (TextView)findViewById(R.id.tvInvClothe2Amount);
        tvInvclothe3Amount = (TextView)findViewById(R.id.tvInvCloth3Amount);
        tvInvclothe4Amount = (TextView)findViewById(R.id.tvInvClothe4Amount);
        tvInvTotalNumCloth = (TextView)findViewById(R.id.tvInvTotalNumCloth);
        tvTotalInvoice = (TextView)findViewById(R.id.tvTotalInvoice);
        tvInvOrderNum = (TextView)findViewById(R.id.tvInvOrderNum);
        btnPrintInvoice = (Button)findViewById(R.id.btnPrintInvoice);

        int pos = orderPosetion;



        for (Orders o : ordersList)
        {
            if (pos == o.getOrderNumber())
            {
                tvInvOrderNum.setText(""+o.getOrderNumber());
                tvInvClothe1.setText(o.getCloth1());
                tvInvClothe2.setText(o.getCloth2());
                tvInvClothe3.setText(o.getCloth3());
                tvInvClothe4.setText(o.getCloth4());
                tvInvNumCloth1.setText(""+o.getNumCloth1());
                tvInvNumCloth2.setText(""+o.getNumCloth2());
                tvInvNumCloth3.setText(""+o.getNumCloth3());
                tvInvNumCloth4.setText(""+o.getNumCloth4());

                //1
                if (tvInvClothe1.getText().toString().equals("Kandora 10 AED"))
                {
                    tvInvclothe1Amount.setText(""+kandora * o.getNumCloth1());

                }
                if (tvInvClothe1.getText().toString().equals("Sofra 5 AED"))
                {
                    tvInvclothe1Amount.setText(""+sofra * o.getNumCloth1());

                }
                if (tvInvClothe1.getText().toString().equals("Wazar 3 AED"))
                {
                    tvInvclothe1Amount.setText(""+wazar * o.getNumCloth1());

                }
                //2
                if (tvInvClothe2.getText().toString().equals("Kandora 10 AED"))
                {
                    tvInvclothe2Amount.setText(""+kandora * o.getNumCloth2());

                }
                if (tvInvClothe2.getText().toString().equals("Sofra 5 AED"))
                {
                    tvInvclothe2Amount.setText(""+sofra * o.getNumCloth2());

                }
                if (tvInvClothe2.getText().toString().equals("Wazar 3 AED"))
                {
                    tvInvclothe2Amount.setText(""+wazar * o.getNumCloth2());

                }
                //3
                if (tvInvClothe3.getText().toString().equals("Kandora 10 AED"))
                {
                    tvInvclothe3Amount.setText(""+kandora * o.getNumCloth3());

                }
                if (tvInvClothe3.getText().toString().equals("Sofra 5 AED"))
                {
                    tvInvclothe3Amount.setText(""+sofra * o.getNumCloth3());

                }
                if (tvInvClothe3.getText().toString().equals("Wazar 3 AED"))
                {
                    tvInvclothe3Amount.setText(""+wazar * o.getNumCloth3());

                }
                //4
                if (tvInvClothe4.getText().toString().equals("Kandora 10 AED"))
                {
                    tvInvclothe4Amount.setText(""+kandora * o.getNumCloth4());

                }
                if (tvInvClothe4.getText().toString().equals("Sofra 5 AED"))
                {
                    tvInvclothe4Amount.setText(""+sofra * o.getNumCloth4());

                }
                if (tvInvClothe4.getText().toString().equals("Wazar 3 AED"))
                {
                    tvInvclothe4Amount.setText(""+wazar * o.getNumCloth4());

                }


            }

        }

        int totalCloth = Integer.parseInt(tvInvNumCloth1.getText().toString()) + Integer.parseInt(tvInvNumCloth2.getText().toString()) +
                Integer.parseInt(tvInvNumCloth3.getText().toString()) + Integer.parseInt(tvInvNumCloth4.getText().toString());


        tvInvTotalNumCloth.setText(""+ totalCloth);

        int totalInvoice = Integer.parseInt(tvInvclothe1Amount.getText().toString())+ Integer.parseInt(tvInvclothe2Amount.getText().toString())
                + Integer.parseInt(tvInvclothe3Amount.getText().toString()) + Integer.parseInt(tvInvclothe4Amount.getText().toString());
        tvTotalInvoice.setText(""+totalInvoice);




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
