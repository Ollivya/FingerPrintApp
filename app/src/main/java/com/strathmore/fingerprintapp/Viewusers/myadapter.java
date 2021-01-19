package com.strathmore.fingerprintapp.Viewusers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.strathmore.fingerprintapp.R;


public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
    {


        public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
            super(options);
        }

        @Override
        protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {

            holder.DateofBirth.setText(model.getDateofBirth());
            holder.Email.setText(model.getEmail());
            holder.Fullname.setText(model.getFullName());
            holder.Gender.setText(model.getGender());
            holder.Phone.setText(model.getPhone());
            holder.Course.setText(model.getCourse());
        }

        @NonNull
        @Override
        public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item,parent,false);
           return new myviewholder(view);
        }

        class myviewholder extends RecyclerView.ViewHolder
        {
            TextView DateofBirth, Email, Fullname, Gender, Phone, Course;

            public myviewholder(@NonNull View itemView) {

                super(itemView);
                DateofBirth=(TextView)itemView.findViewById(R.id.dateofbirth_text);
                Email=(TextView)itemView.findViewById(R.id.email_text);
                Fullname=(TextView)itemView.findViewById(R.id.fullname_text);
                Gender=(TextView)itemView.findViewById(R.id.gender);
                Phone=(TextView)itemView.findViewById(R.id.phone_text);
                Course = (TextView)itemView.findViewById(R.id.course_text);
            }
        }


}
