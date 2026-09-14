package data.model

data class SignUpRequest(
    val username: String,
    val email: String,
    val password: String,
)


data class SignInRequst(
    val email: String,
    val password: String
)