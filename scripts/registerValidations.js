document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("register").addEventListener('submit', validarFormulario);
 });
 
 function validarFormulario(evento) {
   evento.preventDefault();
   const message = document.getElementById("alert");
   var name = document.getElementById("name").value;
   var lastname = document.getElementById("lastname").value;
   var email = document.getElementById("email").value;
   var pass = document.getElementById("pass").value;
   var pass2 = document.getElementById("pass2").value;

   if (name.length == 0) {
     message.classList.replace("invisible", "visible");
     message.innerHTML = "Por favor, escribe tu nombre";
     setTimeout(() => (message.innerHTML = ""), 1900);
     setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
     return;
   }
   if (name.length < 3) {
    message.classList.replace("invisible", "visible");
    message.innerHTML = "Por favor, escribe un nombre valido";
    setTimeout(() => (message.innerHTML = ""), 1900);
    setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
    return;
  }
   if (lastname.length == 0) {
     message.classList.replace("invisible", "visible");
     message.innerHTML = "Por favor, escribe tu apellido";
     setTimeout(() => (message.innerHTML = ""), 1900);
     setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
     return;
   }
   if (lastname.length < 3) {
    message.classList.replace("invisible", "visible");
    message.innerHTML = "Por favor, escribe un apellido valido";
    setTimeout(() => (message.innerHTML = ""), 1900);
    setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
    return;
  }
   if (email.length == 0) {
     message.classList.replace("invisible", "visible");
     message.innerHTML = "Por favor, escribe tu correo electronico";
     setTimeout(() => (message.innerHTML = ""), 1900);
     setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
     return;
   }
   if (email.length < 5 || !email.includes("@") || !email.includes(".")) {
     message.classList.replace("invisible", "visible");
     message.innerHTML = "Por favor, escribe un correo valido";
     setTimeout(() => (message.innerHTML = ""), 1900);
     setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
     return;
   }
   if (pass.length == 0) {
     message.classList.replace("invisible", "visible");
     message.innerHTML = "Por favor, escribe tu contraseña";
     setTimeout(() => (message.innerHTML = ""), 1900);
     setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
     return;
   }
   if (pass2.length == 0) {
     message.classList.replace("invisible", "visible");
     message.innerHTML = "Por favor, repite tu contraseña";
     setTimeout(() => (message.innerHTML = ""), 1900);
     setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
     return;
   }
   if (pass != pass2) {
     message.classList.replace("invisible", "visible");
     message.innerHTML = "Las contraseñas no coinciden";
     setTimeout(() => (message.innerHTML = ""), 1900);
     setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
     return;
   }
   if (pass.length < 6) {
    message.classList.replace('invisible', 'visible');
    message.innerHTML='La clave debe tener al menos 6 caraceres';
    setTimeout(()=> message.innerHTML= "",1900);
    setTimeout(()=> message.classList.replace('visible', 'invisible'),1900);
    return;
  }
   if (!document.getElementById("check").checked) {
    message.classList.replace("invisible", "visible");
    message.innerHTML = "Debe aceptar los terminos y condiciones";
    setTimeout(() => (message.innerHTML = ""), 1900);
    setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
    return;
   }
   this.submit();
   alert("Registro exitoso!");
 }
 
 
 