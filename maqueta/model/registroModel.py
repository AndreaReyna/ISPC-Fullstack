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
            print("¡No se conectó!",descripcionError)

    def agregarUsuario(self, nombre, apellido, email, password):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                sentenciaSQL= """INSERT INTO Usuarios (nombre, apellido, email, password) VALUES (%s,%s,%s,%s)"""
                data= (nombre, apellido, email, password)

                cursor.execute(sentenciaSQL,data)
                self.conexion.commit()
                self.conexion.close()

            except:
                print("No se pudo concectar a la base de datos")
   
    def buscarUsuario(self, email):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                sentenciaSQL= """SELECT * from Usuarios (email) WHERE email=%s"""
                cursor.execute(sentenciaSQL)
                resultadoREAD = cursor.fetchall()
                self.conexion.close()
                return resultadoREAD

            except:
                print("No se pudo concectar a la base de datos")

    def eliminarUsuario(self,id):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                sentenciaSQL = """DELETE from Usuario (id) where id=%s"""
                cursor.execute(sentenciaSQL)

                self.conexion.commit()                
                self.conexion.close()
            except:
                print("No se pudo concectar a la base de datos")