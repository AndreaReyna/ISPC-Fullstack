document.addEventListener("DOMContentLoaded", function () {
   document.getElementById("login").addEventListener('submit', validarFormulario);
});

function validarFormulario(evento) {
      evento.preventDefault();
      var email = document.getElementById('email').value;
      var pass = document.getElementById('pass').value;
      const message = document.getElementById('alert');

      if (email.length == 0) {
         message.classList.replace('invisible', 'visible');
         message.innerHTML='Por favor, escribe tu correo electronico';
         setTimeout(()=> message.innerHTML= "",1900);
         setTimeout(()=> message.classList.replace('visible', 'invisible'),1900);
         return;
      }
      if (email.length < 6 || !email.includes("@") || !email.includes(".")) {
         message.classList.replace("invisible", "visible");
         message.innerHTML = "Por favor, escribe un correo valido";
         setTimeout(() => (message.innerHTML = ""), 1900);
         setTimeout(() => message.classList.replace("visible", "invisible"), 1900);
         return;
       }
      if (pass.length == 0) {
        message.classList.replace('invisible', 'visible');
        message.innerHTML='Por favor, escribe tu clave';
        setTimeout(()=> message.innerHTML= "",1900);
        setTimeout(()=> message.classList.replace('visible', 'invisible'),1900);
        return;
      }
      if (pass.length < 6) {
         message.classList.replace('invisible', 'visible');
         message.innerHTML='Por favor, escribe una clave valida';
         setTimeout(()=> message.innerHTML= "",1900);
         setTimeout(()=> message.classList.replace('visible', 'invisible'),1900);
         return;
       }
      this.submit();
      alert("Inicio de sesión exitoso!");
   }

