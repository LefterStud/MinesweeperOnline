fetch("http://localhost:8080/back?test", {
    method: 'POST',
}).then(response =>
    response.json().then(data => ({
        data: data,
        status: response.status
    })).then(res => {
        alert(res.data);
    }))