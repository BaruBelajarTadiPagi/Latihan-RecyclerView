package com.adityabrian.latihanrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_superhero.view.*

class SuperHeroAdapter(private val list:ArrayList<SuperHero>):RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder>(){

        /** dEKLARASIKAN INTERFACENYA DALAM ADAPTER KITA*/
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemWithCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class SuperHeroViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        fun bind(superHero:SuperHero){
            with(itemView){
                tv_name.text = superHero.name
                tv_deskripsi.text = superHero.deskripsi

                    /** cara bacanya, saat itemView ini di klik dia bisa di panggil di activity(superHero)*/
                itemView.setOnClickListener{ onItemClickCallback?.onItemClick(superHero)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_superhero,parent,false)
        return SuperHeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback{
        fun onItemClick(data : SuperHero)
    }
}