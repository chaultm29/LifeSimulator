package com.example.lifesimulator.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.Model.AppDialog;
import com.example.lifesimulator.Model.IConfirm;
import com.example.lifesimulator.R;


public class BankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnWithdraw25 = view.findViewById(R.id.btnWithdraw25);
        Button btnWithdraw50 = view.findViewById(R.id.btnWithdraw50);
        Button btnWithdraw75 = view.findViewById(R.id.btnWithdraw75);
        Button btnSave25 = view.findViewById(R.id.btnSave25);
        Button btnSave50 = view.findViewById(R.id.btnSave50);
        Button btnSave75 = view.findViewById(R.id.btnSave75);
        Button btnLoan = view.findViewById(R.id.btnLoan);
        Button btnHotLoan = view.findViewById(R.id.btnHotLoan);
        Button btnGVietlot = view.findViewById(R.id.btnGVietlot);
        Button btnGBillionaire = view.findViewById(R.id.btnGBillionaire);
        Button btnGBit = view.findViewById(R.id.btnGBit);
        Button btnGReal = view.findViewById(R.id.btnGReal);

        btnWithdraw25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().withdraw(view.getContext(), 25 );
                AppDataStore.UpdateBankView();
            }
        });
        btnWithdraw50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().withdraw(view.getContext(), 50 );
                AppDataStore.UpdateBankView();
            }
        });
        btnWithdraw75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().withdraw(view.getContext(), 75 );
                AppDataStore.UpdateBankView();
            }
        });
        btnSave25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().saveMoney(view.getContext(), 25 );
                AppDataStore.UpdateBankView();
            }
        });
        btnSave50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().saveMoney(view.getContext(), 50 );
                AppDataStore.UpdateBankView();
            }
        });
        btnSave75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().saveMoney(view.getContext(), 75 );
                AppDataStore.UpdateBankView();
            }
        });
        btnLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDialog.ConfirmDialog(view.getContext(), "Vay ngân hàng 10 000 với lãi suất 7%/năm, trả góp 5 năm. Sau 5 năm lãi suất 15%", new IConfirm() {
                    @Override
                    public void doAgree() {
                        AppDataStore.identity.getBank().getLoan(view.getContext(), 10000 );
                        AppDataStore.UpdateBankView();
                    }

                    @Override
                    public void doCancel() {
                        //nothing
                    }
                });
            }
        });

        btnHotLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDialog.ConfirmDialog(view.getContext(), "Bạn đi tìm mấy 'anh em' vay 50 000 với lãi suất kép 20%/năm, trả góp 5 năm. Sau 5 năm các anh em sẽ đến nhà bạn uống trà.", new IConfirm() {
                    @Override
                    public void doAgree() {
                        AppDataStore.identity.getBank().getHotLoan(view.getContext(), 50000 );
                        AppDataStore.UpdateBankView();
                    }

                    @Override
                    public void doCancel() {
                        //nothing
                    }
                });
            }
        });
    }
}