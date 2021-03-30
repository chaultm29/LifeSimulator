package com.example.lifesimulator.Model;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lifesimulator.Interface.IConfirm;
import com.example.lifesimulator.Interface.IGame;
import com.example.lifesimulator.R;

import java.util.ArrayList;

public class AppDialog {

    public static void InfoDialog(Context context, String info, Boolean status){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_information);

        TextView txtInfo = (TextView) dialog.findViewById(R.id.txtInfo);
        Button btnOK = (Button) dialog.findViewById(R.id.btnOK);
        ImageView imgStatus = (ImageView) dialog.findViewById(R.id.imgStatus);

        if (status != null) {
            if (status) imgStatus.setImageResource(R.drawable.true_image);
            else imgStatus.setImageResource(R.drawable.false_image);
        }

        txtInfo.setText(info);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public static void ConfirmDialog(Context context, String info, IConfirm confirm){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_confirm);

        TextView txtInfo = (TextView) dialog.findViewById(R.id.txtInfo2);
        Button btnAgree = (Button) dialog.findViewById(R.id.btnAgree);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        txtInfo.setText(info);
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm.doAgree();
                dialog.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm.doCancel();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public enum GameName {VIETLOTT, BIT}
    public static void EzGameDialog(Context context, GameName gName, IGame game){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_game_easy);

        TextView txtInfo = (TextView) dialog.findViewById(R.id.txtInfo3);
        Button btnLeft = (Button) dialog.findViewById(R.id.btnLeft);
        Button btnRight = (Button) dialog.findViewById(R.id.btnRight);
        ImageView imgDes = (ImageView) dialog.findViewById(R.id.imgDes);

        if (gName == GameName.VIETLOTT) {
           txtInfo.setText("Hôm nay trời đẹp làm con Vietlott đổi đời xem sao.\n1000/vé");
           imgDes.setImageResource(R.drawable.logo_vietlott);
           btnLeft.setText("Mua");
           btnRight.setText("Không mua");
        }
        if (gName == GameName.BIT){
            txtInfo.setText("Nhân phẩm đang lên, pick là trúng\n5000 ăn 10000");
            imgDes.setImageResource(R.drawable.coin);
            btnLeft.setText("Chẵn");
            btnRight.setText("Lẻ");
        }
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bonus = -1;
                if (gName == GameName.VIETLOTT) bonus = game.play(29);
                if (gName == GameName.BIT)  bonus = game.play(0);
                if (bonus > 0){
                    InfoDialog(view.getContext(), "Chúc mừng bạn đã vác về " + bonus + " đồng", true);
                } else if (bonus == 0) {
                    InfoDialog(view.getContext(), "Ngã ở đâu, gấp đôi ở đó !", false);
                }
                dialog.dismiss();
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gName == GameName.BIT) {
                    int bonus = game.play(1);
                    if (bonus > 0) {
                        InfoDialog(view.getContext(), "Chúc mừng bạn đã vác về " + bonus + " đồng", true);
                    } else if (bonus == 0) {
                        InfoDialog(view.getContext(), "Ngã ở đâu, gấp đôi ở đó !", false);
                    }
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public static void QuestionDialog(Context context, Question question){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_question);

        TextView txtQuestion = (TextView) dialog.findViewById(R.id.txtQuestion);

        Button btnAnw1 = (Button) dialog.findViewById(R.id.btnAnswer1);
        Button btnAnw2 = (Button) dialog.findViewById(R.id.btnAnswer2);
        Button btnAnw3 = (Button) dialog.findViewById(R.id.btnAnswer3);
        Button btnAnw4 = (Button) dialog.findViewById(R.id.btnAnswer4);
        txtQuestion.setText(question.getQues());

        ArrayList<Button> list = new ArrayList<Button>();
        list.add(btnAnw1);
        list.add(btnAnw2);
        list.add(btnAnw3);
        list.add(btnAnw4);
        for (int i = 0; i< list.size(); i++) {
            Button btn = list.get(i);
            btn.setText(question.getAnsArr()[i]);
            btn.setTag(i == question.getAnswer());
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InfoDialog(view.getContext(), (boolean)btn.getTag()?"Chính xác":"Sai", (boolean)btn.getTag());
                    dialog.dismiss();
                }
            });
        }
        dialog.show();
    }
}
