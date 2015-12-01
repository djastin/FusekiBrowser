/*
$(document).ready(function() 
{
	$("#SubmitButton").click(function() 
	{
		$.ajax(
		{ 
			url:'sc', 
			type:'GET', 
            dataType: 'json', 
            success: function(data) 
            { 
            	$("#main").html("<p>Name:"+data.name+",Company:"+data.company+"</p>");
            },
            error: function(e)
            {
            	alert(e.status);
            }
         });
     });
});*/