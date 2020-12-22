package healofy.demo.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import healofy.demo.R
import healofy.demo.databaseclass.SongsDB

class ChapterAdapter(var activity: Activity, var songsDB: List<SongsDB>) :
    RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterAdapter.ViewHolder {
        return ChapterAdapter.ViewHolder(
            LayoutInflater.from(activity).inflate(
                R.layout.single_chapter,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return songsDB.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val chapter: SongsDB = songsDB.get(position)
        holder.tvChapterName.setText(chapter.name)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvChapterName: TextView = view.findViewById(R.id.tvChapterName)
    }
}
