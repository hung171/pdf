
function update(){
    const s1 = document.getElementById("s1");
    const s2 = document.getElementById("s2");

    let au=0, war=0;
    if(s1.checked){
        au=1;
    }
    if(s2.checked) war=1;

    let request={
        "statusWar":war,
        "statusAu":au
    }

    fetch("/setting", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(request)
    })
        .then(r =>r.json())
        .then((data)=>{
            if(data.code === "00"){
                alert("Update successfully")
                window.location="http://localhost:8080/customer/home";
            } else {
                alert("Update fail")
            }
            /*location.reload();*/
        })
}