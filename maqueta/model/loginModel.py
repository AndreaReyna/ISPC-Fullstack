import persona
import mysql.connector

class Conectar(persona):

    def __init__(self) -> None:
        try:
            self.conexion = mysql.connector.connect(
                host = 'localhost',
                port = 3306,
                user = 'root',
                password = 'root',
                db = 'libreria_db'

            )
        except mysql.connector.Error as descripcionError:
            print("¡Error en la conexion!",descripcionError)

    def validarLogin(self, email, password):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                sentenciaSQL= """SELECT * FROM Usuario (email, password) WHERE email=%s AND password=%s"""
                cursor.execute(sentenciaSQL)
                resultadoREAD = cursor.fetchall()
                self.conexion.close()
                return resultadoREAD
                
            except:
                print("No se pudo concectar a la base de datos")