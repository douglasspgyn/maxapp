package douglasspgyn.com.github.maxapp.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.extension.inflate
import douglasspgyn.com.github.maxapp.model.Pedido

class OrderHistoryAdapter(private val orders: List<Pedido>) : RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryViewHolder {
        return OrderHistoryViewHolder(parent.inflate(R.layout.item_order_history))
    }

    override fun onBindViewHolder(holder: OrderHistoryViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int = orders.size

    class OrderHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(order: Pedido) {
            with(itemView) {

            }
        }
    }
}