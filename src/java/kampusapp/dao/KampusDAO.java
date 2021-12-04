/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.dao;

import java.util.List;
import kampusapp.model.Kas;

/**
 *
 * @author 62878
 */
public interface KampusDAO {

    List<Kas> get();

    Kas getSinggle(int idtransaksi);

    boolean save(Kas mahasiswa);

    boolean update(Kas mahasiswa);

    boolean delete(int idtransaksi);

    List<Kas> out();

    Kas outSinggle(int idtransaksi);

    boolean outsave(Kas out);

    boolean outupdate(Kas out);

    boolean outdelete(int idtransaksi);

    int sumGet();

    int sumOut();
}
