package healofy.demo

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import healofy.demo.adapter.SubjectAdapter
import healofy.demo.base.BaseActivity
import healofy.demo.databaseclass.SongsDB
import healofy.demo.databinding.ActivityMainBinding
import healofy.demo.viewmodel.MainViewModel
import java.util.*


@AndroidEntryPoint
@ActivityScoped
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(){
    var subjectAdapter: SubjectAdapter? = null
    var displaySongs = ArrayList<SongsDB>() as List<SongsDB>
    var categories: MutableList<String> = ArrayList()
    var items: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)
        initView()
    }

    private fun initView() {
        mViewModel.getSongsInfoo().observe(this, Observer {
            displaySongs = it
            if (displaySongs.size == 0) {
                setupObservers()
            } else {
                setupUI(displaySongs)
            }
        })
    }

    private fun setupUI(displaySongs: List<SongsDB>) {
        categories.add("Artist")
        categories.add("Album")
        var adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, categories)
        mViewBinding.spinner1.adapter = adapter

        items.add("1")
        items.add("2")
        val adapter1 = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, items)
        mViewBinding.spinner2.adapter = adapter1


        subjectAdapter = SubjectAdapter(this!!, displaySongs)
        mViewBinding.rcView.setLayoutManager(LinearLayoutManager(this))
        mViewBinding.rcView.setAdapter(subjectAdapter)

    }

    private fun setupObservers() {
        mViewModel.putSongsData().observe(this, Observer {
            if (it != null) {
                for (i in it.payload.songList.indices) {
                    var songsDB = SongsDB()
                    songsDB.album = it.payload.songList.get(i).album
                    songsDB.artist = it.payload.songList.get(i).artist
                    songsDB.name = it.payload.songList.get(i).name
                    mViewModel.insertPost(songsDB)
                }

            }
        })
    }

    override val mViewModel: MainViewModel by viewModels()
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


}