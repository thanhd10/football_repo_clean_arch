package com.example.football_exp.presentation.player_list

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
import com.example.football_exp.presentation.models.Player
import javax.inject.Inject

class PlayerListFragment : Fragment(), PlayerListContract.View {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    @Inject lateinit var mPresenter: PlayerListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_player_list, container, false)
        Injector.footballDataComponent.inject(this)

        mPresenter.setView(this)

        return view
    }

    override fun onResume() {
        super.onResume()

        val args = arguments
        if(args != null) {
            mPresenter.handlePlayersOfTeam(args.getInt(BundleCodes.TEAM_ID.toString()))
        }else {
            mPresenter.handlePlayersOfTeam(BuildConfig.FOOTBALL_DATA_INIT_TEAM_ID)
        }
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onUnbind()
    }

    override fun showPlayers(players: List<Player>) {
        viewManager = LinearLayoutManager(this.activity)
        viewAdapter = PlayerAdapter(players)

        this.activity!!.findViewById<RecyclerView>(R.id.player_recyclerview).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun showErrorMessage() {
        Toast.makeText(this.activity, "Failed to load player data", Toast.LENGTH_LONG).show()
    }
}
