package Adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;
import com.ornach.nobobutton.NoboButton;

import Model.Address;

public class ShippingAddressAdapter extends RecyclerView.Adapter<ShippingAddressAdapter.myviewholder> {

    private String[] address  = new String[]{"Full Name", "Phone", "Province", "City", "Ward", "Detail Address"};
    private ShippingAddressAdapter.AddressInterface addressInterface;
    private Address oldAddress;

    public ShippingAddressAdapter(AddressInterface addressInterface, Address oldAddress) {
        this.addressInterface = addressInterface;
        this.oldAddress = oldAddress;
    }

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item, parent, false);
        return new myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        String txtAddress = address[position];
        String editAddress = "Fill " + address[position];
        holder.txtAddress.setText(txtAddress);
        holder.edtAddress.setHint(editAddress);

        if (oldAddress != null ) {
            if ( txtAddress == "Full Name")
                holder.edtAddress.setText(oldAddress.getFullName());
            else if ( txtAddress == "Phone" )
                holder.edtAddress.setText(oldAddress.getPhone());
            else if ( txtAddress == "City" )
                holder.edtAddress.setText(oldAddress.getProvince());
            else if ( txtAddress == "Province" )
                holder.edtAddress.setText(oldAddress.getCity());
            else if ( txtAddress == "Ward" )
                holder.edtAddress.setText(oldAddress.getWard());
            else if ( txtAddress == "Detail Address" )
                holder.edtAddress.setText(oldAddress.getAddressDetail());
        }

        holder.edtAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addressInterface.changeAddress(s.toString(), txtAddress);
            }
        });
    }

    @Override
    public int getItemCount() {
        return address.length;
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        private TextView txtAddress;
        private EditText edtAddress;
        private NoboButton btnSave;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
              txtAddress = itemView.findViewById(R.id.txtAddress);
              edtAddress = itemView.findViewById(R.id.edtAddress);
        }
    }

    public interface AddressInterface {
        void changeAddress(String address, String type);
    }
}