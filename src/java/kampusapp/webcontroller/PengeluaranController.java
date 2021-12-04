/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.webcontroller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import kampusapp.dao.KampusDAO;
import kampusapp.dao.KampusDAOProses;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kampusapp.model.Kas;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 62878
 */
public class PengeluaranController {

    KampusDAO mhsDAO = null;

    public PengeluaranController() {
        mhsDAO = new KampusDAOProses();
    }

    @RequestMapping(value = "/pengeluaran")
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res) {
        String action = req.getParameter("action");
        ModelAndView modelAndView;
        if (action == null) {
            action = "ADD";
        }
        switch (action.toUpperCase()) {
            case "EDIT":
                modelAndView = editMahasiswa(req, res);
                break;
            case "DELETE":
                modelAndView = deleteMahasiswa(req, res);
                break;
            case "LOGOUT":
                return new ModelAndView("redirect:/login.htm");
            default:
                modelAndView = addMahasiswa(req, res);
                break;
        }
        return modelAndView;

    }

    @RequestMapping(value = "/pengeluaran", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("out") Kas mh) {
        ModelAndView modelAndView = new ModelAndView("redirect:/pengeluaran.htm");
        if (mh.getIdtransaksi() != 0) {

            if (mhsDAO.outupdate(mh)) {
                return new ModelAndView("redirect:/home.htm");
            } else {
                modelAndView.addObject("message", "Error Save");
            }
        } else {
            if (mhsDAO.outsave(mh)) {
                return new ModelAndView("redirect:/home.htm");

            } else {
                modelAndView.addObject("message", "Error Save");
            }
        }
        return modelAndView;

    }

    private ModelAndView editMahasiswa(HttpServletRequest req, HttpServletResponse res) {
        String idtransaksi = req.getParameter("idtransaksi");
        Kas mah = mhsDAO.outSinggle(Integer.parseInt(idtransaksi));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("out", mah);
        return modelAndView;
    }

    private ModelAndView deleteMahasiswa(HttpServletRequest req, HttpServletResponse res) {
        String idtransaksi = req.getParameter("idtransaksi");
        if (mhsDAO.outdelete(Integer.parseInt(idtransaksi))) {
            return new ModelAndView("redirect:/home.htm");
        } else {
            req.setAttribute("message", "gagal delete");
            return addMahasiswa(req, res);
        }
    }

    private ModelAndView addMahasiswa(HttpServletRequest req, HttpServletResponse res) {
        if (req.getParameter("message") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", req.getParameter("message"));
            return modelAndView;
        }
        return new ModelAndView();
    }
}
