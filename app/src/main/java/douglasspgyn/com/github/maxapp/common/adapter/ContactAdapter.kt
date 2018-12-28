package douglasspgyn.com.github.maxapp.common.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.extension.formSpanColor
import douglasspgyn.com.github.maxapp.common.extension.inflate
import douglasspgyn.com.github.maxapp.model.Contato
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(private val contacts: List<Contato>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(parent.inflate(R.layout.item_contact))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int = contacts.size

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contact: Contato) {
            with(itemView) {
                contactName.text = contact.nome
                contactPhone.text = context.getString(R.string.contact_phone, replaceEmptyText(context, contact.telefone)).formSpanColor(9)
                contactCellPhone.text = context.getString(R.string.contact_cellphone, replaceEmptyText(context, contact.celular)).formSpanColor(8)
                contactPartner.text = context.getString(R.string.contact_partner, replaceEmptyText(context, contact.conjuge)).formSpanColor(8)
                contactType.text = context.getString(R.string.contact_type, replaceEmptyText(context, contact.tipo)).formSpanColor(5)
                contactEmail.text = context.getString(R.string.contact_email, replaceEmptyText(context, contact.email)).formSpanColor(7)
                contactBornDate.text = context.getString(R.string.contact_borndate, replaceEmptyText(context, contact.dataDeNascimento)).formSpanColor(11)
                contactPartnerBornDate.text = context.getString(R.string.contact_partner_borndate, replaceEmptyText(context, contact.dataNascimentoConjuge)).formSpanColor(19)
                contactTeam.text = context.getString(R.string.contact_team, replaceEmptyText(context, contact.time)).formSpanColor(5)
            }
        }

        private fun replaceEmptyText(context: Context, text: String): String = if (text.isEmpty()) context.getString(R.string.not_informed) else text
    }
}