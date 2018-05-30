package id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.R;
import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.model.Product;

/**
 * Created by batuh on 30/05/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context context;
    private List<Product> productList;


    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.price_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Product product = productList.get(position);
        holder.name.setText(product.getName_product());
        holder.price_yes.setText(product.getPrice_yerterday());
        holder.price_tod.setText(product.getPrice_today());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, price_yes, price_tod;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_product);
            price_yes = view.findViewById(R.id.price_before);
            price_tod = view.findViewById(R.id.price_today);
        }
    }
}