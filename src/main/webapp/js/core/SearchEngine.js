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
		data : search,
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
			display(e);
		},
		done : function(e) 
		{
			console.log("DONE");
			enableSearchButton(true);
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

function enableSearchButton(flag) 
{
	$("#btn-search").prop("disabled", flag);
}

function display(data) 
{
	var json = "<h4>Ajax Response</h4><pre>" + JSON.stringify(data, null, 4) + "</pre>";
	$('#feedback').html(json);
}
