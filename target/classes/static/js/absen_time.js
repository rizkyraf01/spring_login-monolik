function fullfullTime(){
    var date = new Date();
    var currentDate = date.toISOString().slice(0,10);
    var currentTime = date.getHours() + ':' + date.getMinutes() + ":" + date.getSeconds();
    var fullTime = currentDate + " " + currentTime;

    document.getElementById('fullTime').value = fullTime;
    document.getElementById('currentDate').value = currentDate;
    document.getElementById('currentTime').value = currentTime;
    console.log(fullTime);
}
setInterval(fullfullTime, 1000);