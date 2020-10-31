
function checkAnswer(id) {
	var question_id = id.split("-")[0];
	var choice = id.split("-")[1];
	console.log(question_id);
	console.log(choice);
	
	//call aswer
	
	$.get({
        url: "http://192.168.0.6:80/quiz/question/1/answer"
    }).then(function(data) {
    	console.log(data);
    	if (data.question_id.toString(10) === question_id && choice == data.question_answer) {
    		alert("Congrats:P");
    	} else {
    		alert("Cry:(");
    	}
    	
    });
}


function getQuestions() {
	$.get({
        url: "http://192.168.0.6:80/quiz/question/1/selections"
    }).then(function(data) {

    	var header = "<table class='table table-condensed table-hover'>";
    	
		var content = "";
		
		// /Users/xiaofengli/git/quiz/src/main/resources/audio/letters/a.mp3
		content = content + "<audio id='myAudio'> <source src='a.mp3' type='audio/mpeg'></audio>";
    	content = content + "<button onclick='playAudio()' type='button'>Play Audio</button>"
		content= content + "<tr class='row'><td class='col'>" + data[0].id + "</td> <td class='col'>" + data[0].question_body + "</td><td class='col'></td></tr>" ;
    	content= content + "<tr class='row'>" ;
    	for (id in data) {
    		var data_id = data[id].id;
    		var selection_title = data[id].selection_title;
    		var component_id = data_id + "-" + selection_title;
    		console.log(component_id);
    		
    		
    		content= content + "<td class='col'>" + 
    		   "<a href=# class='isDisabled'"+ " id=" + component_id + " onclick=checkAnswer('" + component_id + "')" + ">" + data[id].selection_title +"</a>" + "</td>";
      	}
    	content = content +"</tr>";
    	content = header+content+ "</table>";
    	$('#gain_records').append(content);
    	
    	//var audio = document.getElementById('myAudio');
    	//	audio.play();
    		//  var promise = document.getElementById('myAudio').play();
      /*
    		  if (promise !== undefined) {
    		    promise.then(_ => {
    		      // Autoplay started!
    		    }).catch(error => {
    		      // Autoplay was prevented.
    		      // Show a "Play" button so that user can start playback.
    		    });
    		  }
    	*/
    	
    });
}

function playAudio() {
	var audio = document.getElementById('myAudio');
	audio.play();
}


$(document).ready(function() {
	getQuestions();


});