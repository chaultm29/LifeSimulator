package com.example.lifesimulator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifesimulator.Fragment.WorkProcessFragment;
import com.example.lifesimulator.Interface.IConfirm;
import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.Model.AppDialog;
import com.example.lifesimulator.Model.Job;
import com.example.lifesimulator.Model.Question;
import com.example.lifesimulator.Model.University;
import com.example.lifesimulator.R;

import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {
    private List<Job> mListJob;
    private List<University> mListUniversity;
    private Fragment mFragment;

    public WorkAdapter(Fragment fragment) {
        if (true) this.mListJob = AppDataStore.jobs;
        else
            this.mListUniversity = AppDataStore.universities;
        mFragment = fragment;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job, parent, false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        if (true){
            Job job = mListJob.get(position);
            System.out.println(job.getName());
            if(job==null)
                return;
            holder.imgJob.setImageResource(job.getResourceID());
            holder.title.setText(job.getName());
            holder.interactButton.setText("Apply");
            holder.description.setText(String.valueOf(job.getGrossSalary()));
        } else {
            System.out.println(position);
            University university = mListUniversity.get(position);
            System.out.println(university.getName());
            if(university==null)
                return;
            holder.imgJob.setImageResource(university.getResourceID());
            holder.title.setText(university.getName());
            holder.interactButton.setText("Apply");
            holder.description.setText(university.getMajor());
        }

    }

    @Override
    public int getItemCount() {
        if (true){
            if(mListJob!=null){
                return mListJob.size();
            }
        } else {
            if(mListUniversity!=null){
                return  mListUniversity.size();
            }
        }
        return 0;
    }

    public class WorkViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgJob;
        private TextView title;
        private Button interactButton;
        private TextView description;


        public WorkViewHolder(@NonNull View itemView) {
            super(itemView);

            imgJob = itemView.findViewById(R.id.img_job);
            title = itemView.findViewById(R.id.job_title);
            interactButton = itemView.findViewById(R.id.interact_button_job);
            description = itemView.findViewById(R.id.description_work);

            interactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    AppDialog.InfoDialog(view.getContext(), "hi", null);
//                    Question q = new Question("hiii", new String[]{"um", "uk", "uh", "ò"}, 3);
//                    AppDialog.QuestionDialog(view.getContext(),q);
                    if (true){
                        AppDataStore.identity.setJob(mListJob.get(getAdapterPosition()));
                        Question q = new Question("Dưới nước có 3 con vịt, hỏi ông thuyền trưởng bao tuổi?", new String[]{"20", "3 xịch", "100 tủi", "Tào lao"}, 3);
                        AppDialog.QuestionDialog(view.getContext(), q, new IConfirm() {
                            @Override
                            public void doAgree() {
                                if(AppDialog.getResult()){
                                    mFragment.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.job_select, new WorkProcessFragment()).commit();
                                    mListJob = null;
                                    mListUniversity = null;
                                    notifyDataSetChanged();
                                }
                            }

                            @Override
                            public void doCancel() {

                            }
                        });
                    }
                    else {

                        AppDataStore.identity.setUniversity(mListUniversity.get(getAdapterPosition()));
                        //AppDialog.InfoDialog(view.getContext(), "hi", null);
                        Question q = new Question("Dưới nước có 3 con vịt, hỏi ông thuyền trưởng bao tuổi?", new String[]{"20", "3 xịch", "100 tủi", "Tào lao"}, 3);
                        AppDialog.QuestionDialog(view.getContext(), q, new IConfirm() {
                            @Override
                            public void doAgree() {
                                if(AppDialog.getResult()){
                                    mFragment.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.job_select, new WorkProcessFragment()).commit();
                                    mListJob = null;
                                    mListUniversity = null;
                                    notifyDataSetChanged();
                                }
                            }

                            @Override
                            public void doCancel() {

                            }
                        });
                    }
                }
            });
        }
    }
}
