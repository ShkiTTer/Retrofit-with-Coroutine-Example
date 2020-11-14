package com.example.repoexample.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.repoexample.R
import com.example.repoexample.data.net.common.Network
import com.example.repoexample.data.net.common.NetworkPriority
import com.example.repoexample.data.net.priority.PriorityRepository
import com.example.repoexample.data.net.repo.RepoDataSourceImpl
import com.example.repoexample.domain.repo.RepoDataSource
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val repoDataSource: RepoDataSource = RepoDataSourceImpl(Network.retrofit)
    private val priorityRepository = PriorityRepository(NetworkPriority.getInstance())
    private val priorityAdapter = PriorityAdapter()
    private val repoAdapter = RepoAdapter() // Use for show repositories from Github Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

        getAllPriorities()
    }

    private fun initView() {
        repoRecycler.apply {
            adapter = priorityAdapter
            ContextCompat.getDrawable(this@MainActivity, R.drawable.repo_separator)?.let {
                addItemDecoration(RepoItemDecoration(it))
            }
        }
    }

    private fun getAllRepoList() {
        GlobalScope.launch(Dispatchers.Main) {
            val repoList = withContext(Dispatchers.IO) {
                try {
                    repoDataSource.getAllRepoList()
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            } ?: return@launch

            repoAdapter.setItems(repoList)
        }
    }

    private fun getAllPriorities() {
        GlobalScope.launch(Dispatchers.Main) {
            val priorityList = withContext(Dispatchers.IO) {
                priorityRepository.getAllPriorities()
            }

            priorityAdapter.setItems(priorityList)
        }
    }
}