package http;

import okhttp3.*;

import java.io.IOException;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-07 14:51
 */
public class OkHttpTest {

    public static void main(String[] args) throws IOException {
        asyncGet();

        syncGet();

        syncPost();
    }

    private static void syncPost() throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("apiSymbol", "boss_hot_position_strategy_people_biz_813_37")
                .add("apikey","")
                .add("apiSecret","")
                .add("bossId","123")
                .build();
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        Response resp = call.execute();
        System.out.println(resp.body().string());
    }

    private static void syncGet() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .get()//默认就是GET请求，可以不写
                .build();

        Call call = okHttpClient.newCall(request);

        System.out.println("==========同步get=========");
        Response response = call.execute();
        System.out.println(response.body().string());
        System.out.println("==========同步get=========");
    }

    private static void asyncGet() {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .get()//默认就是GET请求，可以不写
                .build();

        Call call = okHttpClient.newCall(request);

        System.out.println("=========异步get==========");

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(call);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });


        System.out.println("=========异步get==========");
    }
}
