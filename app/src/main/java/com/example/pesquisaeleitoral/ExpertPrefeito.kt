import com.example.pesquisaeleitoral.R

class ExpertPrefeito {
    fun getCandidato(tipo: String?): List<Any> {
        val candidato: MutableList<Any> = mutableListOf()
        when (tipo) {
            "Junio" -> {
                candidato.add("Junio")
                candidato.add("10")
                candidato.add("IF GOIANO")
                candidato.add(R.drawable.gabriel) // ID da imagem
            }
            "Viviam" -> {
                candidato.add("Viviam")
                candidato.add("20")
                candidato.add("GTI")
                candidato.add(R.drawable.vivian)
            }
            "Gabriel" -> {
                candidato.add("Gabriel")
                candidato.add("30")
                candidato.add("SI IA")
                candidato.add(R.drawable.gabriel)
            }
            "Paulo" -> {
                candidato.add("Paulo")
                candidato.add("40")
                candidato.add("SI")
                candidato.add(R.drawable.paulo)
            }
        }
        return candidato
    }
}
