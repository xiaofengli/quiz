function getQuestions() {
	$.get({
        url: "http://192.168.0.3:9080/quiz/question/1/selections"
    }).then(function(data) {

    	var header = "<table class='table table-bordered table-condensed table-hover'>" +
    			"<tr class='row active'>" +
    							"<th class='col'>id</th>" +
    							"<th class='col'>题号 </th>" +
    							"<th class='col'></th>" +
    							"</tr>"
    	
		var content = "";
    	content= content + "<tr class='row'><td class='col'>" + data[0].id + "</td> <td class='col'>" + data[0].question_body + "</td><td class='col'></td></tr>" ;
    	content= content + "<tr class='row'>" ;
    	for (id in data) {
    		content= content + "<td class='col'>" + data[id].selection_title + "</td>";
      	}
    	content = content +"</tr>";
    	content = header+content+ "</table>";
    	$('#gain_records').append(content);
    });
}



$(document).ready(function() {
	getQuestions();


});