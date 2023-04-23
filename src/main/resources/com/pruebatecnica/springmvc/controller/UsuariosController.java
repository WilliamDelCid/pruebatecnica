package com.pruebatecnica.springmvc.controller;

import com.pruebatecnica.springmvc.dao.UsuarioDao;
import com.pruebatecnica.springmvc.model.Usuarios;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    UsuarioDao usuarioDao;

    @RequestMapping("/usuario")
    public String usuariosList(Model model){
        List<Usuarios> listUsuarios = usuarioDao.list();
        model.addAttribute("listaUsuarios",listUsuarios);
        return "usuarios";
    }

    @RequestMapping(value="/agregar",params={"registrar"})
    public String registrarEstudiantes(@ModelAttribute Usuarios usuarios, final BindingResult bindingResult){
        String password = BCrypt.hashpw(usuarios.getPassword(), BCrypt.gensalt());

//        usuarioDao.guardar(new Usuarios(usuarios.getUser(),password,usuarios.get()));
        usuarioDao.guardar(usuarios);
        return "redirect:/usuario";
    }

  @GetMapping("/editar")
    @ResponseBody
    public Usuarios editar(Integer id,Model model){
        return usuarioDao.obtener(id);
  }



    @RequestMapping(value="/eliminar/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        usuarioDao.eliminar(id);
        return "redirect:/usuario";
    }


}
