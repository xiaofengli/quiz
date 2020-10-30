function getValue(){
    var cn = document.getElementById("cn").value;
    var cp = document.getElementById("cp").value;
    var bp = document.getElementById("bp").value;
    var ep = document.getElementById("ep").value;

    var pn = (cp-ep)* cn / (ep-bp);
    document.getElementById("result").innerHTML = "Expected buying " + Math.round(pn) +" shares with a total amount of $" + Math.round(pn) * ep;
}