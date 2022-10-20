document.getElementById("policy").onmouseover = function() {mouseOver()};
document.getElementById("policy").onmouseout = function() {mouseOut()};

function mouseOver() {
  document.getElementById("policy").style.color = "black";
}

function mouseOut() {
  document.getElementById("policy").style.color = "#ffffff";
}