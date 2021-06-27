package repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Model.Address;

public class AddressRepo {
    private MutableLiveData<Address> mutableAddress = new MutableLiveData<>();

    public LiveData<Address> getAddress() {
        if ( mutableAddress.getValue() == null ) {
            initAddress();
        }
        return  mutableAddress;
    }

    public void initAddress() {
        mutableAddress.setValue(new Address());
    }

    public boolean changeAddress(String address, String type) {
        if (mutableAddress.getValue() == null)
            mutableAddress.setValue(new Address());
        Address addr = mutableAddress.getValue();
        if ( type == "Full Name")
            addr.setFullName(address);
        else if ( type == "Phone" )
            addr.setPhone(address);
        else if ( type == "City" )
            addr.setCity(address);
        else if ( type == "Province" )
            addr.setProvince(address);
        else if ( type == "Ward" )
            addr.setWard(address);
        else if ( type == "Detail Address" )
            addr.setAddressDetail(address);
        return true;
    }
}
