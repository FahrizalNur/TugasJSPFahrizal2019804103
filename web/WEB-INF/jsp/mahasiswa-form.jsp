<%-- 
    Document   : mahasiswa-form
    Created on : Dec 1, 2021, 9:52:14 PM
    Author     : 62878
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Add Pemasukan ${message}</h1><hr/>
            <div class=""row">
                <div class="col-md-4">
                    <form action="mahasiswa-form.htm"
                          modelAttribute="mhs" method="post">
                        <div class="form-group">
                            <input type="date" class="form-control" name="tanggal" placeholder="Tanggal" value="${mhs.tanggal}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="nama" placeholder="Nama" value="${mhs.nama}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="keterangan" placeholder="Keterangan" value="${mhs.keterangan}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="jumlah" placeholder="Jumlah" value="${mhs.jumlah}"/>
                        </div>
                        <input type="hidden" name="idtransaksi" value="${mhs.idtransaksi != null ? mhs.idtransaksi : 0}"/>

                        <button type ="submit" class="btn btn-primary">Save</button>
                    </form>
                </div> 
            </div>
            <a href="${pageContext.request.contextPath}/home.htm">Back to List</a>
        </div>
    </body>
</html>
