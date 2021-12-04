<%-- 
    Document   : home
    Created on : Nov 28, 2021, 12:43:58 AM
    Author     : 62878
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        Welcome ${sessionScope.user.username}<a href="mahasiswa-form.htm?action=logout">Logout<a/>
            <h1>Laporan KAS Bulanan</h1>
            <h2>Sisa Saldo : Rp. ${saldo}</h2>
            <p>
                <button class="btn btn-primary"
                        onclick="window.location.href = 'mahasiswa-form.htm'">
                    Add Uang Kas Masuk
                </button>
            </p>
            <table class="table table-striped table-bordered align-middle">
                <tr class="table-primary">
                    <th>IDTransaksi</th>
                    <th>Tanggal</th>
                    <th>Nama</th>
                    <th>Keterangan</th>
                    <th>Pemasukan</th>
                    <th>Aksi</th>
                </tr>
                <c:forEach items="${listMahasiswa}" var="mhs">
                    <tr>
                        <td>${mhs.idtransaksi}</td>
                        <td>${mhs.tanggal}</td>
                        <td>${mhs.nama}</td>
                        <td>${mhs.keterangan}</td>
                        <td>Rp. ${mhs.jumlah}</td>
                        <td>
                            <button class="btn btn-primary"
                                    onclick="window.location.href = 'mahasiswa-form.htm?action=edit&idtransaksi=${mhs.idtransaksi}'">
                                Edit
                            </button>
                            <button class="btn btn-primary"
                                    onclick="window.location.href = 'mahasiswa-form.htm?action=delete&idtransaksi=${mhs.idtransaksi}'">
                                Delete
                            </button>      
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4" style="text-align: end">Total</td>
                    <td>Rp. ${jumlahin}</td>
                    <td></td>
                </tr>
            </table>

            <!--KAS KELUAR-->
            <p>
                <button class="btn btn-primary"
                        onclick="window.location.href = 'pengeluaran.htm'">
                    Add Uang Kas Keluar
                </button>
            </p>
            <table class="table table-striped table-bordered align-middle">
                <tr class="table-primary">
                    <th>IDTransaksi</th>
                    <th>Tanggal</th>
                    <th>Nama</th>
                    <th>Keterangan</th>
                    <th>Pengeluaran</th>
                    <th>Aksi</th>
                </tr>
                <c:forEach items="${listKeluar}" var="out">
                    <tr>
                        <td>${out.idtransaksi}</td>
                        <td>${out.tanggal}</td>
                        <td>${out.nama}</td>
                        <td>${out.keterangan}</td>
                        <td>Rp. ${out.jumlah}</td>
                        <td>
                            <button class="btn btn-primary"
                                    onclick="window.location.href = 'pengeluaran.htm?action=edit&idtransaksi=${out.idtransaksi}'">
                                Edit
                            </button>
                            <button class="btn btn-primary"
                                    onclick="window.location.href = 'pengeluaran.htm?action=delete&idtransaksi=${out.idtransaksi}'">
                                Delete
                            </button>      
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4" style="text-align: end">Total</td>
                    <td>Rp. ${jumlahout}</td>
                    <td></td>
                </tr>
            </table>

    </body>
</html>
