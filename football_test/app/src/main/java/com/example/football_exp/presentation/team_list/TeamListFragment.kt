package com.example.football_exp.presentation.team_list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.football_exp.BuildConfig
import com.example.football_exp.BundleCodes
import com.example.football_exp.R
import com.example.football_exp.core.di.Injector
import com.example.football_exp.presentation.models.Team
import com.example.football_exp.presentation.player_list.PlayerListFragment
import javax.inject.Inject

class TeamListFragment: Fragment(), TeamListContract.View {

    private lateinit var viewAdapter: TeamAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    @Inject lateinit var mPresenter: TeamListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_team_list, container, false)
        Injector.footballDataComponent.inject(this)

        mPresenter.setView(this)

        return view
    }

    override fun onResume() {
        super.onResume()

        val args = arguments
        if (args != null) {
            mPresenter.loadTeamsOfCompetition(args.getInt(BundleCodes.COMPETITION_ID.toString()))
        }
        else {
            mPresenter.loadTeamsOfCompetition(BuildConfig.FOOTBALL_DATA_INIT_COMPETITION_ID)
        }
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onUnbind()
    }

    override fun showTeams(teams: List<Team>) {
        viewManager = LinearLayoutManager(this.activity)
        viewAdapter = TeamAdapter(teams) { team -> onTeamItemClicked(team)}

        this.activity!!.findViewById<RecyclerView>(R.id.team_recyclerview).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onTeamItemClicked(team: Team){
        val newPlayerListFragment = PlayerListFragment()
        val args = Bundle()
        args.putInt(BundleCodes.TEAM_ID.toString(), team.teamId)
        newPlayerListFragment.arguments = args
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_team_list_id, newPlayerListFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun showErrorMessage() {
        Toast.makeText(this.activity, "Failed to load team data", Toast.LENGTH_LONG).show()
    }

}