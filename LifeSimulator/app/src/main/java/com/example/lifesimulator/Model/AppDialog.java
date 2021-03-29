package com.example.lifesimulator.Model;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lifesimulator.R;

import java.util.ArrayList;

public class AppDialog {

    public static void InfoDialog(String info, Boolean status, Context context){
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

    public static void QuestionDialog(Question question, Context context){
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
                    InfoDialog((boolean)btn.getTag()?"Chính xác":"Sai", (boolean)btn.getTag(), view.getContext());
                    dialog.dismiss();
                }
            });
        }
        dialog.show();
    }
}
