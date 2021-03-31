package com.example.lifesimulator.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lifesimulator.Interface.IGame;
import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.Model.AppDialog;
import com.example.lifesimulator.Interface.IConfirm;
import com.example.lifesimulator.R;

import java.util.Random;


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
        Button btnGVietlot = view.findViewById(R.id.btnGVietlott);
        Button btnGBillionaire = view.findViewById(R.id.btnGBillionaire);
        Button btnGBit = view.findViewById(R.id.btnGBit);
        Button btnGReal = view.findViewById(R.id.btnGReal);

        btnWithdraw25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().withdraw(view.getContext(), 25 );
            }
        });
        btnWithdraw50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().withdraw(view.getContext(), 50 );
            }
        });
        btnWithdraw75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().withdraw(view.getContext(), 75 );
            }
        });
        btnSave25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().saveMoney(view.getContext(), 25 );
            }
        });
        btnSave50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().saveMoney(view.getContext(), 50 );
            }
        });
        btnSave75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.getBank().saveMoney(view.getContext(), 75 );
            }
        });
        btnLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDialog.ConfirmDialog(view.getContext(), "Vay ngân hàng 10 000 với lãi suất 7%/năm, trả góp 5 năm. Sau 5 năm lãi suất 15%", new IConfirm() {
                    @Override
                    public void doAgree() {
                        AppDataStore.identity.getBank().getLoan(view.getContext(), 10000 );
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
                    }

                    @Override
                    public void doCancel() {
                        //nothing
                    }
                });
            }
        });

        btnGVietlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDialog.EzGameDialog(view.getContext(), AppDialog.GameName.VIETLOTT, new IGame() {
                    @Override
                    public int play(int select) {
                        int bonus = -1;
                        if (AppDataStore.identity.getBank().decrease(view.getContext(), 1000)){
                            int value = AppDataStore.Generate(10, 99);
                            bonus = value == select? 1000000: 0;
                            AppDataStore.identity.getBank().increase(bonus);
                        }
                        return bonus;
                    }
                });
            }
        });

        btnGBit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDialog.EzGameDialog(view.getContext(), AppDialog.GameName.BIT, new IGame() {
                    @Override
                    public int play(int select) {
                        int bonus = -1;
                        if (AppDataStore.identity.getBank().decrease(view.getContext(), 5000)){
                            Random random = new Random();
                            int value = random.nextInt(2);
                            bonus = value == select? 10000: 0;
                            AppDataStore.identity.getBank().increase(bonus);
                        }
                        return bonus;
                    }
                });
            }
        });
    }
}