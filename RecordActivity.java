package ikwala.com;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecordActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Orders> ordersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());



        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(llm);
        RVAdaptor adaptor = new RVAdaptor(ordersListView);
        rv.setAdapter(adaptor);

    }

    private class RVAdaptor extends RecyclerView.Adapter<RVAdaptor.OrdersViewHolder>
    {
        List<Orders> list;
        String totalNumberofCloth;
        String strOrderNum;
        String checker = "";

        public  RVAdaptor(List<Orders> ordersList)
        {
            this.list = Variabels.ordersList;

        }

        @Override
        public OrdersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list,parent,false);
            OrdersViewHolder ovh = new OrdersViewHolder(v);
            return ovh;
        }

        @Override
        public void onBindViewHolder(OrdersViewHolder holder, int position) {
            holder.tvDate.setText(list.get(position).getDate());
            holder.tvNumberOfOrder.setText(strOrderNum = String.valueOf(list.get(position).getOrderNumber()));
            holder.tvTotalNumber.setText(totalNumberofCloth = String.valueOf(list.get(position).getNumCloth1() + list.get(position).getNumCloth2() +
            list.get(position).getNumCloth3() + list.get(position).getNumCloth4()));



        }



        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

        public class OrdersViewHolder extends RecyclerView.ViewHolder
        {
            TextView tvDate;
            TextView tvTotalNumber;
            TextView tvNumberOfOrder;

            public OrdersViewHolder(final View itemView) {
                super(itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Variabels.orderPosetion = Integer.parseInt(strOrderNum.toString());
                        Snackbar.make(v,tvNumberOfOrder.getText().toString(),Snackbar.LENGTH_SHORT).show();
                        checker = tvNumberOfOrder.getText().toString();
                        Variabels.orderPosetion = Integer.parseInt(checker);
                        Intent i = new Intent(RecordActivity.this,InvoiceActivity.class);
                        startActivity(i);
                    }
                });
                tvDate = (TextView)itemView.findViewById(R.id.tvDate);
                tvTotalNumber = (TextView)itemView.findViewById(R.id.tvnumberOfTotalClothes);
                tvNumberOfOrder = (TextView)itemView.findViewById(R.id.tvOrderNumber);
            }
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


