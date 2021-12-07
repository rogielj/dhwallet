package com.digitalhouse.dhwallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.Adapter.ContactAdapter
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType

class TransferFragment : Fragment(R.layout.fragment_transfer) {

    //  Do jetio acima só funciona para passar um layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itensInteractions: MutableList<Contact> = mutableListOf(

            Contact(
                image = "https://static.glamurama.uol.com.br/2020/11/leleco2.jpg",
                name = "João",
                type = ContactType.AMIGO
            ),

            Contact(
                image = "https://observatoriog.bol.uol.com.br/wordpress/wp-content/uploads/2019/04/lisa-1.jpg",
                name = "Lisa",
                type = ContactType.AMIGA
            ),

            Contact(
                image = "https://yt3.ggpht.com/ytc/AKedOLQfFwyLBwXFHHmpYJlSMk6A_aruzxcDdERsAAdn=s900-c-k-c0x00ffffff-no-rj",
                name = "Cailou",
                type = ContactType.IRMAO
            ),

            Contact(
                image = "https://gartic.com.br/imgs/mural/al/aloklok/ana-catarina-p-sofia-angel.png",
                name = "Ana Catarina",
                type = ContactType.IRMA
            ),
            Contact(
                image = "https://static.vecteezy.com/ti/vetor-gratis/p1/2124893-uma-unica-linha-desenho-de-jovem-mae-feliz-segurando-sua-filha-uma-mae-brincando-junto-com-seu-filho-em-casa-isolado-no-fundo-branco-familia-paternidade-conceito-ilustracao-vetor.jpg",
                name = "Mainha",
                type = ContactType.MAE
            ),
            Contact(
                image = "https://img.elo7.com.br/product/zoom/2B34508/matriz-bordado-minie-da-angola.jpg",
                name = "Conjuge",
                type = ContactType.ESPOSA
            ),
            Contact(
                image = "https://static.glamurama.uol.com.br/2020/11/leleco2.jpg",
                name = "João",
                type = ContactType.AMIGO
            ),

            Contact(
                image = "https://observatoriog.bol.uol.com.br/wordpress/wp-content/uploads/2019/04/lisa-1.jpg",
                name = "Lisa",
                type = ContactType.AMIGA
            ),

            Contact(
                image = "https://yt3.ggpht.com/ytc/AKedOLQfFwyLBwXFHHmpYJlSMk6A_aruzxcDdERsAAdn=s900-c-k-c0x00ffffff-no-rj",
                name = "Cailou",
                type = ContactType.IRMAO
            ),

            Contact(
                image = "https://gartic.com.br/imgs/mural/al/aloklok/ana-catarina-p-sofia-angel.png",
                name = "Ana Catarina",
                type = ContactType.IRMA
            ),
            Contact(
                image = "https://static.vecteezy.com/ti/vetor-gratis/p1/2124893-uma-unica-linha-desenho-de-jovem-mae-feliz-segurando-sua-filha-uma-mae-brincando-junto-com-seu-filho-em-casa-isolado-no-fundo-branco-familia-paternidade-conceito-ilustracao-vetor.jpg",
                name = "Mainha",
                type = ContactType.MAE
            ),
            Contact(
                image = "https://img.elo7.com.br/product/zoom/2B34508/matriz-bordado-minie-da-angola.jpg",
                name = "Conjuge",
                type = ContactType.ESPOSA
            )
        )

        val recycler = view.findViewById<RecyclerView>(R.id.recycler1)
        recycler.adapter = ContactAdapter(itensInteractions)

        // Essa parte foi colocado no layout, caso queira layout horizontal, faça dessa forma

//        recycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
    }

}