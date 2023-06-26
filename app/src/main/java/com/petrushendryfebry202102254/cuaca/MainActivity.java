package com.petrushendryfebry202102254.cuaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView _recyclerView1;
    private SwipeRefreshLayout _swipeRefreshLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _recyclerView1 = (RecyclerView) findViewById(R.id.recycleView1);
        _swipeRefreshLayout1 = findViewById(R.id.swipeRefreshLayout1);

        initRecyclerView();
        initSwipeRefreshLayout();
    }
    private void initSwipeRefreshLayout()
    {
        _swipeRefreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initRecyclerView();
                _swipeRefreshLayout1.setRefreshing(false);
            }
        });
    }
    private void initRecyclerView(){
        String url = "https://api.openweathermap.org/data/2.5/forecast?id=1630789&appid=b6f1b0919ab27c05abc6465d7d81fd2c";
        AsyncHttpClient ahc = new AsyncHttpClient();

        ahc.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                RootModel rm = gson.fromJson(new String(responseBody), RootModel.class);

                RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
                CuacaAdapter ca = new CuacaAdapter(rm);

                _recyclerView1.setLayoutManager(lm);
                _recyclerView1.setAdapter(ca);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}