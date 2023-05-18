function welcome(){
    alert('Message');
    console.log("Got to this point");
    elem = document.getElementById("welcome");

    elem.innerHTML="Hi guest"

}
//date
function mydate() {
  //alert("");
  document.getElementById("dt").hidden = false;
  document.getElementById("ndt").hidden = true;
}

function mydate1() {
  d = new Date(document.getElementById("dt").value);
  dt = d.getDate();
  mn = d.getMonth();
  mn++;
  yy = d.getFullYear();
  document.getElementById("ndt").value = dt + "/" + mn + "/" + yy
  document.getElementById("ndt").hidden = false;
  document.getElementById("dt").hidden = true;
}

