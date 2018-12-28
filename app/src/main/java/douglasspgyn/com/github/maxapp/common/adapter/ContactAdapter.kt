package douglasspgyn.com.github.maxapp.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.extension.formSpanColor
import douglasspgyn.com.github.maxapp.common.extension.formValidateNotInformedField
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
                contactPhone.text = context.getString(R.string.contact_phone, contact.telefone.formValidateNotInformedField(context)).formSpanColor(9)
                contactCellPhone.text = context.getString(R.string.contact_cellphone, contact.celular.formValidateNotInformedField(context)).formSpanColor(8)
                contactPartner.text = context.getString(R.string.contact_partner, contact.conjuge.formValidateNotInformedField(context)).formSpanColor(8)
                contactType.text = context.getString(R.string.contact_type, contact.tipo.formValidateNotInformedField(context)).formSpanColor(5)
                contactHobbie.text = context.getString(R.string.contact_hobbie, contact.hobbie.formValidateNotInformedField(context)).formSpanColor(7)
                contactEmail.text = context.getString(R.string.contact_email, contact.email.formValidateNotInformedField(context)).formSpanColor(7)
                contactBornDate.text = context.getString(R.string.contact_borndate, contact.dataDeNascimento.formValidateNotInformedField(context)).formSpanColor(11)
                contactPartnerBornDate.text = context.getString(R.string.contact_partner_borndate, contact.dataNascimentoConjuge.formValidateNotInformedField(context)).formSpanColor(19)
                contactTeam.text = context.getString(R.string.contact_team, contact.time.formValidateNotInformedField(context)).formSpanColor(5)
            }
        }
    }
}