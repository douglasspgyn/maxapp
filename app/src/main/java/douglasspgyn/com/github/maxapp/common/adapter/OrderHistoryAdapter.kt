package douglasspgyn.com.github.maxapp.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.extension.formSpanColor
import douglasspgyn.com.github.maxapp.common.extension.gone
import douglasspgyn.com.github.maxapp.common.extension.inflate
import douglasspgyn.com.github.maxapp.common.extension.visible
import douglasspgyn.com.github.maxapp.model.Pedido
import kotlinx.android.synthetic.main.item_order_history.view.*
import java.text.SimpleDateFormat
import java.util.*

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
                orderNumberRcaAndErp.text = context.getString(R.string.order_number_rca_erp, order.numeroPedidoRca, order.numeroPedidoErp).formSpanColor(16)
                orderClient.text = context.getString(R.string.order_client, order.codigoCliente, order.nomeDoCliente).formSpanColor(8)
                orderStatus.text = order.status
                orderDateTime.text = getDateTimeFormated(order.datetime)
                orderValue.text = context.getString(R.string.order_value, order.valor)

                if (order.critica.isEmpty()) {
                    orderReviewContainer.gone()
                } else {
                    orderReviewContainer.visible()
                }

                if (order.legendas.isEmpty()) {
                    orderSubtitle1.gone()
                    orderSubtitle2.gone()
                } else {
                    orderSubtitle1.visible()
                    orderSubtitle2.visible()
                }
            }
        }

        private fun getDateTimeFormated(date: Date): String {
            val oneDay = 60 * 60 * 24

            return if (date.time > System.currentTimeMillis() - oneDay) {
                SimpleDateFormat("HH:mm", Locale.getDefault()).format(date)
            } else {
                SimpleDateFormat("dd MMM", Locale.getDefault()).format(date)
            }
        }
    }
}