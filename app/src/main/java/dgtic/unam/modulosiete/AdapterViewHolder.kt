package dgtic.unam.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import dgtic.unam.modulosiete.R

class AdapterViewHolder(private val context:Context,private val data:List<Data>):RecyclerView.Adapter<AdapterViewHolder.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val name:TextView
        val description:TextView
        val image:ImageView
        val constraint:ConstraintLayout
        init{
            name = view.findViewById(R.id.name_view)
            description = view.findViewById(R.id.description_view)
            image = view.findViewById(R.id.imageView)
            constraint = view.findViewById(R.id.data_constraint)
        }
    }
    // pasará el layout a viewholder para el pintado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li = LayoutInflater.from(parent.context)
        val v = li.inflate(R.layout.item_data,parent,false)
        return ViewHolder(v)
    }

    // Realizará el pintado de cada elemento
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = data[position]
        holder.name.text = info.name
        holder.description.text = info.description
        holder.image.setImageResource(R.drawable.ic_android_black_24dp)
        holder.constraint.setOnClickListener{
            Toast.makeText(context,"Item ${data[position].name}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}