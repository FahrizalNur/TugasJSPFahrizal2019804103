/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kampusapp.model.DatabaseConfig;
import kampusapp.model.Kas;

/**
 *
 * @author 62878
 */
public class KampusDAOProses implements KampusDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Kas> get() {
        List<Kas> list = null;
        Kas mhs = null;
        try {
            list = new ArrayList<Kas>();
            String sql = "SELECT * FROM tbl_pemasukan";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                mhs = new Kas();
                mhs.setIdtransaksi(resultSet.getInt("idtransaksi"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setTanggal(resultSet.getString("tanggal"));
                mhs.setJumlah(resultSet.getInt("jumlah"));
                mhs.setKeterangan(resultSet.getString("keterangan"));
                list.add(mhs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Kas mahasiswa) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO tbl_pemasukan (nama, tanggal, jumlah, keterangan)VALUES"
                    + "(?,?,?,?)";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mahasiswa.getNama());
            preparedStatement.setString(2, mahasiswa.getTanggal());
            preparedStatement.setInt(3, mahasiswa.getJumlah());
            preparedStatement.setString(4, mahasiswa.getKeterangan());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return flag;
    }

    @Override
    public Kas getSinggle(int idtransaksi) {
        Kas mhs = null;
        try {
            String sql = "SELECT * FROM tbl_pemasukan where idtransaksi=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idtransaksi);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mhs = new Kas();
                mhs.setIdtransaksi(resultSet.getInt("idtransaksi"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setTanggal(resultSet.getString("tanggal"));
                mhs.setJumlah(resultSet.getInt("jumlah"));
                mhs.setKeterangan(resultSet.getString("keterangan"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mhs;
    }

    @Override
    public boolean update(Kas mahasiswa) {
        boolean flag = false;
        try {
            String sql = "update tbl_pemasukan set nama=?, tanggal=?, jumlah=?, keterangan=? where idtransaksi=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mahasiswa.getNama());
            preparedStatement.setString(2, mahasiswa.getTanggal());
            preparedStatement.setInt(3, mahasiswa.getJumlah());
            preparedStatement.setString(4, mahasiswa.getKeterangan());
            preparedStatement.setInt(5, mahasiswa.getIdtransaksi());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return flag;
    }

    @Override
    public boolean delete(int idtransaksi) {
        boolean flag = false;
        try {
            String sql = "delete from tbl_pemasukan where idtransaksi=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idtransaksi);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Kas> out() {
        List<Kas> list = null;
        Kas out = null;
        try {
            list = new ArrayList<Kas>();
            String sql = "SELECT * FROM tbl_pengeluaran";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                out = new Kas();
                out.setIdtransaksi(resultSet.getInt("idtransaksi"));
                out.setNama(resultSet.getString("nama"));
                out.setTanggal(resultSet.getString("tanggal"));
                out.setJumlah(resultSet.getInt("jumlah"));
                out.setKeterangan(resultSet.getString("keterangan"));
                list.add(out);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Kas outSinggle(int idtransaksi) {
        Kas out = null;
        try {
            String sql = "SELECT * FROM tbl_pengeluaran where idtransaksi=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idtransaksi);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                out = new Kas();
                out.setIdtransaksi(resultSet.getInt("idtransaksi"));
                out.setNama(resultSet.getString("nama"));
                out.setTanggal(resultSet.getString("tanggal"));
                out.setJumlah(resultSet.getInt("jumlah"));
                out.setKeterangan(resultSet.getString("keterangan"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return out;
    }

    @Override
    public boolean outsave(Kas out) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO tbl_pengeluaran (nama, tanggal, jumlah, keterangan)VALUES"
                    + "(?,?,?,?)";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, out.getNama());
            preparedStatement.setString(2, out.getTanggal());
            preparedStatement.setInt(3, out.getJumlah());
            preparedStatement.setString(4, out.getKeterangan());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return flag;
    }

    @Override
    public boolean outupdate(Kas out) {
        boolean flag = false;
        try {
            String sql = "update tbl_pengeluaran set nama=?, tanggal=?, jumlah=?, keterangan=? where idtransaksi=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, out.getNama());
            preparedStatement.setString(2, out.getTanggal());
            preparedStatement.setInt(3, out.getJumlah());
            preparedStatement.setString(4, out.getKeterangan());
            preparedStatement.setInt(5, out.getIdtransaksi());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return flag;
    }

    @Override
    public boolean outdelete(int idtransaksi) {
        boolean flag = false;
        try {
            String sql = "delete from tbl_pengeluaran where idtransaksi=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idtransaksi);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public int sumGet() {
        int totalKasMasuk = 0;
        try {
            String sql = "SELECT Sum(jumlah) from tbl_pemasukan";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int c = resultSet.getInt(1);
                totalKasMasuk = totalKasMasuk + c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalKasMasuk;
    }

    @Override
    public int sumOut() {
        int totalKasKeluar = 0;
        try {
            String sql = "SELECT Sum(jumlah) from tbl_pengeluaran";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int c = resultSet.getInt(1);
                totalKasKeluar = totalKasKeluar + c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalKasKeluar;
    }

}
