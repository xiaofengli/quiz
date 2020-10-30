$(document).ready(function(){

	function loadDate() {
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();

		today = yyyy + '-' + mm + '-' + dd;
		document.getElementById('washsale_last_updated_date').value = today;
	};
	
	loadDate();
	
$("button#symbolsubmit").click(function(event){
				event.preventDefault(); // prevent default action
				var post_url = "http://localhost:9080/fidelity/stock/add" 
				console.log("url: " + post_url);
				console.log("form data:" + form_data);
				
				// TODO get data from the id.
				    //get data here
				//
				$.ajax( {type: 'POST',
		             url: url,
		              data: {name:"xiaofeng"},
		              headers: {
		                  'Content-Type':'application/json'
		              },
		              success:function(data) {
		                 console.log(data);
		              }
					}
		           );
			});



$("button#washsubmit").click(function(event){
	event.preventDefault(); // prevent default action
	alert("hello");
	var post_url = "http://localhost:9080/fidelity/stock/wash/add";
   
	var symbol = document.getElementById('wash_symbol').value;
    var company = document.getElementById('wash_symbol_company').value;
    var comment = document.getElementById('washsale_comment').value;
    var cost = document.getElementById('washsale_cost').value;
    var proceeding = document.getElementById('washsale_proceeding').value;
    var transactionDate = document.getElementById('washsale_transaction_date').value;
    var lastUpdatedDate= document.getElementById('washsale_last_updated_date');
    var payload = {"symbol": symbol, 
    		       "company": company,
    		       "comment": comment,
    		       "cost": cost,
    		       "proceeding": proceeding,
    		       "transactionDate": transactionDate,
    				"lastUpdated": lastUpdatedDate
    				};
	
	$.ajax( {type: 'POST',
             url: post_url,
              data:JSON.stringify( payload),
              headers: {
                  'Content-Type':'application/json'
              },
              success:function(data) {
            	  console.log(payload);
                 console.log(data);
              }
			}
           );
	});

});