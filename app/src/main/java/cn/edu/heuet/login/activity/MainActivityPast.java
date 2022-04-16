package cn.edu.heuet.login.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xuexiang.xhttp2.XHttp;
import com.xuexiang.xhttp2.callback.SimpleCallBack;
import com.xuexiang.xhttp2.exception.ApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.heuet.login.R;
import cn.edu.heuet.login.adapter.SearchAdapter;
import cn.edu.heuet.login.bean.Shared;
import cn.edu.heuet.login.constant.ModelConstant;
import cn.edu.heuet.login.constant.NetConstant;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 展示新闻列表与搜素框
 */
public class MainActivityPast extends BaseActivity {

    private static RecyclerView rvList;
    private static SearchAdapter searchAdapter;
    private static final String TAG = "MAIN_ACTIVITY";
    private List<Shared> sharedList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_past);

        // 搜索框
        EditText etSearch = findViewById(R.id.et_search);

        // 列表展示
        rvList = findViewById(R.id.rv_list);

        //呈现纵向滑动列表布局，不设置xml里是不会有滑动效果的
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);

        //填充子布局的适配器
        setAdapter(sharedList);

        // 获取数据
//        String url = NetConstant.baseService + NetConstant.getNewsListURL();
//        MyAsyncTask task = new MyAsyncTask();
//        task.execute(url);
        String url = NetConstant.getSharedListURL();
        asyncGetSharedList(url);

        // 动态搜索
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                hideToast();

                if (TextUtils.isEmpty(s)) {
                    String url = NetConstant.getSharedListURL();
//                    MyAsyncTask listTask = new MyAsyncTask();
//                    listTask.execute(url);
                    asyncGetSharedList(url);
                    return;
                }

                //  String url = NetConstant.getNewsByIdURL() + s;
                String url = NetConstant.getSharedByCommunityURL() + s;
//                MyAsyncTask detailTask = new MyAsyncTask();
//                detailTask.execute(url);
                asyncGetSharedList(url);
            }

        };
        etSearch.addTextChangedListener(watcher);

        // 退出登录
        Button btLogout = findViewById(R.id.bt_logout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 清空 SharedPreferences 中的登录信息
                SharedPreferences sp = getSharedPreferences(ModelConstant.LOGIN_INFO, MODE_PRIVATE);
                sp.edit().clear().apply();
                // 跳转到登录页
                Intent intent = new Intent(MainActivityPast.this, LoginActivity.class);
                startActivity(intent);
                // 关闭当前页
                finish();
            }
        });
    }

    /**
     * 网络访问请求，并调用setAdapter()将请求到的数据传入适配器
     *
     * @param url
     */
    private void asyncGetSharedList(String url) {
        XHttp.get(url)
                .syncRequest(false)
                .execute(new SimpleCallBack<List<Shared>>() {
                    @Override
                    public void onSuccess(List<Shared> data) throws Throwable {
                        if (data.size() == 0) {
                            showToastInThread(MainActivityPast.this, "查询结果为空");
                            setAdapter(null);
                        } else {
                            setAdapter(data);
                        }
                    }

                    @Override
                    public void onError(ApiException e) {
                        Log.d(TAG, "请求URL异常,获取新闻列表失败" + e.toString());
                        showToastInThread(MainActivityPast.this, e.getMessage());
                    }
                });

    }

    /**
     * 将请求到的shards数据表做参传入新适配器
     *
     * @param shareds
     */
    private static void setAdapter(List<Shared> shareds) {
        if (shareds == null || shareds.size() == 0) {
            rvList.removeAllViews();
            return;
        }
        searchAdapter = new SearchAdapter(shareds);
        rvList.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();
    }

    /**
     * 网络请求(暂未启用)
     * <p>
     */
    /*private static class MyAsyncTask extends AsyncTask<String, Void, List<Shared>> {

        @Override
        protected List<Shared> doInBackground(String... strings) {
            String url = strings[0];
            List<Shared> sharedList = null;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                String jsonStr = response.body().string();
                JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                String status = jsonObject.get("status").getAsString();
                if (TextUtils.equals(status, "success")) {
                    JsonArray data = jsonObject.get("data").getAsJsonArray();
                    String dataStr = data.toString();
                    sharedList = JSON.parseArray(dataStr, Shared.class);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sharedList;
        }

        @Override
        protected void onPostExecute(List<Shared> shared) {
            super.onPostExecute(shared);
            setAdapter(shared);
        }
    }*/
}
