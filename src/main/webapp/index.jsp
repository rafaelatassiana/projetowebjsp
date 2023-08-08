<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container w-100">
    <div class="justify-content-center w-100">
        <h1>Shoes Happy</h1>
        <form>
            <div class="form-group">
                <label for="exampleName">Nome</label>
                <input type="text" class="form-control" id="exampleName" aria-describedby="nameHelp" placeholder="Digite o nome">
            </div>
            <div class="form-group">
                <label for="exampleRegistration">Matricula</label>
                <input type="text" class="form-control" id="exampleRegistration" placeholder="Matricula">
            </div>
            <div class="form-group">
                <label for="exampleAddress">Endereço</label>
                <input type="text" class="form-control" id="exampleAddress" placeholder="Endereço">
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="exampleRadios" id="fisica" value="1" checked>
                <label class="form-check-label" for="fisica">
                    Pessoa Física
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="exampleRadios" id="juridica" value="2">
                <label class="form-check-label" for="juridica">
                    Pessoa Jurídica
                </label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
