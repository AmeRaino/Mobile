package repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import Api.ProductApi;
import Model.Cake;
import Model.CategoryCake;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopRepo {
    private MutableLiveData<List<Cake>> mutableCakes;
    private MutableLiveData<List<CategoryCake>> mutableCategories;

    public LiveData<List<Cake>> getCakes() {
        if (mutableCakes == null) {
            mutableCakes = new MutableLiveData<>();
            loadCakes();
        }
        return mutableCakes;
    }

    private void loadCakes() {
        ProductApi.productApi.getCakes().enqueue(new Callback<ArrayList<Cake>>() {
            @Override
            public void onResponse(Call<ArrayList<Cake>> call, Response<ArrayList<Cake>> response) {
                mutableCakes.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Cake>> call, Throwable t) {
                Log.e("loadCakes", "error");
            }
        });
    }

    public LiveData<List<CategoryCake>> getCategories() {
        if (mutableCategories == null) {
            mutableCategories = new MutableLiveData<>();
            loadCategories();
        }
        return mutableCategories;
    }

    private void loadCategories() {
        ProductApi.productApi.getCategories().enqueue(new Callback<ArrayList<CategoryCake>>() {
            @Override
            public void onResponse(Call<ArrayList<CategoryCake>> call, Response<ArrayList<CategoryCake>> response) {
                mutableCategories.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<CategoryCake>> call, Throwable t) {
                Log.e("loadCategories", "error");
            }
        });
    }
}
