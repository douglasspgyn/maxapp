package douglasspgyn.com.github.maxapp.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.Constant
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
                stub?.layoutResource = when (order.tipo) {
                    Constant.ERP_TYPE_PROCESSING -> R.layout.erp_status_processing
                    Constant.ERP_TYPE_REFUSED -> R.layout.erp_status_refused
                    Constant.ERP_TYPE_PENDING -> R.layout.erp_status_pending
                    Constant.ERP_TYPE_BLOCKED -> R.layout.erp_status_blocked
                    Constant.ERP_TYPE_RELEASED -> R.layout.erp_status_released
                    Constant.ERP_TYPE_MOUNTED -> R.layout.erp_status_mounted
                    Constant.ERP_TYPE_BILLED -> R.layout.erp_status_billed
                    Constant.ERP_TYPE_CANCELED -> R.layout.erp_status_canceled
                    Constant.ERP_TYPE_BUDGET -> R.layout.erp_status_budget
                    else -> R.layout.erp_status_processing
                }
                stub?.inflate()

                orderNumberRcaAndErp.text = context.getString(R.string.order_number_rca_erp, order.numeroPedidoRca, order.numeroPedidoErp).formSpanColor(16)
                orderClient.text = context.getString(R.string.order_client, order.codigoCliente, order.nomeDoCliente).formSpanColor(8)
                orderStatus.text = order.status
                orderDateTime.text = getDateTimeFormated(order.datetime)
                orderValue.text = context.getString(R.string.order_value, order.valor)

                if (order.critica.isEmpty()) {
                    orderReviewContainer.gone()
                } else {
                    when (order.critica) {
                        Constant.REVIEW_WAITING_ERP -> orderReviewIcon.setImageDrawable(context.getDrawable(R.drawable.ic_maxima_aguardando_critica))
                        Constant.REVIEW_SUCCESS -> orderReviewIcon.setImageDrawable(context.getDrawable(R.drawable.ic_maxima_critica_sucesso))
                        Constant.REVIEW_PARTIAL_FAILURE -> orderReviewIcon.setImageDrawable(context.getDrawable(R.drawable.ic_maxima_critica_alerta))
                        Constant.REVIEW_TOTAL_FAILURE -> orderReviewIcon.setImageDrawable(context.getDrawable(R.drawable.ic_maxima_critica_falha))
                    }
                    orderReviewContainer.visible()
                }

                orderSubtitleCutted.gone()
                orderSubtitleMissing.gone()
                orderSubtitleCanceled.gone()
                orderSubtitleReturn.gone()
                orderSubtitleTelemarketing.gone()

                order.legendas.forEach {
                    when (it) {
                        Constant.ORDER_CUTTED -> orderSubtitleCutted.visible()
                        Constant.ORDER_MISSING -> orderSubtitleMissing.visible()
                        Constant.ORDER_CANCELED -> orderSubtitleCanceled.visible()
                        Constant.ORDER_RETURN -> orderSubtitleReturn.visible()
                        Constant.ORDER_BY_TELEMARKETING -> orderSubtitleTelemarketing.visible()
                    }
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