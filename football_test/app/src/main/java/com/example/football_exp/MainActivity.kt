package com.example.football_exp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.football_exp.presentation.competition_list.CompetitionListFragment
import com.example.football_exp.presentation.player_list.PlayerListFragment
import com.example.football_exp.presentation.team_list.TeamListFragment

class MainActivity: AppCompatActivity() {

    private val NAVIGATION_HOME = R.id.navigation_home
    private val NAVIGATION_DASHBOARD = R.id.navigation_dashboard
    private val NAVIGATION_NOTIFICATIONS = R.id.navigation_notifications

    private val playerListFragment: PlayerListFragment = PlayerListFragment()
    private val competitionListFragment: CompetitionListFragment = CompetitionListFragment()
    private val teamListFragment: TeamListFragment = TeamListFragment()

    private val fm: FragmentManager = supportFragmentManager
    private var activeFragment: Fragment = playerListFragment

    private lateinit var navigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById(R.id.navigation)
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.main_container, teamListFragment).hide(teamListFragment).commit()
        fm.beginTransaction().add(R.id.main_container, competitionListFragment).hide(competitionListFragment).commit()
        fm.beginTransaction().add(R.id.main_container, playerListFragment).commit()
    }

    private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            selectedItem ->
        when (selectedItem.itemId) {
            NAVIGATION_HOME -> {
                fm.beginTransaction().hide(activeFragment).show(playerListFragment).commit()
                activeFragment = playerListFragment
                navigationView.checkItem(NAVIGATION_HOME)
            }
            NAVIGATION_DASHBOARD -> {
                fm.beginTransaction().hide(activeFragment).show(competitionListFragment).commit()
                activeFragment = competitionListFragment
                navigationView.checkItem(NAVIGATION_DASHBOARD)
            }
            NAVIGATION_NOTIFICATIONS -> {
                fm.beginTransaction().hide(activeFragment).show(teamListFragment).commit()
                activeFragment = teamListFragment
                navigationView.checkItem(NAVIGATION_NOTIFICATIONS)
            }
        }
        false
    }

    private fun BottomNavigationView.checkItem(actionId: Int){
        menu.findItem(actionId)?.isChecked = true
    }
}
