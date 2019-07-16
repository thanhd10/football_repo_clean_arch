package com.example.football_exp.presentation.player_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.football_exp.R
import com.example.football_exp.presentation.models.Player

class PlayerAdapter(private val players: List<Player>): RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    class PlayerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var view: View = itemView
        private val playerName: TextView = view.findViewById(R.id.single_player_item_name)
        private val nationality: TextView = view.findViewById(R.id.single_player_item_nationality)
        private val playerPosition: TextView = view.findViewById(R.id.single_player_item_position)

        fun bindPlayer(player: Player){
            playerName.text = player.name
            nationality.text = player.nationality
            playerPosition.text = player.position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_player_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.bindPlayer(player)
    }
}