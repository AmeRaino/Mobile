package ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import Dto.OrderDetailDto;
import Model.Address;
import Model.Cake;
import Model.CartItem;
import Model.CategoryCake;
import repositories.AddressRepo;
import repositories.CartRepo;
import repositories.ShopRepo;

public class ShopViewModel extends ViewModel {
    CartRepo cartRepo = new CartRepo();
    ShopRepo shopRepo = new ShopRepo();
    AddressRepo addressRepo = new AddressRepo();

    MutableLiveData<Cake> mutableCake = new MutableLiveData<>();
    MutableLiveData<CategoryCake> mutableCategory = new MutableLiveData<>();
    private MutableLiveData<Address> mutableSaveAddress = new MutableLiveData<>();
    MutableLiveData<List<OrderDetailDto>> mutableSaveOrder = new MutableLiveData<>();

    public LiveData<List<OrderDetailDto>> getSaveOrder() {
        return mutableSaveOrder;
    }

    public void setSaveOrder(OrderDetailDto order) {
        if ( mutableSaveOrder == null) {
            mutableSaveOrder = new MutableLiveData<>();
            List<OrderDetailDto> list = new ArrayList<>();
            list.add(order);
            mutableSaveOrder.setValue(list);
        }
        if (mutableSaveOrder.getValue() == null) {
            List<OrderDetailDto> list = new ArrayList<>();
            list.add(order);
            mutableSaveOrder.setValue(list);
            ArrayList<OrderDetailDto> arrayList = new ArrayList<>(mutableSaveOrder.getValue());
            Log.e("1", " " + arrayList.toString());
        }
        else {
            List<OrderDetailDto> list = mutableSaveOrder.getValue();
            list.add(order);
            mutableSaveOrder.setValue(list);
        }
    }

    public void resetSaveOrder() {
        mutableSaveOrder.setValue(null);
    }

    public LiveData<Address> getAddress() {
        return addressRepo.getAddress();
    }

    public boolean changeAddress(String address, String type) {
        return addressRepo.changeAddress(address, type);
    }

    public void setSaveAddress(Address address) {
        mutableSaveAddress.setValue(address);
    }

    public LiveData<Address> getSaveAddress() {
        return mutableSaveAddress;
    }


    public LiveData<List<Cake>> getCakes() {
        return shopRepo.getCakes();
    }

    public void setCake(Cake cake) {
        mutableCake.setValue(cake);
    }

    public LiveData<Cake> getCake() {
        return mutableCake;
    }

    public LiveData<List<CategoryCake>> getCategories() {
        return shopRepo.getCategories();
    }

    public void setCategory(CategoryCake category) {
        mutableCategory.setValue(category);
    }

    public LiveData<CategoryCake> getCategory() {
        return mutableCategory;
    }

    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }

    public boolean addCakeToCart(Cake cake) {
        return cartRepo.addItemToCart(cake);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }
}
