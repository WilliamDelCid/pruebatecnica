package com.pruebatecnica.springmvc.controller;

import com.pruebatecnica.springmvc.dao.UsuarioDao;
import com.pruebatecnica.springmvc.model.Usuarios;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("usuario")
public class UsuariosController {

    @Autowired
    UsuarioDao usuarioDao;

    @RequestMapping("/usuario")
    public String usuariosList(Model model, HttpServletRequest req, HttpServletResponse resp){

        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") == null) {
            return "redirect:/";
        } else {
            List<Usuarios> listUsuarios = usuarioDao.list();
            model.addAttribute("listaUsuarios",listUsuarios);
            return "usuarios";
        }


    }

    @RequestMapping(value="/agregar",params={"registrar"})
    public String registrarUsuario(@ModelAttribute Usuarios usuarios, final BindingResult bindingResult, HttpServletRequest req){

        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") == null) {
            return "redirect:/";
        } else {
            String password = BCrypt.hashpw(usuarios.getPassword(), BCrypt.gensalt());
            usuarioDao.guardar(new Usuarios(usuarios.getUser(),password,usuarios.getRol()));
            return "redirect:/usuario";
        }

    }
    @RequestMapping(value="/editar",params={"EditarRegistro"})
    public String editarRegistro(@ModelAttribute Usuarios usuarios, final BindingResult bindingResult, HttpServletRequest req){

        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") == null) {
            return "redirect:/";
        } else {
            String password = BCrypt.hashpw(usuarios.getPassword(), BCrypt.gensalt());
            usuarioDao.actualizar(new Usuarios(usuarios.getIdUser(),usuarios.getUser(),password,usuarios.getRol()));
            return "redirect:/usuario";
        }

    }

      @GetMapping("/editar")
        @ResponseBody
        public Usuarios editar(Integer id,Model model){
            return usuarioDao.obtener(id);
      }



    @RequestMapping(value="/eliminar/{id}")
    public String deleteUser(@PathVariable("id") Integer id, HttpServletRequest req){
        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") == null) {
            return "redirect:/";
        } else {
            usuarioDao.eliminar(id);
            return "redirect:/usuario";
        }



    }


}
