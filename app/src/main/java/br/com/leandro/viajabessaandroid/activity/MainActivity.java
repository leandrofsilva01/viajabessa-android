package br.com.leandro.viajabessaandroid.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import br.com.leandro.viajabessaandroid.R;
import br.com.leandro.viajabessaandroid.adapter.PromotionAdapter;
import br.com.leandro.viajabessaandroid.application.Const;
import br.com.leandro.viajabessaandroid.model.Promotion;
import br.com.leandro.viajabessaandroid.model.Promotions;
import br.com.leandro.viajabessaandroid.rest.service.ApiService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity
{

    private ListView listView;
    private PromotionAdapter adapter;
    private List<Promotion> promotionList = new ArrayList<Promotion>();
    private JSONArray user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new PromotionAdapter(this, this.promotionList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,  long id)
            {
                Promotion promotion = promotionList.get(position);
                //System.out.println("Selecionado: " + promotion.getTitle());

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("promotion", promotion);
                startActivity(intent);
            }
        });

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Const.BASE_URL)
                .build();

        ApiService apiService = restAdapter.create(ApiService.class);

        apiService.getPromotions(new Callback<Promotions>() {
            @Override
            public void success(Promotions promotions, Response response) {
                for (Promotion promotion : promotions.getPromotions())
                    promotionList.add(promotion);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace();
            }
        });
    }

}
