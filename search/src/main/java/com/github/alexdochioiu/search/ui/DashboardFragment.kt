package com.github.alexdochioiu.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.alexdochioiu.androidnewsv2.appComponent
import com.github.alexdochioiu.search.DaggerFeatureComponent
import com.github.alexdochioiu.search.FeatureComponent
import com.github.alexdochioiu.search.R
import com.github.alexdochioiu.search_networking.di.DaggerSearchNetworkComponent

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })

        inject()
        return root
    }

    private val featureComponent: FeatureComponent by lazy {
        val searchNetworkComponent = DaggerSearchNetworkComponent
            .builder()
            .appComponent(this.activity!!.appComponent())
            .build()

        DaggerFeatureComponent
            .builder()
            .searchNetworkComponent(searchNetworkComponent)
            .build()
    }

    companion object {
        @JvmStatic
        fun featureComponent(fragment: DashboardFragment) =
            fragment.featureComponent

        fun DashboardFragment.inject() {
            featureComponent(this).inject(this)
        }
    }
}