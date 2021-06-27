package Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetWorkProvider {
    private static volatile NetWorkProvider mInstance = null;

    public Retrofit retrofit;

    private NetWorkProvider() {
        OkHttpClient okHttpClient = HttpsTrustManager.getUnsafeOkHttpClient();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://10.0.2.2:5001/")
                .client(okHttpClient)
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static NetWorkProvider self() {
        if (mInstance == null)
            mInstance = new NetWorkProvider();
        return mInstance;
    }
}
