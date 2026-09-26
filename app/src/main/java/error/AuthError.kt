package error

sealed class AuthError() {

    class Validation(val message: String): AuthError()

}




