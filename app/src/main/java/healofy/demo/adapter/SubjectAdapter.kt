package healofy.demo.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import healofy.demo.R
import healofy.demo.databaseclass.SongsDB


class SubjectAdapter(
    var activity: Activity,
    var displaySongs: List<SongsDB>
):RecyclerView.Adapter<SubjectAdapter.RecycelrViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectAdapter.RecycelrViewHolder {
        return SubjectAdapter.RecycelrViewHolder(
            LayoutInflater.from(activity).inflate(
                R.layout.single_subject,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return displaySongs.size
    }

    override fun onBindViewHolder(holder: SubjectAdapter.RecycelrViewHolder, position: Int) {
      holder.rvChapters.setAdapter(ChapterAdapter(activity, displaySongs))
        holder.rvChapters.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        holder.tvSubjectName.setText(displaySongs.get(position).artist)

    }

    fun updateData(displaySongs: List<SongsDB>) {

    }

    class RecycelrViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvSubjectName: TextView = view.findViewById(R.id.tvSubjectName)
        var rvChapters: RecyclerView =view.findViewById(R.id.rvChapters)
    }
}