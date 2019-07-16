package com.example.football_exp.presentation.competition_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.football_exp.R
import com.example.football_exp.presentation.models.Competition

class CompetitionAdapter(private val competitions: List<Competition>, private val clickListener: (Competition) -> Unit):
    RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder>() {


    class CompetitionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val view: View = itemView
        private val nation: TextView = view.findViewById(R.id.single_competition_nation)
        private val name: TextView = view.findViewById(R.id.single_competition_name)
        private val plan: TextView = view.findViewById(R.id.single_competition_plan)

        fun bindCompetition(competition: Competition, clickListener: (Competition) -> Unit){
            nation.text = competition.nation
            name.text = competition.competitionName
            plan.text = competition.plan
            view.setOnClickListener { clickListener(competition)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CompetitionViewHolder {
        return CompetitionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_competition_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return competitions.size
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val competition = competitions[position]
        holder.bindCompetition(competition, clickListener)
    }

}