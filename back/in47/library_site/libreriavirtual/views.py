from django.shortcuts import render
from django.contrib.auth import authenticate, login, logout
from rest_framework import status, generics
from rest_framework.response import Response
from rest_framework.views import APIView
from .serializers import UserSerializer

# Create your views here.

class SignupView(generics.CreateAPIView):
    serializer_class = UserSerializer

class LoginView(APIView):
    def post(self, request):
        # Recuperamos las credenciales y atutenticamos al usuario
        email = request.data.get('email', None)
        password = request.data.get('password', None)
        user = authenticate(email=email, password=password)

        # Si es correcto aniadimos a la request la informacion de sesion
        if user:
            login(request, user)
            return Response(
                UserSerializer(user).data,
                status=status.HTTP_200_OK)
        
        # Si no es correcto devolvemos un error en la peticion
        return Response(
            status=status.HTTP_404_NOT_FOUND)
        

class LogoutView(APIView):
    def post(self, request):
        # Borramos de la request la informacion de sesion
        logout(request)

        # Devolvemos la respuesta al cliente
        return Response(status=status.HTTP_200_OK)
    