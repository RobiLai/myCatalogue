
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<title>Catalogo Prodotti</title>
</head>
<body>
<h1>Catalogo Prodotti</h1>


<#if prodottoDaModificare != null >
<h2>Modifica del prodotto - ${prodottoDaModificare.nome}</h2>
<div>
<form method="POST" action="update" id="datiProdotto">
<input type="hidden" name="id" value="${prodottoDaModificare.id}"/>
<div>
<label for="nome">Nome</label>
<input type="text" name="nome" id="nome" value="${prodottoDaModificare.nome}"/>
<label for="prezzo">Prezzo</label>
<input type="number" name="prezzo" id="nome" value="${prodottoDaModificare.prezzo}"/>
</div>
<div>
<input type="submit" name="invia" value="Modifica"/>
</div>
</form>
</div>
<h2>Lista Prodotti</h2>
<div>
<table>
<thead>
<tr>
<th>Nome</th>
<th>Prezzo</th>
<th>Azioni</th>
</tr>
</thead>
<tbody>
<#list listaProdotti as prodotto>
<tr>
<td>${prodotto.nome}</td>
<td>${prodotto.prezzo}</td>
<td>
<a href="delete?id=${prodotto.id}">Elimina</a>
<a href="?id=${prodotto.id}">Modifica</a>
</td>
</tr>
</list>
</tbody>
</table>
</div>


<#else>

<h2>Nuovo Prodotto</h2>
<div>
<form method="POST" action="add" id="datiProdotto">
<div>
<label for="nome">Nome</label>
<input type="text" name="nome" id="nome" value=""/>
<label for="prezzo">Prezzo</label>
<input type="number" name="prezzo" id="nome" value=""/>
</div>
<div>
<input type="submit" name="invia" value="Aggiungi"/>
</div>
</form>
</div>
<h2>Lista Prodotti</h2>
<div>
<table>
<thead>
<tr>
<th>Nome</th>
<th>Prezzo</th>
<th>Azioni</th>
</tr>
</thead>
<tbody>
<#list listaProdotti as prodotto>
<tr>
<td>${prodotto.nome}</td>
<td>${prodotto.prezzo}</td>
<td>
<a href="delete?id=${prodotto.id}">Elimina</a>
<a href="?id=${prodotto.id}">Modifica</a>
</td>
</tr>
</list>
</tbody>
</table>
</div>


</#if>

</body>
</html>