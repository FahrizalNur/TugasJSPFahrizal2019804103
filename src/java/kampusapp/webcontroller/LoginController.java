/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kampusapp.dao.KampusDAO;
import kampusapp.dao.KampusDAOProses;
import kampusapp.model.LoginModel;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

/**
 *
 * @author 62878
 */
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    KampusDAO mhsDAO = null;

    public LoginController() {
        mhsDAO = new KampusDAOProses();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
        if (req.getParameter("message") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", req.getParameter("message"));
            return modelAndView;
        }
        return new ModelAndView();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") LoginModel emp, HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login.htm");
        if (emp.getusername() != null && emp.getpassword() != null) {
            if (emp.getusername().equalsIgnoreCase("rizal") && emp.getpassword().equalsIgnoreCase("rizal")) {
                return new ModelAndView("redirect:/home.htm");
            } else {
                modelAndView.addObject("message", "Username atau password salah");
            }

        } else {
            modelAndView.addObject("message", "username & password tidak boleh kbsong");
        }
        return modelAndView;
    }
}
