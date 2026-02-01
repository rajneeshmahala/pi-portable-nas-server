
interface ApiService {
    suspend fun system(token: String): Map<String, String>
}
