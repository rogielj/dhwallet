package com.digitalhouse.dhwallet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.Adapter.TransactionAdapter
import com.digitalhouse.dhwallet.model.Transaction

private const val ARG_IN = "param1"
private const val ARG_OUT = "param2"

class TransactionFragment : Fragment(), TransactionAdapter.OnClickListener {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_IN)
            param2 = it.getString(ARG_OUT)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val in01view = view.findViewById<TextView>(R.id.value_left)
        val in02view = view.findViewById<TextView>(R.id.value_right)
        param1.let {
            in01view.text = it
        }
        param2.let{
            in02view.text = it
        }
        // Função que inicia o fragmento transferência
        startFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_transaction, container, false)

        val itensTransaction: MutableList<Transaction> = mutableListOf(
            Transaction(
                "Dribble Inc.", "Pagamento", value = "+ R$45,00","https://icons-for-free.com/iconfiles/png/512/dribble+outline+social+media+icon-1320193495457640297.png",
            ),
            Transaction(
                "Spotify Family", "Pagamento", "- R$ 163","https://play-lh.googleusercontent.com/dwyqtk9CgAaoXUcYB8pUHXRErF5A2Shd0UrZdBLkpAFx_e630aZahwN31HRZWNksIQ"
            ),
            Transaction(
                "Netflix", "Pagamento", "+ R$ 35,00","https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Netflix_icon.svg/2048px-Netflix_icon.svg.png"
            ),
            Transaction(
                "Netflix", "Pagamento", "+ R$ 55,00","https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Netflix_icon.svg/2048px-Netflix_icon.svg.png"
            ),
            Transaction(
                "Netflix", "Pagamento", "+ R$ 25,00","https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Netflix_icon.svg/2048px-Netflix_icon.svg.png"
            ),
            Transaction(
                "Dribble Inc.", "Pagamento", "+ R$ 45,00","https://icons-for-free.com/iconfiles/png/512/dribble+outline+social+media+icon-1320193495457640297.png"
            )
        )

        val recycler = v.findViewById<RecyclerView>(R.id.recycler_trans)
        recycler.adapter = TransactionAdapter(itensTransaction, this)

        return v
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransactionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_IN, param1)
                    putString(ARG_OUT, param2)
                }
            }
    }

    override fun onClick(transaction: Transaction){

        Log.d("Teste",transaction.title)
    }

    private fun startFragment (){
        val v = requireView().findViewById<TextView>(R.id.title_transaction_inicial)
        v.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, TransferFragment())
                .addToBackStack(TransferFragment::class.java.name)
                .commit()
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.add(R.id.fragmentContainer, TransferFragment())
//                ?.addToBackStack(null)
//                ?.commit()
        }
    }
}