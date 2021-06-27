package Api;

import Dto.AuthenticateUserDto;
import Model.EndUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface EndUserApi {
    String baseUrl = "api/enduser/";

    EndUserApi endUserApi = NetWorkProvider.self().retrofit.create(EndUserApi.class);

    @POST(baseUrl + "authenticate")
    Call<EndUser> authenticate(@Body AuthenticateUserDto authenticateUserDto);
}
