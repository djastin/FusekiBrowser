jQuery(document).ready(function($)
{
	$(".table-hover").on('click','td',function(e){
	    e.preventDefault();
	    var search_result = $(this).attr('data-value');
	    searchViaAjax(search_result);
	}); 
});

function searchViaAjax(input)
{
	var search = input;

	$.ajax(
	{
		type : "POST",
		contentType : "application/json",
		url : "/FusekiBrowser/search/api/getSearchResult",
		data : JSON.stringify(search),
		dataType : 'json',
		timeout : 100000,
		success : function(data) 
		{
			console.log("SUCCESS: ", data);
			display(data);
		},
		error : function(e)
		{
			console.log("ERROR: ", e);
			alert("error");
		},
		done : function(e) 
		{
			console.log("DONE");
		}
	});
}

function getUrlVars() 
{
	var vars = {};
	var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) 
	{
		vars[key] = value;
	});
	return vars;
}

function display(data) 
{
	var table_headers = "<thead><tr><th>Subject</th><th>Predicate</th><th>Object</th></tr></thead>";
	var table_data = table_data += table_headers;
	
	for(var i = 0; i < data["triples"].length; i++)
	{
		var subject = data["triples"][i]["subject"];
		var predicate = data["triples"][i]["predicate"];
		var object = data["triples"][i]["object"];
		
		table_data += "<tr>"
                        	+ "<td data-value='subject:" + subject + "'><a href='#'>" + subject + "</a></td>" +
                        	"<td data-value='predicate:" + predicate + "'><a href='#'>" + predicate + "</a></td>" +
                        	"<td data-value='object:" + object + "'><a href='#'>" + object + "</a></td>" +
                     	"</tr>";
	}
	
	table_data = table_data += table_headers;
	$("#example1").html(table_data);
}
