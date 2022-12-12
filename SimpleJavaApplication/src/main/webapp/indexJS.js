var isEditClicked = false;
var Eid =0;

$(document).ready(function(){
	document.getElementById("innerTable").hidden = true;
	});
var windowLr = window.location.href;
$(document).on("click", "#submitId" ,function(e){
	 var mail = document.getElementById("email").value;
	 var name = document.getElementById("name").value;
	 var id =0;
	 if(isEditClicked == true){
		id=Eid;
	}	
	 
	 let URLs =  windowLr  + "submit?email="+ encodeURIComponent(mail)+"&name="+encodeURIComponent(name)+"&id="+id;
	
	fetch(URLs, {
    method: "POST",
})
                .then(function (response) {
					
                    return response.json();
                })
                .then(function (data) {
                    appendData(data);
                })
                .catch(function (err) {
                    console.log('error: ' + err);
                });
            function appendData(data) {
				
				let placeholder = document.querySelector("#data-output");
				let out ="";
				if(data.message=="invalid mail"){
					alert("Invalid Email");
				} 
				if(data.message=="mail is already present"){
					alert("mail is already present");
				} else { 
				let datalength = 0; 
				datalength = data.data.length;
				if(datalength == 0){
					document.getElementById("innerTable").hidden = true;
				}else {
					document.getElementById("innerTable").hidden = false;
				}
				let count = 1;
				for(let d of data.data){
					out += `<tr>
					<td >${count}</td>
					<td>${d.email}</td>
					<td>${d.name}</td>
					<td ><input type ="button" class="table-btn" value="edit" id="btn_edit"/></td>
					<td><input type ="button" class="table-btn" value="delete" id="btn_delete"/></td>
					<td style ="display:none;">${d.eid}</td></tr>`;
					count = count +1;
				}
				placeholder.innerHTML = out;
				document.getElementById("email").value ="";
				document.getElementById("name").value = "";
            }
            }
            
})



$(document).on("click", "#btn_delete" ,function(e){
	console.log( $(this).closest("tr").find("td:eq(1)").text());
var email =  $(this).closest("tr").find("td:eq(1)").text();
	//alert($(this).parent("tr"));
	
	if(isEditClicked){
		document.getElementById("email").value = "";
	 document.getElementById("name").value="";
	 isEditClicked =false;
	}
	 
	 let URLs =  windowLr  + "delete?email="+ email;
	
	fetch(URLs, {
    method: "POST",
})
                .then(function (response) {
					
                    return response.json();
                })
                .then(function (data) {
                    deleteData(data);
                })
                .catch(function (err) {
                    console.log('error: ' + err);
                });
            function deleteData(data) {
				
				let placeholder = document.querySelector("#data-output");
				let out ="";
				if(data.message=="mail is not present"){
					alert("mail is not present");
				} else { 
				let datalength = 0; 
				datalength = data.data.length;
				if(datalength == 0){
					document.getElementById("innerTable").hidden = true;
				}else {
					document.getElementById("innerTable").hidden = false;
				}
				let count = 1;
				for(let d of data.data){
					out += `<tr>
					<td>${count}</td>
					<td>${d.email}</td>
					<td>${d.name}</td>
					<td ><input type ="button" class="table-btn" value="edit" id="btn_edit"/></td>
					<td><input type ="button" class="table-btn" value="delete" id="btn_delete"/></td>
					<td style ="display:none;">${d.eid}</td></tr>`;
					count = count +1;
				}
				placeholder.innerHTML = out;
            }
            }
            
})

$('#formid').on('keyup keypress', function(e) {
  var keyCode = e.keyCode || e.which;
  if (keyCode === 13) { 
    e.preventDefault();
    return false;
  }
});


 $(document).on("click", "#btn_edit" ,function(e){
	var email =  $(this).closest("tr").find("td:eq(1)").text();
	var name = $(this).closest("tr").find("td:eq(2)").text();
	Eid = $(this).closest("tr").find("td:eq(5)").text();
	document.getElementById("email").value = email;
	 document.getElementById("name").value=name;
	 isEditClicked =true;
	 //document.getElementById("btn_delete").attributes("disabled", true);
	//alert("hai");
	
	})
	