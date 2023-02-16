const daysTag = document.querySelector(".days"),
currentDate = document.querySelector(".current-date"),
prevNextIcon = document.querySelectorAll(".icons span");
const submit = document.querySelector('#submit');

let date = new Date(),
currYear = date.getFullYear(),
currMonth = date.getMonth();

const months = ["January", "February", "March", "April", "May", "June", "July",
              "August", "September", "October", "November", "December"];
const renderCalendar = () => {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay(), 
    lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(),
    lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(), 
    lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate(); 
    let liTag = "";
    for (let i = firstDayofMonth; i > 0; i--) { 
        liTag += `<li class="inactive">${lastDateofLastMonth - i + 1}</li>`;
    }
    for (let i = 1; i <= lastDateofMonth; i++) { 
        let isToday = i === date.getDate() && currMonth === new Date().getMonth() 
                     && currYear === new Date().getFullYear() ? "active" : "";
        liTag += `<li class="${isToday}">${i}</li>`;
    }
    for (let i = lastDayofMonth; i < 6; i++) { 
        liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`
    }
    currentDate.innerText = `${months[currMonth]} ${currYear}`; 
    daysTag.innerHTML = liTag;
}
renderCalendar();
prevNextIcon.forEach(icon => { 
    icon.addEventListener("click", () => { 
        currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;
        if(currMonth < 0 || currMonth > 11) { 
            
            date = new Date(currYear, currMonth);
            currYear = date.getFullYear(); 
            currMonth = date.getMonth(); 
        } else {
            date = new Date(); 
        }
        renderCalendar();
    });
});
const saveLead =  async() => {
    let eventName=document.getElementById("event_name").value
    let eventDetails=document.getElementById("event_details").value
    let eventDate=document.getElementById("event_start_date").value
    let response =await fetch('http://localhost:8070/events');
    console.log(response);
    
    let response2=await fetch('http://localhost:8070/events' ,{
        method:'POST',
        headers: {
            'Accept':'application/json',
            'Content-Type': 'application/json'
        },
        body:JSON.stringify({
            event_Date:eventDate,
            event_Name:eventName,
            event_Description:eventDetails,
            
        })

    })
    console.log(response2);

}
submit.addEventListener('click', saveLead)