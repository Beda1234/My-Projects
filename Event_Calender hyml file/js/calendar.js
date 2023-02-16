var dt = new Date();
var st = new Date();//
function RenderDate(){
    
    
var dt= new Date();dt.setDate(1);
var day = dt.getDay();
var endDate= new Date(
    dt.getFullYear(),
    dt.getMonth()+ 1,
    0
).getDate();

var prevDate =new Date(
    dt.getFullYear(),
    dt.getMonth(),
    0
).getDate();
// console.log(endDate);

var today = new Date().getDate();

var months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
];

document.getElementById("date_str").innerHTML = dt.toDateString();//
document.getElementById("month").innerHTML= months[dt.getMonth()];//
var cells="";
for(x = day; x>0; x--)
{
    cells+="<div class ='previous_Date'>" + (prevDate-x+1) + "</div>";
}
for(i=1;i<=endDate;i++)
{
    if(i == today)
    {
        cells += "<div class='today'>" + i + "</div>";
    }
    else
    {
        cells+="<div>" + i + "</div>";
    }
}
document.getElementsByClassName("days")[0].innerHTML=cells;
}

 function moveDate(para) {
    // dt=st;
    if(para == "previous") {
        // st.setMonth(st.getMonth() - 1)
        dt.setMonth(dt.getMonth() - 1);
    } else if(para == 'next') {
        // st.setMonth(st.getMonth() + 1)
        dt.setMonth(dt.getMonth() + 1);
    }
    RenderDate();
}
