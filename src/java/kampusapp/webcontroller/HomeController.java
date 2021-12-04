/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.webcontroller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kampusapp.dao.KampusDAO;
import kampusapp.dao.KampusDAOProses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import kampusapp.model.Kas;

/**
 *
 * @author 62878
 */
@Controller
public class HomeController {

    KampusDAO mhsDAO = null;

    public HomeController() {
        mhsDAO = new KampusDAOProses();
    }

    private int getSumGet() {
        return mhsDAO.sumGet();
    }

    private int getSumOut() {
        return mhsDAO.sumOut();
    }

    private int getSaldo() {
        return mhsDAO.sumGet() - mhsDAO.sumOut();
    }

    private ModelAndView listMahasiswa(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<Kas> theList = mhsDAO.get();
        List<Kas> listKeluar = mhsDAO.out();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listMahasiswa", theList);
        modelAndView.addObject("listKeluar", listKeluar);
        modelAndView.addObject("saldo", getSaldo());
        modelAndView.addObject("jumlahin", getSumGet());
        modelAndView.addObject("jumlahout", getSumOut());

        return modelAndView;
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        return listMahasiswa(req, res);
    }

}
