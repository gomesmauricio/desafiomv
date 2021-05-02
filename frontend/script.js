/*
function salvar() { 
										
    var json, pessoa,
		data 	= {},
		request = new XMLHttpRequest(),
		url 	= "http://localhost:8090/api/v1/pessoa";
		
	data.nome = document.getElementById('inputNome').value;		
	json 	  = JSON.stringify(data);
	
    request.open('POST', url, true);
	request.setRequestHeader("Content-Type", "application/json");
		
	request.onload = function () {
		
		pessoa = JSON.parse(request.responseText);
	
		if (request.readyState == 4 && request.status == "201") {
			console.table(pessoa);
		} else {
			console.error(pessoa);
		}
	}
	
	request.onerror = function() {
        console.log("Erro:"+request);
    };

    request.send(json);
	console.log(request.response);	
}
*/

function salvar(){
	var json,
		data = {};
		
		data.cpf = document.getElementById('inputcpf').value;	
		data.nome = document.getElementById('inputNome').value;
		data.opcao = document.getElementById('inputOpcao').value;		
		json 	  = JSON.stringify(data);
		
		$.ajax({
			url : "https://desafiomv.herokuapp.com/colaboradores",
			type: "POST",
			contentType:"application/json; charset=utf-8",
			data: json
		}).done( function( response ){
			//$('#registerForm')[0].reset();//limpa todos os campos do form
			toastr.success('Cadastro realizado com sucesso!');
		}).fail(function() {
			toastr.error('Failed!');
		});
}

/*
function alterar(){
	
	var pessoa, json,
		data 	= {},
		url  	= "http://localhost:8090/api/v1/pessoa",
		request = new XMLHttpRequest();
	
	data.id	  = document.getElementById('inputID').value;
	data.nome = document.getElementById('inputNome').value;
	json	  = JSON.stringify(data);
	
	//request.open("PUT", url+'/'+data.id, true);
	request.open("PUT", url, true);
	request.setRequestHeader("Content-type","application/json");
	
	request.onload = function () {
		
		pessoa = JSON.parse(request.responseText);
	
		if (request.readyState == 4 && request.status == "200") {
			console.table(pessoa);
			toastr.success('Alteração realizada com sucesso!');			
		} else {	
			console.error(pessoa);		
		}		
	}

	request.send(json);	
}
*/

function alterar(){
	var json,
		data = {};
		
		data.cpf	  = document.getElementById('inputcpf').value;
		data.nome = document.getElementById('inputNome').value;
		json	  = JSON.stringify(data);
		
		$.ajax({
			url : "https://desafiomv.herokuapp.com/colaboradores",
			type: "PUT",
			contentType:"application/json; charset=utf-8",
			data: json
		}).done( function( response ){
			//$('#registerForm')[0].reset();//limpa todos os campos do form
			toastr.success('Alteração realizada com sucesso!');
		}).fail(function() {
			toastr.error('Falhou!');
		});
}

/*
function excluir(){
	
	var pessoa,
		data 	= {},
		request = new XMLHttpRequest(),
		url 	= "http://localhost:8090/api/v1/pessoa";
	
	data.id = document.getElementById('inputID').value;
		
	request.open("DELETE", url+'/'+data.id, true);
	
	request.onload = function () {
		
		pessoa = JSON.parse(request.responseText);
	
		if (request.readyState == 4 && request.status == "200") {
			console.table(pessoa);
			toastr.success('Exclusão realizada com sucesso!');
		} else {
			console.error(pessoa);
		}
	}
	request.send(null);
}
*/

function excluir(){
	var data = {};
		
		data.cpf= document.getElementById('inputcpf').value;
				
		$.ajax({
			url : "https://desafiomv.herokuapp.com/colaboradores"+'/'+data.cpf,
			type: "DELETE",
			contentType:"application/json; charset=utf-8",
		}).done( function( response ){
			//$('#registerForm')[0].reset();//limpa todos os campos do form
			toastr.success('Exclusão realizada com sucesso!');
		}).fail(function() {
			toastr.error('Falhou!');
		});
}

/*
function listar() { 
	
	var resp, i, 
		txt 	= "",
		request = new XMLHttpRequest(),
		url 	= "http://localhost:8090/api/v1/pessoa";
                    
	request.open('GET', url, true);

    request.onload = function() {
		if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {

			resp = JSON.parse(request.responseText);
														
			txt += "<table style='width:53%' border='1' class='table table-hover'>"
			txt += "<thead class='thead-dark'>"
			txt += "<tr><th style='text-align:center'>Código</th><th>Nome</th></tr></thead>"
		
			for (i=0; i < resp.length; i++) {
				txt += "<tr><td style='text-align:center'>" + resp[i].id + "</td>";
				txt += "<td>" + resp[i].nome + "</td></tr>";
			}
				
			txt += "</table>"
			document.getElementById('tabela').innerHTML = txt;
			
		} else {
			console.error(request);
		}
	};

    request.onerror = function() {
        console.log("Erro:"+request);
		toastr.error('Falhou!');
    };
	
    request.send();    
}
*/

function listar(){
	var i, 
		txt = "";
		
		$.ajax({
			url : "https://desafiomv.herokuapp.com/colaboradores",
			type: "GET",
			contentType:"application/json; charset=utf-8"			
		}).done( function( response ){
			//$('#registerForm')[0].reset();//limpa todos os campos do form			
														
			txt += "<table style='width:60%' border='1'  class='table table-hover'>"
			txt += "<thead class='thead-dark'>"
			txt += "<tr> <th style='text-align:center'>Nome</th> <th style='text-align:center'>Opção</th>"
			txt += "<th style='text-align:center'>CPF</th> </thead>"

			for (i=0; i < response.length; i++) {
				txt += "<><td style='text-align:center'>" + response[i].nome + "</td>";
				txt += "<td style='text-align:center'>" + response[i].opcao + "</td>";
				txt += "<td style='text-align:center'>" + response[i].cpf + "</td></tr>";
			
				

			}
				
			txt += "</table>"
			document.getElementById('tabela').innerHTML = txt;
			
		}).fail(function() {
			toastr.error('Falhou!');
		});
}

/*
function consultar() { 
	
	var resp,
		txt 	= "",
		data 	= {},
		request = new XMLHttpRequest(),
		url 	= "http://localhost:8090/api/v1/pessoa";

	data.id	  = document.getElementById('inputID').value;
		
	request.open('GET', url+'/'+data.id, true);

    request.onload = function() {
		if (request.readyState == 4 && (request.status >= 200 && request.status < 400)) {
                
			resp = JSON.parse(request.responseText);
				
			txt += "<table style='width:53%' border='1' class='table table-hover'>"
			txt += "<thead class='thead-dark'>"
			txt += "<tr><th style='text-align:center'>Código</th><th>Nome</th></tr></thead>"
	
			txt += "<tr><td style='text-align:center'>" + resp.id + "</td>";
			txt += "<td style='text-align:center'>" + resp.nome + "</td></tr>";
		
			txt += "</table>"
			document.getElementById('tabela').innerHTML = txt;
							
		} else {
			console.error(request);
			
		}
	};

    request.onerror = function() {
        console.log("Erro:"+request);
		toastr.error('Falhou!');
    };

    request.send();    
}
*/

function consultar(){
	var data = {},
		txt  = "";
		
		data.id	= document.getElementById('inputID').value;
		
		$.ajax({
			url : "https://desafiomv.herokuapp.com/colaboradores"+'/'+data.cpf,
			type: "GET",
			contentType:"application/json; charset=utf-8"
		}).done( function( response ){
			//$('#registerForm')[0].reset();//limpa todos os campos do form			
				
			txt += "<table style='width:53%' border='1' class='table table-hover'>"
			txt += "<thead class='thead-dark'>"
			txt += "<tr><th style='text-align:center'>CPF</th><th>Nome</th> <th>Opção</th></tr></thead>"
	
			txt += "<tr><td style='text-align:center'>" + response.cpf + "</td>";
			txt += "<td style='text-align:center'>" + response.nome + "</td></tr>";
			txt += "<td style='text-align:center'>" + response.opcao + "</td></tr>";
		
			txt += "</table>"
			document.getElementById('tabela').innerHTML = txt;
			
		}).fail(function() {
			toastr.error('Falhou!');
		});
}