package br.com.leandro.viajabessaandroid.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import br.com.leandro.viajabessaandroid.R;
import br.com.leandro.viajabessaandroid.adapter.PromotionAdapter;
import br.com.leandro.viajabessaandroid.application.Const;
import br.com.leandro.viajabessaandroid.model.Promotion;
import br.com.leandro.viajabessaandroid.model.Promotions;
import br.com.leandro.viajabessaandroid.rest.service.ApiService;
import br.com.leandro.viajabessaandroid.util.StringUtil;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new PromotionAdapter(this, this.promotionList);
        listView.setAdapter(adapter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
