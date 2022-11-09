import loginModel

def validar(email, password):
    
    # enviamos el fetch del usuario al modelo
    resultado = loginModel.Conectar.validarLogin(email, password)
    
    if resultado.count() == 1: # usuario encontrado
        return resultado
        # enviamos a la vista dashboard del usuario o activamos un modal que indique que esta logeado

    else:

        # retornamos mensaje de no validacion
        print("Usuario o contraseña no valida")