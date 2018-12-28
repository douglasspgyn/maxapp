package douglasspgyn.com.github.maxapp.common.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
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
                orderNumberRcaAndErp.text = span(context.getString(R.string.order_number_rca_erp, order.numeroPedidoRca, order.numeroPedidoErp), 16)
                orderClient.text = span(context.getString(R.string.order_client, order.codigoCliente, order.nomeDoCliente), 8)
                orderStatus.text = order.status
                orderDateTime.text = getDateTimeFormated(order.datetime)

                if (order.critica.isEmpty()) {
                    orderReviewContainer.gone()
                } else {
                    orderReviewContainer.visible()
                }

                if (order.legendas.isEmpty()) {
                    orderSubtitle.gone()
                } else {
                    orderSubtitle.visible()
                }
            }
        }

        private fun span(text: String, colorChangePosition: Int): Spannable {
            val spannable: Spannable = SpannableString(text)
            spannable.setSpan(ForegroundColorSpan(Color.parseColor("#95989A")), 0, colorChangePosition, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            spannable.setSpan(ForegroundColorSpan(Color.parseColor("#000000")), colorChangePosition, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            return spannable
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