var map = L.map('map').setView([ 35.69046127201924, 51.40848349548901 ], 13);

L.tileLayer('http://a.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	attribution : 'Map data &copy; OpenStreetMap contributors',
	maxZoom : 18
}).addTo(map);

var popup = L.popup({
	minWidth : 250
}).setContent('<p>dddddddddddddd</p>');

var faxIcon = L.icon({
	iconUrl : 'resources/leaflet/images/marker-icon.png'
});

// var
// marker=L.marker([35.69046127201924,51.40848349548901]).addTo(map).bindPopup('<p>dddddddddddddd</p>');
/*function ajaxSend(){
var xhr;
var lat;
var lng;
xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		document.getElementById('map').innerHTML = xhr.responseText;
	}
}
xhr.open("get" , "merchant.xhtml?shopName=7Cell" , true);
xhr.send();
}*/



var marker={};
var circle={};
map.on('click', function(e) {
	//alert(e.latlng['lat'] + "OOOOOOOOOO" + e.latlng['lng']);

	var xhr;
 	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('dv').innerHTML = xhr.responseText;
		}
	} 
/*    if (marker != undefined) {
        map.removeLayer(marker);
     };*/
     
     if (circle != undefined) {
         map.removeLayer(circle);
      };
   
/*	marker = L.marker([e.latlng['lat'],e.latlng['lng']], {
		icon : faxIcon
	}).addTo(map).bindPopup(popup);*/
	 circle=new L.circle([e.latlng['lat'],e.latlng['lng']],1000).addTo(map);
    document.getElementById("ig").style.display="none";
 	xhr.open("get" , "searchmap.xhtml?lat=" + e.latlng['lat'] + "&lng=" + e.latlng['lng'] , true);
	xhr.send(); 
	document.getElementById("ig").style.display="block";
})





