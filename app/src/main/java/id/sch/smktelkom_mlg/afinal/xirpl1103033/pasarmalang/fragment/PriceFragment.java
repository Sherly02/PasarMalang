package id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.fragment;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.R;
import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.app.MyApplication;
import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.model.Product;

public class PriceFragment extends Fragment {

    private static final String TAG = PriceFragment.class.getSimpleName();
    private static final String URL = "https://api.androidhive.info/json/movies_2017.json";

    private RecyclerView recyclerView;
    private List<Product> productList;
    private StoreAdapter mAdapter;

    public PriceFragment() {
        // Required empty public constructor
    }

    public static PriceFragment newInstance(String param1, String param2) {
        PriceFragment fragment = new PriceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_price, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        productList = new ArrayList<>();
        mAdapter = new StoreAdapter(getActivity(), productList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetchProduct();

        return view;
    }

    private void fetchProduct() {
        JsonArrayRequest request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response == null) {
                            Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                            return;
                        }

                        List<Product> items = new Gson().fromJson(response.toString(), new TypeToken<List<Movie>>() {
                        }.getType());

                        productList.clear();
                        productList.addAll(items);

                        // refreshing recycler view
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error in getting json
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        MyApplication.getInstance().addToRequestQueue(request);
    }

    class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
        private Context context;
        private List<Product> productList;

        public StoreAdapter(Context context, List<Product> productList) {
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
            holder.nameProduct.setText(product.getName_product());
            holder.priceYes.setText(product.getPrice_yerterday());
            holder.priceTod.setText(product.getPrice_today());
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView nameProduct, priceYes, priceTod;

            public MyViewHolder(View view) {
                super(view);
                nameProduct = view.findViewById(R.id.name_product);
                priceYes = view.findViewById(R.id.price_before);
                priceTod = view.findViewById(R.id.price_today);
            }
        }
    }

}
