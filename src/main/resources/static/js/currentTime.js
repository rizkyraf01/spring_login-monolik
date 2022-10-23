function currentDate (){
	const currentTime = new Date();
	document.getElementById("tanggalwaktu").innerHTML = currentTime.toLocaleString();
	console.log(currentTime);
}
setInterval(currentDate, 1000);