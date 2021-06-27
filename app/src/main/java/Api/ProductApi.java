package Api;

import java.util.ArrayList;

import Model.Cake;
import Model.CategoryCake;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    String baseUrl = "api/product/";
    ProductApi productApi = NetWorkProvider.self().retrofit.create(ProductApi.class);

    @GET("api/product/")
    Call<ArrayList<Cake>> getCakes();

    @GET(baseUrl + "getcategories")
    Call<ArrayList<CategoryCake>> getCategories();
}
