package mcptest;

import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import utils.SecurityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CommandHttpClient {

    /**
     * 1、URLCOnnection
     * 2、HttpClient
     * 3、OkHttp
     *
     * @param args
     */

    // 模拟表单提交
    public static void main(String[] args) {

        getClient();
    }

    public static void postClient(){
        //创建client对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post
        HttpPost httpPost = new HttpPost("http://172.16.24.181:8081/api/geek/getResumeQuality?app_id=1004&client_info=%7B%22end_time%22%3A%221510715520821%22%2C%22os%22%3A%22iOS%22%2C%22longitude%22%3A%22116.445496%22%2C%22model%22%3A%22iPhone8%2C1%22%2C%22start_time%22%3A%221510713876037%22%2C%22ssid%22%3A%22kanzhun-inc.com%22%2C%22bssid%22%3A%220%3A6%3Af4%3Ae2%3Af7%3A14%22%2C%22version%22%3A%2210.1%22%2C%22latitude%22%3A%2239.970819%22%2C%22resume_time%22%3A%221510716843052%22%2C%22idfa%22%3A%221A915888-769B-4D54-BB36-4AEB5D15DC39%22%7D&curidentity=0&req_time=1510716862570&sig=V2.06f29086743a95679383c9aa3daa50d4d&t=BVjZSQwQ1BT9ZbFYwDTUBY1BrVGYLO1I1CmpbZQ..&uniqid=78C2BA49C9740F60CB651834D2A1FCC0&v=5.47");
        //创建参数队列  Pair
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("Host", "172.16.24.181:8081"));
        formParams.add(new BasicNameValuePair("Accept", "*/*"));
        formParams.add(new BasicNameValuePair("Cookie", "JSESSIONID=8DAE072BD1D30DD5E94F1D783A3991CD"));
        formParams.add(new BasicNameValuePair("User-Agent", "BossZhipin/5.47 Screen/375X667"));
        formParams.add(new BasicNameValuePair("Accept-Language", "zh,CN"));
        formParams.add(new BasicNameValuePair("Accept-Encoding", "gzip, deflate, sdch"));
        formParams.add(new BasicNameValuePair("Connection", "keep-alive"));

        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
            System.out.println("url:" + httpPost.getURI());
            CloseableHttpResponse response = client.execute(httpPost);
            responseParse(response);

        } catch (IOException e) {
            System.out.println(String.format("Error:%s", "CommandHttpClient"));
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getClient(){
        //创建client对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post
        HttpGet httpGet = new HttpGet("http://172.16.24.181:8081/api/batch/batchRun?uniqid=78C2BA49C9740F60CB651834D2A1FCC0&curidentity=0&client_info=%7B%22end_time%22%3A%221510715369040%22%2C%22os%22%3A%22iOS%22%2C%22longitude%22%3A%22116.445496%22%2C%22model%22%3A%22iPhone8%2C1%22%2C%22start_time%22%3A%221510713876037%22%2C%22ssid%22%3A%22kanzhun-inc.com%22%2C%22bssid%22%3A%220%3A6%3Af4%3Ae2%3Af7%3A14%22%2C%22version%22%3A%2210.1%22%2C%22latitude%22%3A%2239.970819%22%2C%22resume_time%22%3A%221510715517199%22%2C%22idfa%22%3A%221A915888-769B-4D54-BB36-4AEB5D15DC39%22%7D&app_id=1004&t=BVjZSQwQ1BT9ZbFYwDTUBY1BrVGYLO1I1CmpbZQ..&v=5.47&sig=V2.02a09e460bb5efc46aaa08124b7642ac1&req_time=1510715517209");
        httpGet.setProtocolVersion(new ProtocolVersion("HTTP",1,1));
        httpGet.setHeader("Host", "172.16.24.181:8081");
        httpGet.setHeader("Accept", "*/*");
        httpGet.setHeader("Cookie", "JSESSIONID=8DAE072BD1D30DD5E94F1D783A3991CD");
        httpGet.setHeader("User-Agent", "BossZhipin/5.47 Screen/375X667");
        httpGet.setHeader("Accept-Language", "zh,CN");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch");
        httpGet.setHeader("Connection", "keep-alive");

        try {
            System.out.println("url:" + httpGet.getURI());
            CloseableHttpResponse response = client.execute(httpGet);
            responseParse(response);

        } catch (IOException e) {
            System.out.println(String.format("Error:%s", "CommandHttpClient"));
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void responseParse(HttpResponse response) {
        System.out.println(response.getStatusLine());

        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
        HttpEntity entity = response.getEntity();
        try {
            long contentLength = entity.getContentLength();
            Header contentEncoding = entity.getContentEncoding();
            InputStream is = entity.getContent();
            String content = IOUtils.toString(is, "UTF-8");
            System.out.println(content);
            System.out.println("entity content: "+ SecurityUtils.rc4Decrypt(content,"dee9ff4fd2d23b612b9f4de5e6e0f8c18f7c0ed786687252d49fe7d601a990ae"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
