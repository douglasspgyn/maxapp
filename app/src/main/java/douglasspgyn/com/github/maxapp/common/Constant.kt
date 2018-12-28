package douglasspgyn.com.github.maxapp.common

object Constant {

    const val ERP_TYPE_PROCESSING: String = "PROCESSANDO"
    const val ERP_TYPE_REFUSED: String = "RECUSADO"
    const val ERP_TYPE_PENDING: String = "PENDENTE"
    const val ERP_TYPE_BLOCKED: String = "BLOQUEADO"
    const val ERP_TYPE_RELEASED: String = "LIBERADO"
    const val ERP_TYPE_MOUNTED: String = "MONTADO"
    const val ERP_TYPE_BILLED: String = "FATURADO"
    const val ERP_TYPE_CANCELED: String = "CANCELADO"
    const val ERP_TYPE_BUDGET: String = "ORCAMENTO"

    const val REVIEW_WAITING_ERP: String = "AGUARDANDO_RETORNO_DO_ERP"
    const val REVIEW_SUCCESS: String = "SUCESSO"
    const val REVIEW_PARTIAL_FAILURE: String = "FALHA_PARCIAL"
    const val REVIEW_TOTAL_FAILURE: String = "FALHA_TOTAL"

    const val ORDER_CUTTED: String = "PEDIDO_SOFREU_CORTE"
    const val ORDER_MISSING: String = "PEDIDO_COM_FALTA"
    const val ORDER_CANCELED: String = "PEDIDO_CANCELADO_ERP"
    const val ORDER_RETURN: String = "PEDIDO_COM_DEVOLUCAO"
    const val ORDER_BY_TELEMARKETING: String = "PEDIDO_FEITO_TELEMARKETING"
}