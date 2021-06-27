package Api;

import java.util.ArrayList;

import Dto.OrderDetailDto;
import Dto.OrderDto;
import Model.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderApi {
    String baseUrl = "api/order/";
    OrderApi orderApi = NetWorkProvider.self().retrofit.create(OrderApi.class);

//    @GET("api/product/")
//    Call<ArrayList<Cake>> getCakes();

    @POST(baseUrl + "createorder")
    Call<Void> createOrder(@Body OrderDto orderDto);

    @GET(baseUrl + "getorderbyidcus/{id}")
    Call<ArrayList<Order>> getOrderByIdCus(@Path("id") String id);

    @GET(baseUrl + "getorderdetailbyidord/{id}")
    Call<OrderDetailDto> getOrderDetailByIdOrd(@Path("id") String id);

    @GET(baseUrl + "getorderdetailbyidcus/guest")
    Call<ArrayList<OrderDetailDto>> getOrderDetailByIdCus();
}
