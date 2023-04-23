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
public class LoginController {
    @Autowired
    UsuarioDao usuarioDao;

    @RequestMapping("/")
    public String login(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        session.invalidate();
        return "login";
    }

    @RequestMapping("/validar")
    public String registrarUsuario(@ModelAttribute Usuarios usuarios, final BindingResult bindingResult, HttpServletRequest req){

        Usuarios usuarioBase = usuarioDao.obtenerUser(usuarios.getUser());
        if (usuarioBase == null){
            return "redirect:/";
        }
        if (BCrypt.checkpw(usuarios.getPassword(),usuarioBase.getPassword())){
            HttpSession session = req.getSession();
            session.setAttribute("usuario", usuarios.getUser());
            return  "redirect:/usuario";
        }else{
            return "redirect:/";
        }

    }

}
