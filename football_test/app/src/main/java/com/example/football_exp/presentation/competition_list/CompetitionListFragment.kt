package com.example.football_exp.presentation.competition_list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.football_exp.BundleCodes
import com.example.football_exp.R
import com.example.football_exp.core.di.Injector
import com.example.football_exp.presentation.models.Competition
import com.example.football_exp.presentation.team_list.TeamListFragment
import javax.inject.Inject

class CompetitionListFragment: Fragment(), CompetitionListContract.View {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    @Inject lateinit var mPresenter: CompetitionListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_competion_list, container, false)
        Injector.footballDataComponent.inject(this)

        mPresenter.setView(this)

        return view
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadCompetitions()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onUnbind()
    }


    override fun showCompetitions(competitions: List<Competition>) {
        viewManager = LinearLayoutManager(this.activity)
        viewAdapter = CompetitionAdapter(competitions) { competition ->  onCompetitionItemClicked(competition)}

        this.activity!!.findViewById<RecyclerView>(R.id.competition_recyclerview).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onCompetitionItemClicked(competition: Competition){
        val newTeamListFragment = TeamListFragment()
        val args = Bundle()
        args.putInt(BundleCodes.COMPETITION_ID.toString(), competition.competitionId)
        newTeamListFragment.arguments = args
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_competition_list_id, newTeamListFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun showErrorMessage() {
        Toast.makeText(this.activity, "Failed to load competition data", Toast.LENGTH_LONG).show()
    }
}