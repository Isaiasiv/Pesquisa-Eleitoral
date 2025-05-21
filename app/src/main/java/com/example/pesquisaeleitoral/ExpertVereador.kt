import com.example.pesquisaeleitoral.R

class ExpertVereador {
    fun getCandidato(tipo: String?): List<Any> {
        val candidato: MutableList<Any> = mutableListOf()
        when (tipo) {
            "Julio" -> {
                candidato.add("Julio")
                candidato.add("10 111")
                candidato.add("MATEMATICA")
                candidato.add(R.drawable.julio) // ID da imagem
            }
            "Jocivam" -> {
                candidato.add("Jocivam")
                candidato.add("24 100")
                candidato.add("WEB")
                candidato.add(R.drawable.paulo)
            }
            "Amaury" -> {
                candidato.add("Amaury")
                candidato.add("15 000")
                candidato.add("SI")
                candidato.add(R.drawable.amaury)
            }
            "Paulo" -> {
                candidato.add("Paulo")
                candidato.add("40 454")
                candidato.add("SI")
                candidato.add(R.drawable.pauloa)
            }
            "Rachel" -> {
                candidato.add("Rachel")
                candidato.add("50 555")
                candidato.add("SI IA")
                candidato.add(R.drawable.racheu)
            }
            "Jaime" -> {
                candidato.add("Jaime")
                candidato.add("60 254")
                candidato.add("SI")
                candidato.add(R.drawable.jamile)
            }
        }
        return candidato
    }
}
