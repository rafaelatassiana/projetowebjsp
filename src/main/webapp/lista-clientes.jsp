<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container w-100">
    <div class="justify-content-center w-100">
        <h1 style="margin-bottom:70px">Shoes Happy - Lista de Clientes</h1>
        <table class="table">
          <thead>
            <tr>
                <th scope="col">Nome</th>
                <th scope="col">Matricula</th>
                <th scope="col">Endereco</th>
                <th scope="col">Tipo Pessoa</th>
                <th scope="col">Ação</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.getNome()}</td>
                    <td>${cliente.getMatricula()}</td>
                    <td>${cliente.getEndereco()}</td>
                    <td>${cliente.getTipoPessoa()}</td>
                    <td>
                        <a class="add" title="" data-toggle="tooltip" data-original-title="delete">
                            <i class="fa fa-pencil-square-o" style="color:orange;cursor: pointer;" aria-hidden="true"></i>
                        </a>
                        <a class="add" title="" data-toggle="tooltip" data-original-title="delete">
                            <i class="fa fa-trash" style="color:red;cursor: pointer;" onclick="javascript:DeletarCliente('${cliente.getId()}')" aria-hidden="true"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
        <button class="btn btn-primary" onclick="window.location='criar-cliente.jsp'">Cadastrar Cliente</button>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript">
        DeletarCliente = function(cliente){
            console.log(cliente);
            if (window.confirm("Deseja deletar o cliente?")) {
                document.location.href="deletarCliente?id="+cliente;
            }
        }
</script>
</body>
</html>
