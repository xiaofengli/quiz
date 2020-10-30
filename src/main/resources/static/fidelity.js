function getAllTransactions() {
	$.get({
        url: "http://localhost:9080/fidelity/closeposition/gainloss/account/all"
    }).then(function(data) {

    	var header = "<table class='table table-bordered table-condensed table-hover'>" +
    			"<tr class='row active'>" +
    							"<th class='col'>Account</th>" +
    							"<th class='col'>Symbol </th>" +
    							"<th class='col-xs-2'>Security Description </th>" +
    							"<th class='col'>Short Term </th>" +
    							"<th class='col'>Long Term </th>" +
    							"<th class='col'>Bought Price </th>" +
    							"<th class='col'>Sold Price </th>" +
    							"<th class='col'>Cost Basis </th>" +
    							"<th class='col'>Proceeds</th>" +
    							"<th >Quantity </th>" +
    							"<th >Date Acquired </th>" +
    							"<th >Date Sold </th>" +
    							"<th >Processing Date</th>" +
    							"<th >LastUpdated Date </th>" +
    							"</tr>"
    	
		var content = "";
    	for (id in data) {
    	
    		content= content + "<tr class='row'>" + 
    		               "<td class='col'>" + data[id].account + "</td>" + 
    		               "<td class='col'>" + data[id].symbol  + "</td>" +
    					   "<td class='col'>" + data[id].securityDescription + "</td>" +
    		                "<td class='col'>" + data[id].shortTerm+"</td>"+ 
    		                "<td class='col'>" + data[id].longTerm+"</td>" + 
    		                "<td class='col'>" + data[id].boughtPrice + "</td>" + 
    		                "<td class='col'>" + data[id].soldPrice + "</td>" + 
    		                "<td class='col'>" + data[id].costBasis + "</td>" +
    						"<td class='col'>" + data[id].proceeds + "</td>" +
    						"<td class='col'>" + data[id].quantity + "</td>" +
    						"<td class='col'>" + data[id].dateAcquired + "</td>" +
    						"<td class='col'>" + data[id].dateSold + "</td>" +
    						"<td class='col'>" + data[id].processingDate + "</td>" +
    						"<td class='col'>" + data[id].lastUpdatedDate + "</td></tr>";
      	}
    	content = header+content+ "</table>";
    	$('#gain_records').prepend("<h1>All Transactions</h1>");
    	$('#gain_records').append(content);
    });
}


function getDailyEarning() {
	
	$.get({
        url: "http://localhost:9080/fidelity/closeposition/gainloss/daily"
    }).then(function(data) {

    	var header = "<table class='table table-bordered table-condensed table-hover'>" +
    			"<tr class='row active'>" +
    							"<th class='col'>Date</th>" +
    							"<th class='col'>Earning</th>" +
    							"</tr>"
		var content = "";
    	for (var id in data) {
    		content = content + "<tr class='row'>";
    		for (var ele in data[id]) {
    			var value = data[id][ele];
    			if ( typeof data[id][ele] == 'number') {
    				if (value < 0) {
    					content= content +  "<td class='col bg-danger'>" + value + "</td>";
    				} else if (value >500) {
    					content= content +  "<td class='col bg-success'>" + value + "</td>";
    				} else if (value >200) {
    					content= content +  "<td class='col bg-primary'>" + value + "</td>";
    				}
    				else {
    					content= content +  "<td class='col bg-info'>" + value + "</td>";
    				}
    			} else {
    				content= content +  "<td class='col'>" + data[id][ele] + "</td>";
    			}
    		}
    		content = content+ "</tr>";
    	}
    	content = header+content+ "</table>";
    	$('#daily_gain').prepend("<h1>Daily Earning</h1>");
    	$('#daily_gain').append(content);
    });
}

function getEarningSummary() {
	$.get({
        url: "http://localhost:9080/fidelity/closeposition/gainloss/summary"
    }).then(function(data) {
    	var header = "<table class='table table-bordered table-condensed table-hover'>" +
    			"<tr class='row active'>" +
    							"<th class='col'>Start_Date</th>" +
    							"<th class='col'>End_Date</th>" +
    							"<th class='col'>Short_Term_Total</th>" +
    							"<th class='col'>Long_Term_Total</th>" +
    							"<th class='col'>Total</th>" 
    							"</tr>"
		var content = "";
    	for (var id in data) {
    		content = content + "<tr class='row'>";
    		for (var ele in data[id]) {
    			var value = data[id][ele];
    			content= content +  "<td class='col'>" + value + "</td>";
    		}
    		content = content+ "</tr>";
    	}
    	content = header+content+ "</table>";
    	$('#earning_summary').prepend("<h1>Earning Summary</h1>");
    	$('#earning_summary').append(content);
    });
}

// The following functions might be useful for checking stock performance
function earningByStockByTotalEarning() {
	$.get({
        url: "http://localhost:9080/fidelity/closeposition/gainloss/stock/totalearning"
    }).then(function(data) {
    	var header = "<table class='table table-bordered table-condensed table-hover'>" +
		"<tr class='row active'>" +
						"<th class='col'>Symbol</th>" +
						"<th class='col'>Total_Earning</th>" +
						"<th class='col'>Total_Shares</th>" +
						"<th class='col'>Earning_Per_Share(EPS)</th>"
						"</tr>"
		var content = "";
    	for (var id in data) {
    		content = content + "<tr class='row'>";
    		for (var ele in data[id]) {
    			var value = data[id][ele];
    			content= content +  "<td class='col'>" + value + "</td>";
    		}
    		content = content+ "</tr>";
    	}
    	content = header+content+ "</table>";
    	$('#gain_per_stock').prepend("<h1>Earning Per Stock in Desc Order</h1>");
    	$('#gain_per_stock').append(content);
    });
}

function earningByStockByEPS() {
	$.get({
        url: "http://localhost:9080/fidelity/closeposition/gainloss/stock/eps"
    }).then(function(data) {
    	var header = "<table class='table table-bordered table-condensed table-hover'>" +
    			"<tr class='row active'>" +
    							"<th class='col'>Symbol</th>" +
    							"<th class='col'>Total_Earning</th>" +
    							"<th class='col'>Total_Shares</th>" +
    							"<th class='col'>Earning_Per_Share(EPS)</th>"
    							"</tr>"
		var content = "";
    	for (var id in data) {
    		content = content + "<tr class='row'>";
    		for (var ele in data[id]) {
    			var value = data[id][ele];
    			content= content +  "<td class='col'>" + value + "</td>";
    		}
    		content = content+ "</tr>";
    	}
    	content = header+content+ "</table>";
    	$('#gain_per_stock_eps').prepend("<h1>Earning Per Stock by EPS in Desc Order</h1>");
    	$('#gain_per_stock_eps').append(content);
    });
}

$(document).ready(function() {
	 getEarningSummary();
	 getDailyEarning();
	 getAllTransactions();
	 earningByStockByTotalEarning();
	 earningByStockByEPS();

});