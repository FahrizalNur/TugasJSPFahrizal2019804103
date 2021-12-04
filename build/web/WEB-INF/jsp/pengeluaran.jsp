<%-- 
    Document   : pengeluaran
    Created on : Dec 4, 2021, 12:54:04 AM
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
            <h1>Add Pengeluaran ${message}</h1><hr/>
            <div class=""row">
                <div class="col-md-4">
                    <form action="pengeluaran.htm"
                          modelAttribute="out" method="post">
                        <div class="form-group">
                            <input type="date" class="form-control" name="tanggal" placeholder="Tanggal" value="${out.tanggal}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="nama" placeholder="Nama" value="${out.nama}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="keterangan" placeholder="Keterangan" value="${out.keterangan}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="jumlah" placeholder="Jumlah" value="${out.jumlah}"/>
                        </div>
                        <input type="hidden" name="idtransaksi" value="${out.idtransaksi != null ? out.idtransaksi : 0}"/>

                        <button type ="submit" class="btn btn-primary">Save</button>
                    </form>
                </div> 
            </div>
            <a href="${pageContext.request.contextPath}/home.htm">Back to List</a>
        </div>
    </body>
</html>
