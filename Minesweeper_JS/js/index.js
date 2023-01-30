//const $info_shield = document.querySelector('.info_shield');

document.querySelector('.test').addEventListener("click", function () {
    fetch("http://localhost:8080/back?test", {
        method: 'POST'
    }).then(response =>
        response.text().then(data => ({
            data: data,
            status: response.status
        })).then(res => {
            alert(res.data)
        }));
})

/*fetch("http://localhost:8080/back?test", {
        method: 'POST',
    }).then(response =>
        response.json().then(data => ({
            data: data,
            status: response.status
        })).then(res => {
            if (res.data.toString()=="Connected"){
                alert(res.data);
            }
        }))*/