package com.example.football_exp.presentation.team_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.football_exp.R
import com.example.football_exp.presentation.models.Team

class TeamAdapter(private val teams: List<Team>, private val clickListener: (Team) -> Unit):
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var view: View = itemView
        private val teamName: TextView = view.findViewById(R.id.single_team_item_name)
        private val website: TextView = view.findViewById(R.id.single_team_item_website)

        fun bindTeam(team: Team, clickListener: (Team) -> Unit){
            teamName.text = team.name
            website.text = team.website
            view.setOnClickListener{ clickListener(team)}
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_team_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.bindTeam(team, clickListener)
    }

}